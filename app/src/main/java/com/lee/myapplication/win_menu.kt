package com.lee.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Response
import com.android.volley.toolbox.Volley
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_viewchart.*
import kotlinx.android.synthetic.main.activity_viewchart.winner
import kotlinx.android.synthetic.main.activity_win_menu.*
import kotlinx.android.synthetic.main.activity_worldcup.*
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException
import java.net.URL

class win_menu : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_win_menu)

        val intent = intent
        val f_Name= intent.getStringExtra("f_Name").toString()
        winner.text="${f_Name} 우승!"

        ///////////////////////////////////////////////////
        val responseListener = Response.Listener<String>() {
        }
        //val ListRequest = f_Name?.let { ListRequest(it,responseListener) }
        val ListRequest = ListRequest(f_Name, responseListener)
        val queue = Volley.newRequestQueue(this)
        queue.add(ListRequest)

        fetchJson()

    }
    private val client = OkHttpClient()
    fun fetchJson(){
        val url = URL("http://yg4236.dothome.co.kr/list.php")
        val request = Request.Builder().url(url).build()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                first_menu.setText("Call Fail!")
            }
            override fun onResponse(call: Call, response: okhttp3.Response) {
                val body = response?.body?.string()
                winner.text="${body}"
//                val gson = GsonBuilder().create()
//                val list = gson.fromJson(body, JsonObjj::class.java)
//                val j=0
//                rest.text="${list.result[0].name} ${list.result[1].name}"
            }
        })
    }
}
data class JsonObjj(val result : List<restaurant>)
data class restaurant (val name:String, val main:String, val add:String, val contact:String)