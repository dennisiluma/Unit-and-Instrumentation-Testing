package com.decagon.android.sq007

//import org.junit.Assert.*
import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class RegistrationUtilityTest{
    @Test
    fun name_field_is_empty_ReturnsFalse(){
        val result = RegistrationUtility.validateRegistrationInput(
            "",
            "dennis",
            "123345678965",
            "male"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun number_inpute_lesser_than_11_ReturnsFalse(){
        val result = RegistrationUtility.validateRegistrationInput(
            "dennis",
            "dennis",
            "1234",
            "male"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun correctly_filled_input_ReturnsTrue(){
        val result = RegistrationUtility.validateRegistrationInput(
            "dennis",
            "dennis",
            "12345678987",
            "Female"
        )
        assertThat(result).isTrue()
    }
}