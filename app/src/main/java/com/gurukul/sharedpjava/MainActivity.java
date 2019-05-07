package com.gurukul.sharedpjava;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText etName,etEmail,etPass;
        Button btnSI = (Button) findViewById(R.id.btnSignin);
        etName = (EditText) findViewById(R.id.etName);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPass = (EditText) findViewById(R.id.etPass);

        btnSI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp = getSharedPreferences("SP", Context.MODE_PRIVATE);
                SharedPreferences.Editor spEdit = sp.edit();

                spEdit.putString("name",etName.getText().toString());
                spEdit.putString("email",etEmail.getText().toString());
                spEdit.putString("pass",etPass.getText().toString());
                spEdit.apply();

                startActivity(new Intent(MainActivity.this,LoginActivity.class));
            }
        });
    }
}
