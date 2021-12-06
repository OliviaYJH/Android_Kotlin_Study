package com.example.uselayouts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.uselayouts.databinding.ActivityListViewPracticeBinding


// item layout에서 변화하는 데이터들을 하나의 data class에 묶기
data class BusinessCard(val name:String, val contents:String)

class ListViewPracticeActivity : AppCompatActivity() {

    var businessCardArraylist = ArrayList<BusinessCard>(); // BusinessCard 형식으로 데이터 추가
    private lateinit var customAdapter: CustomAdapter
    lateinit var binding: ActivityListViewPracticeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityListViewPracticeBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)

        for(x in 0..30){
            businessCardArraylist.add(BusinessCard("a", "hi"))
            businessCardArraylist.add(BusinessCard("b", "hi"))
            businessCardArraylist.add(BusinessCard("a", "hi"))
            businessCardArraylist.add(BusinessCard("b", "hi"))
        }

        // 어댑터 추가, 어레이리스트로 추가해 넘기기
        customAdapter = CustomAdapter(this, businessCardArraylist)
        // 어댑터를 집어넣기
        binding.listviewMain.adapter = customAdapter
    }
}