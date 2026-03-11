package com.example.uilover.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uilover.R
import com.example.uilover.ui.components.AnimatedItem
import com.example.uilover.ui.theme.DarkBlue
import com.example.uilover.ui.theme.LightBlue
import kotlinx.coroutines.delay

@Composable
@Preview
fun IntroScreen(onGetStatedClick: () -> Unit = {}) {
    var isVisible by remember { mutableStateOf(value = false) }

    LaunchedEffect(key1 = Unit) {
        delay(timeMillis = 100)
        isVisible = true
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = DarkBlue)
    ) {
        Box(
            modifier = Modifier.wrapContentSize(),
            contentAlignment = Alignment.BottomCenter
        ) {
            Image(
                painter = painterResource(id = R.drawable.women),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Fit
            )
            Image(
                painter = painterResource(id = R.drawable.arc_1),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillWidth
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = LightBlue)
                .padding(horizontal = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(height = 32.dp))
            AnimatedItem(visible = isVisible, delay = 0) {
                Text(
                    text = "Welcome\nto the UILover",
                    fontSize = 37.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    lineHeight = 40.sp,
                    color = Color.Black
                )
            }
            Spacer(modifier = Modifier.height(height = 32.dp))
            AnimatedItem(visible = isVisible, delay = 300) {
                Text(
                    text = "Experience the extraordinary as our \n" +
                            "visionary UI design propels you \n" +
                            "into a world of endless possibilities, \n" +
                            "where innovation shapes the future.",
                    color = Color.Black,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(top = 32.dp),
                    textAlign = TextAlign.Center,
                    lineHeight = 20.sp
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            AnimatedItem(visible = isVisible, delay = 600) {
                Button(
                    onClick = onGetStatedClick,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = DarkBlue),
                    shape = RoundedCornerShape(size = 10.dp)
                ) {
                    Text(
                        text = "Get Started",
                        color = Color.White,
                        fontSize = 20.sp
                    )
                }
            }
            Spacer(modifier = Modifier.height(height = 32.dp))
        }
    }
}
