package com.example.jetpack_compose_ui_exercises.navigation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.*
import androidx.navigation.compose.rememberNavController
import com.example.jetpack_compose_ui_exercises.exercise01.Exercise01LoginScreen
import com.example.jetpack_compose_ui_exercises.exercise02.Exercise02ListScreen


@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") {
            HomeScreen(onExerciseClick = { route ->
                navController.navigate(route)
            })
        }

        composable(Destination.Exercise01.route) {
            Exercise01LoginScreen()
        }

        composable(Destination.Exercise02.route) {
            Exercise02ListScreen()
        }
    }
}

@Composable
fun HomeScreen(onExerciseClick: (String) -> Unit) {
    val items = listOf(
        Destination.Exercise01,
        Destination.Exercise02
        // kolejne zadania
    )

    LazyColumn(Modifier.padding(16.dp)) {
        items(items.size) { index ->
            val item = items[index]
            Card(
                Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .clickable { onExerciseClick(item.route) }
            ) {
                Text(
                    text = item.title,
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }
    }
}
