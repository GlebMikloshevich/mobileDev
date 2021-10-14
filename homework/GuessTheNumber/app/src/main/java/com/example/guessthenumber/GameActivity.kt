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
//        Log.d("test", "new activity")
//        Log.d("test","lowerBound: $lowerBound")
//        Log.d("test", "upperBound: $upperBound")

        var textV  = findViewById<TextView>(R.id.field)


        mean = (upperBound + lowerBound) / 2
        textV.text = mean.toString()

        val butLower: Button = findViewById(R.id.lower)
        val butBigger: Button = findViewById(R.id.bigger)

        butLower.setOnClickListener {

//            Log.d("test", "Lower $lowerBound $upperBound $mean")

            if (mean == lowerBound) {
//                Log.d("test", "Lower! Your number is $lowerBound")
                returnValue(lowerBound)
            }

            if (lowerBound + 1 == upperBound) {
//                Log.d("test", "Lower! Your number is $lowerBound")
                returnValue(lowerBound)
            }

            upperBound = mean
            mean = (upperBound + lowerBound) / 2
            textV.text = mean.toString()
        }

        butBigger.setOnClickListener{
//            Log.d("test", "Bigger $lowerBound $upperBound $mean")

            if (mean == upperBound) {
//                Log.d("test", "Upper! Your number is $upperBound")
                returnValue(upperBound)
            }
            if (lowerBound + 1 == upperBound) {
//                Log.d("test", "Upper! Your number is $upperBound")
                returnValue(upperBound)
            }

            lowerBound = mean
            mean = (upperBound + lowerBound) / 2
            textV.text = mean.toString()
        }
    }


    fun returnValue(res: Int) {
        val resultIntent = Intent()
        resultIntent.putExtra("result", res)
        setResult(Activity.RESULT_OK, resultIntent)
        finish()
    }




}