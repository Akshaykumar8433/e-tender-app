package com.tender;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    EditText mUsername;
    EditText mEmail;
    EditText mPassword;
    EditText mcfPassword;
    Button mRegister;
    TextView mLogin;
    MyDatabaseHelper db;

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

        db = new MyDatabaseHelper(this);

        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String usernameValue = mUsername.getText().toString();
                String emailValue = mEmail.getText().toString();
                String passwordValue = mPassword.getText().toString();
                String password1Value = mcfPassword.getText().toString();

                if (usernameValue.equals("")||emailValue.equals("")||passwordValue.equals("")||password1Value.equals("")){
                    Toast.makeText(Register.this, "Fields are empty", Toast.LENGTH_SHORT).show();
                }
                else {
                    if(passwordValue.equals(password1Value)){
                        Boolean checkemail = db.checkemail(emailValue);
                        if (checkemail==true){
                            Boolean insert = db.insert(usernameValue,emailValue,passwordValue);
                            if(insert==true){
                                Toast.makeText(getApplicationContext(),"Register Successful",Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(getApplicationContext(),"Email already exists",Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Password does not match", Toast.LENGTH_SHORT).show();
                    }
                }



            }
        });

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginIntent = new Intent(Register.this,Login.class);
                startActivity(loginIntent);
            }
        });
    }
}