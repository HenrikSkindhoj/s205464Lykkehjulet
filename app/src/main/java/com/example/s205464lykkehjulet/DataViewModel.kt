package com.example.s205464lykkehjulet

import android.content.ClipData
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

/**
 * The viewModel which makes it possible to destroy and recreate elements from the different
 * fragments.
 */

class DataViewModel: ViewModel() {

    var playerLives = 5
    var playerPoints = 0
    var categoryName: String = ""
    var usedLetters: String = ""
    var gueesingWord: Boolean = false
    var curSpin: Int = 0
    var pointResult: String = ""
    lateinit var hiddenWord: String
    lateinit var correctWord:String


    /**
     * Function for choosing the category and a word from that category
     */
    fun chooseCategory(enumitem: String ) {
        for(i in Words.values()){
            i.nameOfCategory
            if(enumitem.equals(i.nameOfCategory)){
                categoryName = i.nameOfCategory
                correctWord = i.listOf.random()

            }
        }

        Words.values().get(0).nameOfCategory
    }


    /**
     * Function for what should happen when starting a new game
     */
    fun newGame(): GameState {
        usedLetters = ""
        playerLives = 5
        playerPoints = 0
        hideWord(correctWord)
        return getGameState()
    }


    /**
     * Function for hiding word that is chosen to be gueesed
     */
    fun hideWord(correctWord: String) {
        val sb = StringBuilder()
        correctWord.forEach { char ->
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

    /**
     * Function for choosen what the outcome of spinning the wheel should be
     */
    fun spin(){
        val wheelList = Random.nextInt(0,14)
        if (wheelList <= 12) {
            gueesingWord = true
        }

        when(wheelList){
            0 -> {
                curSpin += 100
                pointResult = "100 points!"
            }
            1 -> {
                curSpin += 200
                pointResult = "200 points!"
            }
            2 -> {
                curSpin += 400
                pointResult = "400 points!"
            }
            3 -> {
                curSpin += 600
                pointResult = "600 points!"
            }
            4 -> {
                curSpin += 700
                pointResult = "700 points!"
            }
            5 -> {
                curSpin += 800
                pointResult = "800 points!"
            }
            6 -> {
                curSpin += 900
                pointResult = "900 points!"
            }
            7 -> {
                curSpin += 300
                pointResult = "300 points!"
            }
            8 -> {
                curSpin += 1000
                pointResult = "1000 points!"
            }
            9 -> {
                curSpin += 1100
                pointResult = "1100 points!"
            }
            10 -> {
                curSpin += 1500
                pointResult = "1500 points!"
            }
            11 -> {
                curSpin += 1300
                pointResult = "1300 points!"
            }
            12 -> {
                playerLives = playerLives --
                pointResult = "You miss a turn :("
            }
            13 -> {
                playerLives = playerLives ++
                pointResult = "You gain an extra turn!"
            }
            14 -> {
                playerPoints = 0
                pointResult = "bankrupt :("
            }

        }


    }


    /**
     * Getter for the gamestate
     */
    fun getGameState() : GameState {
        if (playerLives == 0){
            return GameState.GameLost
        }

        if (hiddenWord.equals(correctWord,true)){
            return GameState.GameWon
        }

        return GameState.Playing(usedLetters,hiddenWord)
    }


}