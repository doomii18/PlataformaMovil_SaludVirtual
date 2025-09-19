package com.example.plataformasalud_virtual

import android.content.Context
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    fun create(context: Context): ApiService {
        val ok = OkHttpClient.Builder()
            .addInterceptor(MockInterceptor(context))
            .build()

        return Retrofit.Builder()
            .baseUrl("https://local/")   // Cualquier host; el interceptor intercepta.
            .client(ok)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}
