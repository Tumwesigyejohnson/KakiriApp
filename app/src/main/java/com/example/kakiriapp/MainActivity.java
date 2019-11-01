package com.example.kakiriapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Switch wifiswitch;
    private WifiManager wifiManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wifiswitch = findViewById(R.id.wifi_switch);
        wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        wifiswitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    wifiManager.setWifiEnabled(true);
                    wifiswitch.setText("WI-FI is on");
                } else {
                    wifiManager.setWifiEnabled(false);
                    wifiswitch.setText("WI-FI is Off");
                }
            }
        });
        if (wifiManager.isWifiEnabled()) {
            wifiswitch.setChecked(true);
            wifiswitch.setText("WI-FI is on");
        } else {
            wifiswitch.setChecked(false);
            wifiswitch.setText("WI-FI is Off");
        }


        Button btn = findViewById(R.id.cont);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Login.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter(WifiManager.WIFI_STATE_CHANGED_ACTION);
        registerReceiver(wifistateReceiver, intentFilter);

        Toast.makeText(this, "Application Started", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(wifistateReceiver);
    }

    private BroadcastReceiver wifistateReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
int wifiStateExtra = intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE,WifiManager.WIFI_STATE_UNKNOWN);

switch (wifiStateExtra){
    case WifiManager.WIFI_STATE_ENABLED:
        wifiswitch.setChecked(true);
        wifiswitch.setText("WI-FI is on");
        break;
    case WifiManager.WIFI_STATE_DISABLED:
        wifiswitch.setChecked(false);
        wifiswitch.setText("WI-FI is Off");
        break;
}
        }
    };
}
