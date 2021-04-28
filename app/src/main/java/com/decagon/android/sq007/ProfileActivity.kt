package com.decagon.android.sq007

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class ProfileActivity : AppCompatActivity() {
    companion object{
        val NAME = "NAME"
        val EMAIL = "EMAIL"
        val PHONE_NUMBER = "NUMBER"
        val SEX = "SEX"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val name = intent.getStringExtra(NAME)
        val email = intent.getStringExtra(EMAIL)
        val phoneNumber = intent.getStringExtra(PHONE_NUMBER)
        val gender = intent.getStringExtra(SEX)

        findViewById<TextView>(R.id.tv_name).text = "Your Names Is $name"
        findViewById<TextView>(R.id.tv_email).text = "Your Email is: $email"
        findViewById<TextView>(R.id.tv_number).text = "Your Phone Number is: $phoneNumber"
        findViewById<TextView>(R.id.tv_gender).text = "Your Gender is: $gender"
    }
}