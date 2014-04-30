package com.mattbunyard.androidsdktestingframework.test;

import android.test.InstrumentationTestCase;


public class MainActivityTest extends InstrumentationTestCase {

    public void test() {
        final int expected = 1;
        final int reality = 4;
        assertEquals(expected, reality);
    }

}