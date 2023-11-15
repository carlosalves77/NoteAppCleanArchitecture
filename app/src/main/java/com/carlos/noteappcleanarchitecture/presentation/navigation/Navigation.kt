package com.carlos.noteappcleanarchitecture.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

enum class Screens {
    Home, Detail, Bookmark
}

@Composable
fun NoteNavigation(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
) {
    NavHost(navController =
    navHostController, startDestination = Screens.Home.name) {
        composable(route = Screens.Home.name) {

        }
    }

}