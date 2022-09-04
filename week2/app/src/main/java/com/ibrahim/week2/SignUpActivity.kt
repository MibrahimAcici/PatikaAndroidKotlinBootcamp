package com.ibrahim.week2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.ibrahim.week2.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = Intent(this@SignUpActivity,LoginActivity::class.java)
        binding.signUpBtnSignup.setOnClickListener {
            if(binding.signUpEtMail.text.toString().isEmpty() || binding.signUpEtUsername.text.toString().isEmpty() || binding.signUpEtPassword.text.toString().isEmpty()){
                Toast.makeText(applicationContext,"Lütfen boş bırakmayınız..", Toast.LENGTH_SHORT).show()
            }else{
                startActivity(intent)
            }
        }
        binding.signUpFab.setOnClickListener {
            startActivity(intent)
        }
    }
}