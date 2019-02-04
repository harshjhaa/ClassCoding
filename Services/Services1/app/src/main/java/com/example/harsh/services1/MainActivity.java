package com.example.harsh.services1;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button b1,b2;
    private TextView txt;
    private Intent mIntent;
    private Intent mIntent2;
    private Boolean isBind;
    private MyService2 myService2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Log.i(String.valueOf(R.string.tag),"inside main thread"+Thread.currentThread().getId());
        Toast.makeText(getApplicationContext(),"inside Main Thread "+Thread.currentThread().getId(),Toast.LENGTH_SHORT).show();
        b1 = findViewById(R.id.b1);
        b2= findViewById(R.id.b2);
        txt = findViewById(R.id.idTextView);

        mIntent = new Intent(this,MyService1.class);
        mIntent2 = new Intent(this,MyService2.class);

        bindService(mIntent2,sc,BIND_AUTO_CREATE);
    }

    public void myMethod(View v){
        switch(v.getId()){
            case R.id.b1:
                startService(mIntent);
                break;
            case R.id.b2:
                stopService(mIntent);
                break;
            case R.id.b3:
                txt.setText(myService2.getTime());
                break;
            case R.id.b4:
                onUnBind(sc);
                break;
        }
    }

    public void onUnBind(ServiceConnection sc){
        myService2.onUnbind(mIntent2);
    }

    ServiceConnection sc = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder iBinder) {
            Toast.makeText(getApplicationContext(),"Services connected ",Toast.LENGTH_SHORT).show();
            MyService2.MyBinder mb = (MyService2.MyBinder)iBinder;
            myService2=(MyService2) mb.getService();
            isBind = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Toast.makeText(getApplicationContext(),"Services Disconnected ",Toast.LENGTH_SHORT).show();
            isBind = false;
        }
    };
}
