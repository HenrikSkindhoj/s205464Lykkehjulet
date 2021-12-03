package com.example.s205464lykkehjulet

/**
 * The program is split into 3 states, which determine what is currently happening.
 */
sealed class GameState {

    class Playing(val usedLetters: String, val hiddenWord: String) : GameState()

    class GameLost(val correctWord: String) : GameState()

    class GameWon(val correctWord: String) : GameState()


}