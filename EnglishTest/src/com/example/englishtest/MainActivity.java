package com.example.englishtest;

import com.example.englishtest.R.color;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.media.ExifInterface;
import android.os.Bundle;/*
import android.support.v7.app.ActionBarActivity;*/
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;

public class MainActivity extends Activity {

	RadioGroup rg;
	RadioButton rb1, rb2, rb3, rb4;
	Button btnext;
	TextView textqus;
	String question[] = { "1. What ________ they (talk) ________ about?",
			"2. My father (eat) _____ hot dog.",
			"3. Ashok (drink) _____ milk every morning.",
			"4. They (be) _____ nice.",
			"5. My parents (do) _____ the shopping." };
	String option[][] = {
			{ "talk / does", "does / talk", "do / talk", "talk / do" },
			{ "eates", "eating", "eat", "eats" },
			{ "drinkies", "drink", "drinkes", "drinks" },
			{ "are", "were", "is", "am" } };
	int answer[] = { 1, 1, 4, 1 };
	int countqus = 0;
	int check = 0;
	int rgbtnclk = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		rg = (RadioGroup) findViewById(R.id.radioGroup1);
		rb1 = (RadioButton) findViewById(R.id.radio0);
		rb2 = (RadioButton) findViewById(R.id.radio1);
		rb3 = (RadioButton) findViewById(R.id.radio2);
		rb4 = (RadioButton) findViewById(R.id.radio3);
		btnext = (Button) findViewById(R.id.buttonnext);
		textqus = (TextView) findViewById(R.id.textView1);

		// adding data
		textqus.setText(question[countqus]);
		rb1.setText(option[countqus][0]);
		rb2.setText(option[countqus][1]);
		rb3.setText(option[countqus][2]);
		rb4.setText(option[countqus][3]);

		rg.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				

				switch ()
				{
					case R.id.radio0:
					
					if (answer[countqus] == 1)
					{
						rb1.setTextColor(Color.GREEN);
						rb2.setTextColor(Color.BLACK);
						rb3.setTextColor(Color.BLACK);
						rb4.setTextColor(Color.BLACK);
						
					}	
					break;
					
				case R.id.radio1:
					//checkedId = 2;
					if (answer[countqus] == 2)
					{
						rb1.setTextColor(Color.BLACK);
						rb2.setTextColor(Color.GREEN);
						rb3.setTextColor(Color.BLACK);
						rb4.setTextColor(Color.BLACK);
					}
					
						break;
				case R.id.radio2:
					//checkedId =3;
					if(answer[countqus]==3)
					{
						rb1.setTextColor(Color.BLACK);
						rb2.setTextColor(Color.BLACK);
						rb3.setTextColor(Color.GREEN);
						rb4.setTextColor(Color.BLACK);
					}
					
					break;
				case R.id.radio3:
					
					
					if(answer[countqus]==4)
					{
						rb1.setTextColor(Color.BLACK);
						rb2.setTextColor(Color.BLACK);
						rb3.setTextColor(Color.BLACK);
						rb4.setTextColor(Color.GREEN);
					}
					break;

				default:
					break;
				}
			}
		});
		
		
		// next btn code
		btnext.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				countqus++;
				
				
				textqus.setText(question[countqus]);
				rb1.setText(option[countqus][0]);
				rb2.setText(option[countqus][1]);
				rb3.setText(option[countqus][2]);
				rb4.setText(option[countqus][3]);
				
				rb1.setTextColor(Color.BLACK);
				rb2.setTextColor(Color.BLACK);
				rb3.setTextColor(Color.BLACK);
				rb4.setTextColor(Color.BLACK);
				rg.clearCheck();
				
			}
		});

	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		rg.clearCheck();
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
