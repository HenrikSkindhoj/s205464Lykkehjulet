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
    var activateKeyboard: Boolean = false
    var result: String = ""
    lateinit var hiddenWord: String
    lateinit var correctWord:String



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



    fun newGame(): GameState {
        usedLetters = ""
        playerLives = 5
        playerPoints = 0
        hideWord(correctWord)
        return getGameState()
    }


    fun hideWord(correctWord: String) {
        val sb = StringBuilder()
        correctWord.forEach { char ->
            if (char == ' ') {
                sb.append(' ')
            } else if (char == '-') {
                sb.append("- ")
            } else {
                sb.append("_ ")
            }
        }
        hiddenWord = sb.toString()
    }


    fun spin(){
        val wheelPrizes = arrayOf("100","300","300","300","100","500","500","500","500","500","500","600","600","800","800","1000","1000","1500","Miss turn","Extra turn","Extra turn","Miss turn","Bankrupt")
        var randomPrize = Random.nextInt(0,22)
        result = wheelPrizes[randomPrize]
        if (randomPrize <= 17) {
            activateKeyboard = true
        }

    }

    fun setHiddenWord() : String{
        hiddenWord = hideWord(correctWord).toString()
        return hiddenWord
    }

    fun getGameState() : GameState {
        if (hiddenWord == correctWord){
            return GameState.GameWon(correctWord)
        }

        if (playerLives == 0){
            return GameState.GameLost(correctWord)
        }

        return GameState.Playing(usedLetters,hiddenWord)
    }


}