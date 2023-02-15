package com.example.kandilliapp.model

data class Result(
    val coordinates: List<Double>,
    val date: String,
    val date_day: String,
    val date_hour: String,
    val date_stamp: String,
    val depth: Double,
    val earthquake_id: String,
    val geojson: Geojson,
    val lat: Double,
    val lng: Double,
    val location_properties: LocationProperties,
    val location_tz: String,
    val lokasyon: String,
    val mag: Double,
    val rev: Any,
    val timestamp: String,
    val title: String
)