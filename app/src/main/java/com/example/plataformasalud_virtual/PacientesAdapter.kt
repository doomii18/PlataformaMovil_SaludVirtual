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
        val tvNombre: TextView = v.findViewById(R.id.tvnombre)
        val tvCodigo: TextView = v.findViewById(R.id.tvcodigo)
    }

    override fun onCreateViewHolder(p: ViewGroup, vt: Int): VH {
        val v = LayoutInflater.from(p.context).inflate(R.layout.item_pacientes, p, false)
        return VH(v)
    }

    override fun onBindViewHolder(h: VH, pos: Int) {
        val s = items[pos]
        h.tvNombre.text = s.nombre
        h.tvCodigo.text = s.codigo
    }

    override fun getItemCount() = items.size
}
