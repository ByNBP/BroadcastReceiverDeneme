package com.example.broadcastreceiverdeneme;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

public class BroadcastReceiverTest extends BroadcastReceiver {
    DatabaseHelper databaseHelper;
    private boolean durdur = false;
    int counter = 1;
    @Override
    public void onReceive(Context context, Intent intent) {
        databaseHelper = new DatabaseHelper(context);
        if (ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())) {
            boolean noConnected = intent.getBooleanExtra(
                    ConnectivityManager.EXTRA_NO_CONNECTIVITY, false
            );
            if (noConnected) {
                durdur = true;
                Toast.makeText(context, "disconnected!!", Toast.LENGTH_SHORT).show();
            } else {
                durdur = false;
                Toast.makeText(context, "connected !!", Toast.LENGTH_SHORT).show();
                InsertData();
            }
        }
    }

    private void InsertData() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (counter != 100) {
                    databaseHelper.insertData("deneme", counter);
                    counter++;
                }
                Log.d("COUNTER", counter + " ");
                if (!durdur) {
                    InsertData();
                }
            }
        }, 3000);
    }
}

