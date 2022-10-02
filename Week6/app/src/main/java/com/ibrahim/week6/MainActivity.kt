package com.ibrahim.week6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.*

class MainActivity :AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // sayaç ekleme
        var counter = 0

        // Sonsuz döngüye CoroutineScope eklendi
        while(true) {
            CoroutineScope(Dispatchers.IO).launch {
                val answer = doNetworkCall()
                withContext(Dispatchers.Main) {
                    Log.v("PATIKA", answer)
                }
            }
            // Sayacı her döngüye girdiğinde arttırıyoruz
            counter += 1
            // Her seferinde ekrana bastırıyoruz
            println(counter)
        }
    }
        // 2 Saniye bekleten fonksiyon
    suspend fun doNetworkCall(): String {
        delay(2000L)
        return "NetworkCallAnswer"
    }
}