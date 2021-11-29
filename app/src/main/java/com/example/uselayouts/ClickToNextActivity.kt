package com.example.uselayouts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.uselayouts.databinding.ActivityClickToNextBinding

class ClickToNextActivity : AppCompatActivity() {

    // xml 파일에 해당하는 클래스를 안드로이드에서 자동적으로 생성
    private lateinit var binding: ActivityClickToNextBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 클래스를 인스턴스화 메모리에 올려주는 과정 -> .inflate 라는 거 자체 메모리 올려줌
        binding = ActivityClickToNextBinding.inflate(layoutInflater)

        // 바인딩 클래스에 있는 루트(여기서는 LinearLayout)를 view에 담음


        setContentView(binding.root) // 화면이 메모리상에 올라감

        binding.btnMain.setOnClickListener {
            Toast.makeText(this, "Click!!!", Toast.LENGTH_SHORT).show()
            // 클릭을 할 때 동작하는 메서드

            // binding.btnMain: 세팅한 버튼 이름이 자동으로 생성

            // 클릭하면 데이터를 넘겨주는 작업
            var intent = Intent(this, SecondActivity::class.java) // SecondActivity 명시해주기(명시적 인텐트)
            intent.putExtra("data", binding.edtMain.text.toString())
            startActivity(intent)
        }
    }
}