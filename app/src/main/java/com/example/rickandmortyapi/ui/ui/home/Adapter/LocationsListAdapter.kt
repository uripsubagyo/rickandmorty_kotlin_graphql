package com.example.rickandmortyapi.ui.ui.home.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortyapi.databinding.ItemLocationCardBinding
import com.example.rickandmortyapi.domain.model.Location.SimpleLocation
import com.example.rickandmortyapi.ui.ui.detailLocation.DetailLocation

class LocationsListAdapter : ListAdapter<SimpleLocation, LocationsListAdapter.LocationViewHolder>(DIFF_CALLBACK) {
    override fun onCreateViewHolder(parent: ViewGroup, viewtype: Int): LocationViewHolder {
        val binding = ItemLocationCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LocationViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        holder.apply {
            val location = getItem(position)
            bind(location)

            holder.itemView.setOnClickListener {
                val toDetailLocation = Intent(holder.itemView.context, DetailLocation::class.java)
                toDetailLocation.putExtra(DetailLocation.ID, location.id)
                holder.itemView.context.startActivity(toDetailLocation)
            }
        }
    }

    class LocationViewHolder(private val binding: ItemLocationCardBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(location: SimpleLocation) {
            binding.nameLocation.setText(location.name)
            binding.seeDetail.setText(location.type)
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