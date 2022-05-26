package dev.carlesav.tasklist.presentation

sealed class TasksListEvents {
    data class OnAddTask(val text: String) : TasksListEvents()
}