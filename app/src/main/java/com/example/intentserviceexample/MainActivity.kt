package com.example.intentserviceexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btnstop= findViewById<Button>(R.id.btn_stop_service)
        var btnstart= findViewById<Button>(R.id.btn_start_service)
        var tv_show= findViewById<TextView>(R.id.tv_serviceInfo)

        btnstart.setOnClickListener {
            Intent(this,MyIntentService::class.java).also {
                startService(it)
                tv_show.text = "Service is Running..."
            }

            btnstop.setOnClickListener {
                MyIntentService.stopService()
                tv_show.text = "Service is stopping..."
            }
        }
    }
}