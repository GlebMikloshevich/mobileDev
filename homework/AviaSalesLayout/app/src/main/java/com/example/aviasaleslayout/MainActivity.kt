package com.example.aviasaleslayout

import android.app.DatePickerDialog
import android.icu.text.SimpleDateFormat
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.DatePicker
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView: TextView = findViewById(R.id.textView_date)
        val textView2: TextView = findViewById(R.id.textView_date2)

        textView.text = SimpleDateFormat("dd.MM.yyyy").format(System.currentTimeMillis())
        textView2.text = SimpleDateFormat("dd.MM.yyyy").format(System.currentTimeMillis())

        var cal = Calendar.getInstance()

        val dateSetListener = DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
            cal.set(Calendar.YEAR, year)
            cal.set(Calendar.MONTH, monthOfYear)
            cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)

            val myFormat = "dd.MM.yyyy" // mention the format you need
            val sdf = SimpleDateFormat(myFormat, Locale.US)
            textView.text = sdf.format(cal.time)
        }

        val dateSetListener2 = DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
            cal.set(Calendar.YEAR, year)
            cal.set(Calendar.MONTH, monthOfYear)
            cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)

            val myFormat = "dd.MM.yyyy" // mention the format you need
            val sdf = SimpleDateFormat(myFormat, Locale.US)
            textView2.text = sdf.format(cal.time)
        }


        textView.setOnClickListener {
            DatePickerDialog(this@MainActivity, dateSetListener,
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)).show()
        }

        textView2.setOnClickListener {
            DatePickerDialog(this@MainActivity, dateSetListener2,
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)).show()
        }
    }
}