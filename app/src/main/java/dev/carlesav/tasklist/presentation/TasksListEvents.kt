package dev.carlesav.tasklist.presentation

import dev.carlesav.tasklist.domain.model.Task

sealed class TasksListEvents {
    data class OnAddTask(val text: String) : TasksListEvents()
    data class OnDeleteTask(val task: Task) : TasksListEvents()
}