package com.carlos.noteappcleanarchitecture.domain.repository

import com.carlos.noteappcleanarchitecture.data.local.model.Note
import kotlinx.coroutines.flow.Flow

interface Repository {

    fun getAllNotes(): Flow<List<Note>>
    fun getNoteById(id: Long): Flow<Note>
    suspend fun insert(note: Note)

    suspend fun update(note: Note)
    suspend fun delete(id: Long)

    fun getBookMarkedNotes(): Flow<List<Note>>

}