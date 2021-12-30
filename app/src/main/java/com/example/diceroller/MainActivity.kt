package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            rollDice()

//             Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun rollDice() {
        // Create new Dice object with 6 sides and roll it
        val dice1 = Dice(6)
        val diceRoll1 = dice1.roll()
        val dice2 = Dice(6)
        val diceRoll2 = dice2.roll()

        // Update the screen with the dice roll
        val resultTextView: TextView = findViewById(R.id.textViewResult)
        resultTextView.text = (diceRoll1 + diceRoll2).toString()

        val resultDice1: ImageView = findViewById(R.id.imageViewDice1)
        resultDice1.setImageResource(getImage(diceRoll1))

        val resultDice2: ImageView = findViewById(R.id.imageViewDice2)
        resultDice2.setImageResource(getImage(diceRoll2))
    }

    private fun getImage(dice: Int): Int{
        return when (dice) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    }
}

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}