package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SignInActivity extends AppCompatActivity {
EditText email1;
EditText passw;
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        email1=findViewById(R.id.editTextSIGNinEmailAddress);
        passw=findViewById(R.id.editTextTextPassword);
        databaseHelper=new DatabaseHelper(SignInActivity.this);
    }

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
    }

}