package dev.carlesav.tasklist.domain.use_case

import dev.carlesav.tasklist.domain.repository.TasksRepository
import javax.inject.Inject

class GetTasksUseCase @Inject constructor(private val repository: TasksRepository) {
    operator fun invoke() = repository.getTasks()
}