package com.example.fitnessapp.presentation.ui.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Article : Screen("article")
    object Profile : Screen("profile")
    object DetailArticle : Screen("article/{articleId}") {
        fun createRoute(articleId: Long) = "article/$articleId"
    }
}