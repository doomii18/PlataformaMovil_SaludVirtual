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
        val tvnombreCompletoTutor: TextView = v.findViewById(R.id.tvnombrecompletotutor)
        val tvsexoTutor: TextView = v.findViewById(R.id.tvsexotutor)
        val tvedadTutor: TextView = v.findViewById(R.id.tvedadtutor)
        val tvocupacionTutor: TextView = v.findViewById(R.id.tvocupaciontutor)
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
        h.tvnombreCompletoTutor.text = s.nombreCompletoTutor
        h.tvsexoTutor.text = s.sexoTutor
        h.tvedadTutor.text = s.edadTutor.toString()
        h.tvocupacionTutor.text = s.ocupacionTutor

    }

    override fun getItemCount() = items.size
}
