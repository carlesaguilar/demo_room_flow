package dev.carlesav.tasklist.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import dev.carlesav.tasklist.databinding.ActivityMainBinding

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
    }

    private fun initUI() {
        viewModel.getTasks()
        binding.addTaskBtn.setOnClickListener {
            viewModel.onEvent(TasksListEvents.OnAddTask(binding.taskTxt.toString()))
            binding.taskTxt.setText("")
        }
    }
}
