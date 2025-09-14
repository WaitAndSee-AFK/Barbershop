package com.example.barbershop

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MakeOrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_make_order)
    }

    fun newIntent(context: Context, userName: String): Intent {
        val intent = Intent(context, MakeOrderActivity::class.java)
        intent.putExtra("userName", userName)
        return intent
    }
}