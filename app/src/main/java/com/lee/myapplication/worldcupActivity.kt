package com.lee.myapplication

import android.os.Bundle
import android.util.Log
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.Volley
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_worldcup.*
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request as okhttpRequest
import org.json.JSONObject
import java.io.IOException
import java.net.URL


class worldcupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_worldcup)

        val responseListener = Response.Listener<String>(){

        }
        val worldcupRequest = worldcupRequest(responseListener)
        val queue = Volley.newRequestQueue(this@worldcupActivity)
        queue.add(worldcupRequest)

        Toast.makeText(this, "월드컵 시작", Toast.LENGTH_SHORT).show()
        //Menu 가져오기
        fetchJson()
        Toast.makeText(this, "fetch 완료", Toast.LENGTH_SHORT).show()
    }
    private val client = OkHttpClient()
    fun fetchJson(){
        val url = URL("http://yg4236.dothome.co.kr/worldcup.php")

        Log.d("url","url가능")
        val request = okhttpRequest.Builder().url(url).build()
        Log.d("request","request가능")

        Log.d("client","client가능")
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                first_menu.setText("Call Fail!")
                second_menu.text = "1"
            }
            override fun onResponse(call: Call, response: okhttp3.Response) {

                    val body = response.body?.string()

                    val gson = GsonBuilder().create()
                    val list = gson.fromJson(body, JsonObj::class.java)
                    first_menu.setText(list.result.toString())
                    second_menu.text = "2"
        }
        })
    }
    //////////// requset parameter 제거하기 ////////////////////
}

data class JsonObj(val result : List<Menu>)
data class Menu (val f_name:String, val calorie:Double, val car:Double, val pro:Double, val fat:Double, val win_count:Int )