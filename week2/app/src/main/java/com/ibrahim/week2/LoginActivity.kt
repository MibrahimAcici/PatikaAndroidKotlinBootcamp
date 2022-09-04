package com.ibrahim.week2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.ibrahim.week2.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = Intent(this@LoginActivity,StartActivity::class.java)

        //Float Action Button ile StartActivity sayfasına geçiş
        binding.loginFab.setOnClickListener {
            startActivity(intent)
        }

        /*
        Login butonuna basıldığında username ve password kontrolü
        Sırasıyla username,password ; patika,bootcamp olarak girilmişse
         Toast mesaj ile Kullanıcı girişi başarılı değilse Kullanıcı bilgileri hatalı yazısı
        */
        binding.loginBtnLogin.setOnClickListener {
            if (binding.loginEtUsername.text.toString() == "patika" && binding.loginEtPassword.text.toString() == "bootcamp" ){
                Toast.makeText(applicationContext,"Kullanıcı girişi başarılı",Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(applicationContext,"Kullanıcı bilgileri hatalı",Toast.LENGTH_SHORT).show()
            }
        }
    }
}