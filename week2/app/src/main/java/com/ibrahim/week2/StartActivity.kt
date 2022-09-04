package com.ibrahim.week2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ibrahim.week2.databinding.ActivityStartBinding

class StartActivity : AppCompatActivity() {
    private lateinit var binding : ActivityStartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = Intent(this@StartActivity, SignUpActivity::class.java)
        binding.startBtnJoin.setOnClickListener {
            startActivity(intent)
        }
    }
}