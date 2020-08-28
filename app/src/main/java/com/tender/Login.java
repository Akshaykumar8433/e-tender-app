package com.tender;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {
    EditText mEmail;
    EditText mPassword;
    Button mLogin;
    TextView mRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEmail = (EditText) findViewById(R.id.edittext_email);
        mPassword = (EditText) findViewById(R.id.edittext_password);
        mLogin = (Button) findViewById(R.id.button_login);
        mRegister = (TextView) findViewById(R.id.textview_register);

        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(Login.this,Register.class);
                startActivity(registerIntent);
            }
        });
    }
}