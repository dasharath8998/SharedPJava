package com.gurukul.sharedpjava;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText etEmail,etPass;
        Button btnLogin = (Button) findViewById(R.id.btnLogin);
        etEmail = (EditText) findViewById(R.id.etLEmail);
        etPass = (EditText) findViewById(R.id.etLPass);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp = getSharedPreferences("SP", Context.MODE_PRIVATE);
                String email = sp.getString("email","no value");
                String pass = sp.getString("pass","no value");

                if(email.equals(etEmail.getText().toString()) && pass.equals(etPass.getText().toString())){
                    AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                    builder.setPositiveButton("okay", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    }).setMessage("Done...").show();
                }else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                    builder.setPositiveButton("okay", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    }).setMessage("Failed...").show();
                }
            }
        });
    }
}
