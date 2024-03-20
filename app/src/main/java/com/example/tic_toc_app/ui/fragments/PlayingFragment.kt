package com.example.tic_toc_app.ui.fragments

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Observer
import com.example.tic_toc_app.R
import com.example.tic_toc_app.databinding.FragmentPlayingBinding
import com.example.tic_toc_app.ui.Position
import com.example.tic_toc_app.viewmodels.PlayingViewModel

class PlayingFragment : Fragment() {

    private val playingViewModel = PlayingViewModel()

//    var numberOfPlays = 0

//    var isReset = false

    var sideTypeMain = 0

    private val binding by lazy { FragmentPlayingBinding.inflate(LayoutInflater.from(requireContext())) }

//    private var gameManager: GameManager? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvPlayerName1: TextView = view.findViewById(R.id.tvPlayerName1)
        val tvPlayerName2: TextView = view.findViewById(R.id.tvPlayerName2)
        val ivSideOne: ImageView = view.findViewById(R.id.ivSideOne)
        val ivSideTwo: ImageView = view.findViewById(R.id.ivSideTwo)
        val ivPlayingImageOne: ImageView = view.findViewById(R.id.ivPlayingImageOne)

        val playerOne = arguments?.get("playerOne")
        tvPlayerName1.text = playerOne.toString()
        //        Log.d("playerOne", "$playerOne")
        val playerTwo = arguments?.get("playerTwo")
        tvPlayerName2.text = playerTwo.toString()

        sideTypeMain = arguments?.getInt("type")!!
        val o = 2131231101
        val x = 2131231102
        if (sideTypeMain == o) {
            ivSideOne.setImageResource(R.drawable.small_letter_o)
            ivSideTwo.setImageResource(R.drawable.small_letter_x)
        } else {
            ivSideOne.setImageResource(R.drawable.small_letter_x)
            ivSideTwo.setImageResource(R.drawable.small_letter_o)
        }
        Log.d("typeA", "$sideTypeMain")
//        gameManager = GameManager()



        binding.buttonStartNewGame.setOnClickListener {
            binding.buttonStartNewGame.visibility = View.GONE
//            gameManager!!.reset()
            playingViewModel.reset()
            resetBoxes()
        }


        //Start Configuration for playing, set onClick for the Images


        var player: Int = sideTypeMain


//        ivPlayingImageOne.setOnClickListener {
 //           player = onBoxClicked(ivPlayingImageOne, Position(0, 0), sideType = player)
 //       }

        ivPlayingImageOne.setOnClickListener {
            player = playingViewModel.onBoxClicked(ivPlayingImageOne, Position(0, 0), sideType =  player)
        }

//        binding.ivPlayingImageTwo.setOnClickListener {
//            player = onBoxClicked(binding.ivPlayingImageTwo, Position(0, 1), sideType = player)
//        }

        binding.ivPlayingImageTwo.setOnClickListener {
            player = playingViewModel.onBoxClicked(binding.ivPlayingImageTwo, Position(0,1), sideType = player)
        }

//        binding.ivPlayingImageThree.setOnClickListener {
//            player = onBoxClicked(binding.ivPlayingImageThree, Position(0, 2), sideType = player)
//        }

        binding.ivPlayingImageThree.setOnClickListener {
            player = playingViewModel.onBoxClicked(binding.ivPlayingImageThree, Position(0,2), sideType = player)
        }

//        binding.ivPlayingImageFour.setOnClickListener {
//            player = onBoxClicked(binding.ivPlayingImageFour, Position(1, 0), sideType = player)
//        }

        binding.ivPlayingImageFour.setOnClickListener {
            player = playingViewModel.onBoxClicked(binding.ivPlayingImageFour, Position(1,0), sideType = player)
        }

//        binding.ivPlayingImageFive.setOnClickListener {
//            player = onBoxClicked(binding.ivPlayingImageFive, Position(1, 1), sideType = player)
//        }

        binding.ivPlayingImageFive.setOnClickListener {
            player = playingViewModel.onBoxClicked(binding.ivPlayingImageFive, Position(1,1), sideType = player)
        }

//        binding.ivPlayingImageSix.setOnClickListener {
 //           player = onBoxClicked(binding.ivPlayingImageSix, Position(1, 2), sideType = player)
 //       }

        binding.ivPlayingImageSix.setOnClickListener {
            player = playingViewModel.onBoxClicked(binding.ivPlayingImageSix, Position(1,2), sideType = player)
        }

//        binding.ivPlayingImageSeven.setOnClickListener {
 //           player = onBoxClicked(binding.ivPlayingImageSeven, Position(2, 0), sideType = player)
//        }

        binding.ivPlayingImageSeven.setOnClickListener {
            player = playingViewModel.onBoxClicked(binding.ivPlayingImageSeven, Position(2,0), sideType = player)
        }

 //       binding.ivPlayingImageEight.setOnClickListener {
//            player = onBoxClicked(binding.ivPlayingImageEight, Position(2, 1), sideType = player)
 //       }

        binding.ivPlayingImageEight.setOnClickListener {
            player = playingViewModel.onBoxClicked(binding.ivPlayingImageEight, Position(2,1), sideType = player)
        }

//        binding.ivPlayingImageNine.setOnClickListener {
 //           player = onBoxClicked(binding.ivPlayingImageNine, Position(2, 2), sideType = player)
 //       }

        binding.ivPlayingImageNine.setOnClickListener {
            player = playingViewModel.onBoxClicked(binding.ivPlayingImageNine, Position(2,2), sideType = player)
        }


        playingViewModel.buttonStart.observe(viewLifecycleOwner, Observer { if (it == true) binding.buttonStartNewGame.visibility = View.VISIBLE
        disableBoxes()})

        playingViewModel.playAgain.observe(viewLifecycleOwner, Observer { if (it == true) playAgainDialog() })

        playingViewModel.dialogPlayerO.observe(viewLifecycleOwner, Observer { if (it == true) showWinnerDialogPlayerO() })

        playingViewModel.dialogPlayerX.observe(viewLifecycleOwner, Observer { if (it == true) showWinnerDialogPlayerX() })

    }

/*    private fun onBoxClicked(view: ImageView, position: Position, sideType: Int?): Int {
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

        whoWinner(position)

        return currentPlayer

    }*/


/*    private fun whoWinner(position: Position) {
        Log.d("daeryan", position.toString())
        val winningLine = gameManager?.makeMove(position)
        if (winningLine != null) {
            binding.buttonStartNewGame.visibility = View.VISIBLE
            disableBoxes()
        }
    }*/


    private fun showWinnerDialogPlayerO() {
        val alertDialog = AlertDialog.Builder(context)
        alertDialog.apply {
           setMessage("winner Player O!!")
        }.create().show()
    }

    private fun showWinnerDialogPlayerX() {
        val alertDialog = AlertDialog.Builder(context)
        alertDialog.apply {
            setMessage("winner Player X!!")
        }.create().show()
    }

    private fun playAgainDialog() {
        val alertDialog = AlertDialog.Builder(context)
        alertDialog.apply {
            setMessage("Play Again!")
        }.create().show()
    }


    private fun disableBoxes() {
        binding.ivPlayingImageOne.isEnabled = false
        binding.ivPlayingImageTwo.isEnabled = false
        binding.ivPlayingImageThree.isEnabled = false
        binding.ivPlayingImageFour.isEnabled = false
        binding.ivPlayingImageFive.isEnabled = false
        binding.ivPlayingImageSix.isEnabled = false
        binding.ivPlayingImageSeven.isEnabled = false
        binding.ivPlayingImageEight.isEnabled = false
        binding.ivPlayingImageNine.isEnabled = false
    }

    private fun resetBoxes(){
        binding.ivPlayingImageOne.setImageResource(R.drawable.ic_launcher_background)
        binding.ivPlayingImageTwo.setImageResource(R.drawable.ic_launcher_background)
        binding.ivPlayingImageThree.setImageResource(R.drawable.ic_launcher_background)
        binding.ivPlayingImageFour.setImageResource(R.drawable.ic_launcher_background)
        binding.ivPlayingImageFive.setImageResource(R.drawable.ic_launcher_background)
        binding.ivPlayingImageSix.setImageResource(R.drawable.ic_launcher_background)
        binding.ivPlayingImageSeven.setImageResource(R.drawable.ic_launcher_background)
        binding.ivPlayingImageEight.setImageResource(R.drawable.ic_launcher_background)
        binding.ivPlayingImageNine.setImageResource(R.drawable.ic_launcher_background)
        binding.ivPlayingImageOne.isEnabled = true
        binding.ivPlayingImageTwo.isEnabled = true
        binding.ivPlayingImageThree.isEnabled = true
        binding.ivPlayingImageFour.isEnabled = true
        binding.ivPlayingImageFive.isEnabled = true
        binding.ivPlayingImageSix.isEnabled = true
        binding.ivPlayingImageSeven.isEnabled = true
        binding.ivPlayingImageEight.isEnabled = true
        binding.ivPlayingImageNine.isEnabled = true
    }

/*    inner class GameManager() {

        private var currentPlayer = 1


        private var state = arrayOf(
            intArrayOf(0, 0, 0),
            intArrayOf(0, 0, 0),
            intArrayOf(0, 0, 0)
        )

        fun makeMove(position: Position): WinningLine? {
            state[position.row][position.column] = currentPlayer
            val winningLine = hasGameEnded()


            if (winningLine == null) {
                Log.d("daeryan", "null")
                numberOfPlays++
                Log.d("daeryan", numberOfPlays.toString())
                if (numberOfPlays == 9){
                    numberOfPlays = 0
                    binding.buttonStartNewGame.visibility = View.VISIBLE
                    playAgainDialog()
                }

                currentPlayer = 3 - currentPlayer
                Log.d("jalal", currentPlayer.toString())
            } else {
                numberOfPlays = 0
                Log.d("daeryan", "not null")
                when (currentPlayer) {
                    1 -> {
                        showWinnerDialogPlayerO()
                    }
                    2 -> showWinnerDialogPlayerX()
                }
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


         fun hasGameEnded(): WinningLine? {
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
    }*/

}










