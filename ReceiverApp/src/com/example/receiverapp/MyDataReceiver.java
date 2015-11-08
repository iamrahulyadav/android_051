package com.example.receiverapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.sax.StartElementListener;
import android.widget.TextView;
import android.widget.Toast;

public class MyDataReceiver extends BroadcastReceiver {

	TextView textData;

	@Override
	public void onReceive(Context context, Intent intent) {

		String str = intent.getStringExtra("mydata");
		Toast.makeText(context, str, 5).show();

		
		//send data to mainactivity
		Intent in=new Intent(context,MainActivity.class);
		in.putExtra("newdata", str);
		
		in.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		
		context.startActivity(in);
		
		
		
	}

}
