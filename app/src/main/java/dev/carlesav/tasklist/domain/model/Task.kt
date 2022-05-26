package dev.carlesav.tasklist.domain.model

import dev.carlesav.tasklist.data.database.entitites.TaskEntity

data class Task(val id: Int, val text: String)

fun TaskEntity.toTask() = Task(id = id, text = text)