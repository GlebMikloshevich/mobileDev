package com.example.neighboring_cities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    lateinit var cities: ArrayList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        // variable declaration
        val messageTextView = findViewById<TextView>(R.id.messageTextView)
        cities = intent.getSerializableExtra("cities") as ArrayList<String>

        // spinner
        val spinner = findViewById<Spinner>(R.id.spinner)
        val adapter = ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, cities)
        spinner.adapter = adapter

        // Setting text to TextView
        if (cities.size == 0) {
            messageTextView.text = "There are no such cities"
        } else {
            messageTextView.text = "Cities:"

        }

    }
}