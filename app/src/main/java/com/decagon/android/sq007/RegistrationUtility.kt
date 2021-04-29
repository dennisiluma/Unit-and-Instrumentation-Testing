package com.decagon.android.sq007

import java.util.regex.Matcher
import java.util.regex.Pattern

object RegistrationUtility {

    //function for validating user input starts here
    fun validateRegistrationInput(
        name: String,
        email: String,
        number: String,
        gender: String
    ): Boolean {
        if (name.isNullOrBlank() || email.isNullOrBlank() || number.length < 11 || number.length > 15 || gender.isNullOrBlank()) {
            return false
        }
        return true
    }
    //function for validating user input ends here

    //regex method for phone number validation starts here
    fun phoneNumberValidator(text: String): Boolean {
        // regular expresion code to validate nigeria phone number
        var pattern: Pattern = Pattern.compile("^(0|234)([789][01])([0-9]){8}$")
        var matcher: Matcher = pattern.matcher(text)
        return matcher.matches()
    }
    //regex method for phone number validation ends here


    //    email validation functio using regex strats here
    fun emailvalidator(text: String): Boolean {
        var pattern: Pattern = Pattern.compile("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}\$")
        var matcher: Matcher = pattern.matcher(text)
        return matcher.matches()
    }
    //    email validation functio using regex ends here
}