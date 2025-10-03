package com.example.plataformasalud_virtual

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class RazonCitaViewModel(application: Application) : AndroidViewModel(application) {

    private val _razonesCita = MutableLiveData<List<RazonCita>>()
    val razonesCita: LiveData<List<RazonCita>> = _razonesCita

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> = _error

    init {
        cargarRazonesCita()
    }

    fun cargarRazonesCita() {
        viewModelScope.launch {
            _loading.value = true
            _error.value = null

            try {
                // Simular carga de datos
                delay(1000)

                // Datos de prueba directamente en el ViewModel
                val datosPrueba = listOf(
                    RazonCita("Control de niño sano", "Enero", 45),
                    RazonCita("Fiebre", "Enero", 35),
                    RazonCita("Vacunación", "Enero", 72),
                    RazonCita("Infección respiratoria", "Febrero", 50),
                    RazonCita("Control de niño sano", "Febrero", 90),
                    RazonCita("Dolor abdominal", "Febrero", 25),
                    RazonCita("Vacunación", "Febrero", 60)
                )

                _razonesCita.value = datosPrueba
            } catch (e: Exception) {
                _error.value = "Error cargando datos: ${e.message}"
            } finally {
                _loading.value = false
            }
        }
    }

    fun refrescarDatos() {
        cargarRazonesCita()
    }
}