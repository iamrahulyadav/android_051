package com.example.assign_locationsave;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import android.app.Service;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.IBinder;
import android.telephony.PhoneStateListener;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.widget.Toast;

public class MyService extends Service {

	TelephonyManager telMgr;

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();

		telMgr = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);

		telMgr.listen(new MyPhoneStateListner(),
				PhoneStateListener.LISTEN_CALL_STATE
						| PhoneStateListener.LISTEN_DATA_CONNECTION_STATE);

	}

	class MyPhoneStateListner extends PhoneStateListener {

		ApplicationInfo appInfo = getApplicationInfo();
		final String strDataDirPath = appInfo.dataDir;

		final String filePath = strDataDirPath + "/location.txt";

		@Override
		public void onCallStateChanged(int state, String incomingNumber) {

			super.onCallStateChanged(state, incomingNumber);

			Toast.makeText(MyService.this, incomingNumber + ":" + state,
					Toast.LENGTH_LONG).show();

		//	int num = Integer.parseInt(incomingNumber);

			String loc="";

				if (state == TelephonyManager.CALL_STATE_RINGING) {

					try {
						BufferedReader br = new BufferedReader(new FileReader(
								filePath));
						 loc = br.readLine();
						br.close();
						
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
					Toast.makeText(MyService.this,loc+ ":" + state,
							Toast.LENGTH_LONG).show();

					SmsManager smsManager = SmsManager.getDefault();

					smsManager.sendTextMessage(incomingNumber, null, loc,
							null, null);

				

			}
		}

	}
}
