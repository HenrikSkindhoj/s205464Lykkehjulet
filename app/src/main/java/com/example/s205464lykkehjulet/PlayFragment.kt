package com.example.s205464lykkehjulet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.example.s205464lykkehjulet.databinding.FragmentPlayBinding
import com.example.s205464lykkehjulet.databinding.FragmentWinBinding


class PlayFragment : Fragment(R.layout.fragment_play) {

    var _binding: FragmentPlayBinding? = null
    val binding get() = _binding!!
    val data: DataViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPlayBinding.inflate(inflater, container, false)
        val view = binding.root
        binding.buttonSpin
        binding.tvCategory
        binding.tvLife
        binding.tvPoint
        binding.tvUsedLetters
        binding.tvCorrectWord
        binding.life.setText(" "+data.playerLives)
        binding.point.setText(" "+data.playerPoints)

        return view

    }

    fun gainPoints(){
        binding.point.setText(data.playerPoints + 1)
        data.playerPoints += 1
    }

    fun missTurn(){
        binding.life.setText(data.playerLives - 1)
        data.playerLives -= 1
    }

    fun extraTurn(){
        binding.life.setText(data.playerLives + 1)
        data.playerLives += 1
    }

    fun bankrupt(){
        binding.point.setText(data.playerPoints - data.playerPoints)
        data.playerPoints = 0
    }


}