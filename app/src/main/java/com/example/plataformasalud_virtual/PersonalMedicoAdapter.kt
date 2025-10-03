package com.example.plataformasalud_virtual

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PersonalMedicoAdapter : RecyclerView.Adapter<PersonalMedicoAdapter.ViewHolder>() {

    private var items: List<PersonalMedicoCitas> = emptyList()

    fun submitList(list: List<PersonalMedicoCitas>) {
        items = list
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNombreMedico: TextView = itemView.findViewById(R.id.tvMedico)
        val tvMes: TextView = itemView.findViewById(R.id.tvMes)
        val tvCitas: TextView = itemView.findViewById(R.id.tvCitas)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_medico_citas, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.tvNombreMedico.text = item.nombreMedico
        holder.tvMes.text = item.mes
        holder.tvCitas.text = "${item.recuentoCitas} citas pediátricas"
    }

    override fun getItemCount() = items.size
}