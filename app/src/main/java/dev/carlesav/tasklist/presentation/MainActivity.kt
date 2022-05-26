package dev.carlesav.tasklist.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import dev.carlesav.tasklist.databinding.ActivityMainBinding

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: TasksListAdapter
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpRecycler()
        initUI()
    }

    private fun setUpRecycler() {
        adapter = TasksListAdapter { task ->
            viewModel.onEvent(TasksListEvents.OnDeleteTask(task))
        }
        binding.recyclerview.adapter = adapter
        binding.recyclerview.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    private fun initUI() {
        viewModel.init()

        binding.addTaskBtn.setOnClickListener {
            val taskToAdd = binding.taskTxt.text.toString()
            if (taskToAdd.isNotEmpty()) {
                viewModel.onEvent(TasksListEvents.OnAddTask(taskToAdd))
                binding.taskTxt.setText("")
            }
        }

        viewModel.getTasksList().observe(this) { tasksList ->
            adapter.addItems(newItems = tasksList)
        }
    }
}
