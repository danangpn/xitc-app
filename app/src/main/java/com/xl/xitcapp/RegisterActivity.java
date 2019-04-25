package com.xl.xitcapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

public class RegisterActivity extends AppCompatActivity {
    EditText edtRegUsername;
    EditText edtRegPassword;
    EditText edtRegReTypePassword;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        edtRegUsername = findViewById(R.id.edtRegUsername);
        edtRegPassword = findViewById(R.id.edtRegPassword);
        edtRegReTypePassword = findViewById(R.id.edtRegReTypePassword);
    }

    public void doRegister(View view) {
        String strRegUsername = edtRegUsername.getText().toString();
        String strRegPassword = edtRegPassword.getText().toString();
        String strReTypePassword = edtRegReTypePassword.getText().toString();

        if (!(strRegUsername.equals(""))){
            if (strRegPassword.equals("") || strReTypePassword.equals("")) {
                showToast("Password tidak boleh kosong!");
            } else if (!(strRegPassword.equals(strReTypePassword))) {
                showToast("Password tidak sama!");
            } else {
                Bundle b = new Bundle();
                Intent i = new Intent(RegisterActivity.this, MainActivity.class);
                b.putString("USERNAME", strRegUsername);
                b.putString("PASSWORD", strRegPassword);
//            i.putExtra("USERNAME", strUsername);
                i.putExtras(b);
                startActivity(i);
            }
        }else{
            showToast("Username tidak boleh kosong!");
        }
    }


    public void showToast(String text){
        CharSequence charSequence = new StringBuilder(text);
        Toast.makeText(this,charSequence,Toast.LENGTH_LONG).show();
    }
}
