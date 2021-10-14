package com.example.guessthenumber

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class GameActivity : AppCompatActivity() {
    var upperBound = 0
    var lowerBound = 0
    var mean = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        lowerBound = intent.getIntExtra("lowerBound", 0)
        upperBound = intent.getIntExtra("upperBound", 0)

        var textV  = findViewById<TextView>(R.id.field)
        val butLower: Button = findViewById(R.id.lower)
        val butBigger: Button = findViewById(R.id.bigger)

        mean = (upperBound + lowerBound) / 2
        textV.text = mean.toString()

        //No button
        butLower.setOnClickListener {
            if (mean == lowerBound) {
                returnValue(lowerBound)
            }
            upperBound = mean
            mean = (upperBound + lowerBound) / 2
            textV.text = mean.toString()
        }

        //Yes button
        butBigger.setOnClickListener{
            if (mean+1 == upperBound) {
                returnValue(upperBound)
            }
            lowerBound = mean
            mean = (upperBound + lowerBound) / 2
            textV.text = mean.toString()
        }
    }


    private fun returnValue(res: Int) {
        val resultIntent = Intent()
        resultIntent.putExtra("result", res)
        setResult(Activity.RESULT_OK, resultIntent)
        finish()
    }

    private fun printDebug() {
        Log.d("debug", "$lowerBound $mean $upperBound")
    }
}