package com.example.film_list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.io.InputStreamReader
import kotlin.random.Random
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {

    private lateinit var moviesRaw : Array<Movie>
    private lateinit var movies : ArrayList<Movie>
    private lateinit var filmTitle: TextView
    private lateinit var directorView: TextView
    private lateinit var releaseYearView: TextView
    private lateinit var ratingView: TextView

    private lateinit var resetButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        filmTitle = findViewById(R.id.title)
        directorView = findViewById(R.id.director)
        releaseYearView = findViewById(R.id.year)
        ratingView = findViewById(R.id.rating)

        val movies_stream = resources.openRawResource(R.raw.movie)
        val gson = Gson()
        moviesRaw = gson.fromJson(InputStreamReader(movies_stream), Movies::class.java).movies
        movies = moviesRaw.toCollection(ArrayList())

        filmTitle.text = "Press next films"

        resetButton = findViewById(R.id.button2)
//        val resetButton: Button = findViewById(R.id.button2)
        resetButton.text = resources.getString(R.string.next)
        val nextButton: Button = findViewById(R.id.button)
        nextButton.text = (resources.getString(R.string.reset))

    }

    fun onNextClick(view: View) {
        if (movies.isEmpty()) {
            updateText("Press reset button")

        } else {
            val i = Random.nextInt(0, movies.size)
            Log.d("films", movies[i].toString())
            setData(movies[i])
            movies.removeAt(i)
        }
    }

    private fun setData(data: Movie) {
        filmTitle.text = data.name
        directorView.text = data.director
        ratingView.text = data.rating.toString()
        releaseYearView.text = data.year.toString()
    }

    fun onClearClick(view: View) {
        movies = moviesRaw.toCollection(ArrayList())
        updateText("Press next films")
    }

    private fun updateText(titleText: String) {
        filmTitle.text = titleText
        directorView.text = ""
        ratingView.text = ""
        releaseYearView.text = ""
    }

}