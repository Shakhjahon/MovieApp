package com.example.movieapp.domain.models.details_domain

import java.io.Serializable


data class ProductionCompanyDetailsDomein(
    val id: Int,
    val logoPath: String?,
    val name: String,
    val originCountry: String
): Serializable