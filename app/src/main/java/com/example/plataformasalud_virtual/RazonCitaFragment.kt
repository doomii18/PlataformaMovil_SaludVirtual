package com.example.plataformasalud_virtual

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.plataformasalud_virtual.databinding.FragmentRazonCitaBinding
import com.google.android.material.snackbar.Snackbar

class RazonCitaFragment : Fragment(R.layout.fragment_razon_cita) {

    private var _binding: FragmentRazonCitaBinding? = null
    private val binding get() = _binding!!


    private val viewModel: RazonCitaViewModel by viewModels()
    private val adapter = RazonCitaAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentRazonCitaBinding.bind(view)



        setupRecyclerView()
        setupObservers()
    }

    private fun setupRecyclerView() {
        binding.rvRazonesCitas.layoutManager = LinearLayoutManager(requireContext())
        binding.rvRazonesCitas.adapter = adapter
    }

    private fun setupObservers() {
        viewModel.razonesCita.observe(viewLifecycleOwner) { razones ->
            adapter.submitList(razones)
            updateStatisticsCards(razones)
        }


        viewModel.loading.observe(viewLifecycleOwner) { isLoading ->
            binding.progress.visibility = if (isLoading) View.VISIBLE else View.GONE
        }

        viewModel.error.observe(viewLifecycleOwner) { error ->
            error?.let {
                // Muestra snackbar pero no es error fatal porque tenemos datos de fallback
                Snackbar.make(binding.root, it, Snackbar.LENGTH_LONG).show()
            }
        }

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