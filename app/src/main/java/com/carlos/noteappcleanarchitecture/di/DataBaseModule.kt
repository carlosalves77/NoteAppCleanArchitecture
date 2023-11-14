package com.carlos.noteappcleanarchitecture.di

import android.content.Context
import androidx.room.Room
import com.carlos.noteappcleanarchitecture.data.local.NoteDao
import com.carlos.noteappcleanarchitecture.data.local.NoteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Provides
    @Singleton
    fun provideNoteDao(database: NoteDatabase): NoteDao =
        database.noteDao

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): NoteDatabase = Room.databaseBuilder(
        context,
        NoteDatabase::class.java,
        "notes_db"
    ).build()
}