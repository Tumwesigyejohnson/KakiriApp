package com.example.kakiriapp;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SignupActivity extends AppCompatActivity {
Button  btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        btn=(Button) findViewById(R.id.register);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Intent intent=new Intent(SignupActivity.this,Login.class);
               // startActivity(intent);

                notification();
            }
        });
    }

    public void notification(){
        Button bton;
        bton=findViewById(R.id.register);
        bton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message="Thank you for joining our community";
                NotificationCompat.Builder builder = new NotificationCompat.Builder(
                        SignupActivity.this
                )
                        .setSmallIcon(R.drawable.logo)
                        .setContentTitle("New Kakiri Notification")
                        .setContentText(message)
                        .setAutoCancel(true);

                Intent intent=new Intent(SignupActivity.this,Login.class);
                startActivity(intent);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("message",message);

                PendingIntent pendingIntent = PendingIntent.getActivity(SignupActivity.this,0,intent,
                        PendingIntent.FLAG_UPDATE_CURRENT);
                builder.setContentIntent(pendingIntent);
                NotificationManager notificationManager =(NotificationManager)getSystemService(
                        Context.NOTIFICATION_SERVICE
                );
                notificationManager.notify(0,builder.build());
            }
        });

    }
    }

