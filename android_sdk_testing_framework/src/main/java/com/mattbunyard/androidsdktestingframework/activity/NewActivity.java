package com.mattbunyard.androidsdktestingframework.activity;

import android.app.Activity;
import android.os.Bundle;

import com.mattbunyard.androidsdktestingframework.R;

public class NewActivity extends Activity {
    private static final String TAG = NewActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
    }
}
