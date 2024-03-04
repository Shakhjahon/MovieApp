package com.example.movieapp.data.models.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MovieDataModel(
    @SerializedName("results")
    val movieDataList: List<MovieResultsDataModel>
) : Serializable



