package com.example.peliculasapp.common.network.response

import com.example.peliculasapp.model.PeliculaModel
import com.google.gson.annotations.SerializedName

data class PeliculaResponse(
    @SerializedName("results")
    var resultados:List<PeliculaModel>
)
