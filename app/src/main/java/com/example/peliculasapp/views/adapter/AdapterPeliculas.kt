package com.example.peliculasapp.views.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import antonkozyriatskyi.circularprogressindicator.CircularProgressIndicator
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.peliculasapp.R
import com.example.peliculasapp.common.network.api.Endpoints
import com.example.peliculasapp.model.PeliculaModel

class AdapterPeliculas (val context: Context, var listaPeliculas:List<PeliculaModel>
): RecyclerView.Adapter<AdapterPeliculas.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val cvPelicula = itemView.findViewById(R.id.cv_Pelicula) as CardView
        val ivPoster = itemView.findViewById(R.id.ivPoster) as ImageView
        val pcIndicador = itemView.findViewById(R.id.circularProgress) as CircularProgressIndicator
        val textName = itemView.findViewById(R.id.text_name) as TextView

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_rv_peliculas, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pelicula = listaPeliculas[position]

        Glide.with(context).load("${Endpoints.BASE_URL_IMAGE}${pelicula.poster_path}")
            .apply(RequestOptions().override(Endpoints.IMAGE_ANCHO, Endpoints.IMAGE_ALTO))
            .into(holder.ivPoster)

        with(holder) {
            pcIndicador.maxProgress = Endpoints.MAX_CALIFICACION
            pcIndicador.setCurrentProgress(pelicula.vote_average.toDouble())
            textName.text = pelicula.title
        }
    }

    override fun getItemCount(): Int {
        return listaPeliculas.size
    }
}