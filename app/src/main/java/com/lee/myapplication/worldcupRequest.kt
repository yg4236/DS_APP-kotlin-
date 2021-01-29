package com.lee.myapplication

import com.android.volley.AuthFailureError
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import java.util.*

class worldcupRequest(f_num1 : String,f_num2:String, listener: Response.Listener<String>) : StringRequest(Method.POST, URL, listener, null) {
    private val map: MutableMap<String, String>

    @Throws(AuthFailureError::class)
    override fun getParams(): Map<String, String> {
        return map
    }
    companion object {
        //서버 URL 설정
        private const val URL = "http://yg4236.dothome.co.kr/worldcup.php"
    }

    init {
        map = HashMap()
        map["f_num1"] = f_num1
        map["f_num2"] = f_num2
    }
}