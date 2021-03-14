package com.mohdev.therapyapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myproject.R;
import com.mohdev.therapyapp.activities.DatabaseHelper;

public class RegisterActivity extends AppCompatActivity {
    //User Email
    EditText email;
    //User Phone
    EditText phone;
    //First User Password
    EditText pass;
    //Second User Password
    EditText pass2;
    //register button
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
        register.setOnClickListener(v -> checkDataEntered());
        //databaseHelper = new DatabaseHelper(RegisterActivity.this);
    }

    boolean isPhone(EditText text){
        CharSequence phone = text.getText().toString();
        return(!TextUtils.isEmpty(phone) && Patterns.PHONE.matcher(phone).matches());
    }

    boolean isEmail(EditText text){
        CharSequence email = text.getText().toString();
        return(!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    boolean isEmpty(EditText text){
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }

    boolean isValidPassword(EditText text1, EditText text2){
         String str1 = text1.getText().toString();
        String str2 = text2.getText().toString();
        return str1.equals(str2);
    }

    void checkDataEntered(){
        if(isPhone(phone) == false){
            phone.setError("Enter valid Phone number!");

        }
        if (isEmpty(phone)){
            Toast t = Toast.makeText(this, "رجاءا اكتب رقم هاتفك النقال", Toast.LENGTH_SHORT);
            t.show();
        }

        if(isEmpty(pass)){
            Toast t = Toast.makeText(this, "اكتب كلمة المرور من فضلك", Toast.LENGTH_SHORT);
            t.show();
        }

        if (isEmpty(pass2)) {
            Toast t = Toast.makeText(this, "اكتب كلمة المرور مرة اخرى بشكل صحيح", Toast.LENGTH_SHORT);
            t.show();
        }

        if(isValidPassword(pass,pass2) == false){
            pass2.setError("Error Password not match, please try again ...");
        }


        if(isEmpty(email)){
            Toast t = Toast.makeText(this, "اكتب البريد الاكتروني", Toast.LENGTH_SHORT);
            t.show();
        }
        if (isEmail(email) == false) {
            email.setError("Enter valid email!");
        }
    }
}
