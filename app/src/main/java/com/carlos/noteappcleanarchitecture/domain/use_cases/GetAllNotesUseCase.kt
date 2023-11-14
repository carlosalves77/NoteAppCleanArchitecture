package com.carlos.noteappcleanarchitecture.domain.use_cases

import com.carlos.noteappcleanarchitecture.data.local.model.Note
import com.carlos.noteappcleanarchitecture.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllNotesUseCase @Inject constructor(
    private val repository: Repository
) {
    operator fun invoke(): Flow<List<Note>> = repository.getAllNotes()
}