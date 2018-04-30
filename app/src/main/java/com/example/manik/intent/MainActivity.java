package com.example.manik.intent;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.content.Intent;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
    private static final int request_code = 5;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClick(View view) {

        Intent i = new Intent(this, Main2Activity.class);

        final EditText editText1 = (EditText)findViewById(R.id.editText1);
        String myString = editText1.getText().toString();
        i.putExtra("qString", myString);
        //startActivity(i);
        startActivityForResult(i, request_code);
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if ((requestCode == request_code) && (resultCode == RESULT_OK)) {

            TextView textView1 = (TextView) findViewById(R.id.textView1);

            String returnString = data.getExtras().getString("returnData");

            textView1.setText(returnString);
        }
    }

}
