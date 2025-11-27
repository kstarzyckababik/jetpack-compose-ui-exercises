package com.example.jetpack_compose_ui_exercises.exercise02

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Exercise02ListScreen() {


    val items = List(10) {
        MyItem(
            title = "Item Title",
            description = "Short description of the item goes here.\nIt can span multiple lines as needed."
        )
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF1F3F6))
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(88.dp)
                .background(Color(0xFF2D63C8))   
        )

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(items) { item ->
                ItemCard(item)
            }
        }
    }
}


@Composable
fun ItemCard(item: MyItem) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFF1F3F6)
        )
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp)
        ) {

            Box(
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .background(Color(0xFFD1D5DB))
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = item.title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.DarkGray
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = item.description,
                    fontSize = 14.sp,
                    color = Color.DarkGray
                )
            }
        }
    }
}

data class MyItem(
    val title: String,
    val description: String
)

@Preview(showBackground = true)
@Composable
fun Exercise02Preview() {
    Exercise02ListScreen()
}
