package dev.carlesav.tasklist.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dev.carlesav.tasklist.data.database.entitites.TaskEntity

@Dao
interface TasksDao {
    @Query("SELECT * FROM tasks_table")
    suspend fun getTasks(): List<TaskEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(task: TaskEntity)
}