package com.example.kakiriapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class Login extends AppCompatActivity {
    TextView reg;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
//for notification
        TextView textView=findViewById(R.id.not);
        String message = getIntent().getStringExtra("message");
        textView.setText(message);



        //end of notification
        reg=(TextView) findViewById(R.id.register);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Login.this,SignupActivity.class);
                startActivity(intent);
            }
        });
    }
}