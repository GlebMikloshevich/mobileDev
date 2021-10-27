package com.example.film_list

import com.google.gson.annotations.SerializedName


data class Movies (
    @SerializedName("movies") val movies: Array<Movie>
    ) {

}