package com.example.s205464lykkehjulet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.children
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.example.s205464lykkehjulet.databinding.FragmentPlayBinding

/**
 * Fragment for the play screen which switches between the guessing game part of the program and
 * the wheel which changes the players points, and lives
 */
class PlayFragment : Fragment(R.layout.fragment_play) {

    var _binding: FragmentPlayBinding? = null
    val binding get() = _binding!!
    val data: DataViewModel by activityViewModels()

    /**
     * Setting up the view for the play fragment
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPlayBinding.inflate(inflater, container, false)
        val view = binding.root
        binding.tvCategory.setText(data.categoryName)
        binding.tvLife
        binding.tvPoint

        binding.tvWheelResult
        binding.wResult

        val gameState = data.newGame()
        updateState(gameState)


        binding.lettersLayout.children.forEach { letterView ->
            if (letterView is TextView) {
                letterView.setOnClickListener {
                    val gameState = playingState((letterView).text[0])
                    data.gueesingWord = false
                    updateState(gameState)
                    letterView.visibility = View.GONE
                }
            }
        }


        binding.buttonSpin.setOnClickListener {
            data.spin()
        updateState(data.getGameState())
        }

        return view

    }

    /**
     * A function for update what happens in the different states of the program
     */
    fun updateState(gameState: GameState) {
        when (gameState) {
            is GameState.GameLost -> showGameLost()
            is GameState.Playing -> {
                binding.tvCorrectWord.setText(data.hiddenWord)
                binding.tvUsedLetters.setText("Used Letters: ${data.usedLetters}")
                binding.point.text = " ${data.playerPoints}"
                binding.life.text = " ${data.playerLives}"
                binding.wResult.setText(data.pointResult)
                if (data.gueesingWord){
                    binding.buttonSpin.visibility = View.INVISIBLE
                    binding.lettersLayout.visibility = View.VISIBLE
                } else {
                    binding.buttonSpin.visibility = View.VISIBLE
                    binding.lettersLayout.visibility = View.INVISIBLE
                }

            }
            is GameState.GameWon -> showGameWon()
        }
    }


    /**
     * The function for the process of guessing a letter and spinning the wheel
     */
    fun playingState(letter: Char): GameState {
        data.usedLetters += "$letter"
        val indexes = mutableListOf<Int>()

        data.correctWord.forEachIndexed { index, char ->
            if (char.equals(letter, true)) {
                indexes.add(index)
            }
        }
        var newHiddenWord = "" + data.hiddenWord
        indexes.forEach { index ->
            val sb = StringBuilder(newHiddenWord).also { it.setCharAt(index, letter) }
            newHiddenWord = sb.toString()
            data.playerPoints = data.playerPoints + data.curSpin
        }
        if (indexes.isEmpty()) {
            data.playerLives--
        }
        data.hiddenWord = newHiddenWord
        data.curSpin = 0

        return data.getGameState()
    }



    fun showGameLost() {
        view?.let { Navigation.findNavController(it).navigate(R.id.playToLose) }
    }

    fun showGameWon() {
        view?.let { Navigation.findNavController(it).navigate(R.id.playToWin) }
    }


}