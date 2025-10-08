package com.example.plataformasalud_virtual

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton

class TableroAdapter(
    private val items: List<TableroItem>,
    private val onItemClick: (TableroItem) -> Unit
) : RecyclerView.Adapter<TableroAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgIcono: ImageView = itemView.findViewById(R.id.imgIcono)
        val tvTitulo: TextView = itemView.findViewById(R.id.tvTitulo)
        val tvDescripcion: TextView = itemView.findViewById(R.id.tvDescripcion)
        val btnAcceder: MaterialButton = itemView.findViewById(R.id.btnAcceder)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_tablero, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

        holder.imgIcono.setImageResource(item.iconoResId)
        holder.tvTitulo.text = item.titulo
        holder.tvDescripcion.text = item.descripcion

        // Click en toda la tarjeta
        holder.itemView.setOnClickListener {
            onItemClick(item)
        }

        // Click en el botón "Acceder"
        holder.btnAcceder.setOnClickListener {
            onItemClick(item)
        }
    }

    override fun getItemCount(): Int = items.size
}
