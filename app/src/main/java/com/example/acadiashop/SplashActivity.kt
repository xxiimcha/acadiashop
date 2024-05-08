package com.example.acadiashop

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity


class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Delay for SPLASH_DELAY milliseconds and then start MainActivity
        Handler().postDelayed({
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            finish() // Finish the splash activity
        }, SPLASH_DELAY.toLong())
    }

    companion object {
        private const val SPLASH_DELAY = 2000 // 2 seconds
    }
}

