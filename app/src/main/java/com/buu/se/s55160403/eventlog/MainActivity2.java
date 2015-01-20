package com.buu.se.s55160403.eventlog;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class MainActivity2 extends Activity implements View.OnClickListener {

    private Button btn01;
    private EditText fname, lname, email, sex;
    private RadioButton radioSexButton;
    private RadioGroup radioSexGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2);

        btn01 = (Button) findViewById(R.id.btn01);
        btn01.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity2, menu);
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
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn01:
                sendDataToMain();
                break;
        }
    }

    private void sendDataToMain() {
        radioSexGroup = (RadioGroup) findViewById(R.id.radioSex);

        int selectedId = radioSexGroup.getCheckedRadioButtonId();
        radioSexButton = (RadioButton) findViewById(selectedId);

        fname = (EditText) findViewById(R.id.txbFname);
        lname = (EditText) findViewById(R.id.txbLname);
        email = (EditText) findViewById(R.id.txbEmail);

        Intent data = new Intent();
        data.putExtra("FNAME", fname.getText().toString());
        data.putExtra("LNAME", lname.getText().toString());
        data.putExtra("EMAIL", email.getText().toString());
        data.putExtra("SEX", radioSexButton.getText());
        setResult(RESULT_OK, data);
        finish();
    }
}
