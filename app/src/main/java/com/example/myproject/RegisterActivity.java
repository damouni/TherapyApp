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
    User currentUser;
    DatabaseHelper databaseHelper;
    private String Name, Phone, Password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        email = findViewById(R.id.edtEmail);
        phone = findViewById(R.id.editTextPhone);
        pass = findViewById(R.id.edtpassword);
        register = findViewById(R.id.Signupbtn);
        databaseHelper = new DatabaseHelper(RegisterActivity.this);
    }

    private boolean chkFields() {
        Name = email.getText().toString();
        Phone = phone.getText().toString();
        Password = pass.getText().toString();
        if (Name.isEmpty()) {
            email.setError("اكتب البريد الاكتروني من فضلك!");
            email.requestFocus();
        } else if (Phone.isEmpty()) {
            phone.setError("اكتب رقم الهاتف من فضلك!");
            phone.requestFocus();
        } else if (Password.isEmpty()) {
            pass.setError("اكتب كلمة المرور من فضلك!");
            pass.requestFocus();
        } else if (Name.isEmpty() && Phone.isEmpty() && Password.isEmpty()) {
            Toast.makeText(this, "املأ التفاصيل لو سمحت", Toast.LENGTH_SHORT).show();
        } else if (!(Name.isEmpty() && Phone.isEmpty() && Password.isEmpty()))
            return true;

        return false;
    }
    public void ff(View view) {
        if (chkFields()) {
            currentUser = new User();
            currentUser.setName(Name);
            currentUser.setPassWord(Password);
            currentUser.setPhone(Phone);
            currentUser = databaseHelper.insert(currentUser);
            Toast.makeText(this, "تم التسجيل بنجاح..", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(this,SigninActivity.class);
            startActivity(intent);
        }
    }

}
