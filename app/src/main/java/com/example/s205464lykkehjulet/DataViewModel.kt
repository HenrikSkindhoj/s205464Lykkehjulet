package com.example.s205464lykkehjulet

import androidx.lifecycle.ViewModel
import com.example.s205464lykkehjulet.databinding.FragmentPlayBinding

class DataViewModel: ViewModel() {
    var playerLives = 5
    var playerPoints = 0
    private var usedLetters: String = ""
    private lateinit var hiddenWord: String
    private lateinit var correctWord:String
    val wheelPrizes = arrayOf("100","300","300","300","100","500","500","500","500","500","500","600","600","800","800","1000","1000","1500","Miss turn","Extra turn","Extra turn","Miss turn","Bankrupt")

       fun startGame(): String.Companion {
           usedLetters = ""

           return String
       }


    fun hideWord(word: String) {
        val sb = StringBuilder()
        word.forEach { char ->
            if (char == ' ') {
                sb.append(' ')
            } else if (char == '-') {
                sb.append("-")
            } else {
                sb.append("_")
            }
        }
        hiddenWord = sb.toString()
    }

    /*
    fun curGameState(): GameState {

    }

    fun chooseCategory(enum: Words) {
        Mutablelive

    }


 */



}