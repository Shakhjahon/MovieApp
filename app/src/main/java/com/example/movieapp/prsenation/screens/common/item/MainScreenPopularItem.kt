package com.example.movieapp.prsenation.screens.common.item

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import com.example.movieapp.data.utils.Constants.POSTER_PATH_URL
import com.example.movieapp.prsenation.theme.dp14
import com.example.movieapp.prsenation.theme.dp17

@Composable
fun MainScreenPopularItem(
    model: String,
    modifier: Modifier = Modifier,
    image: Painter,
    movieId: Int,
    onNavigatyInfo: (Int) -> Unit
) {
    Spacer(modifier = modifier.padding(end = dp17))
    Box(
        modifier = modifier
            .width(144.dp)
            .height(210.dp)
            .clip(shape = RoundedCornerShape(size = dp14))
            .clickable { onNavigatyInfo(movieId) },
            contentAlignment = Alignment.Center
    ) {
        AsyncImage(
            model = POSTER_PATH_URL + model,
            contentDescription = null,
            placeholder = image,
            contentScale = ContentScale.Crop
        )
    }
}