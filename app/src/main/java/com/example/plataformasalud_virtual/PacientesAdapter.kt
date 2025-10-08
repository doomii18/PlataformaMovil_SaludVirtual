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
        val tvNombrecompletoPacientes: TextView = v.findViewById(R.id.tvnombrecompletopaciente)
        val tvsexoPacientes: TextView = v.findViewById(R.id.tvsexopaciente)
        val tvedadPacientes: TextView = v.findViewById(R.id.tvedadpacientes)
        val tvalergiasPacientes: TextView = v.findViewById(R.id.tvalergiaspacientes)

    }

    override fun onCreateViewHolder(p: ViewGroup, vt: Int): VH {
        val v = LayoutInflater.from(p.context).inflate(R.layout.item_pacientes, p, false)
        return VH(v)
    }

    override fun onBindViewHolder(h: VH, pos: Int) {
        val s = items[pos]
        h.tvNombrecompletoPacientes.text = s.nombreCompletoPacientes
        h.tvsexoPacientes.text = s.sexoPacientes
        h.tvedadPacientes.text = s.edadPacientes.toString()
        h.tvalergiasPacientes.text = s.alergiasPacientes


    }

    override fun getItemCount() = items.size
}
