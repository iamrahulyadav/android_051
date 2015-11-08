package com.example.servicedemo;

import java.io.FileWriter;
import java.io.IOException;

import android.app.Service;
import android.content.Intent;
import android.os.Environment;
import android.os.IBinder;
import android.widget.Toast;

public class MyFileService extends Service{
	String filePath="";
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		Toast.makeText(this, "CREATED...", 5).show();
		filePath=Environment.getExternalStorageDirectory().getPath()+"/mydata.txt";
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Toast.makeText(this, "STARTED..."+startId, 5).show();
		
		String str=intent.getStringExtra("name");
		//store data in file
		try {
			FileWriter writer=new FileWriter(filePath,true);
			writer.write(str+"\n");
			writer.flush();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return super.onStartCommand(intent, flags, startId);
	}
	
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Toast.makeText(this, "FINISHED...", 5).show();
	}
}
