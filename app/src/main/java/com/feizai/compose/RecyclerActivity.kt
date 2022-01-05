package com.feizai.compose

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration

/**
 * Author: chenhao
 * Date: 2021/12/27-0027 下午 05:44:48
 * Describe:
 */
class RecyclerActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recycler)
        var recycler:RecyclerView = findViewById(R.id.recycler)
        var data:MutableList<String> = ArrayList()
        data+="aa"
        data+="bb"
        data+="cc"
        data+="dd"
        recycler.addItemDecoration(HorizontalDividerItemDecoration.Builder(this).color(Color.BLACK).size(1).build())
        recycler.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false)
        recycler.adapter = MyAdapter(this,data)
    }
}