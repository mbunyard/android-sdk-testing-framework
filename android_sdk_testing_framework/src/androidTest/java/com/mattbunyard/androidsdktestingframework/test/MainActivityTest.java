package com.mattbunyard.androidsdktestingframework.test;

import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.test.ViewAsserts;
import android.test.suitebuilder.annotation.MediumTest;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mattbunyard.androidsdktestingframework.R;
import com.mattbunyard.androidsdktestingframework.activity.MainActivity;

/**
 *  Typically, in the setUp() method, you should:
 *      - Invoke the superclass constructor for setUp(), which is required by JUnit.
 *
 *  Initialize your test fixture state by:
 *      - Defining the instance variables that store the state of the fixture.
 *      - Creating and storing a reference to an instance of the Activity under test.
 *      - Obtaining a reference to any UI components in the Activity that you want to test.
 *
 *  Your UI testing goals might include:
 *      - Verifying that a button is displayed with the correct layout when the Activity is launched.
 *      - Verifying that a TextView is initially hidden.
 *      - Verifying that a TextView displays the expected string when a button is pushed.
 *
 */
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    private MainActivity activity;
    private TextView titleTextView;
    private Button hideShowButton;

    public MainActivityTest() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        // Prevent the UI control from taking focus when test clicks it programmatically
        setActivityInitialTouchMode(true);

        activity = getActivity();
        titleTextView = (TextView) activity.findViewById(R.id.title);
        hideShowButton = (Button) activity.findViewById(R.id.hideShow);
    }

    /**
     * Verify test fixture setup correctly
     */
    public void testPreconditions() {
        assertNotNull("activity is null", activity);
        assertNotNull("titleTextView is null", titleTextView);
        assertNotNull("hideShowButton is null", hideShowButton);
    }

    /**
     * Test title TextView is displayed to user
     */
    @MediumTest
    public void testTitleTextView_layout() {
        // Get top-level ViewGroup view in the layout hierarchy
        final View decorView = activity.getWindow().getDecorView();
        ViewAsserts.assertOnScreen(decorView, titleTextView);
        // assertTrue(titleTextView.getVisibility() == View.VISIBLE);
    }

    /**
     * Test title text is correct
     */
    @MediumTest
    public void testTitleTextView_labelText() {
        final String expected = activity.getString(R.string.app_name);
        final String actual = titleTextView.getText().toString();
        assertEquals(expected, actual);
    }

    /**
     * Test hide/show button is displayed to user
     */
    @MediumTest
    public void testHideShowButton_layout() {
        final View decorView = activity.getWindow().getDecorView();
        ViewAsserts.assertOnScreen(decorView, hideShowButton);
        // assertTrue(titleTextView.getVisibility() == View.VISIBLE);
    }

    /**
     * Test hide/show button click and visibility change of title text with button text change
     */
    @MediumTest
    public void testHideShowButton_clickButtonAndExpectVisibilityChange() {
        TouchUtils.clickView(this, hideShowButton);
        assertTrue(titleTextView.getVisibility() == View.INVISIBLE);
        assertEquals(activity.getString(R.string.show_title), hideShowButton.getText().toString());
        TouchUtils.clickView(this, hideShowButton);
        assertTrue(titleTextView.getVisibility() == View.VISIBLE);
        assertEquals(activity.getString(R.string.hide_title), hideShowButton.getText().toString());
    }

    /*
    @Override
    protected void tearDown() {

    }
    */
}
