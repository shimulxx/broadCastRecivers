package com.example.broadcastreceivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import static android.content.ContentValues.TAG;

public class SampleBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive: started alibaba");
        String action = intent.getAction();
        if(action != null){
            if(action.equals(Intent.ACTION_BOOT_COMPLETED)) Toast.makeText(context, "Boot Completed", Toast.LENGTH_LONG).show();
            else if(action.equals(Intent.ACTION_AIRPLANE_MODE_CHANGED)) Toast.makeText(context, "Airplane mode changed", Toast.LENGTH_LONG).show();
            else if(action.equals("com.example.TOAST_MESSAGE")){
                String message = intent.getStringExtra("message");
                Toast.makeText(context, message, Toast.LENGTH_LONG).show();
            }
        }
    }
}
