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

var arr= arrayOfNulls<Int>(8)
class worldcupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_worldcup)

        val responseListener = Response.Listener<String>() {

        }
        val worldcupRequest = worldcupRequest(responseListener)
        val queue = Volley.newRequestQueue(this@worldcupActivity)
        queue.add(worldcupRequest)

        Toast.makeText(this, "월드컵 시작", Toast.LENGTH_SHORT).show()

        var i =0
        var click:Boolean=false
        var pal_pick=arrayOf(1,1,1,1,1,1,1,1)
        var sa_pick=arrayOf(1,1,1,1)
        var finall=arrayOf(1,1)
        var win:Int
        var pal_index=0
        var sa_index=0
        var final_index=0
        //for(i in 0..14 step(2)) {
            fetchJson(i)
            Toast.makeText(this, "fetch 완료", Toast.LENGTH_SHORT).show()

            first_menu.setOnClickListener {
                // arr[i / 2] = array[i].f_num
                if(i<=14){
                    pal_pick[pal_index++]=i
                    i+=2
                    if(i<14) fetchJson(i)
                    else if (i==14)
                    {
                        fetchJson(pal_pick[0])
                        Round.text="8강"
                    }
                }
                else if(i>14&&i<=22)
                {
                    sa_pick[sa_index++]=pal_pick[i-16]
                    i+=2
                    if(i<22) fetchJson(pal_pick[i-16])
                    else if (i==22){
                        fetchJson(pal_pick[i-16])
                        Round.text="4강"
                    }
                }
                else if(i<22&&i<=26){
                    finall[final_index++]=sa_pick[i-24]
                    i+=2
                    if(i<26) fetchJson(sa_pick[i-24])
                    else if (i==26){
                        fetchJson(sa_pick[i-24])
                        Round.text="결승"
                    }
                }
                else
                {
                    win=finall[0]
                    Round.text="${finall[0]}번 음식 우승"
                }
            }
            second_menu.setOnClickListener {
                // arr[i / 2] = array[i + 1].f_num
                if(i<=14){
                    pal_pick[pal_index++]=i+1
                    i+=2
                    if(i<14) fetchJson(i)
                    else if (i==14)
                    {
                        fetchJson(pal_pick[0])
                        Round.text="8강"
                    }
                }
                else if(i>14&&i<=22) {
                    sa_pick[sa_index++] = pal_pick[i - 15]
                    i += 2
                    if (i < 22) fetchJson(pal_pick[i - 16])
                    else if (i == 22) {
                        fetchJson(pal_pick[i - 16])
                        Round.text = "4강"
                    }
                }
                else if(i<22&&i<=26){
                    finall[final_index++]=sa_pick[i-23]
                    i+=2
                    if(i<26) fetchJson(sa_pick[i-24])
                    else if (i==26){
                        fetchJson(sa_pick[i-24])
                        Round.text="결승"
                    }
                }
                else
                {
                    win=finall[1]
                    Round.text="${finall[1]}번 음식 우승"
                }
            }

    }

    private val client = OkHttpClient()
    fun fetchJson(i:Int) {
        val url = URL("http://yg4236.dothome.co.kr/worldcup.php")

        Log.d("url", "url가능")
        val request = okhttpRequest.Builder().url(url).build()
        Log.d("request", "request가능")
        Log.d("client", "client가능")

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.d("실패","실패")
                first_menu.setText("Call Fail!")
                //second_menu.text = "1"
            }

            override fun onResponse(call: Call, response: okhttp3.Response) {
                Log.d("onResponse In","onResponse In")
                val body = response.body?.string()
                val gson = GsonBuilder().create()
                val list = gson.fromJson(body, JsonObj::class.java)
                val array = list.result
                first_menu.text ="\t${list.result[i].f_name}\ncalorie : ${list.result[i].calorie}\ncar : ${list.result[i].car}\npro : ${list.result[i].pro}\nfat : ${list.result[i].fat}"
                second_menu.text = "\t${list.result[i+1].f_name}\ncalorie : ${list.result[i+1].calorie}\ncar : ${list.result[i+1].car}\npro : ${list.result[i+1].pro}\nfat : ${list.result[i+1].fat}"

            }

        })

    }
    //////////// requset parameter 제거하기 ////////////////////


}
data class JsonObj(val result : List<Menu>)
data class Menu (val f_num:Int, val f_name:String, val calorie:Double, val car:Double, val pro:Double, val fat:Double, val win_count:Int )