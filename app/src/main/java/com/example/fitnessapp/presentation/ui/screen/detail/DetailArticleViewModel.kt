package com.example.fitnessapp.presentation.ui.screen.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fitnessapp.data.repository.ArticleRepositoryImpl
import com.example.fitnessapp.data.remote.model.Article
import com.example.fitnessapp.presentation.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailArticleViewModel(
    private val repository: ArticleRepositoryImpl
) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<Article>> =
        MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<Article>>
        get() = _uiState

    fun getArticleById(articleId: Long) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            _uiState.value = UiState.Success(repository.getArticleById(articleId))
        }
    }
}