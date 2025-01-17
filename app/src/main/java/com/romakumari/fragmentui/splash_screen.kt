package com.romakumari.fragmentui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.romakumari.fragmentui.databinding.ActivitySplashScreenBinding


class splash_screen : AppCompatActivity() {
    lateinit var splash_ScreenBinding:ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        splash_ScreenBinding= ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(splash_ScreenBinding.root)
        Handler(Looper.getMainLooper()).postDelayed({
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            this.finish()
        },1000)
    }
}