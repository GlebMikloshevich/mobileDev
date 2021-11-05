package com.example.neighboring_cities

import com.google.gson.annotations.SerializedName

data class City (
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("state") val state: String,
    @SerializedName("country") val country: String,
    @SerializedName("coord") val coord: Coord
    ){
    data class Coord (
        @SerializedName("lon") val lon: Float,
        @SerializedName("lat") val lat: Float
    )
}

// "id": 833, "name": "Ḩeşār-e Sefīd", "state": "", "country": "IR", "coord": {"lon": 47.159401, "lat": 34.330502}}