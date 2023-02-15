package com.example.kandilliapp.model

data class Response(
    val desc: String,
    val httpStatus: Int,
    val result: List<Result>,
    val serverloadms: Int,
    val status: Boolean
)