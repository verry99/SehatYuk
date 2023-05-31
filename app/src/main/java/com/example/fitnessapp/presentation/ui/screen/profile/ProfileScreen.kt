package com.example.fitnessapp.presentation.ui.screen.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.fitnessapp.presentation.ui.common.UiState
import com.example.fitnessapp.presentation.ui.theme.body1
import com.example.fitnessapp.presentation.ui.theme.title2

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    viewModel: ProfileViewModel = ProfileViewModel(),
) {
    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
        when (uiState) {
            is UiState.Loading -> {
                viewModel.getUser()
            }

            is UiState.Success -> {
                val user = uiState.data
                ProfileContent(user.name, user.email, user.imageUrl, modifier = modifier)
            }

            is UiState.Error -> {

            }
        }
    }

}

@Composable
fun ProfileContent(
    name: String,
    email: String,
    imageUrl: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp, 40.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(125.dp)
        ) {
            AsyncImage(
                model = imageUrl,
                contentDescription = name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(125.dp)
                    .clip(RoundedCornerShape(50))
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(verticalArrangement = Arrangement.Center, modifier = Modifier.fillMaxHeight()) {
                Text(
                    text = name,
                    style = MaterialTheme.typography.title2
                )
                Text(
                    text = email,
                    style = MaterialTheme.typography.body1
                )
            }
        }
    }
}