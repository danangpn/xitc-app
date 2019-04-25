package com.xl.xitcapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText edtUsername;
    EditText edtPassword;
//    Button btnClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        /*
        btnClick = findViewById(R.id.btn_login);
        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/
    }

    public void doLogin(View view) {
        String strUsername = edtUsername.getText().toString();
        String strPassword = edtPassword.getText().toString();

        if (strUsername.equals("admin") && strPassword.equals("password")) {
//            Toast.makeText(this, "Username dan password BENAR", Toast.LENGTH_LONG).show();
            Bundle b = new Bundle();
            Intent i = new Intent(LoginActivity.this, MainActivity.class);
            b.putString("USERNAME", strUsername);
            b.putString("PASSWORD", strPassword);
//            i.putExtra("USERNAME", strUsername);
            i.putExtras(b);
            startActivity(i);
        } else {
            Toast.makeText(this, "Username dan password SALAH", Toast.LENGTH_LONG).show();
        }
    }
    public void doInputRegistration(View view) {
            Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(i);
    }

}
