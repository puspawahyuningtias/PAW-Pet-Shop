package com.puspawahyuningtias.paw

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SplashScreen : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        val timerThread: Thread = object : Thread() {
            override fun run() {
                try {
                    sleep(3000)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                } finally {
                    val intent = Intent(this@SplashScreen, MainActivity::class.java)
                    startActivity(intent)
                }
            }
        }
        timerThread.start()
    }
    override fun onPause() { // TODO Auto-generated method stub
        super.onPause()
        finish()
    }
}