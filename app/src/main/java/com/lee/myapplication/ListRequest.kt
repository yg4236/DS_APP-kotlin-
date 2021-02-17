package com.lee.myapplication

import com.android.volley.AuthFailureError
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import java.util.*

class ListRequest(f_Name: String, listener: Response.Listener<String>) : StringRequest(Method.POST, URL, listener, null) {


    companion object {
        //서버 URL 설정
        private const val URL = "http://yg4236.dothome.co.kr/List.php"
    }

    init {
        val f_Name = f_Name
    }
}