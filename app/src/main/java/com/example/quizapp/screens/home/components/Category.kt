package com.example.quizapp.screens.home.components

import com.example.quizapp.R

data class Category(val name: String, val icon: Int)

fun getCategories(): List<Category> {
    return listOf(
        Category("Conhecimentos Gerais", R.drawable.conhecimentos),
        Category("Séries", R.drawable.series),
        Category("Filmes", R.drawable.filmes),
        Category("Animes", R.drawable.anime),
        Category("Música", R.drawable.musica),
        Category("Cultura", R.drawable.cultura)
    )
}