package com.example.broadcastreceivers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private BroadcastReceiver broadcastReceiver;
    private Button button;

    private BroadcastReceiver localreceiver;
    private IntentFilter localIntentFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.btnBroadcast);

        localreceiver = new SampleBroadcastReceiver();
        localIntentFilter = new IntentFilter("com.example.TOAST_MESSAGE");
        LocalBroadcastManager.getInstance(this).registerReceiver(localreceiver, localIntentFilter);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("com.example.TOAST_MESSAGE");
                intent.putExtra("message", "This is our message");
                intent.setPackage(getPackageName());
                sendBroadcast(intent);
            }
        });

        /*broadcastReceiver = new SampleBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        registerReceiver(broadcastReceiver, intentFilter);*/
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //unregisterReceiver(broadcastReceiver);
        LocalBroadcastManager.getInstance(this).unregisterReceiver(localreceiver);
    }

}
