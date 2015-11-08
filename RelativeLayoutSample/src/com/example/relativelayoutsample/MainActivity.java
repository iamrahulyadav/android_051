package com.example.relativelayoutsample;

import android.support.v7.app.ActionBarActivity;
import android.location.Address;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	EditText editName, editPass;
	Button btlogin;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        editName=(EditText)findViewById(R.id.editText1);
        editPass=(EditText)findViewById(R.id.editText2);
        btlogin=(Button)findViewById(R.id.button1);
        btlogin.setOnClickListener(new OnClickListener() {
			String data;
			
        	
			@Override
			public void onClick(View v) {
				
				String name=editName.getText().toString();		
				String pass=editPass.getText().toString();
				System.out.println(name+" "+pass);
				if(name.equals("asdf") && pass.equals("zxcv"))
				{
					data="Thank u";
				}
				else
				{
					data="Try Again";
							
				}
				Toast t=Toast.makeText(MainActivity.this, data, Toast.LENGTH_LONG);
				t.show();
			}
		});
        
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
