package com.carlos.noteappcleanarchitecture.presentation.bookmark

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.carlos.noteappcleanarchitecture.common.ScreenViewState
import com.carlos.noteappcleanarchitecture.data.local.model.Note
import dagger.hilt.android.lifecycle.HiltViewModel

@Composable
fun Bookmark(
    state: BookmarkState,
    modifier: Modifier = Modifier,
    onBookMarkChange: (note: Note) -> Unit,
    onDelete: (Long) -> Unit,
    onNoteClicked: (Long) -> Unit
) {

    when (state.notes) {
        is ScreenViewState.Loading -> {
            CircularProgressIndicator()
        }
        is ScreenViewState.Success -> {
            val notes = state.notes.data
            LazyColumn(
                contentPadding = PaddingValues(4.dp,),
                modifier = modifier
            ) {
                itemsIndexed(notes) { index, item ->

                }
            }
        }
    }

}
