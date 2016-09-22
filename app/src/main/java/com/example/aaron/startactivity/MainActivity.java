package com.example.aaron.startactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText personName ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        personName = ((EditText) findViewById(R.id.personName));
    }

    public void onGo(View view) {
        Intent i = new Intent(this, Main2Activity.class);
        i.putExtra("Name", personName.getText().toString());
        startActivityForResult(i, 1);
        //startActivity(i);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1){
            if(resultCode == RESULT_OK){
                String tmp = data.getStringExtra("Name");
                personName.setText(tmp);
            }
        }
    }
}
