package dev.carlesav.tasklist.data.database.entitites

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import dev.carlesav.tasklist.domain.model.Task

@Entity(tableName = "tasks_table")
data class TaskEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "text") val text: String,
)

fun Task.toTaskEntity() = TaskEntity(text = text)