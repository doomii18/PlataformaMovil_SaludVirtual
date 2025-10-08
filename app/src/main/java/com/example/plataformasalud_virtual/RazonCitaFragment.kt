package com.example.plataformasalud_virtual

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.plataformasalud_virtual.databinding.FragmentRazonCitaBinding

class RazonCitaFragment : Fragment(R.layout.fragment_razon_cita) {

    private var _binding: FragmentRazonCitaBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentRazonCitaBinding.bind(view)

        // Datos de prueba
        val razonesPrueba = listOf(
            RazonCita("Control de niño sano", "Enero", 45),
            RazonCita("Fiebre", "Enero", 35),
            RazonCita("Vacunación", "Enero", 72),
            RazonCita("Infección respiratoria", "Febrero", 50),



        )

        setupRecyclerView(razonesPrueba)
        updateStatisticsCards(razonesPrueba)
    }

    private fun setupRecyclerView(razones: List<RazonCita>) {
        val adapter = RazonCitaAdapter()
        binding.rvRazonesCitas.layoutManager = LinearLayoutManager(requireContext())
        binding.rvRazonesCitas.adapter = adapter
        adapter.submitList(razones)
    }

    private fun updateStatisticsCards(razones: List<RazonCita>) {
        val totalRazones = razones.distinctBy { it.razonCita }.size
        val totalCitas = razones.sumOf { it.recuentoCitas }

        binding.tvTotalRazones.text = totalRazones.toString()
        binding.tvTotalCitas.text = totalCitas.toString()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}