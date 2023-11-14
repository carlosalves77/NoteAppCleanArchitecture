package com.carlos.noteappcleanarchitecture.di

import com.carlos.noteappcleanarchitecture.data.repository.NoteRepositoryImpl
import com.carlos.noteappcleanarchitecture.domain.repository.Repository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindRepository(repositoryImpl: NoteRepositoryImpl): Repository
}