package dev.carlesav.tasklist.data.repository

import dev.carlesav.tasklist.data.database.dao.TasksDao
import dev.carlesav.tasklist.data.database.entitites.TaskEntity
import dev.carlesav.tasklist.domain.model.Task
import dev.carlesav.tasklist.domain.model.toTask
import dev.carlesav.tasklist.domain.repository.TasksRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TasksRepositoryImpl(
    private val dao: TasksDao,
) : TasksRepository {
    override fun getTasks(): Flow<List<Task>> = dao.getTasks().map { taskEntitylist ->
        taskEntitylist.map { taskEntity ->
            taskEntity.toTask()
        }
    }

    override suspend fun insertTask(text: String) {
        dao.insertTask(TaskEntity(text = text))
    }
}