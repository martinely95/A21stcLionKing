package eu.dreamix.a21stclionking;

import android.widget.Button;

import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import eu.dreamix.a21stclionking.activities.CustomersCountActivity;

import static org.junit.Assert.assertNotEquals;

public class ButtonHeightsTest {

    @Rule
    public ActivityTestRule<CustomersCountActivity> customersCountActivityActivityTestRule =
            new ActivityTestRule<>(CustomersCountActivity.class);

    private CustomersCountActivity customersCountActivity = null;

    @Before
    public void setUp() {
        customersCountActivity = customersCountActivityActivityTestRule.getActivity();
    }

    @Test
    public void checkLoginButton() {
        final Button login = customersCountActivity.findViewById(R.id.buttonOk);
        final Button increaseButton = customersCountActivity.findViewById(R.id.increaseButton);

        assertNotEquals(login.getHeight(), 0);
        assertNotEquals(increaseButton.getHeight(), 0);
    }

    @After
    public void tearDown() {
        customersCountActivity = null;
    }

}
