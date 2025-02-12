package com.example.quizapp.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.quizapp.R
import com.example.quizapp.screens.home.components.CategoriesSection
import com.example.quizapp.navigation.components.BottomBarCustom
import com.example.quizapp.screens.home.components.CategoryCard
import com.example.quizapp.screens.home.components.Category
import com.example.quizapp.screens.home.components.getCategories

data class Quiz(val id: String, val title: String, val description: String)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        bottomBar = {
            BottomBarCustom(
                navController = navController,
                currentDestination = navController.currentBackStackEntry?.destination
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues) // 🟢 Garante que o conteúdo não fique atrás da barra
                .background(MaterialTheme.colorScheme.background)
                .padding(16.dp) // 🟢 Padding para espaçamento correto
        ) {
            // 🟢 Header com nome do usuário
            HomeHeader()

            // 🟢 Barra de pesquisa
            SearchBar()

            // 🟢 Banner principal
            BannerSection()

            Spacer(modifier = Modifier.height(16.dp))

            // 🟢 Categorias de quiz
            CategoriesSection(navController)
        }
    }
}


@Composable
fun HomeHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.perfil), // Ícone de perfil
            contentDescription = "User Profile",
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text("Thamires Taboza", style = MaterialTheme.typography.titleMedium)
            Text("Level 5", style = MaterialTheme.typography.bodySmall, color = Color.Gray)
        }
    }
}

@Composable
fun SearchBar() {
    OutlinedTextField(
        value = "",
        onValueChange = { /* Implementar lógica de busca */ },
        placeholder = { Text("Pesquisar quizzes...") },
        leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Buscar") },
        trailingIcon = { Icon(Icons.Filled.FilterList, contentDescription = "Filtrar") },
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clip(RoundedCornerShape(8.dp))
    )
}

@Composable
fun BannerSection() {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp), // 🟢 Ajuste o tamanho conforme necessário
        colors = CardDefaults.cardColors(containerColor = Color.Transparent) // 🔹 Remove cor padrão do Card
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            // 🔹 IMAGEM DE FUNDO PARA O BANNER
            Image(
                painter = painterResource(id = R.drawable.fundo4), // 🟢 Substitua por sua imagem real
                contentDescription = "Banner Image",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop // 🔹 Faz a imagem cobrir todo o espaço
            )

            // 🔹 SOBREPOSIÇÃO ESCURA PARA MELHORAR A LEITURA DO TEXTO
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.4f)) // 🔹 Escurece a imagem para melhor visibilidade do texto
            )

            // 🔹 TEXTO CENTRALIZADO NO BANNER
            Text(
                text = "Desafie seus conhecimentos e divirta-se!",
                style = TextStyle(
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.sp
                ),
                textAlign = TextAlign.Center,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}



@Composable
fun CategoriesSection(navController: NavController) {
    Column {
        Text("Top Quiz Categories", style = MaterialTheme.typography.titleMedium)
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.padding(vertical = 8.dp)
        ) {
            items(getCategories()) { category ->
                CategoryCard(category, navController)
            }
        }
    }
}

@Composable
fun CategoryCard(category: Category, navController: NavController) {
    Card(
        modifier = Modifier
            .size(100.dp)
            .clickable { /* Implementar navegação */ },
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = category.icon), // 🟢 Correção do erro
                contentDescription = category.name,
                modifier = Modifier.size(50.dp)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(category.name, style = MaterialTheme.typography.bodySmall)
        }
    }
}


