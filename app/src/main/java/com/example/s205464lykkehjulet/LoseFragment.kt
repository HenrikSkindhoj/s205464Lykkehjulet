package com.example.s205464lykkehjulet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.example.s205464lykkehjulet.databinding.FragmentLoseBinding
import com.example.s205464lykkehjulet.databinding.FragmentWinBinding

/**
 * The lose fragment which contains a button to start a new game, and a textView telling the user
 * that they have lost
 */
class LoseFragment : Fragment(R.layout.fragment_lose) {

    var _binding: FragmentLoseBinding? = null
    val binding get() = _binding!!
    val data: DataViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoseBinding.inflate(inflater,container,false)
        val view = binding.root
        binding.tvLose
        binding.buttonLose
        binding.buttonLose.setOnClickListener{
            data.newGame()
            Navigation.findNavController(view).navigate(R.id.loseToStart)
        }


        return view
    }

}