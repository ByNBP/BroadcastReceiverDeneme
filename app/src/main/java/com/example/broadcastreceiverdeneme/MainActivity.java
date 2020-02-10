package com.example.broadcastreceiverdeneme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {



    BroadcastReceiverTest broadcastReceiverTest = new BroadcastReceiverTest();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    @Override
    protected void onStart() {
        super.onStart();

            IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
            registerReceiver(broadcastReceiverTest, filter);

    }

    @Override
    protected void onStop() {
        super.onStop();

        unregisterReceiver(broadcastReceiverTest);

    }
}
