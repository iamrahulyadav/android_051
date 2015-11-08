package com.example.fragmentdemo2;



import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity implements Details{

	Button btCity, btstate;
	FragmentManager fragManager;
	TextView textCity, textState;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btCity = (Button) findViewById(R.id.button1);
		btstate = (Button) findViewById(R.id.button2);
		textCity=(TextView) findViewById(R.id.textView1);
		textState=(TextView) findViewById(R.id.textView2);

		fragManager = getSupportFragmentManager();

		btCity.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				FragmentTransaction ft = fragManager.beginTransaction();
				
				ft.replace(R.id.linear1, new CityFrag());
				ft.commit();
				

			}
		});

		btstate.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				FragmentTransaction ft = fragManager.beginTransaction();

				ft.replace(R.id.linear1, new StateFrag());

				ft.commit();
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

	@Override
	public void setCity(String city) {
		textCity.setText(city);
		
	}

	@Override
	public void setState(String state) {
		// TODO Auto-generated method stub
		textState.setText(state);
	}
}
