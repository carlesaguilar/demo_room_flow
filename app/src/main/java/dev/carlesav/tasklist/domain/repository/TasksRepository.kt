package dev.carlesav.tasklist.domain.repository

import dev.carlesav.tasklist.domain.model.Task
import kotlinx.coroutines.flow.Flow

interface TasksRepository {
    fun getTasks(): Flow<List<Task>>

    suspend fun insertTask(text: String)

    suspend fun deleteTask(task: Task)
}