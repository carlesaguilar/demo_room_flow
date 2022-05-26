package dev.carlesav.tasklist.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
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
) : ViewModel() {

    fun getTasks() {
        getTasksUseCase().onEach { tasksList ->
            Log.d("xxx", tasksList.size.toString())
        }.launchIn(viewModelScope)
    }

    private fun insertTask(text: String) {
        viewModelScope.launch {
            insertTaskUseCase.invoke(text)
        }
    }

    fun onEvent(event: TasksListEvents) {
        when (event) {
            is TasksListEvents.OnAddTask -> {
                insertTask(event.text)
            }
        }
    }
}