package dev.carlesav.tasklist.domain.repository

interface TasksRepository {
    suspend fun insertTask(text: String)
}