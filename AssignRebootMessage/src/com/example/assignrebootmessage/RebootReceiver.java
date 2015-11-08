package com.example.assignrebootmessage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class RebootReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {

		
		
		try {
			Thread.sleep(5000);
			
			Toast.makeText(context, "welcome", 5).show();

			Intent in = new Intent(context, MainActivity.class);
			
			in.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			
			context.startActivity(in);

			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
