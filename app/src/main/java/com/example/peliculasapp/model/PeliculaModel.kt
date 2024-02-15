package com.example.peliculasapp.model

import com.google.gson.annotations.SerializedName

data class PeliculaModel(
    @SerializedName("id")
    var id:String,
    @SerializedName("title")
    var title:String,
    @SerializedName("poster_path")
    var poster_path:String,
    @SerializedName("vote_average")
    var vote_average:String,
    @SerializedName("release_date")
    var release_date:String,
    @SerializedName("overview")
    var overview:String
)
