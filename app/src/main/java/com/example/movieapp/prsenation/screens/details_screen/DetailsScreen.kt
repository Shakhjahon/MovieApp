package com.example.movieapp.prsenation.screens.details_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import coil.compose.AsyncImage
import com.example.movieapp.R
import com.example.movieapp.data.utils.Constants.POSTER_PATH_URL
import com.example.movieapp.prsenation.screens.common.error.ErrorScreen
import com.example.movieapp.prsenation.screens.main_screen.LoadingScreen
import com.example.movieapp.prsenation.theme.Black
import com.example.movieapp.prsenation.theme.LikeFont
import com.example.movieapp.prsenation.theme.Orang
import com.example.movieapp.prsenation.theme.dp10
import com.example.movieapp.prsenation.theme.dp11
import com.example.movieapp.prsenation.theme.dp130
import com.example.movieapp.prsenation.theme.dp15
import com.example.movieapp.prsenation.theme.dp2
import com.example.movieapp.prsenation.theme.dp20
import com.example.movieapp.prsenation.theme.dp230
import com.example.movieapp.prsenation.theme.dp24
import com.example.movieapp.prsenation.theme.dp25
import com.example.movieapp.prsenation.theme.dp3
import com.example.movieapp.prsenation.theme.dp30
import com.example.movieapp.prsenation.theme.dp4
import com.example.movieapp.prsenation.theme.dp40
import com.example.movieapp.prsenation.theme.dp54
import com.example.movieapp.prsenation.theme.dp75
import com.example.movieapp.prsenation.theme.dp8
import com.example.movieapp.prsenation.theme.dp80
import com.example.movieapp.prsenation.theme.dp95
import com.example.movieapp.prsenation.theme.sp17
import com.example.movieapp.prsenation.theme.sp18
import com.example.movieapp.prsenation.theme.sp27
import kotlinx.coroutines.flow.StateFlow


@Composable
fun DetailsScreen(
    onGetMovieInfo: () -> Unit,
    stateFlow: StateFlow<DetailsUiState>,
    onGetMovieMainScreen: () -> Unit,
) {
    when (val mainUiStateFlow = stateFlow.collectAsState().value) {
        is DetailsUiState.Loading -> LoadingScreen()
        is DetailsUiState.Success -> DetailsMovieScreens(
            uiState = mainUiStateFlow, onGetMovieMainScreen = onGetMovieMainScreen
        )

        is DetailsUiState.Error -> ErrorScreen(
            tryAgainCallBack = {},
        )
    }
    LaunchedEffect(key1 = true) {
        onGetMovieInfo()
    }
}

@Composable
fun DetailsMovieScreens(
    uiState: DetailsUiState.Success,
    modifier: Modifier = Modifier,
    onGetMovieMainScreen: () -> Unit,
) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(dp10),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(onClick = { onGetMovieMainScreen() }) {
                Icon(
                    painter = painterResource(id = R.drawable.back_icon),
                    contentDescription = null,
                )
            }
            Text(
                modifier = modifier.padding(top = dp11),
                text = stringResource(R.string.detail),
                fontSize = sp17,
                fontWeight = FontWeight.SemiBold,
                fontFamily = LikeFont
            )
            IconButton(onClick = {}) {
                Icon(
                    painter = painterResource(id = R.drawable.favorite_icon),
                    contentDescription = null,
                )
            }
        }
        Card(
            modifier = modifier, shape = RoundedCornerShape(bottomEnd = dp20, bottomStart = dp20)
        ) {
            AsyncImage(
                modifier = modifier,
                model = POSTER_PATH_URL + uiState.movieDetails.backdropPath,
                contentDescription = null,
            )
        }
    }
    Column(
        modifier = modifier.padding(top = dp230, start = dp30)

    ) {
        Row(
            modifier = modifier.fillMaxWidth()
        ) {
            Card(
                modifier = modifier
                    .width(dp95)
                    .height(dp130),
                shape = RoundedCornerShape(dp10),
            ) {
                AsyncImage(
                    modifier = modifier,
                    model = POSTER_PATH_URL + uiState.movieDetails.posterPath,
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
            }
            Text(
                text = uiState.movieDetails.title,
                modifier = modifier.padding(top = dp75, start = dp10),
                fontSize = sp18,
                fontWeight = FontWeight.SemiBold,
                lineHeight = sp27,
                fontFamily = LikeFont,
            )
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = dp40, end = dp15),
                horizontalArrangement = Arrangement.End
            ) {
                Card(
                    modifier = modifier
                        .width(dp54)
                        .height(dp24),
                    shape = RoundedCornerShape(dp8),
                    colors = CardDefaults.cardColors(
                        Black
                    )
                ) {
                    Row {
                        Image(
                            modifier = modifier.padding(top = dp3, start = dp3),
                            painter = painterResource(id = R.drawable.star_icon),
                            contentDescription = null
                        )
                        Text(
                            modifier = modifier.padding(start = dp4),
                            text = uiState.movieDetails.voteCount.toString(),
                            color = Orang
                        )
                    }
                }
            }
        }
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(top = dp25),
            horizontalArrangement = Arrangement.Center
        ) {
            Row {
                Icon(
                    modifier = modifier.padding(top = dp3),
                    painter = painterResource(
                        id = R.drawable.calendar_icon
                    ),
                    contentDescription = null,
                )
                Text(
                    modifier = modifier.padding(start = dp2),
                    text = "${uiState.movieDetails.releaseDate} | ",
                )
            }
            Row {
                Icon(
                    modifier = modifier.padding(top = dp4),
                    painter = painterResource(id = R.drawable.clock_icon),
                    contentDescription = null
                )
                Text(
                    modifier = modifier.padding(start = dp2),
                    text = "${uiState.movieDetails.runtime} Minutes | "
                )
            }
            Row {
                Icon(
                    modifier = modifier.padding(top = dp4),
                    painter = painterResource(id = R.drawable.ticket_icon),
                    contentDescription = null,
                )
                Text(
                    modifier = modifier.padding(start = dp2), text = stringResource(R.string.action)
                )
            }
        }
        DetailsTabRow(
            uiState = uiState, modifier = modifier.padding(top = dp30, end = dp80)
        )
    }
}
