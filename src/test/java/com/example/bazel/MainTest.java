package com.example.bazel;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MainTest {

    @Rule
    public ActivityScenarioRule<MainActivity> scenarioRule = new ActivityScenarioRule<>(MainActivity.class);

    public ActivityScenario<MainActivity> scenario;

    @Before
    public void setup() {
        scenario = scenarioRule.getScenario();
    }

    @Test
    public void checkImageIsBazelImage() {
        Espresso.onView(ViewMatchers.withId(R.id.iv_main)).check(ViewAssertions.matches(EspressoTestsMatchers.withDrawable(R.drawable.bazel)));
    }

    @Test
    public void checkTextIsBazel() {
        Espresso.onView(ViewMatchers.withId(R.id.tv_main)).check(ViewAssertions.matches(ViewMatchers.withText("Bazel")));
    }

}

