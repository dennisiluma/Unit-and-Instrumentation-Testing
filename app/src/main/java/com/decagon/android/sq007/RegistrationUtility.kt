package com.decagon.android.sq007

import java.util.regex.Matcher
import java.util.regex.Pattern

object RegistrationUtility {
    /*
    *the impute isn't valid if,
    * any  of the fields are empty empty,
    * all fields are string except the number which must be a number input
    *
     */

    fun validateRegistrationInput(name:String, email:String, number: String, gender:String): Boolean {
        if (name.isNullOrBlank()||email.isNullOrBlank()||number.length < 11 || number.length > 15 || gender.isNullOrBlank()){
            return false
        }
        return true
    }

    //regex method for phone number validation starts here

    fun phoneNumberValidator(text: String): Boolean {
        // regular expresion code to validate nigeria phone number
        var pattern: Pattern = Pattern.compile("^(0|234)([789][01])([0-9]){8}$")te
        var matcher: Matcher = pattern.matcher(text)
        return matcher.matches()
    }
    //regex method for phone number validation ends here

}