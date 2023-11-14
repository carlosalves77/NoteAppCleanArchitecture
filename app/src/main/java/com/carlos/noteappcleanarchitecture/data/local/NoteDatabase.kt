package com.carlos.noteappcleanarchitecture.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.carlos.noteappcleanarchitecture.data.local.converter.DataConverter
import com.carlos.noteappcleanarchitecture.data.local.model.Note


@TypeConverters(value = [DataConverter::class])
@Database(
    entities = [Note::class],
    version = 1,
    exportSchema = false
)
abstract class NoteDatabase: RoomDatabase() {

    abstract val noteDao: NoteDao
}