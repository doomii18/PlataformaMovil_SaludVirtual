package com.example.plataformasalud_virtual


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.plataformasalud_virtual.databinding.FragmentListBinding
import com.google.android.material.snackbar.Snackbar

class ListadosFragment   : Fragment(R.layout.fragment_list) {

    private var _b: FragmentListBinding? = null
    private val b get() = _b!!

    private val vm: PacientesViewModel by viewModels()
    private val adapter = PacientesAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _b = FragmentListBinding.bind(view)

        b.rvPacientes.layoutManager = LinearLayoutManager(requireContext())
        b.rvPacientes.adapter = adapter

        vm.pacientes.observe(viewLifecycleOwner) { adapter.submit(it) }
        vm.loading.observe(viewLifecycleOwner) {
            b.progress.visibility = if (it) View.VISIBLE else View.GONE
        }
        vm.error.observe(viewLifecycleOwner) { it?.let { msg ->
            Snackbar.make(b.root, msg, Snackbar.LENGTH_LONG).show()
        }}

        vm.load()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _b = null
    }
}
