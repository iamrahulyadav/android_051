package com.wimc.calc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PowerActivity extends Activity {
	EditText editData;
	TextView textPowResult,textData1;
	Button btCalcPow, btPowBack;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.power);

		// get/receive intent sent from home activity
		
		textData1=(TextView)findViewById(R.id.ptextView1);
		
		textPowResult = (TextView) findViewById(R.id.ptextView3);
		btCalcPow = (Button) findViewById(R.id.pbutton1);
		btPowBack = (Button) findViewById(R.id.pbutton2);
		editData=(EditText)findViewById(R.id.peditText1);
		
		
		
		
		Intent intent1 = getIntent();
		
		Bundle bundle = intent1.getExtras();
		
		final int data = bundle.getInt("data");
		
		textData1.setText("Number:" + data);
		
		
		
		btCalcPow.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String power=editData.getText().toString();
				int num=Integer.parseInt(power);	
				int pow=data;
				for(int i=num;i>+1;i--)
				{
					pow=pow*data;
				}
				textPowResult.setText("Power is:"+pow);
				//pass the data back to home activity
				Intent intentPow=new Intent();
				intentPow.putExtra("powerresult", pow);
				//setResult(resultCode(int), data(intent));
				setResult(RESULT_OK, intentPow); //-->OS
			}
		});
		btPowBack.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				finish();
			}
		});
	}
}
