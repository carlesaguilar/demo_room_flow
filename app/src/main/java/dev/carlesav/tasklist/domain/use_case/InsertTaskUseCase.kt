package dev.carlesav.tasklist.domain.use_case

import dev.carlesav.tasklist.domain.repository.TasksRepository
import javax.inject.Inject

class InsertTaskUseCase @Inject constructor(private val repository: TasksRepository) {
    suspend operator fun invoke(text: String) = repository.insertTask(text)
}