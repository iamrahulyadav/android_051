package com.example.alertdialog_demo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

	TextView textData;
	Button btMovie;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		textData = (TextView) findViewById(R.id.textView1);
		btMovie = (Button) findViewById(R.id.button1);

		btMovie.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				AlertDialog.Builder builder = new AlertDialog.Builder(
						MainActivity.this);
				builder.setTitle("weekend planning");

				builder.setMessage("Movie today?");

				builder.setIcon(R.drawable.ic_launcher);

				// set buttond

				builder.setPositiveButton("sure",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {

								textData.setText("Fury");

							}
						});
				builder.setNegativeButton("No", null);
				builder.setNeutralButton("I m busy", null);

				AlertDialog alert = builder.create();

				alert.show();

			}
		});

	}

}
