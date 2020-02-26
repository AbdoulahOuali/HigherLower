package com.abdoulahouali.task1.higherlower

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_higher_lower.*

class HigherLowerActivity : AppCompatActivity() {

    private var currentThrow: Int = 1
    private var lastThrow: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_higher_lower)
        initViews()

    }

    /**
     * Update the last throw text and the dice image resource drawable
     * with the current throw.
     */
    private fun updateUI() {
        lastThrowTv.text = getString(R.string.last_throw, lastThrow)
        when (currentThrow) {
            1 -> dice.setImageResource(R.drawable.dice1)
            2 -> dice.setImageResource(R.drawable.dice2)
            3 -> dice.setImageResource(R.drawable.dice3)
            4 -> dice.setImageResource(R.drawable.dice4)
            5 -> dice.setImageResource(R.drawable.dice5)
            6 -> dice.setImageResource(R.drawable.dice6)
        }
    }

    /**
     * Sets the initial UI of the game
     * */
    private fun initViews() {
        higherBtn.setOnClickListener { onHigherClick() }
        lowerBtn.setOnClickListener { onLowerClick() }
        equalsBtn.setOnClickListener { onEqualsClick() }
        updateUI()
    }

    /**
     * Replaces the previous dice value with the current one and replaces
     * the current dice with a new dice
     * with a random number between 1 and 6 (inclusive).
     */
    private fun rollDice() {
        lastThrow = currentThrow
        // In this code snippet the (1..6).random() call makes use of Kotlin Ranges
        // which makes a range of 1 to 6 (inclusive).
        currentThrow = (1..6).random()
        updateUI()
    }

    private fun onAnswerCorrect() {
        Toast.makeText(this, getString(R.string.correct), Toast.LENGTH_LONG).show()
    }

    private fun onAnswerInorrect() {
        Toast.makeText(this, getString(R.string.incorrect), Toast.LENGTH_LONG).show()
    }

    private fun onHigherClick() {
        rollDice()
        if (currentThrow > lastThrow) {
            onAnswerCorrect()
        } else onAnswerInorrect()
    }

    private fun onLowerClick() {
        rollDice()
        if (currentThrow < lastThrow) {
            onAnswerCorrect()
        } else onAnswerInorrect()
    }

    private fun onEqualsClick() {
        rollDice()
        if (currentThrow == lastThrow) {
            onAnswerCorrect()
        } else onAnswerInorrect()
    }
}
