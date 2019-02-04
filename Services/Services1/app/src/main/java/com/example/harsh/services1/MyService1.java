package com.example.harsh.services1;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MyService1 extends Service {

    public MyService1() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //Log.i(String.valueOf("My Tag"),"inside Start command()"+Thread.currentThread().getId());
        Toast.makeText(getApplicationContext(),"Inside Start command() "+Thread.currentThread().getId(),Toast.LENGTH_SHORT).show();
        return super.onStartCommand(intent,flags,startId);
    }

    @Override
    public void onDestroy() {
        //Log.i(String.valueOf("My Tag"),"inside Destroy command()"+Thread.currentThread().getId());
        Toast.makeText(getApplicationContext(),"Inside Destroy command() "+Thread.currentThread().getId(),Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }



}
