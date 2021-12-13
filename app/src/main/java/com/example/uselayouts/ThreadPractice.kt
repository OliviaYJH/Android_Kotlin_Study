package com.example.uselayouts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.uselayouts.databinding.ActivityThreadPracticeBinding

class ThreadPractice : AppCompatActivity() {

    private lateinit var binding: ActivityThreadPracticeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityThreadPracticeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var pictureChangeArraylist = ArrayList<Int>()


        // 메인 Thread를 제외한 다른 Thread에서는 view를 다룰 수 없음! -> Handler 사용!
        var handler = Handler(Looper.getMainLooper())


        pictureChangeArraylist.add(R.drawable.dog)
        pictureChangeArraylist.add(R.drawable.cat)
        pictureChangeArraylist.add(R.drawable.rabit)
        pictureChangeArraylist.add(R.drawable.tiger)


        Thread(){
            for(i in pictureChangeArraylist){ // for-each문
                Thread.sleep(1000) // 1초 단위로 이미지 변경

                handler.post{ // Handler를 사용하면 orign Thread가 아닌 다른 Thread에서도 뷰를 다룰 수 있음
                    binding.imageMainChangePicture.setImageResource(i)
                }

            }
        }.start()
    }
}