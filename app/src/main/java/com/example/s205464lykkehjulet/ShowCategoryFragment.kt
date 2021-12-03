package com.example.s205464lykkehjulet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.s205464lykkehjulet.databinding.FragmentShowCategoryBinding
import com.example.s205464lykkehjulet.databinding.FragmentWinBinding

/**
 * The showcategory fragment which contains a layoutmanager and a adapter,
 * to create the recyclerView
 */
class ShowCategoryFragment : Fragment() {
    private val gameData : DataViewModel by activityViewModels()
    var _binding: FragmentShowCategoryBinding? = null
    val binding get() = _binding!!

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        layoutManager = LinearLayoutManager(context)
        _binding = FragmentShowCategoryBinding.inflate(inflater, container,false)
        val view = binding.root
        binding.recyclerView.layoutManager = layoutManager
        val adapter = RecyclerAdapter(gameData)
        binding.recyclerView.adapter = adapter

        return view
    }


}