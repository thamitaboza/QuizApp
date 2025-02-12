package com.example.quizapp.screens.home.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.quizapp.screens.home.components.getCategories
import com.example.quizapp.screens.home.components.CategoryCard
import com.example.quizapp.screens.home.components.Category

@Composable
fun CategoriesSection(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp) // 🟢 Alinhado com o banner
    ) {
        Text(
            text = "Top Quiz Categories",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(bottom = 12.dp)
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(3), // 🟢 Mantém 3 colunas fixas
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 4.dp), // 🟢 Ajuste fino no alinhamento
            verticalArrangement = Arrangement.spacedBy(16.dp), // 🟢 Aumentado para separar as linhas
            horizontalArrangement = Arrangement.spacedBy(16.dp) // 🟢 Aumentado para separar os quadrados
        ) {
            items(getCategories()) { category ->
                CategoryCard(category, navController)
            }
        }
    }
}


