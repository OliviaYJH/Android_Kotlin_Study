package com.example.uselayouts

import com.example.uselayouts.models.WeatherResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherInterface {
    
    @GET("weather")// GET 방식으로 데이터를 가져오겠다는 것을 Annotation으로 명시

    // @Query Annotation을 이용해 2개의 쿼리값 명시
    fun getWeather(@Query("q") q:String,
                   @Query("appid") appid:String
    ): Call<WeatherResponse>
    // getWeather() 메서드의 반환타입을 다음과 같이 앞서 만들었던 WeatherResponse 타입의 Call 객체로 작성
    
    

}