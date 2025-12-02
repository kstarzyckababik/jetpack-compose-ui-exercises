package com.example.jetpack_compose_ui_exercises.navigation


sealed class Destination(val route: String, val title: String) {
    object Exercise01 : Destination("exercise01", "Exercise 01 - Login Screen")
    object Exercise02 : Destination("exercise02", "Exercise 02 - List Screen")
    object Exercise03 : Destination("exercise03", "Exercise 03 - Bank Home Screen ")
    // kolejne zadania
}