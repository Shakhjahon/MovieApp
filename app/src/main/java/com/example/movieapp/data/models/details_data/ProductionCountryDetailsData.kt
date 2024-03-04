package com.example.movieapp.data.models.details_data


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ProductionCountryDetailsData(
    @SerializedName("iso_3166_1")
    val movieIso31661: String,
    @SerializedName("name")
    val movieName: String
): Serializable