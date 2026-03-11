package com.example.uilover.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uilover.ui.components.AnimatedItem
import com.example.uilover.ui.components.HeaderSection
import com.example.uilover.ui.components.MiddleSection
import com.example.uilover.ui.components.TrendsSection

@Composable
@Preview
fun HomeScreen() {
    var showItems by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        showItems = true
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState())
    ) {
        AnimatedItem(visible = showItems, delay = 300) {
            HeaderSection()
        }
        AnimatedItem(visible = showItems, delay = 600) {
            MiddleSection()
        }
        AnimatedItem(visible = showItems, delay = 900) {
            TrendsSection()
        }
        Spacer(modifier = Modifier.height(80.dp))
    }
}
