package com.example.bostatask.ui.photo

import androidx.lifecycle.SavedStateHandle
import com.example.bostatask.data.repository.RepositoryImp
import com.example.bostatask.ui.album.PhotoUiState
import com.example.bostatask.ui.album.toPhotoUiState
import com.example.bostatask.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class PhotoViewModel @Inject constructor(
    private val repositoryImp: RepositoryImp,
    savedStateHandle: SavedStateHandle,
) : BaseViewModel<PhotoViewUiState, Long>(PhotoViewUiState()) {
    override val Tag: String = this::class.simpleName.toString()
    private val args =
        PhotoViewFragmentArgs.fromSavedStateHandle(savedStateHandle)
    init {
        getPhotosByAlbumId()

    }
    private fun getPhotosByAlbumId(){
        _state.update { it.copy(isLoading = true) }
        log("${args.photoId} , ${args.albumId}")
        tryToExecute({repositoryImp.getPhotoByAlbumId(args.albumId.toString()).toPhotoUiState() },
            ::onGetPhotoByAlbumIdSuccess,
            ::onError)
    }
    private fun onGetPhotoByAlbumIdSuccess(photos: List<PhotoUiState>){
        _state.update { it.copy(isLoading = false , photos = photos ,) }
        getPhotoView()

    }
    private fun onError(throwable: Throwable) {
        _state.update {
            it.copy(
                isLoading = false,
                isError = true
            )
        }
        log(throwable.message.toString())

    }
    fun getPhotoView(){
        val photo = _state.value.photos.firstOrNull { it.id ==args.photoId }
        _state.update { it.copy(photo = photo!!.thumbnailUrl) }
    }

}