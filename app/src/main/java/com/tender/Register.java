package com.tender;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Register extends AppCompatActivity {
    EditText mUsername;
    EditText mEmail;
    EditText mPassword;
    EditText mcfPassword;
    Button mRegister;
    TextView mLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mUsername = (EditText) findViewById(R.id.edittext_Username);
        mEmail = (EditText) findViewById(R.id.edittext_email);
        mPassword = (EditText) findViewById(R.id.edittext_password);
        mcfPassword = (EditText) findViewById(R.id.edittext_cfpassword);
        mRegister = (Button) findViewById(R.id.button_register);
        mLogin = (TextView) findViewById(R.id.textview_login);

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginIntent = new Intent(Register.this,Login.class);
                startActivity(loginIntent);
            }
        });
    }
}