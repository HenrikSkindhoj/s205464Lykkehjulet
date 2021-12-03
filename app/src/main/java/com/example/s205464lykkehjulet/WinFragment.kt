package com.example.s205464lykkehjulet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.example.s205464lykkehjulet.databinding.FragmentShowCategoryBinding
import com.example.s205464lykkehjulet.databinding.FragmentStartBinding
import com.example.s205464lykkehjulet.databinding.FragmentWinBinding

/**
 * Fragment for the win screen, which contains a button to start a new game, and the textView,
 * showing that the player has won
 */
class WinFragment : Fragment(R.layout.fragment_win) {

    var _binding: FragmentWinBinding? = null
    val binding get() = _binding!!
    val data: DataViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWinBinding.inflate(inflater,container,false)
        val view = binding.root
        binding.tvWin
        binding.buttonWin.setOnClickListener{
            data.newGame()
            Navigation.findNavController(view).navigate(R.id.winToStart)}



        return view
    }

}