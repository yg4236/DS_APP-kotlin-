package com.lee.myapplication

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.HandlerCompat.postDelayed
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

<<<<<<< HEAD
var eight_Arr_f_num= arrayOfNulls<Int>(8)
var eight_Arr_f_name= arrayOfNulls<String>(8)
var eight_Arr_f_calorie = arrayOfNulls<Double>(8)
var eight_Arr_f_car = arrayOfNulls<Double>(8)
var eight_Arr_f_pro = arrayOfNulls<Double>(8)
var eight_Arr_f_fat = arrayOfNulls<Double>(8)

var four_Arr_f_num= arrayOfNulls<Int>(4)
var four_Arr_f_name= arrayOfNulls<String>(4)
var four_Arr_f_calorie = arrayOfNulls<Double>(4)
var four_Arr_f_car = arrayOfNulls<Double>(4)
var four_Arr_f_pro = arrayOfNulls<Double>(4)
var four_Arr_f_fat = arrayOfNulls<Double>(4)

var final_Arr_f_num= arrayOfNulls<Int>(2)
var final_Arr_f_name= arrayOfNulls<String>(2)
var final_Arr_f_calorie = arrayOfNulls<Double>(2)
var final_Arr_f_car = arrayOfNulls<Double>(2)
var final_Arr_f_pro = arrayOfNulls<Double>(2)
var final_Arr_f_fat = arrayOfNulls<Double>(2)

=======
>>>>>>> 69f32db89ce5d82776afa255455ff4aedbe9cf7b

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
        var click :Boolean
        fetchJson()
//        for(k in 0..14 step 2) {

        click = true
        Handler().postDelayed({
            first_menu.text = "\t${Arr_f_name[0]}\ncalorie : ${Arr_f_calorie[0]}\ncar : ${Arr_f_car[0]}\npro : ${Arr_f_pro[0]}\nfat : ${Arr_f_fat[0]}"
        },1300)
        Handler().postDelayed({
            second_menu.text = "\t${Arr_f_name[1]}\ncalorie : ${Arr_f_calorie[1]}\ncar : ${Arr_f_car[1]}\npro : ${Arr_f_pro[1]}\nfat : ${Arr_f_fat[1]}"
        },1300)
        var round=2
        var eightIndex=0
        var fourIndex=0
        var finalIndex=0
    first_menu.setOnClickListener {
        if(round>=2 && round<=16) {///16강
            eight_Arr_f_num[eightIndex] = Arr_f_num[round - 2]
            eight_Arr_f_name[eightIndex] = Arr_f_name[round - 2]
            eight_Arr_f_calorie[eightIndex] = Arr_f_calorie[round - 2]
            eight_Arr_f_car[eightIndex] = Arr_f_car[round - 2]
            eight_Arr_f_pro[eightIndex] = Arr_f_pro[round - 2]
            eight_Arr_f_fat[eightIndex] = Arr_f_fat[round - 2]
            eightIndex++
            if(round!=16) {
                first_menu.text = "\t${Arr_f_name[round]}\ncalorie : ${Arr_f_calorie[round]}\ncar : ${Arr_f_car[round]}\npro : ${Arr_f_pro[round]}\nfat : ${Arr_f_fat[round]}"
                second_menu.text = "\t${Arr_f_name[round + 1]}\ncalorie : ${Arr_f_calorie[round + 1]}\ncar : ${Arr_f_car[round + 1]}\npro : ${Arr_f_pro[round + 1]}\nfat : ${Arr_f_fat[round + 1]}"
                round += 2
            }else {
                first_menu.text = "\t${eight_Arr_f_name[0]}\ncalorie : ${eight_Arr_f_calorie[0]}\ncar : ${eight_Arr_f_car[0]}\npro : ${eight_Arr_f_pro[0]}\nfat : ${eight_Arr_f_fat[0]}"
                second_menu.text = "\t${eight_Arr_f_name[1]}\ncalorie : ${eight_Arr_f_calorie[1]}\ncar : ${eight_Arr_f_car[1]}\npro : ${eight_Arr_f_pro[1]}\nfat : ${eight_Arr_f_fat[1]}"
                round+=2
                Round.text = "8강"
            }
        }
        else if(round>=18&&round<=24){//8강

            four_Arr_f_num[fourIndex] = eight_Arr_f_num[round-18]
            four_Arr_f_name[fourIndex] = eight_Arr_f_name[round-18]
            four_Arr_f_calorie[fourIndex] = eight_Arr_f_calorie[round-18]
            four_Arr_f_car[fourIndex] = eight_Arr_f_car[round-18]
            four_Arr_f_pro[fourIndex] = eight_Arr_f_pro[round-18]
            four_Arr_f_fat[fourIndex] = eight_Arr_f_fat[round-18]
            fourIndex++
            if(round!=24){
                first_menu.text = "\t${eight_Arr_f_name[round -16]}\ncalorie : ${eight_Arr_f_calorie[round -16]}\ncar : ${eight_Arr_f_car[round -16]}\npro : ${eight_Arr_f_pro[round -16]}\nfat : ${eight_Arr_f_fat[round -16]}"
                second_menu.text = "\t${eight_Arr_f_name[round -15]}\ncalorie : ${eight_Arr_f_calorie[round -15]}\ncar : ${eight_Arr_f_car[round -15]}\npro : ${eight_Arr_f_pro[round -15]}\nfat : ${eight_Arr_f_fat[round -15]}"
                round+=2
            }else{
                first_menu.text = "\t${four_Arr_f_name[0]}\ncalorie : ${four_Arr_f_calorie[0]}\ncar : ${four_Arr_f_car[0]}\npro : ${four_Arr_f_pro[0]}\nfat : ${four_Arr_f_fat[0]}"
                second_menu.text = "\t${four_Arr_f_name[1]}\ncalorie : ${four_Arr_f_calorie[1]}\ncar : ${four_Arr_f_car[1]}\npro : ${four_Arr_f_pro[1]}\nfat : ${four_Arr_f_fat[1]}"
                round+=2
                Round.text = "4강"
            }
        }
        else if(round>=26&&round<=28) {//4강

            final_Arr_f_num[finalIndex] = four_Arr_f_num[round-26]
            final_Arr_f_name[finalIndex] = four_Arr_f_name[round-26]
            final_Arr_f_calorie[finalIndex] = four_Arr_f_calorie[round-26]
            final_Arr_f_car[finalIndex] = four_Arr_f_car[round-26]
            final_Arr_f_pro[finalIndex] = four_Arr_f_pro[round-26]
            final_Arr_f_fat[finalIndex] = four_Arr_f_fat[round-26]
            finalIndex++
            if(round!=28){
                first_menu.text = "\t${four_Arr_f_name[round - 24]}\ncalorie : ${four_Arr_f_calorie[round - 24]}\ncar : ${eight_Arr_f_car[round - 24]}\npro : ${eight_Arr_f_pro[round - 24]}\nfat : ${eight_Arr_f_fat[round - 24]}"
                second_menu.text = "\t${four_Arr_f_name[round - 23]}\ncalorie : ${four_Arr_f_calorie[round - 23]}\ncar : ${eight_Arr_f_car[round - 23]}\npro : ${eight_Arr_f_pro[round - 23]}\nfat : ${eight_Arr_f_fat[round - 23]}"
                round+=2
            }else{
                first_menu.text = "\t${final_Arr_f_name[0]}\ncalorie : ${final_Arr_f_calorie[0]}\ncar : ${final_Arr_f_car[0]}\npro : ${final_Arr_f_pro[0]}\nfat : ${final_Arr_f_fat[0]}"
                second_menu.text = "\t${final_Arr_f_name[1]}\ncalorie : ${final_Arr_f_calorie[1]}\ncar : ${final_Arr_f_car[1]}\npro : ${final_Arr_f_pro[1]}\nfat : ${final_Arr_f_fat[1]}"
                round+=2
                Round.text = "결승"
            }
        }
        else{//결승

<<<<<<< HEAD
            first_menu.text ="\t${final_Arr_f_name[0]}우승!"
        }
    }
    second_menu.setOnClickListener {
        if(round>=2 && round<=16) {///16강
            eight_Arr_f_num[eightIndex] = Arr_f_num[round - 1]
            eight_Arr_f_name[eightIndex] = Arr_f_name[round - 1]
            eight_Arr_f_calorie[eightIndex] = Arr_f_calorie[round - 1]
            eight_Arr_f_car[eightIndex] = Arr_f_car[round - 1]
            eight_Arr_f_pro[eightIndex] = Arr_f_pro[round - 1]
            eight_Arr_f_fat[eightIndex] = Arr_f_fat[round - 1]
            eightIndex++
            if(round!=16) {
                first_menu.text = "\t${Arr_f_name[round]}\ncalorie : ${Arr_f_calorie[round]}\ncar : ${Arr_f_car[round]}\npro : ${Arr_f_pro[round]}\nfat : ${Arr_f_fat[round]}"
                second_menu.text = "\t${Arr_f_name[round + 1]}\ncalorie : ${Arr_f_calorie[round + 1]}\ncar : ${Arr_f_car[round + 1]}\npro : ${Arr_f_pro[round + 1]}\nfat : ${Arr_f_fat[round + 1]}"
                round += 2
            }else {
                first_menu.text = "\t${eight_Arr_f_name[0]}\ncalorie : ${eight_Arr_f_calorie[0]}\ncar : ${eight_Arr_f_car[0]}\npro : ${eight_Arr_f_pro[0]}\nfat : ${eight_Arr_f_fat[0]}"
                second_menu.text = "\t${eight_Arr_f_name[1]}\ncalorie : ${eight_Arr_f_calorie[1]}\ncar : ${eight_Arr_f_car[1]}\npro : ${eight_Arr_f_pro[1]}\nfat : ${eight_Arr_f_fat[1]}"
                round+=2
                Round.text = "8강"
            }
        }
        else if(round>=18&&round<=24){//8강

            four_Arr_f_num[fourIndex] = eight_Arr_f_num[round-17]
            four_Arr_f_name[fourIndex] = eight_Arr_f_name[round-17]
            four_Arr_f_calorie[fourIndex] = eight_Arr_f_calorie[round-17]
            four_Arr_f_car[fourIndex] = eight_Arr_f_car[round-17]
            four_Arr_f_pro[fourIndex] = eight_Arr_f_pro[round-17]
            four_Arr_f_fat[fourIndex] = eight_Arr_f_fat[round-17]
            fourIndex++
            if(round!=24){
                first_menu.text = "\t${eight_Arr_f_name[round -16]}\ncalorie : ${eight_Arr_f_calorie[round -16]}\ncar : ${eight_Arr_f_car[round -16]}\npro : ${eight_Arr_f_pro[round -16]}\nfat : ${eight_Arr_f_fat[round -16]}"
                second_menu.text = "\t${eight_Arr_f_name[round -15]}\ncalorie : ${eight_Arr_f_calorie[round -15]}\ncar : ${eight_Arr_f_car[round -15]}\npro : ${eight_Arr_f_pro[round -15]}\nfat : ${eight_Arr_f_fat[round -15]}"
                round+=2
            }else{
                first_menu.text = "\t${four_Arr_f_name[0]}\ncalorie : ${four_Arr_f_calorie[0]}\ncar : ${four_Arr_f_car[0]}\npro : ${four_Arr_f_pro[0]}\nfat : ${four_Arr_f_fat[0]}"
                second_menu.text = "\t${four_Arr_f_name[1]}\ncalorie : ${four_Arr_f_calorie[1]}\ncar : ${four_Arr_f_car[1]}\npro : ${four_Arr_f_pro[1]}\nfat : ${four_Arr_f_fat[1]}"
                round+=2
                Round.text = "4강"
            }
        }
        else if(round>=26&&round<=28) {//4강

            final_Arr_f_num[finalIndex] = four_Arr_f_num[round-25]
            final_Arr_f_name[finalIndex] = four_Arr_f_name[round-25]
            final_Arr_f_calorie[finalIndex] = four_Arr_f_calorie[round-25]
            final_Arr_f_car[finalIndex] = four_Arr_f_car[round-25]
            final_Arr_f_pro[finalIndex] = four_Arr_f_pro[round-25]
            final_Arr_f_fat[finalIndex] = four_Arr_f_fat[round-25]
            finalIndex++
            if(round!=28){
                first_menu.text = "\t${four_Arr_f_name[round - 24]}\ncalorie : ${four_Arr_f_calorie[round - 24]}\ncar : ${eight_Arr_f_car[round - 24]}\npro : ${eight_Arr_f_pro[round - 24]}\nfat : ${eight_Arr_f_fat[round - 24]}"
                second_menu.text = "\t${four_Arr_f_name[round - 23]}\ncalorie : ${four_Arr_f_calorie[round - 23]}\ncar : ${eight_Arr_f_car[round - 23]}\npro : ${eight_Arr_f_pro[round - 23]}\nfat : ${eight_Arr_f_fat[round - 23]}"
                round+=2
            }else{
                first_menu.text = "\t${final_Arr_f_name[0]}\ncalorie : ${final_Arr_f_calorie[0]}\ncar : ${final_Arr_f_car[0]}\npro : ${final_Arr_f_pro[0]}\nfat : ${final_Arr_f_fat[0]}"
                second_menu.text = "\t${final_Arr_f_name[1]}\ncalorie : ${final_Arr_f_calorie[1]}\ncar : ${final_Arr_f_car[1]}\npro : ${final_Arr_f_pro[1]}\nfat : ${final_Arr_f_fat[1]}"
                round+=2
                Round.text = "결승"
            }
        }
        else{//결승
=======
        fetchJson()
        first_menu.text="\t${Arr_f_name[0]}\ncalorie : ${Arr_f_calorie[0]}\ncar : ${Arr_f_car[0]}\npro : ${Arr_f_pro[0]}\nfat : ${Arr_f_fat[0]}"
        second_menu.text="\t${Arr_f_name[1]}\ncalorie : ${Arr_f_calorie[1]}\ncar : ${Arr_f_car[1]}\npro : ${Arr_f_pro[1]}\nfat : ${Arr_f_fat[1]}"
        first_menu.setOnClickListener {
            first_menu.text="\t${Arr_f_name[2]}\ncalorie : ${Arr_f_calorie[2]}\ncar : ${Arr_f_car[2]}\npro : ${Arr_f_pro[2]}\nfat : ${Arr_f_fat[2]}"
        }
        second_menu.setOnClickListener {
            second_menu.text="\t${Arr_f_name[3]}\ncalorie : ${Arr_f_calorie[3]}\ncar : ${Arr_f_car[3]}\npro : ${Arr_f_pro[3]}\nfat : ${Arr_f_fat[3]}"
        }

>>>>>>> 69f32db89ce5d82776afa255455ff4aedbe9cf7b

            first_menu.text ="\t${final_Arr_f_name[1]}우승!"
        }
    }
<<<<<<< HEAD

    }
=======
>>>>>>> 69f32db89ce5d82776afa255455ff4aedbe9cf7b
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