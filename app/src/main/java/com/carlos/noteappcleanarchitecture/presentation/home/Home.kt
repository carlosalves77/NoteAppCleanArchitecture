package com.carlos.noteappcleanarchitecture.presentation.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.carlos.noteappcleanarchitecture.common.ScreenViewState
import com.carlos.noteappcleanarchitecture.data.local.model.Note

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    state: HomeState,
    onBookmarkChange: (note: Note) -> Unit,
    onDeleteNote: (Long) -> Unit,
    onNoteClicked: (Long) -> Unit,
) {
    when(state.notes) {
        is ScreenViewState.Loading -> {
            CircularProgressIndicator()
        }
        is ScreenViewState.Success -> {
         val notes = state.notes.data
         HomeDetail()
        }
        is ScreenViewState.Error -> {
            Text(text = state.notes.message ?: "Unknow Error",
                color = MaterialTheme.colorScheme.error
            )
        }
    }

}

@Composable
private fun HomeDetail(
    notes: List<Note>,
    modifier: Modifier,
    onBookmarkChange: (note: Note) -> Unit,
    onDeleteNote: (Long) -> Unit,
    onNoteClicked: (Long) -> Unit
) {

    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2),
        contentPadding = PaddingValues(4.dp)
    ) {
        itemsIndexed(notes) { index, item ->

        }
    }

}

@Composable
fun NoteCard(
    index: Int,
    note: Note,
    onBookmarkChange: (note: Note) -> Unit,
    onDeleteNote: (Long) -> Unit,
    onNoteClicked: (Long) -> Unit
) {
    val isEvenIndex = index % 2 == 0
    val shape = when {
        isEvenIndex -> {
            RoundedCornerShape(
                topStart = 50f,
                bottomEnd = 50f
            )
        }

        else -> {
            RoundedCornerShape(
                topStart = 50f,
                bottomEnd = 50f
            )
        }
    }
}