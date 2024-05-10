package com.example.rickandmortyapi.present.ui.detailLocation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rickandmortyapi.R
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
            bind(character)
        }
    }

    class CharacterItemViewHolder(private val binding: ItemCharacterIconBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(character: ResidenceCharacter) {
            binding.textName.setText(character.name)

            Glide.with(this.binding.root).load(character.image).into(binding.imageIcon)
            binding.statusCharacter.setText(character.status)

            if(character.status.equals("Alive")){
                binding.statusCharacter.setBackground(ContextCompat.getDrawable(itemView.context, R.drawable.rounded_corner_green))
                binding.statusCharacter.setTextColor(ContextCompat.getColor(itemView.context, R.color.green))
            } else if(character.status.equals("Dead")){
                binding.statusCharacter.setBackground(ContextCompat.getDrawable(itemView.context, R.drawable.rounded_corner_red))
                binding.statusCharacter.setTextColor(ContextCompat.getColor(itemView.context, R.color.red))
            } else {
//                binding.statusCharacter.setTextColor(Color.Gray)
            }
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