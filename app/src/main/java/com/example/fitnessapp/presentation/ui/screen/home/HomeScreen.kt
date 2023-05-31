package com.example.fitnessapp.presentation.ui.screen.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import com.example.fitnessapp.R
import com.example.fitnessapp.presentation.ui.theme.title2

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navigateToProfile: () -> Unit
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = stringResource(R.string.welcome), style = MaterialTheme.typography.title2)
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = { navigateToProfile() },
            modifier = Modifier.semantics { contentDescription = "about_page" }) {
            Text(text = "Profile Menu")
        }
    }
}