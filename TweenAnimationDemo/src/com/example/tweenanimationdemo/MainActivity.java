package com.example.tweenanimationdemo;


import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {
	TextView textWelcome;
	ImageView imageView;
	Button btStart;
	Animation animation;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// textWelcome=(TextView) findViewById(R.id.textView1);
		imageView = (ImageView) findViewById(R.id.imageView1);
		btStart = (Button) findViewById(R.id.button1);

		// load animation properties Animation
		animation = AnimationUtils.loadAnimation(MainActivity.this,
				R.anim.translation);
		imageView.setBackgroundResource(R.drawable.i0);
		// textWelcome.setAnimation(animation);
		imageView.setAnimation(animation);

	/*	btStart.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				imageView.setBackgroundResource(R.drawable.rabbitframes);

				AnimationDrawable animationDrawable = (AnimationDrawable) imageView
						.getBackground();

				animationDrawable.start();
				// TODO Auto-generated method stub

			}
		});*/

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
