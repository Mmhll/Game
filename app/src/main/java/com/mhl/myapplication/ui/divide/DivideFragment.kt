package com.mhl.myapplication.ui.divide

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import com.mhl.myapplication.MainActivity
import com.mhl.myapplication.R
import com.mhl.myapplication.safe_load.Doc
import com.mhl.myapplication.ui.divide.exercise.FirstDivideFragment
import com.mhl.myapplication.ui.divide.exercise.SecondDivideFragment

class DivideFragment : Fragment() {
    private lateinit var first : Button
    private lateinit var second : Button
    private lateinit var score : TextView
    var count : Int = 0
    var pref : SharedPreferences? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var root = inflater.inflate(R.layout.fragment_divide, container, false)
        first = root.findViewById(R.id.divide_first)
        second = root.findViewById(R.id.divide_second)
        score = root.findViewById(R.id.score_divide)
        pref = this.activity?.getSharedPreferences("TABLE", Context.MODE_PRIVATE)
        score.text = (pref?.getInt("count", 0)!!).toString()
        first.setOnClickListener {
            val intent = Intent(context, FirstDivideFragment::class.java)
            startActivity(intent)
        }
        second.setOnClickListener {
            val intent = Intent(context, SecondDivideFragment::class.java)
            startActivity(intent)
        }
        return root
    }
}