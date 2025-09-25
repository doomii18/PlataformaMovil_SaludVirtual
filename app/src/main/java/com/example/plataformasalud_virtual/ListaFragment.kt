package com.example.plataformasalud_virtual


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class ListaFragment : Fragment() {

    companion object {
        private const val ARG_TIPO = "tipo" // "A", "B" o "C"

        fun newInstance(tipo: String) = ListaFragment().apply {
            arguments = Bundle().apply { putString(ARG_TIPO, tipo) }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, s: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_pacientes, container, false)
    }
}
//    override fun onViewCreated(view: View, s: Bundle?) {
//        val tipo = arguments?.getString(ARG_TIPO) ?: "A"

//        val datos = when (tipo) {
//            "A" -> listOf("Bienvenido a la Plataforma Salud Virtual")
//            "B" -> listOf("Pacientes Pediatricos")
//            "C" -> listOf("Tutores")
//
//            else -> listOf("Reportes Medicos")
//        }

//       val rv = view.findViewById<RecyclerView>(R.id.recyclerView)
//        rv.layoutManager = LinearLayoutManager(requireContext())
//        rv.adapter = ListaAdapter(datos)
   // }
//}
