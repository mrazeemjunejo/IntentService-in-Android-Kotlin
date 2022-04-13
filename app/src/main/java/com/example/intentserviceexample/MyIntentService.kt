package com.example.intentserviceexample

import android.annotation.SuppressLint
import android.app.IntentService
import android.content.Intent
import android.util.Log
import kotlin.math.log

class MyIntentService : IntentService ("MyIntentService") {

    init {
        instance = this
    }

    companion object {

       @SuppressLint("StaticFieldLeak")
       private lateinit var instance: IntentService
        var isRuning: Boolean = false
       fun stopService(){
           Log.d("MyIntentService","Service is stopping...")
           isRuning = false
           instance.stopSelf()
       }
    }
    override fun onHandleIntent(p0: Intent?) {
        try {
            isRuning = true
            while (isRuning){
                Log.d("MyIntentService","Service is running")
                Thread.sleep(1000)
            }
        }catch (e:InterruptedException){
            Thread.currentThread().interrupt()
        }
    }
}