package com.example.lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    public static final  String EXTRA_REPLY = "com.example.lifecycle.extra.REPLY";
    private static final String LOG_TAG = "Lifecycle" + SecondActivity.class.getSimpleName();
    private EditText mReply;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.d(LOG_TAG, "Second Activity started!");

        mReply = findViewById(R.id.editTextSecond);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = findViewById(R.id.textMessage);
        textView.setText(message);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "We are inside onStop Method");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "We are inside onDestroy Method");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "We are inside onPause Method");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "We are inside onResume Method");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d(LOG_TAG, "We are inside onRestartMethod");
    }

    @Override
    public void onStart(){
        super.onStart();
        Log.d(LOG_TAG, "We are inside onStart Method");
    }

    public void returnReply(View view) {
        Log.d(LOG_TAG, "Reply Button Clicked!");
        String reply = mReply.getText().toString();
        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, reply);
        setResult(RESULT_OK, replyIntent);
        Log.d(LOG_TAG, "The Second Activity is finished");
        finish();

    }
}