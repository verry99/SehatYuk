package com.example.fitnessapp.presentation.ui.screen.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fitnessapp.data.remote.model.User
import com.example.fitnessapp.presentation.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProfileViewModel : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<User>> =
        MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<User>>
        get() = _uiState

    private val verry = User(
        "Verry R. Wibawa",
        "verryrwibawa@gmail.com",
        "https://dicoding-web-img.sgp1.cdn.digitaloceanspaces.com/small/avatar/dos:a5264c06903da8f0d8e500f3e228760b20230518214156.png"
    )

    fun getUser() {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            _uiState.value = UiState.Success(verry)
        }
    }
}