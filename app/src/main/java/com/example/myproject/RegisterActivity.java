package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    //User Email
    EditText email;
    //User Phone
    EditText phone;
    //First User Password
    EditText pass;
    //Second User Password
    EditText pass2;
    // register button
    Button register;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        email = findViewById(R.id.edtEmail);
        phone = findViewById(R.id.editTextPhone);
        pass = findViewById(R.id.edtpassword);
        pass2 = findViewById(R.id.edtpassword2);
        register = findViewById(R.id.Signupbtn);
        databaseHelper = new DatabaseHelper(RegisterActivity.this);
    }


    public void ff(View view) {
        boolean flag = true;
        String pss = pass.getText().toString();
        String text = email.getText().toString();
        String a = phone.getText().toString();
        String pss2 = pass2.getText().toString();
        if (text.isEmpty()) {
            Toast.makeText(this, "اكتب البريد الاكتروني", Toast.LENGTH_SHORT).show();
            flag = false;
        }
        if (!pss2.isEmpty() && !a.isEmpty() && !pss.isEmpty() && !text.isEmpty()) {
            if (databaseHelper.addText(text)) {
                email.setText("");
                flag = true;
            }
        }

        if (a.isEmpty()) {
            Toast.makeText(this, "رجاءا اكتب رقم هاتفك النقال", Toast.LENGTH_SHORT).show();
            flag = false;
        }
        if (!pss2.isEmpty() && !a.isEmpty() && !pss.isEmpty() && !text.isEmpty()) {
            if (databaseHelper.addText(a)) {
                phone.setText("");
                flag = true;

            }
        }

        if (pss.isEmpty()) {
            Toast.makeText(this, "اكتب كلمة المرور من فضلك", Toast.LENGTH_SHORT).show();
            flag = false;
        }
        if (!pss2.isEmpty() && !a.isEmpty() && !pss.isEmpty() && !text.isEmpty()) {
            if (databaseHelper.addText(pss)) {
                pass.setText("");
                flag = true;
            }
        }

        if (pss2.isEmpty()) {
            Toast.makeText(this, "اكتب كلمة المرور مرة اخرى بشكل صحيح", Toast.LENGTH_SHORT).show();
            flag = false;
        }
        if (!pss2.isEmpty() && !a.isEmpty() && !pss.isEmpty() && !text.isEmpty()) {
            if (databaseHelper.addText(pss2)) {
                pass2.setText("");}
            Intent intent = new Intent(this, SigninActivity.class);
            if (flag == true) {
                        Toast.makeText(this, "تم التسجيل  بنجاح", Toast.LENGTH_SHORT).show();
                        startActivity(intent);}
            }
            if (flag == false) {
                Toast.makeText(this, "أكمل الناقص بشكل صحيح من فضلك", Toast.LENGTH_SHORT).show();
            }
        }
    }
