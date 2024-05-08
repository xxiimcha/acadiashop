package com.example.acadiashop

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btnCreateAccount = findViewById<Button>(R.id.btn_create_account)
        btnCreateAccount.setOnClickListener {
            startActivity(Intent(this@LoginActivity, CreateAccountActivity::class.java))
        }
    }
}

