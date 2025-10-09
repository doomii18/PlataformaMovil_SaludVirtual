package com.example.plataformasalud_virtual

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class RazonCitaAdapter : ListAdapter<RazonCita, RazonCitaAdapter.RazonCitaViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RazonCitaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_razon_cita, parent, false)
        return RazonCitaViewHolder(view)
    }

    override fun onBindViewHolder(holder: RazonCitaViewHolder, position: Int) {
        val razon = getItem(position)
        holder.bind(razon)
    }

    class RazonCitaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvRazon: TextView = itemView.findViewById(R.id.tvRazon)
        private val tvMes: TextView = itemView.findViewById(R.id.tvMes)
        val tvanio: TextView = itemView.findViewById(R.id.tvAnio)
        private val tvRecuento: TextView = itemView.findViewById(R.id.tvRecuento)

        fun bind(razon: RazonCita) {
            tvRazon.text = razon.razonCita
            tvMes.text = "Mes: ${razon.mes}"
            tvanio.text = "Año: ${razon.anio}"
            tvRecuento.text = "Citas: ${razon.recuentoCitas}"
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<RazonCita>() {
        override fun areItemsTheSame(oldItem: RazonCita, newItem: RazonCita): Boolean {
            return oldItem.razonCita == newItem.razonCita && oldItem.mes == newItem.mes
        }

        override fun areContentsTheSame(oldItem: RazonCita, newItem: RazonCita): Boolean {
            return oldItem == newItem
        }
    }
}