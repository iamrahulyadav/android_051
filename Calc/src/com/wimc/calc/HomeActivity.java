package com.wimc.calc;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class HomeActivity extends Activity{

	EditText editData;
	TextView textResult;
	Button btFact,btPow;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);
		
		editData=(EditText)findViewById(R.id.editText1);
		 textResult=(TextView)findViewById(R.id.textView2);
		 btFact=(Button)findViewById(R.id.button1);
		 btPow=(Button)findViewById(R.id.button2);		 
		
		 
		 btFact.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				String snum=editData.getText().toString();
				int num=Integer.parseInt(snum);	
				
				//Bundle to store data
				Bundle bundle=new Bundle();
				bundle.putInt("data", num);
				
				// create explicit Intent
				//Intent intent=new Intent(packageContext,cls);
				Intent intent=new Intent(HomeActivity.this,FactActivity.class);
				
				//attach data with Intent
				intent.putExtras(bundle);
				
				//send intent to OS
				//startActivity(intent);
				startActivityForResult(intent, 101);
			}
		});
		 
		 btPow.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					
					String snum=editData.getText().toString();
					int num=Integer.parseInt(snum);	
					//Bundle to store data
					Bundle bundle=new Bundle();
					bundle.putInt("data", num);
					
					// create explicit Intent
					//Intent intent=new Intent(packageContext,cls);
					Intent intent1=new Intent(HomeActivity.this,PowerActivity.class);
					
					//attach data with Intent
					intent1.putExtras(bundle);
					
					//send intent to OS
					//startActivity(intent);
					startActivityForResult(intent1, 102);
				}
			});
		
	}// eof onCreate
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if(requestCode==101 && resultCode==RESULT_OK)
		{
			int f=data.getIntExtra("factresult", 0);
			textResult.setText("Factorial:"+f);
		}
		if(requestCode==102 && resultCode==RESULT_OK)
		{
			int p=data.getIntExtra("powerresult", 0);
			textResult.setText("Factorial:"+p);
		}
	}
	
	
}
