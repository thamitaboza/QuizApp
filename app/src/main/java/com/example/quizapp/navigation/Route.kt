package com.example.quizapp.navigation

sealed class Route(val route: String) {
    object Home : Route("home")
    object QuizDetail : Route("quiz_detail/{quizId}") {
        fun createRoute(quizId: String) = "quiz_detail/$quizId"
    }
    object Favorites : Route("favorites")
    object Settings : Route("settings")
    object Search : Route("search")
    object Help : Route("help")
}
