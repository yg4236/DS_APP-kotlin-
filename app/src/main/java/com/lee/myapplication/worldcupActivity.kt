package com.lee.myapplication

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Response
import com.android.volley.toolbox.Volley

class worldcupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_worldcup)

        val responseListener = Response.Listener<String>(){
        }
        val worldcupRequest = worldcupRequest("1","2", responseListener)
        val queue = Volley.newRequestQueue(this@worldcupActivity)
        queue.add(worldcupRequest)
    }
    //////////// requset parameter 제거하기 ////////////////////
}