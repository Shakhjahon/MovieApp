package com.example.movieapp.prsenation.screens.common.item

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.movieapp.data.utils.Constants
import com.example.movieapp.prsenation.theme.dp14

@Composable
fun MainScreenItem(
    model: String,
    modifier: Modifier = Modifier,
    image: Painter,
    movieId: Int,
    onNavigatyInfo: (Int) -> Unit,
) {
    Spacer(modifier = Modifier.height(16.dp))
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .width(80.dp)
            .height(170.dp)
            .clickable { onNavigatyInfo(movieId) }
        .clip(shape = RoundedCornerShape(size = dp14)),

    ) {
        Spacer(modifier = Modifier.height(16.dp))
        AsyncImage(
            model = Constants.POSTER_PATH_URL + model,
            contentDescription = null,
            placeholder = image,
            contentScale = ContentScale.Crop
        )

    }
}