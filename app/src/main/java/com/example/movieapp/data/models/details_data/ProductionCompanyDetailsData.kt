package com.example.movieapp.data.models.details_data


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ProductionCompanyDetailsData(
    @SerializedName("id")
    val movieId: Int,
    @SerializedName("logo_path")
    val movieLogoPath: String?,
    @SerializedName("name")
    val movieName: String,
    @SerializedName("origin_country")
    val movieOriginCountry: String
): Serializable