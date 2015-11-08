package com.wimc.mycamera;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends ActionBarActivity {

	Button btLaunch;
	ImageView imageView;
	static final int REQUEST_IMAGE_CAPTURE = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btLaunch = (Button) findViewById(R.id.button1);
		imageView = (ImageView) findViewById(R.id.imageView2);

		btLaunch.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// Intent intentView=new Intent();

				/*
				 * intentView.setAction(Intent.ACTION_VIEW); String
				 * url="http://www.yahoo.com"; Uri u=Uri.parse(url);
				 */

				/*
				 * intentView.setAction(Intent.ACTION_DIAL); String
				 * phoneNo="tel:1234567890"; Uri u=Uri.parse(phoneNo);
				 */

				/*
				 * intentView.setAction(Intent.ACTION_CALL); String
				 * phoneNo="tel:1234567890"; Uri u=Uri.parse(phoneNo);
				 * intentView.setData(u);
				 */

				Intent inCame = new Intent();
				inCame.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
				// startActivity(inCame);

				startActivityForResult(inCame, 201);

			}
		});

	}

	@Override
	protected void onActivityResult(int arg0, int arg1, Intent arg2) {
		// TODO Auto-generated method stub
		super.onActivityResult(arg0, arg1, arg2);
		if (arg0 == 201) {
			Bundle myBundle = arg2.getExtras();
			Bitmap bmp = (Bitmap) myBundle.get("data");
			imageView.setImageBitmap(bmp);

		}

	}

}
