package com.opendebugger62.diceroller

import android.annotation.SuppressLint
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    lateinit var diceImage : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton : Button = findViewById(R.id.roll_button)
        this.diceImage = findViewById(R.id.dice_image)

        rollButton.setOnClickListener {
            val result = rollDice()
            Toast.makeText(this, result.toString(), Toast.LENGTH_SHORT).show()
        }

    }

    private fun rollDice() : Int {

        val randomInt = Random.nextInt(1, 6)
        val drawableResource = when(randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        this.diceImage.setImageResource(drawableResource)
        return randomInt
    }
}