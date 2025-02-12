package com.example.quizapp.screens.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.quizapp.R
import com.example.quizapp.screens.home.components.CategoriesSection

@Composable
fun CategoryCard(category: Category, navController: NavController) {
    Card(
        modifier = Modifier
            .size(100.dp) // 🟢 Reduz o tamanho dos quadrados das categorias
            .clickable { /* Navegação */ },
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = category.icon),
                contentDescription = category.name,
                modifier = Modifier.size(50.dp) // 🟢 Tamanho menor da imagem dentro do card
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = category.name,
                fontSize = 14.sp
            )
        }
    }
}




