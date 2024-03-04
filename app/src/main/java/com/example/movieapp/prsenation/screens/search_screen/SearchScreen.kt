package com.example.movieapp.prsenation.screens.search_screen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.movieapp.R
import com.example.movieapp.data.utils.Constants.POSTER_PATH_URL
import com.example.movieapp.prsenation.screens.common.error.ErrorScreen
import com.example.movieapp.prsenation.theme.LikeFont
import com.example.movieapp.prsenation.theme.dp10
import com.example.movieapp.prsenation.theme.dp11
import com.example.movieapp.prsenation.theme.dp15
import com.example.movieapp.prsenation.theme.dp25
import com.example.movieapp.prsenation.theme.sp17
import kotlinx.coroutines.flow.StateFlow

@Composable
fun SearchScreen(
    uiStateFlow: StateFlow<SearchUiState>,
    onValueChange: (String) -> Unit,
    navigateToDetails: (Int) -> Unit,
    callBackPopBackState: () -> Unit,
) {
    when (val searchUiFlow = uiStateFlow.collectAsState().value) {
        is SearchUiState.Error -> ErrorScreen(tryAgainCallBack = {})
        SearchUiState.Loading -> Unit
        is SearchUiState.Loaded -> {
            SearchScreenLoaded(
                onValueChange = onValueChange,
                callBackPopBackState = callBackPopBackState,
                navigateToDetails = navigateToDetails,
                uiState = searchUiFlow,
            )
        }

        is SearchUiState.Install -> Unit
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SearchScreenLoaded(
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    callBackPopBackState: () -> Unit,
    navigateToDetails: (Int) -> Unit,
    uiState: SearchUiState.Loaded
) {
    Column(
        modifier = modifier
            .padding(top = 16.dp)
            .background(MaterialTheme.colorScheme.background)
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(dp10),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(onClick = { callBackPopBackState() }) {
                Icon(
                    painter = painterResource(id = R.drawable.back_icon),
                    contentDescription = null,
                )
            }
            Text(
                modifier = modifier.padding(top = dp11),
                text = stringResource(R.string.search),
                fontSize = sp17,
                fontWeight = FontWeight.SemiBold,
                fontFamily = LikeFont
            )
            IconButton(onClick = {}) {
                Icon(
                    painter = painterResource(id = R.drawable.info_icon),
                    contentDescription = null,
                )
            }
        }

        Spacer(modifier = modifier.height(16.dp))
        OutlinedTextField(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = dp15),
            value = uiState.query,
            onValueChange = onValueChange,
            shape = RoundedCornerShape(dp25),
            trailingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.search_icon),
                    contentDescription = null,
                    tint = Color.Gray,
                )
            },
            placeholder = {
                Text(
                    text = "Start Search",
                    fontFamily = LikeFont,
                    color = Color.Gray,
                    minLines = 1
                )
            },
        )
        LoadedSearch(
            uiState = uiState,
            navigateToDetails = navigateToDetails,
        )
    }
}

@Composable
fun LoadedSearch(
    uiState: SearchUiState.Loaded,
    navigateToDetails: (Int) -> Unit,
) {
    LazyColumn {
        items(items = uiState.searchLoaded, key = { it.movieIdUi }) {
            IncludeWatch(
                navigateToDetails = navigateToDetails,
                posterUrl = POSTER_PATH_URL + it.moviePosterPathUi,
                movieId = it.movieIdUi,
                title = it.movieTitleUi,
                voteAverage = it.movieVoteAverageUi.toString(),
                releaseDate = it.movieReleaseUi,
                runtime = it.movieVoteCountUi,
            )
        }
    }
}