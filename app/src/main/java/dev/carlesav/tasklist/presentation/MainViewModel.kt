package dev.carlesav.tasklist.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.carlesav.tasklist.domain.use_case.InsertTaskUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val insertTaskUseCase: InsertTaskUseCase) :
    ViewModel() {
    fun insertTask(text: String) {
        viewModelScope.launch {
            insertTaskUseCase.invoke(text)
        }
    }
}