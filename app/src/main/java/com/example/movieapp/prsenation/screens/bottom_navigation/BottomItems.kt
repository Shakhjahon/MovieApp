package com.example.movieapp.prsenation.screens.bottom_navigation

import com.example.movieapp.R

sealed class BottomScreens(
    val title: String,
    val iconId: Int,
    val route: String,
) {
    data object MainScreen : BottomScreens(
        "Home",
        R.drawable.bottom_home,
        "MainScreen"
    )

    data object SearchScreen : BottomScreens(
        "Search",
        R.drawable.search_icon,
        "SearchScreen"
    )

    data object WatchListScreen :
        BottomScreens(
            "Watch list",
            R.drawable.bottom_watch,
            "WatchListScreen"
        )
}