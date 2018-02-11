package com.example.nouiapplication.service;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MyService extends Service {
    private static String TAG = "MyService";
    public static final long INTERVAL = 5000;//variable to execute services every 10 second
    private Handler mHandler = new Handler(); // run on another Thread to avoid crash
    private Timer mTimer = null; // timer handling
    private String prnt="First App";
    @Override
    public void onCreate() {
        /*if (mTimer != null)
            mTimer.cancel();
        else
            mTimer = new Timer(); // recreate new timer
       mTimer.scheduleAtFixedRate(new TimeDisplayTimerTask(), 0, INTERVAL);// schedule task
*/
        Intent i = new Intent();
        ComponentName compo = new ComponentName("com.app.myservice", "com.app.myservice.OnlyService");
        i.setComponent(compo);
        this.startService(i);
         /*  Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.app.myanotherapp");
          if (launchIntent != null) {
            launchIntent.putExtra("data","JAGDEEP");
            startActivity(launchIntent);//null pointer check in case package name was not found
        }*/
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "onStartCommand");
        if(intent.getExtras()!=null) {
            prnt=intent.getExtras().getString("data");
        }
        Toast.makeText(getApplicationContext(),"FIRST APP :  " +prnt, Toast.LENGTH_SHORT).show();
        return Service.START_STICKY;
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "In Destroy", Toast.LENGTH_SHORT).show();//display toast when method called
     //   mTimer.cancel();
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

/*    private class TimeDisplayTimerTask extends TimerTask {
        @Override
        public void run() {
            // run on another thread
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    // display toast at every 10 second

                    Toast.makeText(getApplicationContext(),prnt, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }*/
}
