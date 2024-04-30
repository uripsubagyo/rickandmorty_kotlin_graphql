package com.example.rickandmortyapi.ui.ui.home.Adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyapi.databinding.ItemLocationCardBinding
import com.example.rickandmortyapi.domain.model.Location.SimpleLocation

class LocationsListAdapter: ListAdapter<SimpleLocation, LocationsListAdapter.LocationViewHolder>(DIFF_CALLBACK){
    override fun onCreateViewHolder(parent: ViewGroup, viewtype:Int): LocationViewHolder {
        val binding = ItemLocationCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LocationViewHolder(binding)
    }

    override fun onBindViewHolder(holder:LocationViewHolder, position: Int) {
        holder.apply {
            val location = getItem(position)
            bind(location)
        }
    }

        class LocationViewHolder(private val binding: ItemLocationCardBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(location: SimpleLocation){
            binding.nameLocation.setText(location.name)
        }
    }
    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<SimpleLocation>() {
            override fun areItemsTheSame(oldItem: SimpleLocation, newItem: SimpleLocation): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: SimpleLocation, newItem: SimpleLocation): Boolean {
                return oldItem == newItem
            }
        }
    }
}