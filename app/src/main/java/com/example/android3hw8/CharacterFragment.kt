package com.example.android3hw8

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.android3hw8.databinding.FragmentCharacterBinding

class CharacterFragment : Fragment() {
    private lateinit var binding: FragmentCharacterBinding
     var characterList = arrayListOf<Character>(
        Character(
            "https://static.wikia.nocookie.net/rickandmorty/images/a/a6/Rick_Sanchez.png/revision/latest?cb=20160923150728",
            "Alive",
            "Rick Sanchez"
        ),
        Character(
            "https://static.wikia.nocookie.net/rickandmorty/images/e/ee/Morty501.png/revision/latest/scale-to-width-down/350?cb=20210827150137",
            "Alive",
            "Morty Smith"
        ),
        Character(
            "https://static.wikia.nocookie.net/rickandmorty/images/b/bc/Albert_Einstein.png/revision/latest?cb=20150730213810",
            "Dead",
            "Albert Einstein"
        ),
        Character(
            "https://static.wikia.nocookie.net/rickandmorty/images/f/f1/Jerry_Smith.png/revision/latest/thumbnail/width/360/height/360?cb=20160923151111",
            "Alive",
            "Jerry Smith"
        )
    )
    private lateinit var characterAdapter: CharacterAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCharacterBinding.inflate(layoutInflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        characterAdapter = CharacterAdapter(characterList, this::onItemClick)
        binding.rvCharacter.adapter = characterAdapter
    }
     private fun onItemClick(character:Character) {
        findNavController().navigate(CharacterFragmentDirections.actionCharacterFragmentToDetailsFragment(
            character
        )
        )
    }
}