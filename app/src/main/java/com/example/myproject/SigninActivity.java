package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class SigninActivity extends AppCompatActivity {
    EditText username;
    EditText password;
    DatabaseHelper databaseHelper;
    // private String Name, Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        //signin adresse
        username = findViewById(R.id.editTextSIGNinEmailAddress);
        password = findViewById(R.id.editTextTextPassword);
        databaseHelper = new DatabaseHelper(SigninActivity.this);
    }

    private boolean chkFields() {
        String signInUserName = username.getText().toString();
        String signInPassword = password.getText().toString();
        if (signInUserName.isEmpty()) {
            username.setError("اكتب البريد الاكتروني من فضلك!");
            username.requestFocus();
        } else if (signInPassword.isEmpty()) {
            password.setError("اكتب كلمة المرور من فضلك!");
            password.requestFocus();
        } else if (signInUserName.isEmpty() && signInPassword.isEmpty()) {
            Toast.makeText(this, "املأ التفاصيل لو سمحت", Toast.LENGTH_SHORT).show();
        } else if (!(signInUserName.isEmpty() && signInPassword.isEmpty()))
            return true;

        return false;
    }

    public void nextActivity(View view) {
        String signInUserName = username.getText().toString();
        String signInPassword = password.getText().toString();
        if (chkFields()) {
            if (isExistUser()) {
                Toast.makeText(this, "تم تسجيل الدخول بنجاح..", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, TrackActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(this, "البريد الاكتروني او كلمة المرور خطأ", Toast.LENGTH_SHORT).show();

            }
        }

    }

    public boolean isExistUser() {
        String signInUserName = username.getText().toString();
        String signInPassword = password.getText().toString();
        ArrayList<User> users = databaseHelper.genericSelectByEmail(signInUserName);
        if (users.isEmpty() || null == users) {
            return false;
        } else {
            // getting the user back from the database
            User signedInUser = users.get(0);
            if (signedInUser.getName().equals(signInUserName) && signedInUser.getPassWord().equals(signInPassword)) {
                return true;
            } else {
                return false;
            }
        }

    }

}