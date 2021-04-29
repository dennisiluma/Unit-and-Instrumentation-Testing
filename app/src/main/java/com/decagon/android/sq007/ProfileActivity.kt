package com.decagon.android.sq007

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class ProfileActivity : AppCompatActivity() {
    //a companion object that holds registration data coming from main activity starts here
    companion object {
        val NAME = "NAME"
        val EMAIL = "EMAIL"
        val PHONE_NUMBER = "NUMBER"
        val SEX = "SEX"
    }
    //a companion object that holds registration data coming from main activity ends here

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        //get data values coming from main activity which already is stored in companion object starts here
        val name = intent.getStringExtra(NAME)
        val email = intent.getStringExtra(EMAIL)
        val phoneNumber = intent.getStringExtra(PHONE_NUMBER)
        val gender = intent.getStringExtra(SEX)
        //get data values coming from main activity which already is stored in companion object ends here

        // pass the data into the text attrivute on the activity_profile xml file starts here
        findViewById<TextView>(R.id.tv_name).text = "Your Names Is: $name"
        findViewById<TextView>(R.id.tv_email).text = "Your Email is: $email"
        findViewById<TextView>(R.id.tv_number).text = "Your Phone Number is: $phoneNumber"
        findViewById<TextView>(R.id.tv_gender).text = "Your Gender is: $gender"
        // pass the data into the text attrivute on the activity_profile xml file starts here ends here


        //return to main activity when the goButton is clicked
        findViewById<Button>(R.id.btv_goBack).setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}