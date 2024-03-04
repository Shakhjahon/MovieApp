package com.example.movieapp.prsenation.screens.watch_screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.example.movieapp.R

@Composable
fun WatchScreen(
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier
            .fillMaxSize()
            .wrapContentHeight(),
        text = stringResource(R.string.savescreen),
        textAlign = TextAlign.Center
    )
}