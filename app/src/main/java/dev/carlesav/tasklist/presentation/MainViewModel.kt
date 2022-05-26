package dev.carlesav.tasklist.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.carlesav.tasklist.domain.model.Task
import dev.carlesav.tasklist.domain.use_case.DeleteTaskUseCase
import dev.carlesav.tasklist.domain.use_case.GetTasksUseCase
import dev.carlesav.tasklist.domain.use_case.InsertTaskUseCase
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getTasksUseCase: GetTasksUseCase,
    private val insertTaskUseCase: InsertTaskUseCase,
    private val deleteTaskUseCase: DeleteTaskUseCase,
) : ViewModel() {
    private val tasksList = MutableLiveData<List<Task>>()

    fun init() {
        getTasks()
    }

    private fun getTasks() {
        getTasksUseCase().onEach { tasks ->
            tasksList.value = tasks
        }.launchIn(viewModelScope)
    }

    fun getTasksList() = tasksList

    private fun insertTask(text: String) {
        viewModelScope.launch {
            insertTaskUseCase.invoke(text)
        }
    }

    private fun deleteTask(task: Task) {
        viewModelScope.launch {
            deleteTaskUseCase.invoke(task)
        }
    }

    fun onEvent(event: TasksListEvents) {
        when (event) {
            is TasksListEvents.OnAddTask -> {
                insertTask(event.text)
            }
            is TasksListEvents.OnDeleteTask -> {
                deleteTask(event.task)
            }
        }
    }
}