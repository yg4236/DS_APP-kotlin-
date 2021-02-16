package com.lee.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_viewchart.*

class win_menu : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_win_menu)

        val intent = intent
        val f_Name = intent.getDoubleExtra("f_Name",0.1)
        winner.text="${f_Name} 우승!"
    }
}