package com.mhl.myapplication.ui.plus

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.mhl.myapplication.MainActivity
import com.mhl.myapplication.R
import com.mhl.myapplication.ui.divide.exercise.FirstDivideFragment
import com.mhl.myapplication.ui.plus.exercise.FirstPlusFragment
import com.mhl.myapplication.ui.plus.exercise.SecondPlusFragment

class PlusFragment : Fragment() {
    private lateinit var first: Button
    private lateinit var second: Button
    private lateinit var score : TextView
    var pref : SharedPreferences? = null
    override fun onCreateView(
      inflater: LayoutInflater,
      container: ViewGroup?,
      savedInstanceState: Bundle?
    ): View? {
      var root = inflater.inflate(R.layout.fragment_plus, container, false)
      first = root.findViewById(R.id.plus_first)
      second = root.findViewById(R.id.plus_second)
      score = root.findViewById(R.id.score_plus)
      pref = this.activity?.getSharedPreferences("TABLE", Context.MODE_PRIVATE)
      score.text = (pref?.getInt("count", 0)!!).toString()
      first.setOnClickListener { view ->
        val intent = Intent(context, FirstPlusFragment::class.java)
        startActivity(intent)
      }
      second.setOnClickListener { view ->
        val intent = Intent(context, SecondPlusFragment::class.java)
        startActivity(intent)
      }
      return root
    }

}