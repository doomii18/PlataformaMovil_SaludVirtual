package com.example.plataformasalud_virtual


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListaFragment : Fragment() {

    companion object {
        private const val ARG_TIPO = "tipo" // "A", "B" o "C"

        fun newInstance(tipo: String) = ListaFragment().apply {
            arguments = Bundle().apply { putString(ARG_TIPO, tipo) }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, s: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, s: Bundle?) {
        val tipo = arguments?.getString(ARG_TIPO) ?: "A"

        val datos = when (tipo) {
            "A" -> listOf("Bienvenido a la Plataforma Salud Virtual", "La mejor atencion para tus pequeños")
            "B" -> listOf("Pacientes", "nombres", "apellidos", "sexo")
            "C" -> listOf("Tutores", "nombres", "apellidos", "ocupacion")
            "D" -> listOf("Citas Medicas ", "alergias", "codigo", "hora")
            "E" -> listOf("Historial Medico", "alergias", "peso", "pronostico")
            "F" -> listOf("Personal Medico", "Codigo", "Nombres", "Direccion")
            "G" -> listOf("Departamentos", "Codigo", "Nombre del departamento")
            "H" -> listOf("Cargo Médico", "Codigo", "Nombre del cargo")

            else -> listOf("Reportes", "Total Citas atendidas durante 2023-2025")
        }

        val rv = view.findViewById<RecyclerView>(R.id.recyclerView)
        rv.layoutManager = LinearLayoutManager(requireContext())
        rv.adapter = ListaAdapter(datos)
    }
}
