package com.example.plataformasalud_virtual

import retrofit2.http.GET

interface ApiService {
  //endpoints
  @GET("pacientes")
  suspend fun getPacientes(): List<Pacientes>

  @GET("TableroGestion")
  suspend fun getTableroGestion(): List<TableroItem>

  @GET("medicos")
  suspend fun getPersonalMedico(): List<PersonalMedicoCitas>

}