package com.example.movieapp.prsenation.screens.common.item

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.example.movieapp.R
import com.example.movieapp.prsenation.models.models.MovieModelUi
import kotlinx.collections.immutable.ImmutableList

@Composable
fun MoviesBlock(
    movieList: ImmutableList<MovieModelUi>,
    onNavigatyInfo: (Int) -> Unit,
) {
    LazyRow {
        items(
            items = movieList,
            key = { it.movieIdUi }
        ) {
            MainScreenPopularItem(
                model = it.moviePosterPathUi,
                image = painterResource(id = R.drawable.plaseholder),
                movieId = it.movieIdUi,
                onNavigatyInfo = onNavigatyInfo
            )
        }
    }
}