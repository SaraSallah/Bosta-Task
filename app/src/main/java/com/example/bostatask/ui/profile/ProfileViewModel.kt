package com.example.bostatask.ui.profile

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.example.bostatask.data.repository.RepositoryImp
import com.example.bostatask.ui.base.BaseViewModel
import com.example.bostatask.utils.EventHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val repositoryImp: RepositoryImp,
    savedStateHandle: SavedStateHandle,
    ) : BaseViewModel<ProfileUiState, ProfileUIEffect>(ProfileUiState()), ProfileInteractionListener {
    override val Tag: String = this::class.simpleName.toString()

    init {
        getUserInfo()
        getAlbumsOfUser()
    }

    private fun getUserInfo() {
        _state.update { it.copy(isLoading = true) }
        tryToExecute(
            { repositoryImp.getUserById("1").toUserUiState() },
            ::onGetUserInfoSuccess,
            ::onError
        )
    }
    private fun onGetUserInfoSuccess(user: UserUiState) {
        _state.update {
            it.copy(
                isLoading = false,
                isError = false,
                user = user
            )
        }

    }

    private fun getAlbumsOfUser() {
        _state.update { it.copy(isLoading = true) }
        tryToExecute(
            { repositoryImp.getAlbumByUserId("1").toAlbumUiState()},
            ::onGetAlbumsOfUserSuccess,
            ::onError
        )
    }

    private fun onGetAlbumsOfUserSuccess(albums: List<AlbumUiState>) {
        _state.update {
            it.copy(
                isLoading = false,
                albums = albums
            )
        }
    }

    private fun onError(throwable: Throwable) {
        _state.update {
            it.copy(
                isLoading = false,
                isError = true
            )
        }

    }

    override fun onClickAlbum(albumId: Int) {
        viewModelScope.launch { _effect.emit(EventHandler(ProfileUIEffect(albumId))) }
    }


}