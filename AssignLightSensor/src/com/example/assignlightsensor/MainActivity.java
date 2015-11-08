package com.example.assignlightsensor;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity implements
		SensorEventListener {

	SensorManager sensorManager;
	Sensor sensorAcc;
	RelativeLayout layoutRelative;
	TextView text;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		layoutRelative = (RelativeLayout) findViewById(R.id.view);
		text = (TextView) findViewById(R.id.textView1);

		sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

		sensorAcc = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

		if (sensorAcc == null) {
			Toast.makeText(this, "no sensor", 5).show();
		}
	}

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
		// TODO Auto-generated method stub

	}

	@Override
	public void onSensorChanged(SensorEvent event) {
		// TODO Auto-generated method stub

		float sensorData[] = event.values;

		text.setText(sensorData[0] + "");
		if (sensorData[0] >= 1 && sensorData[0] <= 100) {
			layoutRelative.setBackgroundColor(Color.BLUE);

		}
		if (sensorData[0] >= 101 && sensorData[0] <= 200) {
			layoutRelative.setBackgroundColor(Color.YELLOW);

		}
		if (sensorData[0] >= 201 && sensorData[0] <= 300) {
			layoutRelative.setBackgroundColor(Color.GREEN);

		}
		if (sensorData[0] >= 301) {
			layoutRelative.setBackgroundColor(Color.BLACK);

		}
	}

}
