package com.example.diceroller

import android.os.Bundle
import android.widget.Button
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
        val myFirstDice = Dice(8)
        val rollResult = myFirstDice.roll()
        val luckyNumber = 4
        val result = when (rollResult) {
            luckyNumber -> "You won! You rolled a 4!"
            1 -> "So sorry! You rolled a 1.\n Try again!"
            2 -> "Sadly, you rolled a 2.\n Try again!"
            3 -> "Unfortunately, \nyou rolled a 3.\n Try again!"
            5 -> "Don't cry! You rolled a 5.\n Try again!"
            6 -> "Apologies! You rolled a 6.\n Try again!"
            else -> "To high! You rolled a ${rollResult}.\n Try again!"
        }

        // Update the screen with the dice roll
        val resultTextView: TextView = findViewById(R.id.textView)
        resultTextView.text = result
    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}