package com.mattbunyard.androidsdktestingframework.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mattbunyard.androidsdktestingframework.R;


public class MainActivity extends Activity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private TextView titleTextView;
    private Button hideShowButton;
    private Button startNewActivityButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        titleTextView = (TextView) findViewById(R.id.title);

        hideShowButton = (Button) findViewById(R.id.hideShow);
        updateButtonText();

        hideShowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateTitleVisibility();
                updateButtonText();
            }
        });

        startNewActivityButton = (Button) findViewById(R.id.startNewActivity);
        startNewActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), NewActivity.class));
            }
        });
    }

    private void updateButtonText() {
        if (titleTextView.getVisibility() == View.VISIBLE) {
            hideShowButton.setText(R.string.hide_title);
        } else {
            hideShowButton.setText(R.string.show_title);
        }
    }

    private void updateTitleVisibility() {
        if (titleTextView.getVisibility() == View.VISIBLE) {
            titleTextView.setVisibility(View.INVISIBLE);
        } else {
            titleTextView.setVisibility(View.VISIBLE);
        }
    }
}
