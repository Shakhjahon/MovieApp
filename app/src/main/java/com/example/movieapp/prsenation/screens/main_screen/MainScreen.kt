package com.example.movieapp.prsenation.screens.main_screen


import android.annotation.SuppressLint
import androidx.activity.addCallback
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.movieapp.R
import com.example.movieapp.prsenation.screens.common.error.ErrorScreen
import com.example.movieapp.prsenation.screens.common.item.MoviesBlock
import com.example.movieapp.prsenation.screens.common.tab_row.CommonTabRow
import com.example.movieapp.prsenation.theme.Grays
import com.example.movieapp.prsenation.theme.LikeFont
import com.example.movieapp.prsenation.theme.dp10
import com.example.movieapp.prsenation.theme.dp100
import com.example.movieapp.prsenation.theme.dp15
import com.example.movieapp.prsenation.theme.dp20
import com.example.movieapp.prsenation.theme.dp25
import com.example.movieapp.prsenation.theme.sp16
import com.example.movieapp.prsenation.theme.sp24
import kotlinx.coroutines.flow.StateFlow

@Composable
fun MainScreen(
    viewModel: MainScreenViewModel,
    stateFlow: StateFlow<MainScreenUiState>,
    callBackPopBack: () -> Unit,
    onNavigatyInfo: (Int) -> Unit,
    navigatySearchScreen: () -> Unit,
) {

    val backstackDispatcher = LocalOnBackPressedDispatcherOwner.current

    backstackDispatcher?.onBackPressedDispatcher?.addCallback {
        callBackPopBack()
    }

    when (val mainUiStateFlow = stateFlow.collectAsState().value) {
        is MainScreenUiState.Loading -> LoadingScreen()
        is MainScreenUiState.Loaded -> {
            MainLoadedScreen(
                uiState = mainUiStateFlow,
                onNavigatyInfo = onNavigatyInfo,
                navigatySearchScreen = navigatySearchScreen
            )
        }
        is MainScreenUiState.Error -> ErrorScreen(
            tryAgainCallBack = viewModel::fetchMovie,
        )
    }
}

@SuppressLint("UnusedBoxWithConstraintsScope")
@Composable
fun MainLoadedScreen(
    uiState: MainScreenUiState.Loaded,
    modifier: Modifier = Modifier,
    onNavigatyInfo: (Int) -> Unit,
    navigatySearchScreen: () -> Unit,
) {
    val (value, onValueChange) = remember { mutableStateOf("") }
    BoxWithConstraints(
        modifier = Modifier
    ) {
        val verticalScrollState = rememberScrollState()
        val screenHeight = maxHeight
        Column(
            modifier = modifier
                .fillMaxSize()
                .verticalScroll(state = verticalScrollState)
        ) {
            Text(
                modifier = modifier.padding(start = dp20, top = dp20),
                text = stringResource(R.string.what_do_you_want_to_watch),
                fontSize = sp16,
                lineHeight = sp24,
                fontFamily = LikeFont,
            )

            OutlinedTextField(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(horizontal = dp15)
                    .padding(top = dp10)
                    .clickable { navigatySearchScreen() },
                value = value,
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
                        text = stringResource(R.string.start_search),
                        fontFamily = LikeFont,
                        color = Color.Gray
                    )
                },
            )
            Spacer(modifier = modifier.padding(top = dp20))
            MoviesBlock(
                movieList = uiState.moviePopular,
                onNavigatyInfo = onNavigatyInfo
            )
            Column(
                modifier = modifier.height(screenHeight)
            ) {
                CommonTabRow(
                    uiState = uiState,
                    modifier = modifier.padding(dp100),
                    onNavigatyInfo = onNavigatyInfo,
                )
            }
        }
    }
}

@Composable
fun LoadingScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        CircularProgressIndicator(
            color = Grays
        )
    }
}