package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
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
                String message = "لقد حان وقت اخذ الدواء اضغط هنا لتأكيد تلقيك للدواء ";
                NotificationCompat.Builder builder = new NotificationCompat.Builder(ChooseDwa.this)
                        .setSmallIcon(R.drawable.healthcare)
                        .setContentTitle("لا تنسى انه وقت اخذ الدواء")
                        .setContentText(message)
                        .setAutoCancel(true);
                Intent intent = new Intent(ChooseDwa.this, NotificationActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("message", message);
                PendingIntent pendingIntent = PendingIntent.getActivity(ChooseDwa.this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                builder.setContentIntent(pendingIntent);
                NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                notificationManager.notify(0, builder.build());
            }
        });
    }
}