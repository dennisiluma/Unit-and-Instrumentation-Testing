package com.decagon.android.sq007

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import com.decagon.android.sq007.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Spinner view and adaptor controller starts here
        val spinnerView = findViewById<Spinner>(R.id.spv_gender_field)
        val customList = listOf<String>("Male", "Female")
        val adapter =
            ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, customList)
        spinnerView.adapter = adapter
        //Spinner view and adaptor controller ends here


        //section that handles phone validation before submission starts here
        binding.etvPhoneNumberField.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                //null
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                //null
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (RegistrationUtility.phoneNumberValidator(binding.etvPhoneNumberField.text.toString())) {
                    binding.btvSubmit.isEnabled = true
                } else {
//                    binding.btvSubmit.isEnabled = false
                    binding.etvPhoneNumberField.error = "Invalid Mobile"
                }
            }
        })
        //section that handles phone validatiom before sumbmission ends here


        //section that handles email validation before submission starts here
        binding.etvEmailField.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                //null
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                //null
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (RegistrationUtility.emailvalidator(binding.etvEmailField.text.toString())) {
                    binding.btvSubmit.isEnabled = false
                } else {
                    binding.btvSubmit.isEnabled = false
                    binding.etvEmailField.error = "Invalid Email"
                }
            }
        })
        //section that handles email validatiom before sumbmission ends here


        // val btv_submition
        binding.btvSubmit.setOnClickListener {
            val name = findViewById<EditText>(R.id.etv_name_field).text.toString()
            val email = findViewById<EditText>(R.id.etv_email_field).text.toString()
            val number = findViewById<EditText>(R.id.etv_phone_number_field).text.toString()
            val gender = findViewById<Spinner>(R.id.spv_gender_field).selectedItem.toString().trim()

            //use the registration objectclass to validate input by passing the values to her parameter
            val regInputCheck =
                RegistrationUtility.validateRegistrationInput(name, email, number, gender)
            //pass and put the values to Profile activity
            if (regInputCheck) {
                val intent = Intent(this, ProfileActivity::class.java)
                intent.putExtra(ProfileActivity.NAME, name)
                intent.putExtra(ProfileActivity.EMAIL, email)
                intent.putExtra(ProfileActivity.PHONE_NUMBER, number)
                intent.putExtra(ProfileActivity.SEX, gender)
                startActivity(intent)
                Toast.makeText(this, "Welcome $name", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Check and properly fill your fields", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
}
