package com.example.midterm.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.midterm.R
import com.example.midterm.databinding.ActivitySecondBinding

typealias Strings = R.string

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val message = intent.getStringExtra("user_name")

        if (message != null) {
            if (message.isNotEmpty()){
                binding.nameId.text = "${getString(Strings.hello)} ${message}"
            }else{
                binding.nameId.text = getString(Strings.empty)
            }
        }

        with(binding){
            backArrowId.setOnClickListener {
                backPress()
            }
        }
    }

    private fun backPress(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

}