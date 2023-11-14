package com.carlos.noteappcleanarchitecture.domain.use_cases

import com.carlos.noteappcleanarchitecture.data.local.model.Note
import com.carlos.noteappcleanarchitecture.domain.repository.Repository
import javax.inject.Inject

class AddUseCase @Inject constructor(
    private val repository: Repository
) {
    suspend operator fun invoke(note: Note) = repository.insert(note)
}