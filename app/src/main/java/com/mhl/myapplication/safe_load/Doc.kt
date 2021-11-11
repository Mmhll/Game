package com.mhl.myapplication.safe_load

import android.content.SharedPreferences

class Doc {
    fun saveData(count : Int, pref : SharedPreferences){
        val editor = pref?.edit()
        editor?.putInt("count", count)
        editor?.apply()
    }
}