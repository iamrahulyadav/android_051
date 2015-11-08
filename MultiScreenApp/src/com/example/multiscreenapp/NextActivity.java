package com.example.multiscreenapp;

import android.app.Activity;
import android.content.Intent;
import android.hardware.camera2.params.RggbChannelVector;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class NextActivity extends Activity {

	Button canMarry;
	RadioGroup rgGender;
	TextView textData;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.next);

		textData = (TextView) findViewById(R.id.textView1);
		rgGender = (RadioGroup) findViewById(R.id.radioGroup1);
		canMarry = (Button) findViewById(R.id.button1);

		// get/receive intent sent from home activity
		Intent intent = getIntent();
		Bundle bundle = intent.getExtras();
		String name = bundle.getString("username");
		
		final int age = bundle.getInt("age");
		
		textData.setText(name + ":" + age);

		canMarry.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String result = "No";
				int radioId = rgGender.getCheckedRadioButtonId();
				switch (radioId) {
				case R.id.radio1:
					if (age > 20)
						result = "YES";
					break;
				case R.id.radio2:
					if (age > 17)
						result = "YES";
					break;
				}

				Toast t = Toast.makeText(NextActivity.this, result,
						Toast.LENGTH_LONG);
				t.show();
			}
		});

	}
}