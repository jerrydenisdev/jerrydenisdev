package com.example.peliculasapp.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.peliculasapp.databinding.ActivityMainBinding
import com.example.peliculasapp.viewModel.PeliculaViewModel
import com.example.peliculasapp.views.adapter.AdapterPeliculas

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: PeliculaViewModel
    private lateinit var adapterPeliculas: AdapterPeliculas

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupViewModel()
        setupRecyclerView()

    }
    private fun setupViewModel(){
        viewModel = ViewModelProvider(this)[PeliculaViewModel::class.java]
        viewModel.listaPeliculas.observe(this){
            adapterPeliculas.listaPeliculas = it
            adapterPeliculas.notifyDataSetChanged()
        }
        viewModel.obtenerPelicula()
    }

    private fun setupRecyclerView(){
        val layoutManager = GridLayoutManager(this,3)
        binding.recyclerHome.layoutManager = layoutManager
        adapterPeliculas = AdapterPeliculas(this, arrayListOf())
        binding.recyclerHome.adapter = adapterPeliculas

    }
}
