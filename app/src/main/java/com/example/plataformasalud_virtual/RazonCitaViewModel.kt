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
                    RazonCita("Consulta por fiebre", "Enero", 2015, 42),
                    RazonCita("Consulta por fiebre", "Diciembre", 2015, 31),
                    RazonCita("Consulta por fiebre", "Enero", 2016, 42),
                    RazonCita("Consulta por fiebre", "Diciembre", 2016, 39),
                    RazonCita("Consulta por fiebre", "Enero", 2017, 44),
                    RazonCita("Consulta por fiebre", "Diciembre", 2017, 57),
                    RazonCita("Consulta por fiebre", "Enero", 2018, 49),
                    RazonCita("Consulta por fiebre", "Diciembre", 2018, 45),
                    RazonCita("Consulta por fiebre", "Enero", 2019, 36),
                    RazonCita("Consulta por fiebre", "Diciembre", 2019, 32),
                    RazonCita("Consulta por fiebre", "Enero", 2020, 51),
                    RazonCita("Consulta por fiebre", "Diciembre", 2020, 30),
                    RazonCita("Consulta por fiebre", "Enero", 2021, 40),
                    RazonCita("Consulta por fiebre", "Diciembre", 2021, 39),
                    RazonCita("Consulta por fiebre", "Enero", 2022, 44),
                    RazonCita("Consulta por fiebre", "Diciembre", 2022, 44),
                    RazonCita("Consulta por fiebre", "Enero", 2023, 42),
                    RazonCita("Consulta por fiebre", "Diciembre", 2023, 47),
                    RazonCita("Consulta por fiebre", "Enero", 2024, 34),
                    RazonCita("Consulta por fiebre", "Diciembre", 2024, 38),
                    RazonCita("Consulta por fiebre", "Enero", 2025, 47),

                    RazonCita("Consulta por Tos", "Enero", 2015, 40),
                    RazonCita("Consulta por Tos", "Diciembre", 2015, 39),
                    RazonCita("Consulta por Tos", "Enero", 2016, 37),
                    RazonCita("Consulta por Tos", "Diciembre", 2016, 40),
                    RazonCita("Consulta por Tos", "Enero", 2017, 40),
                    RazonCita("Consulta por Tos", "Diciembre", 2017, 38),
                    RazonCita("Consulta por Tos", "Enero", 2018, 37),
                    RazonCita("Consulta por Tos", "Diciembre", 2018, 42),
                    RazonCita("Consulta por Tos", "Enero", 2019, 39),
                    RazonCita("Consulta por Tos", "Diciembre", 2019, 49),
                    RazonCita("Consulta por Tos", "Enero", 2020, 37),
                    RazonCita("Consulta por Tos", "Diciembre", 2020, 36),
                    RazonCita("Consulta por Tos", "Enero", 2021, 37),
                    RazonCita("Consulta por Tos", "Diciembre", 2021, 50),
                    RazonCita("Consulta por Tos", "Enero", 2022, 43),
                    RazonCita("Consulta por Tos", "Diciembre", 2022, 40),
                    RazonCita("Consulta por Tos", "Enero", 2023, 36),
                    RazonCita("Consulta por Tos", "Diciembre", 2023, 37),
                    RazonCita("Consulta por Tos", "Enero", 2024, 36),
                    RazonCita("Consulta por Tos", "Diciembre", 2024, 49),
                    RazonCita("Consulta por Tos", "Enero", 2025, 45),

                    RazonCita("Dolor de Garganta", "Enero", 2015, 51),
                    RazonCita("Dolor de Garganta", "Diciembre", 2015, 53),
                    RazonCita("Dolor de Garganta", "Enero", 2016, 50),
                    RazonCita("Dolor de Garganta", "Diciembre", 2016, 42),
                    RazonCita("Dolor de Garganta", "Enero", 2017, 37),
                    RazonCita("Dolor de Garganta", "Diciembre", 2017, 44),
                    RazonCita("Dolor de Garganta", "Enero", 2018, 56),
                    RazonCita("Dolor de Garganta", "Diciembre", 2018, 38),
                    RazonCita("Dolor de Garganta", "Enero", 2019, 36),
                    RazonCita("Dolor de Garganta", "Diciembre", 2019, 28),
                    RazonCita("Dolor de Garganta", "Enero", 2020, 41),
                    RazonCita("Dolor de Garganta", "Diciembre", 2020, 34),
                    RazonCita("Dolor de Garganta", "Enero", 2021, 39),
                    RazonCita("Dolor de Garganta", "Diciembre", 2021, 44),
                    RazonCita("Dolor de Garganta", "Enero", 2022, 35),
                    RazonCita("Dolor de Garganta", "Diciembre", 2022, 50),
                    RazonCita("Dolor de Garganta", "Enero", 2023, 44),
                    RazonCita("Dolor de Garganta", "Diciembre", 2023, 41),
                    RazonCita("Dolor de Garganta", "Enero", 2024, 51),
                    RazonCita("Dolor de Garganta", "Diciembre", 2024, 44),
                    RazonCita("Dolor de Garganta", "Enero", 2025, 34),

                    RazonCita("Problemas respiratorios", "Enero", 2015, 39),
                    RazonCita("Problemas respiratorios", "Diciembre", 2015, 40),
                    RazonCita("Problemas respiratorios", "Enero", 2016, 42),
                    RazonCita("Problemas respiratorios", "Diciembre", 2016, 47),
                    RazonCita("Problemas respiratorios", "Enero", 2017, 43),
                    RazonCita("Problemas respiratorios", "Diciembre", 2017, 38),
                    RazonCita("Problemas respiratorios", "Enero", 2018, 32),
                    RazonCita("Problemas respiratorios", "Diciembre", 2018, 46),
                    RazonCita("Problemas respiratorios", "Enero", 2019, 38),
                    RazonCita("Problemas respiratorios", "Diciembre", 2019, 32),
                    RazonCita("Problemas respiratorios", "Enero", 2020, 51),
                    RazonCita("Problemas respiratorios", "Diciembre", 2020, 43),
                    RazonCita("Problemas respiratorios", "Enero", 2021, 46),
                    RazonCita("Problemas respiratorios", "Diciembre", 2021, 46),
                    RazonCita("Problemas respiratorios", "Enero", 2022, 44),
                    RazonCita("Problemas respiratorios", "Diciembre", 2022, 44),
                    RazonCita("Problemas respiratorios", "Enero", 2023, 43),
                    RazonCita("Problemas respiratorios", "Diciembre", 2023, 39),
                    RazonCita("Problemas respiratorios", "Enero", 2024, 35),
                    RazonCita("Problemas respiratorios", "Diciembre", 2024, 44),
                    RazonCita("Problemas respiratorios", "Enero", 2025, 33),
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