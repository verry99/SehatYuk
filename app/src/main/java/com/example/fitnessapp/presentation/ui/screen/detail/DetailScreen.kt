package com.example.fitnessapp.presentation.ui.screen.detail

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.fitnessapp.di.Injection
import com.example.fitnessapp.presentation.ui.ViewModelFactory
import com.example.fitnessapp.presentation.ui.common.UiState
import com.example.fitnessapp.presentation.ui.theme.body1
import com.example.fitnessapp.presentation.ui.theme.title1
import com.example.fitnessapp.R

@Composable
fun DetailScreen(
    articleId: Long,
    viewModel: DetailArticleViewModel = viewModel(factory = ViewModelFactory(Injection.provideArticleRepository())),
    navigateBack: () -> Unit
) {
    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
        when (uiState) {
            is UiState.Loading -> {
                viewModel.getArticleById(articleId)
            }

            is UiState.Success -> {
                val data = uiState.data
                DetailContent(
                    data.title,
                    data.description,
                    data.imageUrl,
                    onBackClick = navigateBack
                )
            }

            is UiState.Error -> {

            }
        }
    }
}

@Composable
fun DetailContent(
    title: String,
    description: String,
    imageUrl: String,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .weight(1f)
        ) {
            Box(
            ) {
                AsyncImage(
                    model = imageUrl,
                    contentDescription = title,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                        .height(250.dp)
                        .clip(RoundedCornerShape(bottomStart = 10.dp, bottomEnd = 10.dp))
                )
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = stringResource(R.string.back),
                    modifier = Modifier
                        .padding(16.dp)
                        .clickable { onBackClick() }
                )
            }
            Column(Modifier.padding(16.dp)) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.title1
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = description,
                    style = MaterialTheme.typography.body1,
                    textAlign = TextAlign.Justify
                )
            }
        }

    }
}
