package com.example.harsh.services1;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

import java.util.Date;

public class MyService2 extends Service {

    //constructor
    public MyService2() { }

    //instance
    IBinder ib = new MyBinder();

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        //throw new UnsupportedOperationException("Not yet implemented");
        return ib;
    }

    class MyBinder extends Binder{
        Service getService()
        {
            return MyService2.this;
        }
    }

    public String getTime(){
        Date obj = new Date();
        return obj.toString();
    }

    @Override
    public void onCreate() {
        Toast.makeText(getApplicationContext(),"Inside onCreate command()",Toast.LENGTH_SHORT).show();
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        Toast.makeText(getApplicationContext(),"Inside onDestroy command()",Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Toast.makeText(getApplicationContext(),"inside onUnbind command()",Toast.LENGTH_SHORT).show();
        return super.onUnbind(intent);
    }
}
