package com.example.uselayouts

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.uselayouts.databinding.ActivityWeatherApiactivityBinding
import com.example.uselayouts.models.WeatherResponse
import retrofit2.Call
import retrofit2.Response

class WeatherAPIActivity : AppCompatActivity() {

    private var API_KEY = "eb43510a125c1517c81d0a1c2874e1b8"
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

        binding.activityMainBtn.setOnClickListener {
            // 클릭리스너 api 구성
            val cityName = binding.activityMainEt.text.toString()
            getWeatherData(cityName, API_KEY)

        }
    }


    // Request 전송을 위한 작업 진행행

    // API 호출을 위한 getWeatherData라는 메서드 구성

    private fun getWeatherData(city: String, key: String){
        // 앞서 구성했던 WeatherInterface 구현현
       val weatherInterface = RetroitClient.sRetrofit.create(WeatherInterface::class.java)
        // enqueue() 메서드를 통해 비동기적으로 네트워크 통신 진행
        weatherInterface.getWeather(city, key).enqueue(object : retrofit2.Callback<WeatherResponse>{
            @SuppressLint("SetTextI18n")
            override fun onResponse(
                call: Call<WeatherResponse>,
                response: Response<WeatherResponse>
            ) {
               if(response.isSuccessful){
                   val result = response.body() as WeatherResponse
                   binding.tvResult.text = result.main.temp.toString() + "도"
               }else{
                   Log.d("MainActivity", "getWeatherData - onResponse: Error code ${response.code()}")
               }
            }

            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                Log.d("MainActivity", t.message ?: "통신오류")
            }

        })
    }
}