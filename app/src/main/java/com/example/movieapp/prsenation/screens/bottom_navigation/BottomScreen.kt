package com.example.movieapp.prsenation.screens.bottom_navigation

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.movieapp.prsenation.navigation.BottomNavigation

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BottomScreen(
    callBackPopBack : () -> Unit,
    ) {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavGraph(navController = navController) }
    ) {
        BottomNavigation(
            navHostController = navController,
            callBackPopBack = callBackPopBack,
        )
    }
}