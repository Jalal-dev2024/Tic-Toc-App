package com.example.tic_toc_app.viewmodels

import android.annotation.SuppressLint
import android.util.Log
import android.widget.ImageView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tic_toc_app.R
import com.example.tic_toc_app.ui.Position
import com.example.tic_toc_app.ui.WinningLine

class PlayingViewModel: ViewModel() {

    @SuppressLint("StaticFieldLeak")
    private var buttonStartGame: MutableLiveData<Boolean> = MutableLiveData<Boolean>()
    val buttonStart :  LiveData<Boolean> = buttonStartGame

    private var playAgainDialog : MutableLiveData<Boolean> = MutableLiveData<Boolean>()
    val playAgain : LiveData<Boolean> = playAgainDialog

    private var winnerDialogPlayerO : MutableLiveData<Boolean> = MutableLiveData<Boolean>()
    val dialogPlayerO : LiveData<Boolean> = winnerDialogPlayerO

    private var winnerDialogPlayerX : MutableLiveData<Boolean> = MutableLiveData<Boolean>()
    val dialogPlayerX : LiveData<Boolean> = winnerDialogPlayerX

    private var currentPlayer = 1

    private var numberOfPlays = 0

    var isReset = false

    var sideTypeMain = 0



     fun onBoxClicked(view: ImageView, position: Position, sideType: Int?): Int {
        //  val sideType = arguments?.get("type")
        val o = 2131231101
        val x = 2131231102
        var currentPlayer = sideType

        if (isReset){
            Log.d("daeryan", " current $sideTypeMain")
            Log.d("daeryan", " current 2 $currentPlayer")
            currentPlayer = sideTypeMain

            isReset = false
        }

        if (currentPlayer == o) {
            view.setImageResource(R.drawable.small_letter_o)
            currentPlayer = x
            view.isEnabled = false
        } else {
            view.setImageResource(R.drawable.small_letter_x)
            currentPlayer = o
            view.isEnabled = false
        }

//        whoWinner(position)
         val winningLine = makeMove(position)
         if (winningLine != null) {
             buttonStartGame.value = true
  //           boxesImageView.value = true
         }

        return currentPlayer

    }


    private var state = arrayOf(
        intArrayOf(0, 0, 0),
        intArrayOf(0, 0, 0),
        intArrayOf(0, 0, 0)
    )

    private fun makeMove(position: Position): WinningLine? {
        state[position.row][position.column] = currentPlayer
        val winningLine = hasGameEnded()


        if (winningLine == null) {
            Log.d("daeryan", "null")
            numberOfPlays++
            Log.d("daeryan", numberOfPlays.toString())
            if (numberOfPlays == 9){
                numberOfPlays = 0
                buttonStartGame.value = true
//                binding.buttonStartNewGame.visibility = View.VISIBLE
//                playAgainDialog()
                playAgainDialog.value = true
            }

            currentPlayer = 3 - currentPlayer
            Log.d("jalal", currentPlayer.toString())
        } else {
            numberOfPlays = 0
            Log.d("daeryan", "not null")
//            currentPlayer = sideTypeMain
//            Log.d("side", currentPlayer.toString())
            when (currentPlayer) {
//                1 ->  showWinnerDialogPlayerO()
                  1 ->  winnerDialogPlayerO.value = true

//                2 -> showWinnerDialogPlayerX()
                  2 ->  winnerDialogPlayerX.value = true
            }
            Log.d("current", currentPlayer.toString())
        }
        return winningLine
    }

    fun reset() {
        state = arrayOf(
            intArrayOf(0, 0, 0),
            intArrayOf(0, 0, 0),
            intArrayOf(0, 0, 0)
        )
        currentPlayer = 1
        isReset = true
    }


    private fun hasGameEnded(): WinningLine? {
        Log.d("daeryan", state.toString())
        if (state[0][0] == currentPlayer && state[0][1] == currentPlayer && state[0][2] == currentPlayer) {
            return WinningLine.ROW_0
        } else if (state[1][0] == currentPlayer && state[1][1] == currentPlayer && state[1][2] == currentPlayer) {
            return WinningLine.ROW_1
        } else if (state[2][0] == currentPlayer && state[2][1] == currentPlayer && state[2][2] == currentPlayer) {
            return WinningLine.ROW_2
        } else if (state[0][0] == currentPlayer && state[1][0] == currentPlayer && state[2][0] == currentPlayer) {
            return WinningLine.COLUMN_0
        } else if (state[0][1] == currentPlayer && state[1][1] == currentPlayer && state[2][1] == currentPlayer) {
            return WinningLine.COLUMN_1
        } else if (state[0][2] == currentPlayer && state[1][2] == currentPlayer && state[2][2] == currentPlayer) {
            return WinningLine.COLUMN_2
        } else if (state[0][0] == currentPlayer && state[1][1] == currentPlayer && state[2][2] == currentPlayer) {
            return WinningLine.DIAGONAL_LEFT
        } else if (state[0][2] == currentPlayer && state[1][1] == currentPlayer && state[2][0] == currentPlayer) {
            return WinningLine.DIAGONAL_RIGHT
        }
        return null
    }

}