package com.example.plataformasalud_virtual

import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.launch

class PacientesViewModel(app: Application) : AndroidViewModel(app) {
    private val api = ApiClient.create(app)

    private val _loading = MutableLiveData(false)
    val loading: LiveData<Boolean> = _loading

    private val _pacientes = MutableLiveData<List<Pacientes>>(emptyList())
    val pacientes: LiveData<List<Pacientes>> = _pacientes

    private val _error = MutableLiveData<String?>(null)
    val error: LiveData<String?> = _error

    fun load() {
        if (_loading.value == true) return
        _loading.value = true
        _error.value = null
        viewModelScope.launch {
            try {
                _pacientes.value = api.getPacientes()
            } catch (e: Exception) {
                _error.value = e.message
            } finally {
                _loading.value = false
            }
        }
    }
}
