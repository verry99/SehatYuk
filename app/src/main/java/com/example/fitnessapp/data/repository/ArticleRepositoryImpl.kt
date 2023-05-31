package com.example.fitnessapp.data.repository

import com.example.fitnessapp.data.remote.model.Article
import com.example.fitnessapp.data.remote.model.FakeArticleDataSource
import com.example.fitnessapp.domain.repository.ArticleRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class ArticleRepositoryImpl : ArticleRepository {
    private val articles = mutableListOf<Article>()

    init {
        if (articles.isEmpty()) {
            FakeArticleDataSource.dummyArticles.forEach {
                articles.add(it)
            }
        }
    }

    override fun getArticles(): Flow<List<Article>> = flowOf(articles)
    override fun getArticleById(articleId: Long): Article = articles.first { it.id == articleId }
}