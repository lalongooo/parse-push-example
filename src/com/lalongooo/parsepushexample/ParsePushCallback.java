package com.lalongooo.parsepushexample;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ParsePushCallback extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.parse_push_callback);
		
		TextView tv = (TextView) findViewById(R.id.tvPushInfo);
		tv.setText(savedInstanceState.getString("com.parse.Data"));
	}
	
}
