package com.example.fitnessapp.presentation.ui.screen.article

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.fitnessapp.di.Injection
import com.example.fitnessapp.data.remote.model.Article
import com.example.fitnessapp.presentation.ui.ViewModelFactory
import com.example.fitnessapp.presentation.ui.common.UiState
import com.example.fitnessapp.presentation.ui.component.ArticleItem

@Composable
fun ArticleScreen(
    modifier: Modifier = Modifier,
    viewModel: ArticleViewModel = viewModel(factory = ViewModelFactory(Injection.provideArticleRepository())),
    navigateToDetail: (Long) -> Unit,
) {
    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
        when (uiState) {
            is UiState.Loading -> {
                viewModel.getAllArticles()
            }

            is UiState.Success -> {
                ArticleContent(
                    articles = uiState.data,
                    navigateToDetail = navigateToDetail,
                    modifier = modifier,
                )
            }

            is UiState.Error -> {

            }
        }
    }
}

@Composable
fun ArticleContent(
    articles: List<Article>,
    navigateToDetail: (Long) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(articles) {
            ArticleItem(
                imageUrl = it.imageUrl,
                title = it.title,
                description = it.description,
                modifier = Modifier.clickable {
                    navigateToDetail(it.id)
                }
            )
        }
    }
}