package com.example.uselayouts

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.uselayouts.databinding.ListviewItemBinding

class CustomAdapter(context: Context, private val businessCardArraylist:ArrayList<BusinessCard>): BaseAdapter(){

    lateinit var binding: ListviewItemBinding

    // layout inflater
    // context는 getSystemService로 시스템에 있는 API를 호출해 애플리케이션에서 쓸 수 있는, 앱과 OS 사이의 중재자 역할
    private val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int = businessCardArraylist.size // ArrayList size 반환

    override fun getItem(p0: Int): Any = businessCardArraylist[p0] // 위치 값에 따른 data

    override fun getItemId(p0: Int): Long = p0.toLong() // 포지션 값 반환

    override fun getView(position: Int, p1: View?, p2: ViewGroup?): View {
        binding = ListviewItemBinding.inflate(inflater, p2, false)
        binding.nameListviewItem.text = businessCardArraylist[position].name
        binding.contentsListviewItem.text = businessCardArraylist[position].contents

        return binding.root
    }
}