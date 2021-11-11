package com.mhl.myapplication.ui.minus.exercise

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.mhl.myapplication.MainActivity
import com.mhl.myapplication.PlayActivity
import com.mhl.myapplication.R
import com.mhl.myapplication.safe_load.Doc

class FirstMinusFragment : Activity() {
    private lateinit var firstButton : Button
    private lateinit var secondButton : Button
    private lateinit var preferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_first_minus)
        firstButton = findViewById(R.id.first_answer_minus_1)
        secondButton = findViewById(R.id.second_answer_minus_1)
        preferences = getSharedPreferences("TABLE", Context.MODE_PRIVATE)
        firstButton.setOnClickListener {
            Toast.makeText(this, "Неправильно, попробуйте ещё раз", Toast.LENGTH_LONG).show()
        }
        secondButton.setOnClickListener {
            Toast.makeText(this, "Правильно", Toast.LENGTH_LONG).show()
            Doc().saveData(preferences.getInt("count", 0) + 1, preferences)
            var intent = Intent(this, PlayActivity::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            finish()
        }
    }

}