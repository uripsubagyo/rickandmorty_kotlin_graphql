package com.example.rickandmortyapi.ui.ui.detailLocation.Adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rickandmortyapi.databinding.ItemCharacterIconBinding
import com.example.rickandmortyapi.domain.model.Location.ResidenceCharacter

class CharacterIconAdapter(
) : ListAdapter<ResidenceCharacter, CharacterIconAdapter.CharacterItemViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterItemViewHolder {
        val binding = ItemCharacterIconBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharacterItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharacterItemViewHolder, position: Int) {

        holder.apply {
            val character = getItem(position)
            Log.d("Data_", "data: $character")
            bind(character)
        }
    }

    class CharacterItemViewHolder(private val binding: ItemCharacterIconBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(character: ResidenceCharacter) {
            binding.textName.setText(character.name)

            Glide.with(this.binding.root).load(character.image).into(binding.imageIcon)
            binding.statusCharacter.setText(character.status)
        }
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ResidenceCharacter>() {
            override fun areItemsTheSame(oldItem: ResidenceCharacter, newItem: ResidenceCharacter): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: ResidenceCharacter, newItem: ResidenceCharacter): Boolean {
                return oldItem == newItem
            }
        }
    }
}