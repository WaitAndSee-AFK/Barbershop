package com.example.barbershop

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class OrderDetailActivity : AppCompatActivity() {
    companion object {
        private const val EXTRA_USER_NAME = "userName"
        private const val EXTRA_SERVICE = "service"
        private const val EXTRA_ADDITIVES = "additives"
        private const val EXTRA_SERVICE_TYPE = "serviceType"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_detail)
    }

    fun newIntent(context: Context, userName: String, service: String, additives: String, serviceType: String) : Intent {
        val intent = Intent(context, OrderDetailActivity::class.java)
        intent.putExtra(EXTRA_USER_NAME, userName)
        intent.putExtra(EXTRA_SERVICE, service)
        intent.putExtra(EXTRA_ADDITIVES, additives)
        intent.putExtra(EXTRA_SERVICE_TYPE, serviceType)
        return intent
    }
}