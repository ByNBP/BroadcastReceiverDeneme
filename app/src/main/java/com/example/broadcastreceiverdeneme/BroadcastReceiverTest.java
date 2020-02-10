package com.example.broadcastreceiverdeneme;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.util.Log;
import android.widget.Toast;

public class BroadcastReceiverTest extends BroadcastReceiver {
    DatabaseHelper databaseHelper;
    private boolean durdur = false;

    @Override
    public void onReceive(Context context, Intent intent) {
        databaseHelper = new DatabaseHelper(context);


        if (ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())) {

            boolean noConnected = intent.getBooleanExtra(
                    ConnectivityManager.EXTRA_NO_CONNECTIVITY, false
            );
            if (noConnected) {
                Toast.makeText(context, "disconnected!!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "connected !!", Toast.LENGTH_SHORT).show();

                for (int i = 0; i < 20; i++) {
                    boolean isInserted = databaseHelper.insertData("deneme");
                    if (isInserted)
                        Log.d("DENEME", "inserted !! ");
                    else
                        Log.d("DENEME", "not inserted !!");
                }
                return;
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }

}

