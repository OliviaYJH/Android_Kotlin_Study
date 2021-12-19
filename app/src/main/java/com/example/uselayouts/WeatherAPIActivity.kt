package com.example.uselayouts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.uselayouts.databinding.ActivityWeatherApiactivityBinding

class WeatherAPIActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWeatherApiactivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityWeatherApiactivityBinding.inflate(layoutInflater)

        setContentView(binding.root)
        
        
        /*
        네트워크 통신 관련 작업
        1. Data Class 정의하기
        2. API 호출을 위한 인터페이스 정의하기
        3. Retrofit Client 생성하기
        4. Request 전송하기
         */
    }
}