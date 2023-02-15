package com.example.kandilliapp.model

data class LocationProperties(
    val airports: List<Airport>,
    val closestCity: ClosestCity,
    val epiCenter: EpiCenter
)