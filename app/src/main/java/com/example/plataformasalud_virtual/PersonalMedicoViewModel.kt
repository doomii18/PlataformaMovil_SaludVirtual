package com.example.plataformasalud_virtual

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class PersonalMedicoViewModel(application: Application) : AndroidViewModel(application) {

    private val _personalMedico = MutableLiveData<List<PersonalMedicoCitas>>()
    val personalMedico: LiveData<List<PersonalMedicoCitas>> = _personalMedico

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> = _error

    init {
        cargarPersonalMedico()
    }

    fun cargarPersonalMedico() {
        viewModelScope.launch {
            _loading.value = true
            _error.value = null

            try {
                // Simular carga de datos
                delay(1000)

                // Usar los datos de tu JSON directamente
                val datos = getDatosDesdeJson()
                _personalMedico.value = datos
            } catch (e: Exception) {
                _error.value = "Error cargando datos: ${e.message}"
            } finally {
                _loading.value = false
            }
        }
    }

    private fun getDatosDesdeJson(): List<PersonalMedicoCitas> {
        return listOf(
            PersonalMedicoCitas("Cameron Iliana Jackson", "Enero", "Consulta General", 143),
            PersonalMedicoCitas("Cameron Iliana Jackson", "Febrero", "Consulta nutricional", 152),
            PersonalMedicoCitas("Cameron Iliana Jackson", "Marzo", "Control de crecimiento", 162),
            PersonalMedicoCitas("Cameron Iliana Jackson", "Abril", "Dificultades para respirar", 153),
            PersonalMedicoCitas("Cameron Iliana Jackson", "Mayo", "Dolor abdominal", 148),
            PersonalMedicoCitas("Cameron Iliana Jackson", "Junio", "Dolor de oido frecuente", 350),
            PersonalMedicoCitas("Carlos Castillo Gutiérrez", "Enero", "Emergencia leve", 153),
            PersonalMedicoCitas("Carlos Castillo Gutiérrez", "Febrero", "Enfermedad Comun", 169),
            PersonalMedicoCitas("Carlos Castillo Gutiérrez", "Marzo", "Fiebre", 170),
            PersonalMedicoCitas("Carlos Castillo Gutiérrez", "Abril", "Neumonia", 163),
            PersonalMedicoCitas("Carlos Castillo Gutiérrez", "Mayo", "Problemas de piel", 164),
            PersonalMedicoCitas("Carlos Castillo Gutiérrez", "Junio", "Revision de vacunas", 312),
            PersonalMedicoCitas("David Mandosa Valencia", "Enero", "Revision neonatal", 120),
            PersonalMedicoCitas("David Mandosa Valencia", "Febrero", "Tos y resfriado", 135),
            PersonalMedicoCitas("David Mandosa Valencia", "Marzo", "Transtorno del desarrollo", 140),
            PersonalMedicoCitas("David Mandosa Valencia", "Abril", "Vacunacion", 167),
            PersonalMedicoCitas("María González López", "Enero", "Consulta de seguimiento", 110),
            PersonalMedicoCitas("María González López", "Febrero", "Consulta General", 125),
            PersonalMedicoCitas("María González López", "Marzo", "Consulta nutricional", 130),
            PersonalMedicoCitas("Juan Pérez Rodríguez", "Enero", "Control de crecimiento", 115),
            PersonalMedicoCitas("Juan Pérez Rodríguez", "Febrero", "Consulta General", 128),
            PersonalMedicoCitas("Juan Pérez Rodríguez", "Marzo", "Consulta de seguimiento", 142),
            PersonalMedicoCitas("Ana Martínez Silva", "Enero", "Vacunacion", 105),
            PersonalMedicoCitas("Ana Martínez Silva", "Febrero", "Neumonia", 118),
            PersonalMedicoCitas("Ana Martínez Silva", "Marzo", "Dolor intestinal", 125)
        )
    }

    fun refrescarDatos() {
        cargarPersonalMedico()
    }
}