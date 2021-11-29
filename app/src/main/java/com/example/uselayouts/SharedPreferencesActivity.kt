package com.example.uselayouts

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.uselayouts.databinding.ActivitySharedPreferencesBinding
import java.util.*
import kotlin.concurrent.timer

class SharedPreferencesActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySharedPreferencesBinding
    private lateinit var sharedPreferences: SharedPreferences // 인스턴스 생성

    private var time = 0
    private var timerTask: Timer? = null // Nullable로 선언 방법


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        startTimer()

        binding = ActivitySharedPreferencesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // "test"라는 이름의 파일에 데이터 저장
        // MODE_PRIVATE: 해당 파일을 자기 앱 내에서 사용할 수 있으며, 외부 앱에서 접근 불가하도록 지정해주는 속성
        sharedPreferences = getSharedPreferences("test", MODE_PRIVATE)


        binding.btn.setOnClickListener{
            // EditText에 입력된 나이와 이름 데이터 가져오기
            val age = binding.etAge.text.toString().toInt() // etAge는 id명
            val name = binding.etName.text.toString()

            // 데이터를 저장하는 과정
            // 1. edit() 메서드를 통해 SharedPreferences.Editor 객체 가져오기
            val editor : SharedPreferences.Editor = sharedPreferences.edit()
            // 2. putter 메서드를 통해 데이터 저장 (SharedPreferences 객체는 key-value 형태로 데이터를 읽고 작성)
            editor.putInt("AGE", age)
            editor.putString("NAME", name)
            editor.apply() // 3. apply() 메서드를 통해 데이터를 최종적으로 파일에 반영

            // 데이터 저장이 완료되면 인텐트를 통해 SharedPreferencesActivity에서 SecondSharedPreferencesActivity로 전환하기
            startActivity(Intent(this, SecondSharedPreferencesActivity::class.java))
        }
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show()
    }

    private fun startTimer(){
        timerTask = timer(period = 10){
            time++

            val sec = time/100
            val milli = time % 100

            runOnUiThread{
                binding.secText.text = "$sec"
                binding.milliText.text = "$milli"

            }
        }
    }
}