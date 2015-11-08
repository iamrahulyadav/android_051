package com.example.telephonydemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.telecom.TelecomManager;
import android.telephony.PhoneStateListener;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.telephony.gsm.SmsMessage;
import android.widget.Toast;

public class MyService extends Service {

	@Override
	public IBinder onBind(Intent intent) {

		return null;
	}

	TelephonyManager telMgr;
	String lastCaller = "";
	int lastCallState = 0;

	@Override
	public void onCreate() {

		super.onCreate();

		telMgr = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);

		String myNumber = telMgr.getLine1Number();

		Toast.makeText(this, myNumber, 5).show();

		// telMgr.listen(listener, events)

		telMgr.listen(new MyPhoneStateListner(),
				PhoneStateListener.LISTEN_CALL_STATE
						| PhoneStateListener.LISTEN_DATA_CONNECTION_STATE);

	}

	// call state listner

	class MyPhoneStateListner extends PhoneStateListener {

		@Override
		public void onCallStateChanged(int state, String incomingNumber) {

			super.onCallStateChanged(state, incomingNumber);

			Toast.makeText(MyService.this, incomingNumber + ":" + state,
					Toast.LENGTH_LONG).show();

			if (state == TelephonyManager.CALL_STATE_RINGING ) {
				// wait for 20 second

				WaitThread thread = new WaitThread();
				thread.start();

			}
			lastCallState = state;

			lastCaller = incomingNumber;

		}

		@Override
		public void onDataConnectionStateChanged(int state) {
			// TODO Auto-generated method stub
			super.onDataConnectionStateChanged(state);

			Toast.makeText(MyService.this, "data state:" + state,
					Toast.LENGTH_LONG).show();
		}

	}

	class WaitThread extends Thread {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();

			try {
				sleep(20000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (lastCallState == TelephonyManager.CALL_STATE_RINGING) {

				SmsManager smsManager = SmsManager.getDefault();

				smsManager
						.sendTextMessage(lastCaller, null, "busy", null, null);

			}

		}

	}

}
