package com.example.plataformasalud_virtual
import android.content.Context
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.Protocol
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody

class MockInterceptor(private val context: Context) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val path = request.url.encodedPath

        // Lista de rutas que manejamos
        val handledPaths = mapOf(
            "/pacientes" to "pacientes.json",
            "/personalmedico" to "personalmedico.json",
            "razonescitas" to "razones_cita.json"

        )

        return if (handledPaths.containsKey(path)) {
            val fileName = handledPaths[path]!!
            try {
                val json = context.assets.open(fileName)
                    .bufferedReader().use { it.readText() }

                Response.Builder()
                    .request(request)
                    .protocol(Protocol.HTTP_1_1)
                    .code(200)
                    .message("OK")
                    .body(json.toResponseBody("application/json".toMediaType()))
                    .addHeader("content-type", "application/json")
                    .build()
            } catch (e: Exception) {
                // Si el archivo no existe, devolver error 404
                Response.Builder()
                    .request(request)
                    .protocol(Protocol.HTTP_1_1)
                    .code(404)
                    .message("Asset not found: $fileName")
                    .body("".toResponseBody("application/json".toMediaType()))
                    .build()
            }
        } else {
            chain.proceed(request)
        }
    }
}
