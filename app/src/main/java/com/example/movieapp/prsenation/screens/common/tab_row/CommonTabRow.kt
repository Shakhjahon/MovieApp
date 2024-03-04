package com.example.movieapp.prsenation.screens.common.tab_row

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.movieapp.R
import com.example.movieapp.prsenation.screens.common.item.MainScreenItem
import com.example.movieapp.prsenation.screens.main_screen.MainScreenUiState
import com.example.movieapp.prsenation.theme.LikeFont
import com.example.movieapp.prsenation.theme.dp10
import com.example.movieapp.prsenation.theme.dp2
import com.example.movieapp.prsenation.theme.dp40
import com.example.movieapp.prsenation.theme.sp14
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CommonTabRow(
    uiState: MainScreenUiState.Loaded,
    onNavigatyInfo: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    val coroutineScope = rememberCoroutineScope()
    val movieList = listOf(
        uiState.moviePopular,
        uiState.movieTopRated,
        uiState.moviePlaying,
        uiState.movieUpComing,
    )
    val pagerState = rememberPagerState {
        movieList.size
    }

    ScrollableTabRow(
        selectedTabIndex = pagerState.currentPage,
        containerColor = MaterialTheme.colorScheme.background,
        modifier = Modifier
            .padding(horizontal = dp10)
            .fillMaxWidth(),
        indicator = { tabPosition ->
            Box(
                modifier = Modifier
                    .tabIndicatorOffset(tabPosition[pagerState.currentPage])
                    .height(dp2)
                    .background(
                        color = MaterialTheme.colorScheme.onBackground,
                        shape = RoundedCornerShape(8.dp)
                    )
            )
        },
        divider = { Spacer(modifier = Modifier.height(4.dp)) },
        edgePadding = 0.dp
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
        state = pagerState, userScrollEnabled = false
    ) { page ->
        val movie = movieList[page]

        LazyVerticalGrid(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            columns = GridCells.Fixed(3),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier
                .padding(all = 16.dp)
                .padding(bottom = dp40),
        ) {
            items(items = movie, key = { it.movieIdUi }) {
                MainScreenItem(
                    model = it.moviePosterPathUi,
                    image = painterResource(id = R.drawable.plaseholder),
                    movieId = it.movieIdUi,
                    onNavigatyInfo = onNavigatyInfo
                )
            }
        }
    }
}


@Composable
fun getPagerHeaderByPosition(position: Int): String = when (position) {
    0 -> "Now playing"
    1 -> "Upcoming"
    2 -> "Top rated"
    else -> "Popular"
}