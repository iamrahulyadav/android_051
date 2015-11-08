package com.example.day3completeassign;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddRecordActivity extends Activity {
	
	EditText editName, editAge, editCity;
	Button btAdd;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.addrecord);
		editName=(EditText)findViewById(R.id.editText1);
		editAge=(EditText)findViewById(R.id.editText2);
		editCity=(EditText)findViewById(R.id.editText3);
		
		btAdd=(Button)findViewById(R.id.button1);
		
		btAdd.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				String name=editName.getText().toString();
				String age=editAge.getText().toString();
				String city=editCity.getText().toString();
				
				String details=name+":"+age+":"+city;
				
				Intent intentDetails=new Intent();
				intentDetails.putExtra("result",details);
				
				setResult(RESULT_OK, intentDetails);
				finish();
				
			}
		});
		
	}
	
	

}
