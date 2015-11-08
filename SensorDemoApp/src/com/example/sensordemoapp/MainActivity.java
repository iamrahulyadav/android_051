package com.example.sensordemoapp;

import android.support.v7.app.ActionBarActivity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity implements
		SensorEventListener {

	EditText editX, editY, editZ;
	SensorManager sensorManager;
	Sensor sensorAcc;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		editX = (EditText) findViewById(R.id.editText1);
		editY = (EditText) findViewById(R.id.editText2);
		editZ = (EditText) findViewById(R.id.editText3);

		sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

		sensorAcc = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

		
		if(sensorAcc==null)
		{
			Toast.makeText(this,"no sensor",5).show();
		}
	}

	// register listner in onResume

	@Override
	protected void onResume() {

		super.onResume();

		sensorManager.registerListener(this, sensorAcc,
				SensorManager.SENSOR_DELAY_NORMAL);

	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();

		sensorManager.unregisterListener(this);

	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		
		
		
	}

	@Override
	public void onSensorChanged(SensorEvent event) {
		// TODO Auto-generated method stub

		
		float sensorData[]=event.values;
		
				
				editX.setText("X:"+sensorData[0]);
				editY.setText("Y:"+sensorData[1]);
				editZ.setText("Z"+sensorData[2]);
	}
}
