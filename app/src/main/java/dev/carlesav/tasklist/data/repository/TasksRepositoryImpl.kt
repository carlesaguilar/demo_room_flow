package dev.carlesav.tasklist.data.repository

import dev.carlesav.tasklist.data.database.dao.TasksDao
import dev.carlesav.tasklist.data.database.entitites.TaskEntity
import dev.carlesav.tasklist.domain.repository.TasksRepository
import kotlinx.coroutines.flow.Flow

class TasksRepositoryImpl(
    private val dao: TasksDao,
) : TasksRepository {
    override fun getTasks(): Flow<List<TaskEntity>> = dao.getTasks()

    override suspend fun insertTask(text: String) {
        dao.insertTask(TaskEntity(text = text))
    }
}