package com.example.nouiapplication.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.example.nouiapplication.service.MyService;

/**
 * Created by jmohmmed on 2/9/2018.
 */

public class MyReceiver extends BroadcastReceiver {
    private static String TAG="MyReceiver";
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG,"OnReceive Called");
        if(intent.getAction().equals(Intent.ACTION_AIRPLANE_MODE_CHANGED ))
        {
            context.startService(new Intent(context, MyService.class));
        }
    }
}
