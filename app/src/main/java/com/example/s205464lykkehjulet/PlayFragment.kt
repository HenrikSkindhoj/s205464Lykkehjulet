package com.example.s205464lykkehjulet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.s205464lykkehjulet.databinding.FragmentPlayBinding
import com.example.s205464lykkehjulet.databinding.FragmentWinBinding
import java.util.EnumSet.of
import java.util.List.of

/**
 * Fragment for the play screen which switches between the guessing game part of the program and
 * the wheel which changes the players points, and lives
 */
class PlayFragment : Fragment(R.layout.fragment_play) {

    var _binding: FragmentPlayBinding? = null
    val binding get() = _binding!!
    val data: DataViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPlayBinding.inflate(inflater, container, false)
        val view = binding.root
        binding.buttonSpin
        binding.tvCategory.setText(data.categoryName)
        binding.tvLife
        binding.tvPoint
        //binding.tvUsedLetters
        //binding.tvCorrectWord.setText(data.hiddenWord)
        binding.life.setText(" "+data.playerLives)
        binding.point.setText(" "+data.playerPoints)
        binding.tvWheelResult
        binding.result

        val gameState = data.newGame()
        updateState(gameState)


        return view

    }

    fun updateState(gameState: GameState) {
        when (gameState) {
            is GameState.GameLost -> showGameLost()
            is GameState.Playing -> {
                playingState()
                binding.tvCorrectWord.setText(data.setHiddenWord())
                binding.tvUsedLetters.setText("Used Letters: ${data.usedLetters}")
                if (data.activateKeyboard){
                    binding.buttonSpin.visibility = View.INVISIBLE
                    binding.etInput.visibility = View.VISIBLE
                } else {
                    binding.buttonSpin.visibility = View.VISIBLE
                    binding.etInput.visibility = View.INVISIBLE
                }

            }
            is GameState.GameWon -> showGameWon()
        }
    }


    fun playingState(): GameState {
        val guess = binding.etInput.text.toString().toCharArray()[0]
        if(binding.etInput.text.isNotEmpty()){
            binding.etInput.toString().lowercase()
            if (data.usedLetters.contains(guess!!)){
                return GameState.Playing(data.usedLetters, data.hiddenWord)
            }

            data.usedLetters += guess
            val indexes = mutableListOf<Int>()

            data.correctWord.forEachIndexed { index, char ->
                if(char.equals(guess,true)) {
                    indexes.add(index)
                }
            }
            var newHiddenWord = "" + data.hiddenWord
            indexes.forEach { index ->
                val sb = StringBuilder(newHiddenWord).also { it.setCharAt(index, guess) }
                newHiddenWord = sb.toString()
            }

            if (indexes.isEmpty()){
                data.playerLives--
            }
            data.hiddenWord = newHiddenWord

        }

        return data.getGameState()
    }



    fun gainPoints(){
        data.playerPoints += 1
        binding.point
    }

    fun missTurn(index: Int){
        if (index==18 || index == 21) {
            data.playerLives -= 1
            binding.life
        }
    }

    fun extraTurn(index: Int){
        if (index==19 || index==20) {
            data.playerLives += 1
            binding.life
        }
    }

    fun bankrupt(index: Int){
        if(index==22) {
            data.playerPoints = 0
            binding.point
        }
    }

    fun showGameLost() {
        view?.let { Navigation.findNavController(it).navigate(R.id.playToLose) }
    }

    fun showGameWon() {
        view?.let { Navigation.findNavController(it).navigate(R.id.playToWin) }
    }


}