package com.carlos.noteappcleanarchitecture.data.local

import androidx.room.Dao
import java.util.concurrent.Flow

@Dao
interface NoteDao {

    fun getAllNotes(): Flow
}