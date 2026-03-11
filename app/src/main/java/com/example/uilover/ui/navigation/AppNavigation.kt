package com.example.uilover.ui.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.uilover.R
import com.example.uilover.ui.components.BottomNavigationBar
import com.example.uilover.ui.screens.HomeScreen
import com.example.uilover.ui.screens.IntroScreen
import com.example.uilover.ui.screens.ProfileScreen
import com.example.uilover.ui.screens.SettingsScreen
import com.example.uilover.ui.screens.WalletScreen
import com.example.uilover.ui.theme.DarkBlue

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "intro") {
        composable(route = "intro") {
            IntroScreen(
                onGetStatedClick = {
                    navController.navigate(route = "main_app") {
                        popUpTo(route = "intro") {
                            inclusive = true
                        }
                    }
                }
            )
        }
        composable(route = "main_app") {
            MainAppContainer()
        }
    }
}

@Composable
@Preview
fun MainAppContainer() {
    var selectedTab by remember { mutableStateOf("Home") }

    Scaffold(
        contentWindowInsets = WindowInsets.navigationBars,
        bottomBar = {
            BottomNavigationBar(
                selectedTab = selectedTab,
                onTabSelected = { newTab -> selectedTab = newTab }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { },
                containerColor = DarkBlue,
                contentColor = Color.White,
                shape = CircleShape,
                modifier = Modifier
                    .offset(y = 50.dp)
                    .size(60.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.float_icon),
                    contentDescription = null,
                    modifier = Modifier.size(30.dp)
                )
            }
        },
        floatingActionButtonPosition = FabPosition.Center
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            when (selectedTab) {
                "Home" -> HomeScreen()
                "Wallet" -> WalletScreen()
                "Profile" -> ProfileScreen()
                "Settings" -> SettingsScreen()
                else -> HomeScreen()
            }
        }
    }
}
