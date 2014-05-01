package com.mattbunyard.androidsdktestingframework.test;

import android.content.Intent;
import android.test.ActivityUnitTestCase;
import android.test.suitebuilder.annotation.MediumTest;
import android.widget.Button;

import com.mattbunyard.androidsdktestingframework.R;
import com.mattbunyard.androidsdktestingframework.activity.MainActivity;

/**
 *  Tests LaunchActivity in isolation from the system.
 *
 *  Typically, in the setUp() method, you should:
 *      - Invoke the superclass constructor for setUp(), which is required by JUnit.
 *
 *  Initialize your test fixture state by:
 *      - Defining the instance variables that store the state of the fixture.
 *      - Obtaining a reference to any UI components in the Activity that you want to test.
 *
 *  Your unit testing goals might include:
 *      - Verifying that LaunchActivity fires an Intent when a button is pushed clicked.
 *      - Verifying that the launched Intent contains the correct payload data.
 *
 */
public class MainActivityUnitTest extends ActivityUnitTestCase<MainActivity> {
    private static final String TAG = MainActivityUnitTest.class.getSimpleName();
    private Intent intent;
    private Button startNewActivityButton;

    public MainActivityUnitTest() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        // When extending ActivityUnitTestCase, the activity is not automatically started.  Start
        // activity under test in isolation
        intent = new Intent(getInstrumentation().getTargetContext(), MainActivity.class);
        startActivity(intent, null, null);

        startNewActivityButton = (Button) getActivity().findViewById(R.id.startNewActivity);
    }

    /**
     *
     */
    @MediumTest
    public void testPreconditions() {
        assertNotNull("newActivity is null", getActivity());
        assertNotNull("startNewActivityButton is null", startNewActivityButton);
    }

    /**
     * Test button click creates new activity intent
     */
    @MediumTest
    public void testNewActivityLaunchedWithIntent() {
        // Simulate user button click
        startNewActivityButton.performClick();

        // Verify Intent to start new Activity was created
        final Intent startedIntent = getStartedActivityIntent();
        assertNotNull("Intent was null", startedIntent);
    }

    /*
    @Override
    protected void tearDown() {

    }
    */
}
