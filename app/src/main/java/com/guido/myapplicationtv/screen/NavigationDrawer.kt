package com.guido.myapplicationtv.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.Icon
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.Text


sealed class Screen(val route: String, val title: String, val icon: ImageVector) {
    data object Home : Screen("home", "Home", Icons.Default.Home)
    data object Search : Screen("search", "Search", Icons.Default.Search)
    data object Favorite : Screen("favorite", "Favorite", Icons.Default.Favorite)
    data object Movie : Screen("movie", "Movie", Icons.Default.AccountCircle)
}

@Composable
fun NavigationDrawer() {
    var selectedScreen by remember { mutableStateOf<Screen?>(null) }

    val screens = listOf(
        Screen.Home,
        Screen.Search,
        Screen.Favorite,
        Screen.Movie
    )

    Column {
        LazyColumn {
            items(screens) { screen ->
                DrawerItem(
                    screen = screen,
                    selected = selectedScreen == screen,
                    onClick = {
                        selectedScreen = screen
                    }
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        selectedScreen?.let { screen ->
            when (screen) {
                is Screen.Home -> HomeContent()
                is Screen.Search -> SearchContent()
                is Screen.Favorite -> FavoriteContent()
                is Screen.Movie -> MovieContent()
            }
        }
    }
}


@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun DrawerItem(
    screen: Screen,
    selected: Boolean,
    onClick: () -> Unit
) {
    val background = if (selected) {
        MaterialTheme.colorScheme.primary
    } else {
        Color.Transparent
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(16.dp)
            .background(background)
    ) {
        Icon(imageVector = screen.icon, contentDescription = "null", modifier = Modifier.size(24.dp))
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = screen.title, style = MaterialTheme.typography.bodyLarge)
    }
}

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun HomeContent() {
    Text("Home Screen Content")
}

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun SearchContent() {
    Text("Search Screen Content")
}

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun FavoriteContent() {
    Text("Favorite Screen Content")
}

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun MovieContent() {
    Text("Movie Screen Content")
}


