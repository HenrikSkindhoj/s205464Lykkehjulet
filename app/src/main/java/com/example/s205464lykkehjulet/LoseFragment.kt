package com.example.s205464lykkehjulet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.s205464lykkehjulet.databinding.FragmentLoseBinding


class LoseFragment : Fragment(R.layout.fragment_lose) {

    private lateinit var binding: FragmentLoseBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoseBinding.inflate(inflater,container,false)
        val view = binding.root
        binding.ivLose
        binding.buttonLose
        binding.buttonLose.setOnClickListener{Navigation.findNavController(view).navigate(R.id.loseToStart)}


        return view
    }

}