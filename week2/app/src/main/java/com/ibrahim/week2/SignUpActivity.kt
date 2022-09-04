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

        /*
        Mail,username ve password girilmişse login sayfasına geçiş
        Herhangi biri girilmemişse Toast mesaj ile Lütfen boş bırakmayınız.. yazısı
        */
        binding.signUpBtnSignup.setOnClickListener {
            if(binding.signUpEtMail.text.toString().isEmpty() || binding.signUpEtUsername.text.toString().isEmpty() || binding.signUpEtPassword.text.toString().isEmpty()){
                Toast.makeText(applicationContext,"Lütfen boş bırakmayınız..", Toast.LENGTH_SHORT).show()
            }else{
                startActivity(intent)
            }
        }

        //Float Action Button ile LoginActivity sayfasına geçiş
        binding.signUpFab.setOnClickListener {
            startActivity(intent)
        }
    }
}