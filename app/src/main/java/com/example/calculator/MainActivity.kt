package com.example.calculator

import android.os.Bundle
import android.os.SystemClock
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculator.databinding.ActivityMainBinding
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var time : Long = 0
        binding.btnstart.setOnClickListener {
            binding.chr.base = SystemClock.elapsedRealtime() + time
            binding.chr.start()
            binding.btnstart.visibility = View.GONE
            binding.btnpause.visibility = View.VISIBLE
            binding.start.setImageDrawable(getDrawable(R.drawable.pause))
        }
        binding.btnpause.setOnClickListener {
            time = binding.chr.base-SystemClock.elapsedRealtime()
            binding.chr.stop()
            binding.btnstart.visibility = View.VISIBLE
            binding.btnpause.visibility = View.GONE
            binding.start.setImageDrawable(getDrawable(R.drawable.start))
        }
        binding.btnrst.setOnClickListener {
            binding.chr.base = SystemClock.elapsedRealtime()
            time = 0
            binding.chr.stop()
            binding.btnstart.visibility = View.VISIBLE
            binding.btnpause.visibility = View.GONE
            binding.start.setImageDrawable(getDrawable(R.drawable.start))
        }/**/




    }
}