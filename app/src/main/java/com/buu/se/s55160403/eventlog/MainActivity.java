package com.buu.se.s55160403.eventlog;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity implements View.OnClickListener {

    private Button btn01;
    private TextView name, email, sex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("TEST", "onCreate Event");

        btn01 = (Button) findViewById(R.id.btn01);
        btn01.setOnClickListener(this);

        name = (TextView) findViewById(R.id.txtName);
        email = (TextView) findViewById(R.id.txtEmail);
        sex = (TextView) findViewById(R.id.txtSex);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("TEST", "onStart Event");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("TEST", "onResume Event");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("TEST", "onPause Event");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("TEST", "onStop Event");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("TEST", "onRestart Event");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("TEST", "onDestroy Event");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn01:
                startPage2();
                break;
        }
    }

    private void startPage2() {
        startActivityForResult(new Intent(this, MainActivity2.class), 1);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if((requestCode == 1) && (resultCode == RESULT_OK)) {
            Log.d("TEST", "onActivityResult");
            name.setText("Name: " + data.getStringExtra("FNAME").toString() + " " + data.getStringExtra("LNAME").toString());
            email.setText("Email: " + data.getStringExtra("EMAIL").toString());
            sex.setText("Sex: " + data.getStringExtra("SEX"));
        }
        Log.d("TEST", "NONONONONonActivityResult");
    }
}
