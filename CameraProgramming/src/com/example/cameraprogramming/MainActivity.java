package com.example.cameraprogramming;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Camera;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	ImageView imageView;
	Button btCapture;

	Camera cam;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		imageView = (ImageView) findViewById(R.id.imageView1);
		btCapture = (Button) findViewById(R.id.button1);

		
		
		btCapture.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				// connect camera

				cam = Camera.open();
				
				if (cam == null) {
					Toast.makeText(MainActivity.this, "no camera", 5).show();
					finish();
				}
				else
					
				cam.takePicture(null, null, new PictureListner());

			}
		});

	}

	class PictureListner implements Camera.PictureCallback {

		@Override
		public void onPictureTaken(byte[] data, Camera camera) {

			Bitmap bmp = BitmapFactory.decodeByteArray(data, 0, data.length);

			imageView.setImageBitmap(bmp);

			
		}

	}

}
