package com.decagon.android.sq007

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test

class ResourceComparerTest {
    private lateinit var resourceComparer: ResourceComparer

    @Before
    fun setUp() {
        //call and initialize the class here
        resourceComparer = ResourceComparer()
    }

    @Test
    fun appName_different_from_given_name_ReturnsFalse() {
        val contex = ApplicationProvider.getApplicationContext<Context>()
        val rsId = R.string.app_name
        val myAppName = "Dennis name"
        val result = resourceComparer.appNameCheck(contex, rsId, myAppName)
        assertThat(result).isFalse()
    }

    @Test
    fun appName_same_as_given_name_ReturnsTrue(){
        val context = ApplicationProvider.getApplicationContext<Context>()
        val rsid = R.string.app_name
        val myAppName = "Decagon Android 007"
        val result = resourceComparer.appNameCheck(context, rsid, myAppName)
        assertThat(result).isTrue()
    }
}