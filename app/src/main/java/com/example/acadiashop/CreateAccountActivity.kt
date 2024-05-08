package com.example.acadiashop

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CreateAccountActivity : AppCompatActivity() {

    companion object {
        private const val REQUEST_IMAGE_CAPTURE = 1
    }

    private lateinit var photoBitmap: Bitmap // Store the captured photo bitmap here

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)

        val btnTakePhoto = findViewById<Button>(R.id.btnTakePhoto)
        val btnCreateAccount = findViewById<Button>(R.id.btnCreateAccount)

        btnTakePhoto.setOnClickListener {
            dispatchTakePictureIntent()
        }

        btnCreateAccount.setOnClickListener {
            // Implement your account creation logic here
            // You can use the photoBitmap to save the profile picture
            Toast.makeText(this, "Account created successfully!", Toast.LENGTH_SHORT).show()
            finish() // Finish the activity after account creation
        }
    }

    private fun dispatchTakePictureIntent() {
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if (takePictureIntent.resolveActivity(packageManager) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK) {
            val imageBitmap = data?.extras?.get("data") as Bitmap
            photoBitmap = imageBitmap // Store the captured photo bitmap
            // You can display the captured photo somewhere in the UI if needed
        }
    }
}

