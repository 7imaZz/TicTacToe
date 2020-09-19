package com.example.tictoctoy

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.collections.ArrayList
class MainActivity : AppCompatActivity() {

    private var player1 = ArrayList<Int>()
    private var player2 = ArrayList<Int>()
    private var btns = ArrayList<Button>()
    var playerTurn = 1
    var winner = -1
    var comCounter = 0
    var playerCounter = 0

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btns = arrayListOf(btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9)

        p1ScoreTV.text = "Player: $playerCounter"
        comScoreTV.text = "Com: $comCounter"

        resetBtn.setOnClickListener {
            reset()
        }
    }

    fun btnClick(view: View) {
        val btn = view as Button
        var cellNum = 0
        when(btn.id){
            R.id.btn1 -> cellNum = 1
            R.id.btn2 -> cellNum = 2
            R.id.btn3 -> cellNum = 3
            R.id.btn4 -> cellNum = 4
            R.id.btn5 -> cellNum = 5
            R.id.btn6 -> cellNum = 6
            R.id.btn7 -> cellNum = 7
            R.id.btn8 -> cellNum = 8
            R.id.btn9 -> cellNum = 9
        }
        playGame(btn, cellNum)

    }

    fun playGame(btn: Button, cellNum: Int){

        if (playerTurn == 1){
            btn.setBackgroundResource(R.color.blue)
            btn.text = "X"
            player1.add(cellNum)
            playerTurn = 2
            checkWinner(player1, 1)
            autoPlay()
        }
        if(playerTurn == 2 && winner == -1){
            btn.setBackgroundResource(R.color.darkGreen)
            btn.text = "O"
            player2.add(cellNum)
            playerTurn = 1
            checkWinner(player2, 2)
        }
        btn.isEnabled = false
        if (toe())
            disable()
    }

    fun autoPlay(){
            val availableCells = ArrayList<Int>()
            for (i in 1..9){
                if (!(player1.contains(i) || player2.contains(i))){
                    availableCells.add(i)
                }
            }
            if (availableCells.size == 0){
                playerTurn = 1
                disable()
                return
            }
            val r= java.util.Random()
            val randIndex = r.nextInt(availableCells.size)
            val cellId = availableCells[randIndex]
            var btnSelected = btn1
            when(cellId){
                1-> btnSelected = btn1
                2-> btnSelected = btn2
                3-> btnSelected = btn3
                4-> btnSelected = btn4
                5-> btnSelected = btn5
                6-> btnSelected = btn6
                7-> btnSelected = btn7
                8-> btnSelected = btn8
                9-> btnSelected = btn9
            }

            playGame(btnSelected, cellId)

    }

    @SuppressLint("SetTextI18n")
    private fun checkWinner(player: ArrayList<Int>, playerNum: Int){
        if (player.contains(1) && player.contains(2) && player.contains(3)){
            Toast.makeText(this, "Player$playerNum Wins", Toast.LENGTH_LONG).show()
            disable()
            winner = playerNum
            if (playerNum == 1){
                playerCounter++
                p1ScoreTV.text = "Player: $playerCounter"
            }else{
                comCounter++
                comScoreTV.text = "Com: $comCounter"
            }
        }else if (player.contains(4) && player.contains(5) && player.contains(6)){
            Toast.makeText(this, "Player$playerNum Wins", Toast.LENGTH_LONG).show()
            disable()
            winner = playerNum
            if (playerNum == 1){
                playerCounter++
                p1ScoreTV.text = "Player: $playerCounter"
            }else{
                comCounter++
                comScoreTV.text = "Com: $comCounter"
            }
        }else if (player.contains(7) && player.contains(8) && player.contains(9)){
            Toast.makeText(this, "Player$playerNum Wins", Toast.LENGTH_LONG).show()
            disable()
            winner = playerNum
            if (playerNum == 1){
                playerCounter++
                p1ScoreTV.text = "Player: $playerCounter"
            }else{
                comCounter++
                comScoreTV.text = "Com: $comCounter"
            }
        }else if (player.contains(1) && player.contains(4) && player.contains(7)){
            Toast.makeText(this, "Player$playerNum Wins", Toast.LENGTH_LONG).show()
            disable()
            winner = playerNum
            if (playerNum == 1){
                playerCounter++
                p1ScoreTV.text = "Player: $playerCounter"
            }else{
                comCounter++
                comScoreTV.text = "Com: $comCounter"
            }
        }else if (player.contains(2) && player.contains(5) && player.contains(8)){
            Toast.makeText(this, "Player$playerNum Wins", Toast.LENGTH_LONG).show()
            disable()
            winner = playerNum
            if (playerNum == 1){
                playerCounter++
                p1ScoreTV.text = "Player: $playerCounter"
            }else{
                comCounter++
                comScoreTV.text = "Com: $comCounter"
            }
        }else if (player.contains(3) && player.contains(6) && player.contains(9)){
            Toast.makeText(this, "Player$playerNum Wins", Toast.LENGTH_LONG).show()
            disable()
            winner = playerNum
            if (playerNum == 1){
                playerCounter++
                p1ScoreTV.text = "Player: $playerCounter"
            }else{
                comCounter++
                comScoreTV.text = "Com: $comCounter"
            }
        }else if (player.contains(1) && player.contains(5) && player.contains(9)){
            Toast.makeText(this, "Player$playerNum Wins", Toast.LENGTH_LONG).show()
            disable()
            winner = playerNum
            if (playerNum == 1){
                playerCounter++
                p1ScoreTV.text = "Player: $playerCounter"
            }else{
                comCounter++
                comScoreTV.text = "Com: $comCounter"
            }
        }else if (player.contains(3) && player.contains(5) && player.contains(7)){
            Toast.makeText(this, "Player$playerNum Wins", Toast.LENGTH_LONG).show()
            disable()
            winner = playerNum
            if (playerNum == 1){
                playerCounter++
                p1ScoreTV.text = "Player: $playerCounter"
            }else{
                comCounter++
                comScoreTV.text = "Com: $comCounter"
            }
        }
    }

    fun toe(): Boolean{
        if (player1.size+player2.size==9)
            return true
        return false
    }
    private fun disable(){
        for (item in btns){
            item.isEnabled = false
            resetBtn.visibility = View.VISIBLE
        }
    }

    private fun reset(){

        player1.clear()
        player2.clear()
        resetBtn.visibility = View.GONE
        playerTurn = 1
        winner = -1

        for(item in btns){
            item.isEnabled = true
            item.setBackgroundColor(Color.WHITE)
            item.text = ""
        }
    }
}

