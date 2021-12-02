package com.example.s205464lykkehjulet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.s205464lykkehjulet.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var data: DataViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        data = ViewModelProvider(this).get(DataViewModel::class.java)
    }

}