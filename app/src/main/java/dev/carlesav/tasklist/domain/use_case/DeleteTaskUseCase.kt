package dev.carlesav.tasklist.domain.use_case

import dev.carlesav.tasklist.domain.model.Task
import dev.carlesav.tasklist.domain.repository.TasksRepository
import javax.inject.Inject

class DeleteTaskUseCase @Inject constructor(private val repository: TasksRepository) {
    suspend operator fun invoke(task: Task) = repository.deleteTask(task)
}