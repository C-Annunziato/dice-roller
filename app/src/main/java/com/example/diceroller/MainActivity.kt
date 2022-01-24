package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Toast.makeText(this@MainActivity,"ON CREATE", Toast.LENGTH_SHORT).show()

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener{
           rollDice()
        }
    }




    override fun onStart(){
        super.onStart()
        Toast.makeText(this@MainActivity,"ON START",
            Toast.LENGTH_SHORT).show()

    }

    override fun onResume(){
        super.onResume()
        Toast.makeText(this@MainActivity,"ON RESUME",
            Toast.LENGTH_SHORT).show()
    }

    override fun onPause(){
        super.onPause()
        Toast.makeText(this@MainActivity,"ON PAUSE",
            Toast.LENGTH_SHORT).show()
    }

    override fun onStop(){
        super.onStop()
        Toast.makeText(this@MainActivity,"ON STOP",
            Toast.LENGTH_SHORT).show()
    }
    override fun onDestroy(){
        super.onDestroy()
        Toast.makeText(this@MainActivity,"ON DESTROY",
            Toast.LENGTH_SHORT).show()
    }
    override fun onRestart(){
        super.onRestart()
        Toast.makeText(this@MainActivity,"ON RESTART",
            Toast.LENGTH_SHORT).show()
    }





    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()

        val diceImage: ImageView = findViewById(R.id.imageView)

        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.dice_1
        }
        diceImage.setImageResource(drawableResource)

        diceImage.contentDescription = diceRoll.toString()
    }
}

class Dice(val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }






}