package com.example.aidlserviceapp;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.widget.Toast;

import com.util.data.IMath;

public class MathService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		
		
		
		return new Calculator();
	}

	
	
	@Override
	public void onCreate() {
		
		super.onCreate();
		Toast.makeText(this, "service created..", 5).show();
		
	}
	
	class Calculator extends IMath.Stub{

		@Override
		public int add(int x, int y) throws RemoteException {
			// TODO Auto-generated method stub
			return x+y;
		}

		@Override
		public int power(int a, int b) throws RemoteException {
			int p=1;
			
			for(int i=1;i<=b;i++)
			{
				p=p*a;
			}
			return p;
		}
		
	}
	
	
	
	
}
