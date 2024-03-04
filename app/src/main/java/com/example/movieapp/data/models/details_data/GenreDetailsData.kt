package com.example.movieapp.data.models.details_data


import com.google.gson.annotations.SerializedName

data class GenreDetailsData(
    @SerializedName("id")
    val movieId: Int,
    @SerializedName("name")
    val movieName: String
)