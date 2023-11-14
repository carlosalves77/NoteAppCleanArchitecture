package com.carlos.noteappcleanarchitecture.domain.use_cases

import com.carlos.noteappcleanarchitecture.domain.repository.Repository
import javax.inject.Inject

class DeleteUseCase @Inject constructor(
    private val repository: Repository
) {

    suspend operator fun invoke(id: Long) = repository.delete(id)
}