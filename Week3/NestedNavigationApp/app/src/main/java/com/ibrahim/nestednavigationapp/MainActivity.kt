package com.ibrahim.nestednavigationapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ibrahim.nestednavigationapp.databinding.ActivityMainBinding

class MainActivity :AppCompatActivity() {
    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //binding ile layout eşleştirme
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)
    }
}