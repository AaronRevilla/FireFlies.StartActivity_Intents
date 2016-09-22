package com.example.aaron.startactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView txtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        txtView = ((TextView) findViewById(R.id.textView));
        Intent i = getIntent();
        txtView.setText( i.getStringExtra("Name"));
    }
}
