package com.example.manualdigamecorner.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DeviceCard(
    modifier: Modifier = Modifier,
    show: Boolean,
    image: String,
    label: String,
    description: String,
    onShowChange: (Boolean) -> Unit
) {
    ElevatedCard(
        modifier = modifier,
        onClick = { /*TODO*/ },
        elevation = CardDefaults.elevatedCardElevation(
            defaultElevation = 2.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp, horizontal = 16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                AsyncImage(
                    modifier = Modifier
                        .size(110.dp)
                        .clip(RoundedCornerShape(14.dp)),
                    model = image,
                    contentDescription = "",
                    contentScale = ContentScale.Crop
                )

                Text(
                    modifier = Modifier
                        .padding(start = 21.dp),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    text = label
                )
            }

            AnimatedVisibility(visible = show) {
                Text(
                    modifier = Modifier.padding(top = 16.dp),
                    text = description
                )
            }

            Text(
                modifier = Modifier
                    .align(Alignment.End)
                    .clickable {
                        onShowChange(!show)
                    },
                text = if (show) "Hide..." else "Show...",
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
                color = Color(0xff4248FF)
            )
        }
    }
}