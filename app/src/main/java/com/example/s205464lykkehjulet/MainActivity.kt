package com.example.s205464lykkehjulet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.s205464lykkehjulet.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var wordAdapter: WordAdapter
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
        wordAdapter = WordAdapter(mutableListOf())


    }


}