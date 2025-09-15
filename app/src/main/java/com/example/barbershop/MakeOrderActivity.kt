package com.example.barbershop

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MakeOrderActivity : AppCompatActivity() {

    companion object {
        private const val EXTRA_USER_NAME = "userName"

        fun newIntent(context: Context, userName: String): Intent {
            return Intent(context, MakeOrderActivity::class.java).apply {
                putExtra(EXTRA_USER_NAME, userName)
            }
        }
    }

    private lateinit var textViewGreetings: TextView
    private lateinit var textViewAdditives: TextView

    private lateinit var radioGroupServices: RadioGroup
    private lateinit var radioButtonServiceOne: RadioButton
    private lateinit var radioButtonServiceTwo: RadioButton

    private lateinit var checkBoxAdditive1: CheckBox
    private lateinit var checkBoxAdditive2: CheckBox
    private lateinit var checkBoxAdditive3: CheckBox

    private lateinit var spinnerServiceOne: Spinner
    private lateinit var spinnerServiceTwo: Spinner

    private lateinit var buttonMakeOrder: Button

    private lateinit var service: String
    private lateinit var userName: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_make_order)
        initViews()
        setupUserName()

        radioGroupServices.setOnCheckedChangeListener(object : RadioGroup.OnCheckedChangeListener {
            override fun onCheckedChanged(group: RadioGroup, checkedId: Int) {
                if (checkedId == radioButtonServiceOne.id) {
                    onUserChoseServiceOne()
                } else if (checkedId == radioButtonServiceTwo.id) {
                    onUserChoseServiceTwo()
                }
            }
        })
        radioButtonServiceOne.isChecked = true

        buttonMakeOrder.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                onUserMadeOrder()
            }
        })
    }

    private fun onUserMadeOrder() {
        val additives = arrayListOf<String>()
        if (checkBoxAdditive1.isChecked) {
            additives.add(checkBoxAdditive1.text.toString())
        }
        if (radioButtonServiceTwo.isChecked && checkBoxAdditive2.isChecked) {
            additives.add(checkBoxAdditive2.text.toString())
        }
        if (checkBoxAdditive3.isChecked) {
            additives.add(checkBoxAdditive3.text.toString())
        }

        var serviceType: String = ""
        if (radioButtonServiceOne.isChecked) {
            serviceType = spinnerServiceOne.selectedItem.toString()
        } else if(radioButtonServiceTwo.isChecked) {
            serviceType = spinnerServiceTwo.selectedItem.toString()
        }

        val intent = OrderDetailActivity().newIntent(
            this,
            userName,
            service,
            additives.toString(),
            serviceType
        )
        startActivity(intent)
    }

    private fun onUserChoseServiceOne() {
        service = getString(R.string.service_1)
        val additives = getString(R.string.additives, service)
        textViewAdditives.text = additives
        checkBoxAdditive2.visibility = View.INVISIBLE
        spinnerServiceOne.visibility = View.VISIBLE
        spinnerServiceTwo.visibility = View.INVISIBLE
    }

    private fun onUserChoseServiceTwo() {
        service = getString(R.string.service_2)
        val additives = getString(R.string.additives, service)
        textViewAdditives.text = additives
        checkBoxAdditive2.visibility = View.VISIBLE
        spinnerServiceTwo.visibility = View.VISIBLE
        spinnerServiceOne.visibility = View.INVISIBLE
    }

    private fun setupUserName() {
        userName = intent.getStringExtra(EXTRA_USER_NAME).toString()
        val greetings = getString(R.string.greetings, userName)
        textViewGreetings.text = greetings
    }

    private fun initViews() {
        textViewGreetings = findViewById(R.id.textViewGreetings)
        textViewAdditives = findViewById(R.id.textViewAdditives)
        radioGroupServices = findViewById(R.id.radioGroupServices)
        radioButtonServiceOne = findViewById(R.id.radioButtonServiceOne)
        radioButtonServiceTwo = findViewById(R.id.radioButtonServiceTwo)
        checkBoxAdditive1 = findViewById(R.id.checkBoxAdditive1)
        checkBoxAdditive2 = findViewById(R.id.checkBoxAdditive2)
        checkBoxAdditive3 = findViewById(R.id.checkBoxAdditive3)
        spinnerServiceOne = findViewById(R.id.spinnerServiceOne)
        spinnerServiceTwo = findViewById(R.id.spinnerServiceTwo)
        buttonMakeOrder = findViewById(R.id.buttonMakeOrder)
    }
}