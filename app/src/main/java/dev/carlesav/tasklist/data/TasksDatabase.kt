package dev.carlesav.tasklist.data

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.carlesav.tasklist.data.database.dao.TasksDao
import dev.carlesav.tasklist.data.database.entitites.TaskEntity

@Database(entities = [TaskEntity::class], version = 1)
abstract class TasksDatabase : RoomDatabase() {
    abstract fun getTasksDao(): TasksDao
}