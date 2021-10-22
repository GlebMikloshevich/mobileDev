package com.example.film_list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var moviesRaw : Array<String>
    private lateinit var movies : ArrayList<String>
    private lateinit var filmTitle: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val resetButton: Button = findViewById(R.id.button2)
        resetButton.text = resources.getString(R.string.next)
        val nextButton: Button = findViewById(R.id.button)
        nextButton.text = (resources.getString(R.string.reset))


        moviesRaw = resources.getStringArray(R.array.films)
        movies = moviesRaw.toCollection(ArrayList())
        Log.d("films", moviesRaw.contentDeepToString())
        filmTitle = findViewById(R.id.title)
        set_tile("Press next film button")
    }

    fun onNextClick(view: View) {
        if (movies.isEmpty()) {
            set_tile("No films")
        } else {
            val i = Random.nextInt(0, movies.size)
            Log.d("films", movies[i])
            set_tile(movies[i])
            movies.removeAt(i)
        }
    }

    fun set_tile(title: String) {
        filmTitle.text = title
    }

    fun onClearClick(view: View) {
        movies = moviesRaw.toCollection(ArrayList())
        set_tile("Press next film button")
    }
}