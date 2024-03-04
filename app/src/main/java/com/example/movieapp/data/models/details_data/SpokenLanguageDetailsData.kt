package com.example.movieapp.data.models.details_data


import com.google.gson.annotations.SerializedName

data class SpokenLanguageDetailsData(
    @SerializedName("english_name")
    val movieEnglishName: String,
    @SerializedName("iso_639_1")
    val movieIso6391: String,
    @SerializedName("name")
    val movieName: String
)