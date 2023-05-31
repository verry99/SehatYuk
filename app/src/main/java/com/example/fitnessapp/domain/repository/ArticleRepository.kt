package com.example.fitnessapp.domain.repository

import com.example.fitnessapp.data.remote.model.Article
import kotlinx.coroutines.flow.Flow

interface ArticleRepository {
    fun getArticles(): Flow<List<Article>>
    fun getArticleById(articleId: Long): Article
}