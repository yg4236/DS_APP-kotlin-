package com.lee.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Response
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val responseListener = Response.Listener<String>(){
        }
        box_worldcup.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@MainActivity, worldcupActivity::class.java)
            startActivity(intent)
//            val worldcupRequest = worldcupRequest("1","2", responseListener)
//            val queue = Volley.newRequestQueue(this@MainActivity)
//            queue.add(worldcupRequest)
        })
        box_viewchart.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@MainActivity, ViewchartActivity::class.java)
            startActivity(intent)
        })
    }

}