package com.example.rickandmortyapi.present.ui.home.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rickandmortyapi.databinding.ItemCharacterCardBinding
import com.example.rickandmortyapi.domain.model.characters.SimpleCharacter
import com.example.rickandmortyapi.present.ui.detailCharacter.DetailCharacter

class CharacterListAdapter(
) : ListAdapter<SimpleCharacter, CharacterListAdapter.CharacterViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewtype:Int): CharacterViewHolder {
        val binding = ItemCharacterCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharacterViewHolder( binding)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.apply {
            val character = getItem(position)
            bind(character)

            holder.itemView.setOnClickListener{
                val toDetailScreen = Intent(holder.itemView.context, DetailCharacter::class.java)
                toDetailScreen.putExtra(DetailCharacter.ID, character.id)
                holder.itemView.context.startActivity(toDetailScreen)
            }
        }

    }
    class CharacterViewHolder(
        private val binding: ItemCharacterCardBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(character: SimpleCharacter){
            binding.typeCharacter.setText(character.species)
            binding.nameItem.setText(character.name)
            Glide.with(binding.imageIcon).load(character.image).into(binding.imageIcon)
        }
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<SimpleCharacter>() {
            override fun areItemsTheSame(oldItem: SimpleCharacter, newItem: SimpleCharacter): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: SimpleCharacter, newItem: SimpleCharacter): Boolean {
                return oldItem == newItem
            }
        }
    }
}