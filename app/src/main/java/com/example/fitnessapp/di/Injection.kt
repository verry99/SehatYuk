package com.example.fitnessapp.di

import com.example.fitnessapp.data.repository.ArticleRepositoryImpl

object Injection {
    fun provideArticleRepository(): ArticleRepositoryImpl {
        return ArticleRepositoryImpl()
    }
}