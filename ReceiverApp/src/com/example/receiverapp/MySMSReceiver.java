package com.example.receiverapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class MySMSReceiver extends BroadcastReceiver {

	final SmsManager sms = SmsManager.getDefault();

	@Override
	public void onReceive(Context context, Intent intent) {

		Object smsObjects[] = (Object[]) intent.getExtras().get("pdus");

		// convert first sms in byte array
		byte smsData[] = (byte[]) smsObjects[0];

		// convert byte sequence in proper smsMessage
		SmsMessage sms = SmsMessage.createFromPdu(smsData);
		String body = sms.getMessageBody();
		String number = sms.getOriginatingAddress();

		Toast.makeText(context, body + ":from:" + number, 5).show();

	}

}
