package com.example.plataformasalud_virtual

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.plataformasalud_virtual.databinding.FragmentPersonalMedicoBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.launch

class PersonalMedicoFragment : Fragment(R.layout.fragment_personal_medico) {

    private var _binding: FragmentPersonalMedicoBinding? = null
    private val binding get() = _binding!!

    private val viewModel: PersonalMedicoViewModel by viewModels()
    private val adapter = PersonalMedicoAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentPersonalMedicoBinding.bind(view)

        setupRecyclerView()
        setupObservers()
    }

    private fun setupRecyclerView() {
        binding.rvMedicosCitas.layoutManager = LinearLayoutManager(requireContext())
        binding.rvMedicosCitas.adapter = adapter
    }

    private fun setupObservers() {
        viewModel.personalMedico.observe(viewLifecycleOwner) { personal ->
            adapter.submitList(personal)
            updateStatisticsCards(personal)
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

    private fun updateStatisticsCards(personal: List<PersonalMedicoCitas>) {
        val total = 20 // Fijo en 6
        val totalCitas = personal.sumOf { it.recuentoCitas }

        binding.tvTotalMedicos.text = total.toString()
        binding.tvTotalCitas.text = totalCitas.toString()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}