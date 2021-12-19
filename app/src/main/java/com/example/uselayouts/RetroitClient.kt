package com.example.uselayouts

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetroitClient {
    
    // Retrofit Client 생성하기 단계
    val sRetrofit = initRetrofit()
    private const val WEATHER_URL = "https://api.openweathermap.org/data/2.5/"

    private fun initRetrofit() : Retrofit =
        Retrofit.Builder() // Retrofit.Builder() 클래스의 인스턴스 만들기 
            .baseUrl(WEATHER_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
}