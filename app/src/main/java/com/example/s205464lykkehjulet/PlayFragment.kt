package com.example.s205464lykkehjulet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.s205464lykkehjulet.databinding.FragmentPlayBinding


class PlayFragment : Fragment(R.layout.fragment_play) {

    private lateinit var binding: FragmentPlayBinding
    var playerLives = 5
    var playerPoints = 0


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPlayBinding.inflate(inflater, container, false)
        val view = binding.root
        binding.buttonSpin
        binding.tvCategory
        binding.tvLife
        binding.tvPoint
        binding.tvWordname
        binding.life.setText(playerLives)
        return view
    }

    fun missTurn(){
        binding.life.setText(playerLives - 1)
        playerLives -= 1
    }

    fun extraTurn(){
        binding.life.setText(playerLives + 1)
        playerLives += 1
    }

    fun bankrupt(){
        binding.point.setText(playerPoints - playerPoints)
        playerPoints = 0
    }


}