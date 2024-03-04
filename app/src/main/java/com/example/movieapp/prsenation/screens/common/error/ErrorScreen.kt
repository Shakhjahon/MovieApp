package com.example.movieapp.prsenation.screens.common.error

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.movieapp.R
import com.example.movieapp.prsenation.common.LottiIcons
import com.example.movieapp.prsenation.theme.dp13
import com.example.movieapp.prsenation.theme.dp15
import com.example.movieapp.prsenation.theme.dp50
import com.example.movieapp.prsenation.theme.sp15
import com.example.movieapp.prsenation.theme.sp20


@Composable
fun ErrorScreen(
    tryAgainCallBack: () -> Unit,
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            LottiIcons(
                modifier = Modifier
                    .size(160.dp)
            )
            Text(
                text = stringResource(R.string.main),
                fontWeight = FontWeight.Medium,
                fontSize = sp20,
            )
            Spacer(modifier = Modifier.padding(top = dp13))
            Button(
                onClick = {
                    tryAgainCallBack()
                },
                modifier = Modifier
                    .width(125.dp)
                    .height(dp50),
                shape = RoundedCornerShape(dp15),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Blue
                )
            ) {
                Text(
                    modifier = Modifier,
                    text = "Повторить",
                    fontSize = sp15,
                    color = Color.White,
                )
            }
        }
    }
}
