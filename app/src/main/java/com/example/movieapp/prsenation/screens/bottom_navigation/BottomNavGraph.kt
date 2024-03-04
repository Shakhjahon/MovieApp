package com.example.movieapp.prsenation.screens.bottom_navigation

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.movieapp.prsenation.theme.sp11

@Composable
fun BottomNavGraph(
    navController: NavController,
) {
    val listItems = listOf(
        BottomScreens.MainScreen, BottomScreens.SearchScreen, BottomScreens.WatchListScreen
    )
    BottomNavigation(
        backgroundColor = MaterialTheme.colorScheme.background
    ) {
        val backStateEmpty by navController.currentBackStackEntryAsState()
        val currentRoute = backStateEmpty?.destination?.route
        listItems.forEach { items ->
            BottomNavigationItem(
                selected = currentRoute == items.route,
                onClick = {
                    navController.navigate(items.route) {
                        launchSingleTop = true
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = false
                        }
                        restoreState = true
                    }
                },
                icon = {
                    Icon(
                        painter = painterResource(id = items.iconId),
                        contentDescription = null,
                    )
                },
                label = {
                    Text(
                        text = items.title,
                        fontSize = sp11,
                    )
                },
                selectedContentColor = MaterialTheme.colorScheme.onBackground,
                unselectedContentColor = Color.Gray,
            )
        }
    }
}