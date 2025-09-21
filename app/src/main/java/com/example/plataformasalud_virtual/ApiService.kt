package com.example.plataformasalud_virtual

import retrofit2.http.GET

interface ApiService {
    @GET("pacientes")
    suspend fun getPacientes(): List<Pacientes>
}
