package com.example.myapps

import androidx.navigation.NavArgs

sealed class Screen(val route: String) {
    object MainScreen: Screen("main_screen")
    object DetailScreen: Screen("detail_screen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}
