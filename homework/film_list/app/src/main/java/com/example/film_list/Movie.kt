package com.example.film_list

import com.google.gson.annotations.SerializedName

data class Movie (
    @SerializedName("name") val name: String,
    @SerializedName("director") val director: String,
    @SerializedName("year") val year: Int,
    @SerializedName("rating") val rating: Float) {

}