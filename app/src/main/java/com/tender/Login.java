package com.tender;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText mEmail;
    EditText mPassword;
    Button mLogin;
    TextView mRegister;
    MyDatabaseHelper mydatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEmail = (EditText) findViewById(R.id.edittext_email);
        mPassword = (EditText) findViewById(R.id.edittext_password);
        mLogin = (Button) findViewById(R.id.button_login);
        mRegister = (TextView) findViewById(R.id.textview_register);
        mydatabaseHelper = new MyDatabaseHelper(this);

        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(Login.this,Register.class);
                startActivity(registerIntent);
            }
        });

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailValue = mEmail.getText().toString();
                String passwordValue = mPassword.getText().toString();

                if (mydatabaseHelper.isLoginValid(emailValue, passwordValue)) {
                    Intent homeIntent = new Intent(Login.this, HomeActivity.class);
                    startActivity(homeIntent);
                    Toast.makeText(Login.this, "Login Successful", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(Login.this, "Login Unsuccessful", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}