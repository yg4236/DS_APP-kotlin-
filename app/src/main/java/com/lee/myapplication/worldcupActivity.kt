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

var Arr_f_num= arrayOfNulls<Int>(16)
var Arr_f_name= arrayOfNulls<String>(16)
var Arr_f_calorie = arrayOfNulls<Double>(16)
var Arr_f_car = arrayOfNulls<Double>(16)
var Arr_f_pro = arrayOfNulls<Double>(16)
var Arr_f_fat = arrayOfNulls<Double>(16)


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

        fetchJson()
        first_menu.text="\t${Arr_f_name[0]}\ncalorie : ${Arr_f_calorie[0]}\ncar : ${Arr_f_car[0]}\npro : ${Arr_f_pro[0]}\nfat : ${Arr_f_fat[0]}"
        second_menu.text="\t${Arr_f_name[1]}\ncalorie : ${Arr_f_calorie[1]}\ncar : ${Arr_f_car[1]}\npro : ${Arr_f_pro[1]}\nfat : ${Arr_f_fat[1]}"
        first_menu.setOnClickListener {
            first_menu.text="\t${Arr_f_name[2]}\ncalorie : ${Arr_f_calorie[2]}\ncar : ${Arr_f_car[2]}\npro : ${Arr_f_pro[2]}\nfat : ${Arr_f_fat[2]}"
        }
        second_menu.setOnClickListener {
            second_menu.text="\t${Arr_f_name[3]}\ncalorie : ${Arr_f_calorie[3]}\ncar : ${Arr_f_car[3]}\npro : ${Arr_f_pro[3]}\nfat : ${Arr_f_fat[3]}"
        }


    }
    private val client = OkHttpClient()
    fun fetchJson(){
        val url = URL("http://yg4236.dothome.co.kr/worldcup.php")
        val request = okhttpRequest.Builder().url(url).build()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                first_menu.setText("Call Fail!")
            }
            override fun onResponse(call: Call, response: okhttp3.Response) {
                val body = response?.body?.string()
                val gson = GsonBuilder().create()
                val list = gson.fromJson(body, JsonObj::class.java)
                 for(j in 0..15){
                    Arr_f_num[j] = list.result[j].f_num
                    Arr_f_name[j] = list.result[j].f_name
                    Arr_f_calorie[j] = list.result[j].calorie
                    Arr_f_car[j] = list.result[j].car
                    Arr_f_pro[j] = list.result[j].pro
                    Arr_f_fat[j] = list.result[j].fat
                }
            }
        })
    }
    //////////// requset parameter 제거하기 ////////////////////


}
//first_menu.text ="\t${list.result[i].f_name}\ncalorie : ${list.result[i].calorie}\ncar : ${list.result[i].car}\npro : ${list.result[i].pro}\nfat : ${list.result[i].fat}"
//second_menu.text = "\t${list.result[i+1].f_name}\ncalorie : ${list.result[i+1].calorie}\ncar : ${list.result[i+1].car}\npro : ${list.result[i+1].pro}\nfat : ${list.result[i+1].fat}"

data class JsonObj(val result : List<Menu>)
data class Menu (val f_num:Int, val f_name:String, val calorie:Double, val car:Double, val pro:Double, val fat:Double, val win_count:Int )