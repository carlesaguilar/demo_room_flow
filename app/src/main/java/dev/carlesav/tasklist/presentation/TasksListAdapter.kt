package dev.carlesav.tasklist.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.carlesav.tasklist.databinding.ItemTaskBinding
import dev.carlesav.tasklist.domain.model.Task

class TasksListAdapter() :
    RecyclerView.Adapter<TasksListAdapter.HeroViewHolder>() {

    private var items = mutableListOf<Task>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder =
        HeroViewHolder(
            ItemTaskBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
        holder.bind(item = items[position])
    }

    fun addItems(newItems: List<Task>) {
        items.clear()
        items = items.toMutableList().apply { addAll(newItems) }
    }

    class HeroViewHolder(private val binding: ItemTaskBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Task) {
            binding.taskText.text = item.text
        }
    }
}