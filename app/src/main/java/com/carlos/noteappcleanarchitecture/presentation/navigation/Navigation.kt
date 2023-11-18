package com.carlos.noteappcleanarchitecture.presentation.navigation

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.carlos.noteappcleanarchitecture.presentation.bookmark.Bookmark
import com.carlos.noteappcleanarchitecture.presentation.bookmark.BookmarkViewModel
import com.carlos.noteappcleanarchitecture.presentation.detail.DetailAssistedFactory
import com.carlos.noteappcleanarchitecture.presentation.detail.DetailScreen
import com.carlos.noteappcleanarchitecture.presentation.home.HomeScreen
import com.carlos.noteappcleanarchitecture.presentation.home.HomeViewModel

enum class Screens {
    Home, Detail, Bookmark
}

@SuppressLint("SuspiciousIndentation")
@Composable
fun NoteNavigation(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
    homeViewModel: HomeViewModel,
    bookmarkViewModel: BookmarkViewModel,
    assistedFactory: DetailAssistedFactory
) {
    NavHost(
        navController =
        navHostController, startDestination = Screens.Home.name
    ) {
        composable(route = Screens.Home.name) {
            val state by homeViewModel.state.collectAsState()
            HomeScreen(
                state = state,
                onBookmarkChange = homeViewModel::onBookMarkChange,
                onDeleteNote = homeViewModel::deleteNote,
                onNoteClicked = {
                    navHostController.navigateToSingleTop(
                        route = "${Screens.Detail.name}?id=$it"
                    )
                }
            )
        }

        composable(
            route = Screens.Bookmark.name
        ) {
            val state by bookmarkViewModel.state.collectAsState()
            Bookmark(
                state = state,
                onBookMarkChange = bookmarkViewModel::onBookmarkChange,
                onDelete = bookmarkViewModel::deleteNote,
                onNoteClicked = {
                    navHostController.navigateToSingleTop(
                        route = "${Screens.Detail.name}?id=$it"
                    )
                }
            )
        }

        composable(
            route = "${Screens.Detail.name}?id={id}",
            arguments = listOf(
                navArgument("id") {
                    NavType.LongType
                    defaultValue = -1L
                }
            )
        ) { navBackStackEntry ->
            val id = navBackStackEntry.arguments?.getLong("id") ?: -1L
            DetailScreen(
                noteId = id,
                navigateUp = { navHostController.navigateUp() },
                modifier = Modifier,
                assistedFactory = assistedFactory
            )
        }
    }


}

fun NavHostController.navigateToSingleTop(route: String) {
    navigate(route) {
        popUpTo(graph.findStartDestination().id) { saveState = true }
        launchSingleTop = true
        restoreState
    }
}

