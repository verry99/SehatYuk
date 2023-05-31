package com.example.fitnessapp.presentation.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.fitnessapp.data.repository.ArticleRepositoryImpl
import com.example.fitnessapp.presentation.ui.screen.article.ArticleViewModel
import com.example.fitnessapp.presentation.ui.screen.detail.DetailArticleViewModel

class ViewModelFactory(private val repository: ArticleRepositoryImpl) :
    ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ArticleViewModel::class.java)) {
            return ArticleViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(DetailArticleViewModel::class.java)) {
            return DetailArticleViewModel(repository) as T

        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }
}