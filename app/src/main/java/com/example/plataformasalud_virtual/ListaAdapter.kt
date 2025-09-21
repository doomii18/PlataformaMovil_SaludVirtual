package com.example.plataformasalud_virtual
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListaAdapter(private var datos: List<String>) :
    RecyclerView.Adapter<ListaAdapter.VH>() {

    class VH(v: View) : RecyclerView.ViewHolder(v) {
        val tv: TextView = v.findViewById(R.id.tvnombre)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_pacientes, parent, false)
        return VH(v)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.tv.text = datos[position]
    }

    override fun getItemCount(): Int = datos.size
}
