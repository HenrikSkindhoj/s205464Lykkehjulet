package com.example.s205464lykkehjulet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.s205464lykkehjulet.databinding.FragmentStartBinding
import com.example.s205464lykkehjulet.databinding.FragmentWinBinding


class WinFragment : Fragment(R.layout.fragment_win) {

    private lateinit var binding: FragmentWinBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWinBinding.inflate(inflater,container,false)
        val view = binding.root
        binding.ivWin
        binding.buttonWin
        binding.buttonWin.setOnClickListener{Navigation.findNavController(view).navigate(R.id.winToStart)}



        return view
    }

}