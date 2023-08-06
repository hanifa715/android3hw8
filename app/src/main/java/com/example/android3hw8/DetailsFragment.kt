package com.example.android3hw8

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.android3hw8.databinding.FragmentDetailsBinding

class DetailsFragment : Fragment() {
private lateinit var binding: FragmentDetailsBinding
private lateinit var navArgs:DetailsFragmentArgs
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
binding = FragmentDetailsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            navArgs = DetailsFragmentArgs.fromBundle(it)
            Glide.with(binding.tvDetailsImg).load(navArgs.character.image).into(binding.tvDetailsImg)
            binding.tvDetailsAlive.text = navArgs.character.alive
            binding.tvDetailsName.text = navArgs.character.name
        }
    }
    }
