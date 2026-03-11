package com.example.uilover.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uilover.R
import com.example.uilover.model.Trend
import com.example.uilover.ui.theme.CategoryOvalColor
import com.example.uilover.ui.theme.DarkBlue
import com.example.uilover.ui.theme.SearchBarColor
import com.example.uilover.ui.theme.TextGray

@Composable
fun AnimatedItem(visible: Boolean, delay: Int, content: @Composable () -> Unit) {
    val density = LocalDensity.current
    val slideDistance = with(density) { 50.dp.roundToPx() }
    AnimatedVisibility(
        visible = visible,
        enter = fadeIn(animationSpec = tween(durationMillis = 700, delayMillis = delay))
                + slideInVertically(
            animationSpec = tween(durationMillis = 700, delayMillis = delay),
            initialOffsetY = { slideDistance }
        )
    ) {
        content()
    }
}

@Composable
@Preview
fun HeaderSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = DarkBlue)
            .padding(all = 32.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.user_2),
                contentDescription = null,
                modifier = Modifier
                    .size(size = 50.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .padding(start = 12.dp)
                    .weight(1f)
            ) {
                Text(
                    text = "Hi, Alex",
                    color = Color.White,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium
                )
            }
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(Color.White.copy(alpha = 0.1f), CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.notification),
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(20.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Find Your Favorite\nHere!",
            color = Color.White,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 32.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = "",
            onValueChange = {},
            placeholder = {
                Text(
                    text = "Search...",
                    color = Color.White.copy(alpha = 0.7f)
                )
            },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.search),
                    contentDescription = null,
                    tint = Color.White
                )
            },
            trailingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.microphone),
                    contentDescription = null,
                    tint = Color.White
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(height = 55.dp),
            shape = RoundedCornerShape(size = 50.dp),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                focusedContainerColor = SearchBarColor,
                unfocusedContainerColor = SearchBarColor,
                cursorColor = Color.White
            ),
            singleLine = true
        )
    }
}

@Composable
fun CategoryItem(iconRes: Int, title: String) {
    Card(
        shape = RoundedCornerShape(size = 10.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        modifier = Modifier
            .width(width = 100.dp)
            .height(height = 120.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .size(size = 60.dp)
                    .clip(CircleShape)
                    .background(CategoryOvalColor),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = iconRes),
                    contentDescription = null,
                    modifier = Modifier.size(size = 30.dp)
                )
            }
            Spacer(modifier = Modifier.height(height = 8.dp))
            Text(
                text = title,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }
    }
}

@Composable
@Preview
fun MiddleSection() {
    Box(modifier = Modifier.fillMaxWidth()) {
        Image(
            painter = painterResource(id = R.drawable.arc_2),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            CategoryItem(iconRes = R.drawable.favorites, title = "Favorites")
            CategoryItem(iconRes = R.drawable.message, title = "Message")
            CategoryItem(iconRes = R.drawable.social, title = "Social")
        }
    }
}

@Composable
fun TrendItem(trend: Trend) {
    Card(
        shape = RoundedCornerShape(size = 10.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        modifier = Modifier
            .width(width = 205.dp)
            .height(height = 280.dp)
            .padding(bottom = 8.dp)
    ) {
        Column {
            Image(
                painter = painterResource(id = trend.picRes),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(height = 160.dp)
                    .clip(shape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp)),
                contentScale = ContentScale.Crop
            )
            Text(
                text = trend.title,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = TextGray,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(start = 8.dp, end = 8.dp, top = 8.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = trend.subtitle,
                fontSize = 12.sp,
                color = DarkBlue,
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 8.dp)
            )
        }
    }
}

@Preview
@Composable
fun TrendItemPreview() {
    TrendItem(
        trend = Trend(
            title = "Mountain",
            subtitle = "Himalaya",
            picRes = R.drawable.trends
        )
    )
}

@Composable
@Preview
fun TrendsSection() {
    val trends = listOf(
        Trend(title = "Future in AI, What will tomorrow be like?", subtitle = "The National", picRes = R.drawable.trends),
        Trend(title = "Important points in concluding a work contract", subtitle = "Reuters", picRes = R.drawable.trends2),
        Trend(title = "Future in AI, What will tomorrow be like?", subtitle = "The National", picRes = R.drawable.trends)
    )

    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
                .padding(top = 32.dp, bottom = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Trends",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = DarkBlue
            )
            Text(
                text = "View All",
                fontSize = 14.sp,
                color = Color.Gray
            )
        }
        
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = androidx.compose.foundation.layout.PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(trends) { trend ->
                TrendItem(trend = trend)
            }
        }
    }
}
