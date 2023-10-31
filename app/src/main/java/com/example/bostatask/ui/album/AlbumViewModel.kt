package com.example.bostatask.ui.album

import androidx.lifecycle.SavedStateHandle
import com.example.bostatask.data.repository.RepositoryImp
import com.example.bostatask.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel

class AlbumViewModel @Inject constructor(
    private val repositoryImp: RepositoryImp,
    savedStateHandle: SavedStateHandle)
    : BaseViewModel<AlbumUiState, Int>(AlbumUiState()),AlbumInteractionListener {
    override val Tag: String = this::class.simpleName.toString()
    private val args = AlbumFragmentArgs.fromSavedStateHandle(savedStateHandle)


    init {
        getPhotosByAlbumId()

    }
    private fun getPhotosByAlbumId(){
        _state.update { it.copy(isLoading = true) }
        tryToExecute({repositoryImp.getPhotoByAlbumId(args.id.toString()).toPhotoUiState() },
            ::onGetPhotoByAlbumIdSuccess,
            ::onError)
    }
    private fun onGetPhotoByAlbumIdSuccess(photos: List<PhotoUiState>){
        _state.update { it.copy(isLoading = false , photos = photos , searchedPhoto = photos) }
        log(state.value.photos.toString())

    }
    private fun onError(throwable: Throwable) {
        _state.update {
            it.copy(
                isLoading = false,
                isError = true
            )
        }

    }
    fun searchPhotoByTitle(query :String){
        val searchedPhoto =_state.value.photos.filter { it.title.contains(query ,true) }
            if(query.isBlank()){
                _state.update { it.copy(searchedPhoto = it.photos) }
            }
        else
            {_state.update { it.copy(searchedPhoto = searchedPhoto) }}

    }

    override fun onClickPhoto(albumId: Int) {
        TODO("Not yet implemented")
    }
}