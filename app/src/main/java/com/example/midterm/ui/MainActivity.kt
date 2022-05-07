package com.example.midterm.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.midterm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            profileIcon.setOnClickListener {
                val userName = binding.nameEditTxt.text.toString()
                startSecondActivity(userName)
            }
            logIn.setOnClickListener {
                val userName = binding.nameEditTxt.text.toString()
                startSecondActivity(userName)
            }
        }
    }

    private fun startSecondActivity(userName: String) {
        val intent = Intent(this, SecondActivity::class.java).apply {
            putExtra("user_name", userName)
        }
        startActivity(intent)
    }
}