package com.guido.myapplicationtv.navigation

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.tv.foundation.lazy.list.TvLazyRow
import androidx.tv.foundation.lazy.list.items
import com.guido.myapplicationtv.screen.FavoriteContent
import com.guido.myapplicationtv.screen.HomeContent
import com.guido.myapplicationtv.screen.MovieContent
import com.guido.myapplicationtv.screen.Screen
import com.guido.myapplicationtv.screen.SearchContent


@Composable
fun NavigationDrawer() {
    var selectedScreen by remember { mutableStateOf<Screen?>(null) }

    val screens = listOf(
        Screen.Home,
        Screen.Search,
        Screen.Favorite,
        Screen.Movie
    )

    Column(modifier = Modifier.fillMaxSize()) {
        TvLazyRow() {
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













