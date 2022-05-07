package com.example.midterm.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.midterm.R
import com.example.midterm.databinding.ActivitySecondBinding

typealias Strings = R.string
const val PREF_NAME="User_data"

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val message = intent.getStringExtra("user_name")

        val sharedPref = this.getPreferences(Context.MODE_PRIVATE) ?: return
        with (sharedPref.edit()) {
            putString(PREF_NAME, message)
            apply()
        }

        val savedUserName = sharedPref.getString(PREF_NAME, getString(Strings.empty))
        binding.nameId.text = "${getString(Strings.hello)} ${savedUserName}"

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