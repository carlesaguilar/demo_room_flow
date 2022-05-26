package dev.carlesav.tasklist.domain.repository

import dev.carlesav.tasklist.data.database.entitites.TaskEntity
import kotlinx.coroutines.flow.Flow

interface TasksRepository {
    fun getTasks(): Flow<List<TaskEntity>>

    suspend fun insertTask(text: String)
}