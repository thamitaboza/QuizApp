package com.example.quizapp.navigation.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy

@Composable
fun BottomBarCustom(navController: NavController, currentDestination: NavDestination?) {
    val items = listOf(
        BottomNavItem("home", "Início", Icons.Default.Home),
        BottomNavItem("quizzes", "Quizzes", Icons.Default.QuestionAnswer),
        BottomNavItem("favorites", "Favoritos", Icons.Default.Favorite) // Ícone de Favoritos ❤️
    )

    NavigationBar(
        tonalElevation = 5.dp,
        containerColor = Color.White,
        modifier = Modifier
            .height(56.dp) // 🟢 Pequena correção para manter alinhado
    ) {
        items.forEach { (route, label, icon) ->
            val selected = currentDestination?.hierarchy?.any { it.route == route } == true

            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = icon,
                        contentDescription = label,
                        modifier = Modifier.size(22.dp), // 🔹 Reduz o tamanho do ícone
                        tint = if (selected) Color(0xDDFDFE) else Color.Gray
                    )
                },
                label = {
                    Text(
                        label,
                        fontSize = 12.sp // 🔹 Ajuste fino no tamanho da fonte
                    )
                },
                selected = selected,
                onClick = {
                    navController.navigate(route) {
                        popUpTo(navController.graph.startDestinationId) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color(0xFF007ACC), // Azul mais visível
                    unselectedIconColor = Color.Gray, // Cinza para os não selecionados
                    indicatorColor = Color(0x6680D8FF)                )
            )
        }
    }

}

data class BottomNavItem(val route: String, val title: String, val icon: androidx.compose.ui.graphics.vector.ImageVector)
