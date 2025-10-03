package com.example.plataformasalud_virtual

import android.R.drawable.ic_menu_help
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.plataformasalud_virtual.databinding.FragmentTableroGerencialBinding
import com.google.android.material.snackbar.Snackbar

class TableroGerencialFragment : Fragment(R.layout.fragment_tablero_gerencial) {

    private var _binding: FragmentTableroGerencialBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentTableroGerencialBinding.bind(view)

        setupTablero()
    }

    private fun setupTablero() {
        // Datos directos y simples
        val tableroItems = listOf(
            TableroItem("Pacientes", "Gestión de pacientes"),
            TableroItem("Doctores", "Personal médico"),
            TableroItem("Citas Médicas", "Citas y agendamiento"),
            TableroItem("Razones Consulta", "Razones de consulta")
        )

        // Configurar RecyclerView
        binding.rvTableroItems.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.rvTableroItems.adapter = TableroAdapter(tableroItems) { item ->
            onItemClicked(item)
        }
    }

    private fun onItemClicked(item: TableroItem) {
        when (item.titulo) {
            "Pacientes" -> {
                // Navegar al fragmento de pacientes
                parentFragmentManager.beginTransaction()
                    .replace(R.id.contentFrame, PacientesFragment())
                    .addToBackStack("tablero")
                    .commit()
            } "Doctores" -> {
            parentFragmentManager.beginTransaction()
                .replace(R.id.contentFrame, PersonalMedicoFragment()) // cambiaaaaaaaaar
                .addToBackStack("tablero")
                .commit()
            }
            "Razones Consulta" -> {
                parentFragmentManager.beginTransaction()
                    .replace(R.id.contentFrame, RazonCitaFragment())
                    .addToBackStack("tablero")
                    .commit()
            }
            else -> {
                Snackbar.make(binding.root, "${item.titulo} - Próximamente", Snackbar.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}