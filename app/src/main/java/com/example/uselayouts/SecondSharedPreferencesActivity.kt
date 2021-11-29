package com.example.uselayouts

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.uselayouts.databinding.ActivitySecondSharedPreferencesBinding

class SecondSharedPreferencesActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondSharedPreferencesBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySecondSharedPreferencesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // SharedPreferences 객체를 생성하면서 "test"라는 이름의 파일을 읽어오도록!
        sharedPreferences = getSharedPreferences("test", MODE_PRIVATE)

        // 데이터를 가져올 때는 getter 메서드를 통해 값을 가져옴
        // defValue는 호출하는 키에 해당하는 값이 파일에 없을 때 출력해줄 Default 값
        val age = sharedPreferences.getInt("AGE", -1)
        val name = sharedPreferences.getString("NAME", "ERROR")

        binding.secondTvAge.text = age.toString()
        binding.secondTvName.text = name
    }
}