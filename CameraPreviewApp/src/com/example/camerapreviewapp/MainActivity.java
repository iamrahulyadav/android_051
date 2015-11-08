package com.example.camerapreviewapp;

import java.io.FileOutputStream;

import android.hardware.Camera;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	Camera cam;
	Button btCapture, btpreview;

	FrameLayout frame;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);
		btCapture = (Button) findViewById(R.id.button1);
		btpreview = (Button) findViewById(R.id.button2);

		frame = (FrameLayout) findViewById(R.id.frame1);

		// open the camera

		cam = Camera.open();

		if (cam == null)

		{
			Toast.makeText(this, "no camera.....", 3).show();
			finish();
		}

		else

		{
			// attach surfaceview to frame
			// attach frame as camera preview

			Preview preview = new Preview(this, cam);

			frame.addView(preview);

			cam.startPreview();

		}

		btCapture.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				cam.takePicture(null, null, new PictureListner());

			}
		});

		btpreview.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				cam.startPreview();

			}
		});

	}

	// eof onCreate

	class PictureListner implements Camera.PictureCallback {

		@Override
		public void onPictureTaken(byte[] data, Camera camera) {
			// TODO Auto-generated method stub

			String fileName = System.currentTimeMillis() + ".jpeg";

			String filePath = getApplicationInfo().dataDir + "/" + fileName;
			Log.e("loc:", filePath);

			try {
				FileOutputStream fout = new FileOutputStream(filePath);

				fout.write(data);

				fout.flush();
				fout.close();

				Toast.makeText(MainActivity.this, "saved at" + filePath, 5)
						.show();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

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
