package com.example.neighboring_cities

import com.google.gson.annotations.SerializedName

data class Cities
    (
        @SerializedName("cities") val cities: Array<City>
    ){
}