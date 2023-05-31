package com.example.fitnessapp.presentation.ui.screen.article

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fitnessapp.data.repository.ArticleRepositoryImpl
import com.example.fitnessapp.data.remote.model.Article
import com.example.fitnessapp.presentation.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class ArticleViewModel(
    private val repository: ArticleRepositoryImpl
) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<List<Article>>> =
        MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<List<Article>>>
        get() = _uiState

    fun getAllArticles() {
        viewModelScope.launch {
            repository.getArticles()
                .catch {
                    _uiState.value = UiState.Error(it.message.toString())
                }
                .collect { articles ->
                    _uiState.value = UiState.Success(articles)
                }
        }
    }
}