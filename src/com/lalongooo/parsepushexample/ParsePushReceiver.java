package com.lalongooo.parsepushexample;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.parse.ParsePushBroadcastReceiver;

public class ParsePushReceiver extends ParsePushBroadcastReceiver {

    @Override
    public void onPushOpen(Context context, Intent intent) {
        Log.e("PUSH TEST", "Push notification opened!");
        Intent i = new Intent(context, ParsePushCallback.class);
        i.putExtras(intent.getExtras());
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        
        String jsonData = intent.getExtras().getString("com.parse.Data");
        Log.e("PUSH TEST", "Intent data: " + jsonData);
        
        context.startActivity(i);
    }
}