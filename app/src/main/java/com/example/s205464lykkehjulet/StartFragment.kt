package com.example.s205464lykkehjulet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.s205464lykkehjulet.databinding.FragmentStartBinding
import com.example.s205464lykkehjulet.databinding.FragmentWinBinding

/**
 * The start fragment, which is the home screen, and is set in the navigation to be the first
 * fragment that is shown
 */
class StartFragment : Fragment(R.layout.fragment_start) {

    var _binding: FragmentStartBinding? = null
    val binding get() = _binding!!
    val data: DataViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStartBinding.inflate(inflater,container,false)
        val view = binding.root
        binding.tvStart
        binding.buttonStart
        binding.buttonStart.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.startToCat) }



        return view
    }

}