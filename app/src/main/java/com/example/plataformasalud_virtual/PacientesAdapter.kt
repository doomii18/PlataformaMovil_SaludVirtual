package com.example.plataformasalud_virtual


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PacientesAdapter(private var items: List<Pacientes> = emptyList())
    : RecyclerView.Adapter<PacientesAdapter.VH>() {

    fun submit(list: List<Pacientes>) {
        items = list
        notifyDataSetChanged()
    }

    class VH(v: View) : RecyclerView.ViewHolder(v) {
        val tvNombre: TextView = v.findViewById(R.id.tvNombre)
        val tvCodigo: TextView = v.findViewById(R.id.tvCodigo)
    }

    override fun onCreateViewHolder(p: ViewGroup, vt: Int): VH {
        val v = LayoutInflater.from(p.context).inflate(R.layout.item_texto, p, false)
        return VH(v)
    }

    override fun onBindViewHolder(h: VH, pos: Int) {
        val s = items[pos]
        h.tvNombre.text = s.nombre
        h.tvCodigo.text = s.Codigo
    }

    override fun getItemCount() = items.size
}
