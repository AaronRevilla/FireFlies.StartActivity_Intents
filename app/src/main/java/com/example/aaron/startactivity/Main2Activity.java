package com.example.aaron.startactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    EditText editText;
    TextView txtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        editText = ((EditText) findViewById(R.id.editText));
        Intent i = getIntent();
        editText.setText( i.getStringExtra("Name"));
        txtView = ((TextView) findViewById(R.id.txtView));
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent();
        i.putExtra("Name", txtView.getText().toString());
        setResult(RESULT_OK, i);
        super.onBackPressed();
    }

    public void goBack(View view) {
        onBackPressed();
        finish();
    }

    public void setClick(View view) {
        String tmp = editText.getText().toString();
        txtView.setText(tmp);
    }

    //Fix the rotate mode
    /*
    When you rotate the phone the activity that is running in that
    time destroys so the rotate activy is created but all the variables
    are destroy so the next methods will save the variables
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("TheName", editText.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        txtView.setText(savedInstanceState.getString("TheName", "Default"));
    }
}
