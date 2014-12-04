package com.lalongooo.parsepushexample;


import android.app.Application;
import android.provider.Settings.Secure;
import android.util.Log;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseInstallation;
import com.parse.ParsePush;
import com.parse.PushService;
import com.parse.SaveCallback;

/**
 * @author lalongooo
 */
public class ParsePushExample extends Application {

	public ParsePushExample(){
		
	}
	
	public void onCreate() {
		super.onCreate();
		
		String androidId = Secure.getString(getApplicationContext().getContentResolver(), Secure.ANDROID_ID);
		Log.d("PARSE TEST", "Android iD: " + androidId);
		
		
		Parse.initialize(this, "KMfIuAwXj3tbieGpqat7ivmFMPRWp77Q45Yi8xjX", "OtMQMK8K6Ujq9NAXO5bfHN1S0CETKfMDqiAVQa3m");
		// Also in this method, specify a default Activity to handle push
		// notifications		
		PushService.setDefaultPushCallback(this, ParsePushCallback.class);
		ParseInstallation installation = ParseInstallation.getCurrentInstallation();
		installation.put("UniqueId", androidId);
		installation.saveInBackground();
		
		
		
//		ParsePush.subscribeInBackground("", new SaveCallback() {
//			@Override
//			public void done(ParseException e) {
//				if (e == null){
//					Log.d("PARSE TEST", "Successfully subscribed to the broadcast channel.");
//				}else{
//					Log.d("PARSE TEST", "Failed to subscriber for push.");
//				}
//			}
//		});
	}

}
