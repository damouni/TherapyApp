package com.mohdev.therapyapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.mohdev.therapyapp.sql.DatabaseHelper;

public class LoginActivity extends AppCompatActivity {
    EditText username;
    EditText password;
    Button register;
    Button login;
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        //databaseHelper=new DatabaseHelper(LoginActivity.this);
    }
/**
    public void nextActivity(View view) {
        Intent intent=new Intent(this,TrackActivity.class);
        boolean flag=true;
        String text=email1.getText().toString();
        String pss=passw.getText().toString();
        if(text.isEmpty()){
            Toast.makeText(this, "اكتب البريد الالكتروني من فضلك", Toast.LENGTH_SHORT).show();
            flag=false;
        }
        if(!pss.isEmpty()&&!text.isEmpty()){
            if(databaseHelper.addText(text)){
                email1.setText("");
                flag=true;
            }
        }

        if (pss.isEmpty()){
            Toast.makeText(this, "اكتب كلمة المرور رجاءا", Toast.LENGTH_SHORT).show();
            flag=false;
        }
        if(!pss.isEmpty()&&!text.isEmpty()){
            if(databaseHelper.addText(pss)){
                passw.setText("");
                flag=true;
            }
        }
        if(flag==true){
            Toast.makeText(this, "تم تسجيل الدخول بنجاح", Toast.LENGTH_SHORT).show();
            startActivity(intent);

        }
    }**/

}