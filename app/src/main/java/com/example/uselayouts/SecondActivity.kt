package com.example.uselayouts

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.uselayouts.databinding.ActivitySecondBinding

class SecondActivity: AppCompatActivity() {

    lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySecondBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // 넘어온 데이터를 txtSecond에다가 세팅 -> txtSecond.text에 인텐트를 가져와야 함
        binding.txtSecond.text = intent.getStringExtra("data")
        // getStringExtra()에 key값(여기서는 data)을 적어 주면 보내준 값을 받을 수 있음
    }
}