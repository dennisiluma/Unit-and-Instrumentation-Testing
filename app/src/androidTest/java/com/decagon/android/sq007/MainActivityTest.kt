import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.decagon.android.sq007.MainActivity
import com.decagon.android.sq007.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {

    @Rule
    @JvmField
    val activityScenarioRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun test_navigation_to_ProfileActivity (){
        onView(withId(R.id.etv_name_field)).perform(replaceText("Dennis"))
        onView(withId(R.id.etv_email_field)).perform(replaceText("dennis@gmail.com"))
        onView(withId(R.id.etv_phone_number_field)).perform(replaceText("08034745689"))
        onView(withId(R.id.btv_submit)).perform(click())
        onView(withId(R.id.profileActivityId)).check(matches(isDisplayed()))
    }

    @Test
    fun name_textview_is_displayed (){
        onView(withId(R.id.etv_name_field)).check(matches(isDisplayed()))
    }

    @Test
    fun email_textview_is_displayed (){
        onView(withId(R.id.etv_email_field)).check(matches(isDisplayed()))
    }
    @Test
    fun phoneNo_textview_is_displayed (){
        onView(withId(R.id.etv_phone_number_field)).check(matches(isDisplayed()))
    }
}