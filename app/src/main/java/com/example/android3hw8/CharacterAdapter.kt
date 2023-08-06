package com.example.android3hw8

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android3hw8.databinding.ItemCharacterBinding
import kotlin.reflect.KFunction1

class CharacterAdapter(
    private val characterList: ArrayList<Character>,
    val onItemClick: (character:Character)->Unit
) : RecyclerView.Adapter<CharacterAdapter.CharacterHolder>() {
    inner class CharacterHolder(private val binding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(character: Character) = with(binding) {
            tvName.text = character.name
            tvAlive.text = character.alive
            Glide.with(ivImg).load(character.image).into(ivImg)
            itemView.setOnClickListener {
                onItemClick(character)
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterHolder {
        return CharacterHolder(
            ItemCharacterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
    override fun getItemCount(): Int {
        return characterList.size
    }
    override fun onBindViewHolder(holder: CharacterHolder, position: Int) {
        holder.bind(characterList[position])
    }
}