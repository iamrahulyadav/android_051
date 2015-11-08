package com.wimc.calc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FactActivity extends Activity {

	TextView textData;
	TextView textFactResult;
	Button btCalcFact, btFactBack;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.fact);
		// get/receive intent sent from home activity
		
		
		textFactResult = (TextView) findViewById(R.id.ftextView2);
		btCalcFact = (Button) findViewById(R.id.btcalfact);
		btFactBack = (Button) findViewById(R.id.btbackfact);
		textData=(TextView)findViewById(R.id.ftextView1);
		Intent intent = getIntent();
		Bundle bundle = intent.getExtras();
		final int data = bundle.getInt("data");
		
		textData.setText("Number:" + data);


		btCalcFact.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				int fact=1;
				for(int i=data;i>1;i--)
				{
					fact=fact*i;  
				}
				textFactResult.setText("Factorial is:"+fact);
				//pass the data back to home activity
				Intent intentFact=new Intent();
				intentFact.putExtra("factresult", fact);
				//setResult(resultCode(int), data(intent));
				setResult(RESULT_OK, intentFact); //-->OS
				
			}
		});
		btFactBack.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				finish();
			}
		});
	}
}