package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChooseDwa extends AppCompatActivity {
    Button BtnNotifacation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_dwa);
        BtnNotifacation = findViewById(R.id.btn_notifacation);
        BtnNotifacation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = "this is a notifacation example";
                NotificationCompat.Builder builder=new NotificationCompat.Builder(ChooseDwa.this)
                        .setSmallIcon(R.drawable.healthcare)
                        .setContentTitle("new notification")
                        .setContentText(message)
                        .setAutoCancel(true);
                Intent intent =new Intent(ChooseDwa.this, Notification.class);

            }
        });
    }
}