package com.carlos.noteappcleanarchitecture.domain.use_cases

import com.carlos.noteappcleanarchitecture.domain.repository.Repository
import javax.inject.Inject

class GetNoteByIdUseCase @Inject constructor(
    private val repository: Repository
) {
     operator fun invoke(id: Long) = repository.getNoteById(id)
}