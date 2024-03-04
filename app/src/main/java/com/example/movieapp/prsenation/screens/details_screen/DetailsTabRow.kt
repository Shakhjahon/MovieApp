package com.example.movieapp.prsenation.screens.details_screen

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.movieapp.prsenation.theme.LikeFont
import com.example.movieapp.prsenation.theme.dp2
import com.example.movieapp.prsenation.theme.dp40
import com.example.movieapp.prsenation.theme.dp8
import com.example.movieapp.prsenation.theme.sp14
import kotlinx.coroutines.launch

@SuppressLint("UnusedBoxWithConstraintsScope")
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DetailsTabRow(
    uiState: DetailsUiState.Success,
    modifier: Modifier = Modifier,
) {
    val coroutineScope = rememberCoroutineScope()
    val movieList = listOf(
        uiState.movieDetails,
    )
    val pagerState = rememberPagerState {
        movieList.size
    }

    TabRow(
        selectedTabIndex = pagerState.currentPage,
        containerColor = MaterialTheme.colorScheme.background,
        modifier = modifier
            .padding(end = dp40)
            .fillMaxWidth(),
        indicator = { tabPosition ->
            Box(
                modifier = Modifier
                    .tabIndicatorOffset(tabPosition[pagerState.currentPage])
                    .height(dp2)
                    .background(
                        color = MaterialTheme.colorScheme.onBackground,
                        shape = RoundedCornerShape(dp8)
                    )
            )
        },
        divider = { Spacer(modifier = Modifier.height(4.dp)) },
    ) {
        movieList.forEachIndexed { index, movieModelUis ->
            val header = getPagerHeaderByPosition(position = index)
            Tab(
                selected = pagerState.currentPage == index,
                text = {
                    Text(
                        text = header,
                        fontSize = sp14,
                        color = MaterialTheme.colorScheme.onBackground,
                        fontFamily = LikeFont,
                    )
                },
                onClick = {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                },
            )
        }
    }
    HorizontalPager(
        state = pagerState,
        userScrollEnabled = false,
    ) {
        BoxWithConstraints {
            val rememberScrollState = rememberScrollState()
            val screenMaxHeight = maxHeight
            Column(
                modifier = modifier
                    .height(screenMaxHeight)
                    .verticalScroll(state = rememberScrollState)
            ) {
                Text(
                    text = uiState.movieDetails.overview,
                )

            }
        }
    }
}


@Composable
fun getPagerHeaderByPosition(position: Int): String = when (position) {
    else -> "About Movie"
}