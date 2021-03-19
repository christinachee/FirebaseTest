package com.example.firebasetest.ui


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.firebasetest.data.models.Entry
import com.example.firebasetest.databinding.EntryItemBinding

class EntriesAdapter() : ListAdapter<Entry, EntryViewHolder>(DiffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EntryViewHolder {
        val binding = EntryItemBinding.inflate(LayoutInflater.from(parent.context))
        return EntryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EntryViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    companion object DiffCallback: DiffUtil.ItemCallback<Entry>() {
        override fun areItemsTheSame(oldItem: Entry, newItem: Entry): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Entry, newItem: Entry): Boolean {
            return oldItem.item_name == newItem.item_name
        }

    }
}

class EntryViewHolder(private val binding: EntryItemBinding): RecyclerView.ViewHolder(binding.root) {
    private lateinit var entry: Entry

    fun bind(item: Entry) {
        this.entry = item

    }
}