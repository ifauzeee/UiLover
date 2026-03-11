package com.example.uilover.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uilover.R
import com.example.uilover.ui.theme.DarkBlue
import com.example.uilover.ui.theme.LightBlue

@Composable
@Preview
fun ProfileScreen(onBackClick: () -> Unit = {}) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = LightBlue)
            .verticalScroll(rememberScrollState())
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .background(color = DarkBlue)
        ) {
            // Header: Tombol Back dan Judul "Profile"
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 48.dp, start = 24.dp, end = 24.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .background(Color.White.copy(alpha = 0.2f), CircleShape)
                        .clickable { onBackClick() },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.back),
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(20.dp)
                    )
                }
                Text(
                    text = "Profile",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.width(40.dp))
            }

            // Bagian Foto Profil dan Nama
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.BottomCenter
            ) {
                Image(
                    painter = painterResource(id = R.drawable.arc_3),
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.FillWidth
                )
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(bottom = 0.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.user_2),
                        contentDescription = null,
                        modifier = Modifier
                            .size(100.dp)
                            .clip(CircleShape),
                        contentScale = ContentScale.Crop
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = "Alex Flores",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        color = DarkBlue
                    )
                    Text(
                        text = "alexflores@gmail.com",
                        fontSize = 14.sp,
                        color = Color.Gray
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Daftar Menu Profile
        Column(modifier = Modifier.padding(horizontal = 24.dp)) {
            ProfileMenuItem(iconRes = R.drawable.btn_1, title = "Notification")
            ProfileMenuItem(iconRes = R.drawable.btn_2, title = "Calendar")
            ProfileMenuItem(iconRes = R.drawable.btn_3, title = "Gallery")
            ProfileMenuItem(iconRes = R.drawable.btn_4, title = "My Playlist")
            ProfileMenuItem(iconRes = R.drawable.btn_5, title = "Share")
            ProfileMenuItem(iconRes = R.drawable.btn_6, title = "Logout")
        }

        Spacer(modifier = Modifier.height(80.dp))
    }
}

@Composable
fun ProfileMenuItem(iconRes: Int, title: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp)
            .clickable { },
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Menggunakan Image langsung karena ikon sudah menyertakan background berwarna
        Image(
            painter = painterResource(id = iconRes),
            contentDescription = null,
            modifier = Modifier.size(45.dp)
        )
        Text(
            text = title,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = Color.Black,
            modifier = Modifier
                .padding(start = 16.dp)
                .weight(1f)
        )
        Icon(
            painter = painterResource(id = R.drawable.arrow),
            contentDescription = null,
            tint = Color.Gray,
            modifier = Modifier.size(16.dp)
        )
    }
}

@Composable
fun PlaceholderScreen(name: String) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(LightBlue),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = name,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = DarkBlue
        )
    }
}
