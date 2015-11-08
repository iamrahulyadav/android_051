package com.wimc.activitylifedemo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class HomeActivity extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Toast t=Toast.makeText(this, "on create...", Toast.LENGTH_LONG);
		t.show();
		
	}
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Toast t=Toast.makeText(this, "on start...", Toast.LENGTH_LONG);
		t.show();
		
	}
@Override
protected void onResume() {
	
	super.onResume();
	Toast t=Toast.makeText(this, "on resume...", Toast.LENGTH_LONG);
	t.show();
	
}

@Override
protected void onPause() {
	
	super.onPause();
	Toast t=Toast.makeText(this, "on pause...", Toast.LENGTH_LONG);
	t.show();
	
}
@Override
protected void onStop() {
	
	super.onStop();
	Toast t=Toast.makeText(this, "on stop+...", Toast.LENGTH_LONG);
	t.show();
	
}
@Override
protected void onDestroy() {
	
	super.onDestroy();
	Toast t=Toast.makeText(this, "on destroy...", Toast.LENGTH_LONG);
	t.show();
	
}
}
