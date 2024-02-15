package com.example.peliculasapp.common.network

import com.example.peliculasapp.common.network.response.PeliculaResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WebService {
    @GET("now_playing")
    suspend fun obtenerPelicula(
        @Query("api_key") apikey: String
    ): Response<PeliculaResponse>

}