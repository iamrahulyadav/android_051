package com.wimc.implicitintents;

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
        setContentView(R.layout.main);
        btLaunch=(Button)findViewById(R.id.button1);
        imageView=(ImageView)findViewById(R.id.imageView2);
        btLaunch.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intentView=new Intent();
				
				/*
				intentView.setAction(Intent.ACTION_VIEW);
				String url="http://www.yahoo.com";
				Uri u=Uri.parse(url);
				*/
				
				/*
				 intentView.setAction(Intent.ACTION_DIAL);
				String phoneNo="tel:1234567890";
				Uri u=Uri.parse(phoneNo);*/
				
				
				 /*intentView.setAction(Intent.ACTION_CALL);
				String phoneNo="tel:1234567890";
				Uri u=Uri.parse(phoneNo);
				intentView.setData(u);*/

			

				
				  Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
				    if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
				        startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE); }
				    
				
				
				
				//
				
				startActivity(intentView);
			}
		});
        
    }
    
   @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imageView.setImageBitmap(imageBitmap);
        }
    
   }
}
   

