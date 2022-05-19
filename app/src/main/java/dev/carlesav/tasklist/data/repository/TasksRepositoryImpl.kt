package dev.carlesav.tasklist.data.repository

import dev.carlesav.tasklist.data.database.dao.TasksDao
import dev.carlesav.tasklist.data.database.entitites.TaskEntity
import dev.carlesav.tasklist.domain.repository.TasksRepository

class TasksRepositoryImpl(
    private val dao: TasksDao,
) : TasksRepository {
    override suspend fun insertTask(text: String) {
        dao.insertTask(TaskEntity(text = text))
    }
}