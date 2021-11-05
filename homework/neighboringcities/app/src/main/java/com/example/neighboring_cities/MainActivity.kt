package com.example.neighboring_cities

import android.annotation.SuppressLint
import android.content.Intent
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import java.io.InputStreamReader
import com.google.gson.Gson

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    private lateinit var gson: Gson
    private lateinit var citiesRaw : Array<City>
    lateinit var cityDistanceEditText: EditText
    var cityName = ""
    var cityIndex = -1
    var distance = 0

    @SuppressLint("CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //Views declaration
        val spinner = findViewById<Spinner>(R.id.spinner)
        val button: Button = findViewById(R.id.button)
        cityDistanceEditText = findViewById(R.id.distance)


        //working with json
        gson = Gson()
        val cities_stream = resources.openRawResource(R.raw.city1)
        citiesRaw = gson.fromJson(InputStreamReader(cities_stream), Cities::class.java).cities
        var city_names: ArrayList<String> = ArrayList()
        for (city in citiesRaw) {
            city_names.add(city.name)
        }
//        Log.d("city", city_names.toString())

        //spinner
        val adapter = ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, city_names)
        spinner.adapter = adapter
        spinner.onItemSelectedListener = this



        button.setOnClickListener {
            val userInput = cityDistanceEditText.text.toString().trim()
            if (! userInput.isNullOrBlank()) {
                distance = userInput.toInt()
                val cities = findCities()
                startResultActivity(cities)
            } else {
                val text = "set up the distance!"
                val toast = Toast.makeText(this, text, Toast.LENGTH_SHORT)
                toast.show()
            }

        }
    }

    // searching neighboring cities
    private fun findCities(): ArrayList<String> {
        val lat : Double = citiesRaw[cityIndex].coord.lat.toDouble()
        val lon : Double = citiesRaw[cityIndex].coord.lon.toDouble()
        val curCity : String = citiesRaw[cityIndex].name
        var suitableCites: ArrayList<String> = ArrayList()
        for (city in citiesRaw) {
            val results = FloatArray(1)
            Location.distanceBetween(
                city.coord.lat.toDouble(), city.coord.lon.toDouble(),
                lat, lon, results)
            if (city.name != curCity && results[0] <= distance) {
                suitableCites.add(city.name)
            }
        }
//        Log.d("city", "$suitableCites")
        return suitableCites
    }

    //new activity
    private fun startResultActivity(cities: ArrayList<String>) {
        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra("cities", cities)
        startActivity(intent)
    }

    // spinner listener
    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        cityName = parent?.getItemAtPosition(position).toString()
        cityIndex = position
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }


}