package com.example.peliculasapp.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.peliculasapp.common.network.RetrofitClient
import com.example.peliculasapp.common.network.api.Endpoints
import com.example.peliculasapp.model.PeliculaModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PeliculaViewModel:ViewModel() {
    private var _ListaPeliculas = MutableLiveData<List<PeliculaModel>>()
    val listaPeliculas: LiveData<List<PeliculaModel>> = _ListaPeliculas

    fun obtenerPelicula(){
        viewModelScope.launch(Dispatchers.IO){
            val response = RetrofitClient.webService.obtenerPelicula(Endpoints.API_KEY)
            withContext(Dispatchers.Main){
                _ListaPeliculas.value = response.body()!!.resultados.sortedByDescending { it.vote_average }
            }
        }
    }
}