package com.example.barbershop

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var ediTextName: EditText
    private lateinit var ediTextPassword: EditText
    private lateinit var  buttonSignIn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

        buttonSignIn.setOnClickListener {
            val userName = ediTextName.text.toString().trim()
            val userPassword = ediTextPassword.text.toString().trim()
            if (userName.isNotEmpty() && userPassword.isNotEmpty()) {
                loadNextScreen(userName)
            } else {
                Toast.makeText(this, R.string.error_fields_empty, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun loadNextScreen(userName: String) {
        val intent = MakeOrderActivity().newIntent(this, userName)
        startActivity(intent)
    }

    private fun initViews() {
        ediTextName = findViewById(R.id.ediTextName)
        ediTextPassword = findViewById(R.id.ediTextPassword)
        buttonSignIn = findViewById(R.id.buttonSignIn)
    }
}