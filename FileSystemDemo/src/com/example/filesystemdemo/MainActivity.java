package com.example.filesystemdemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import android.content.pm.ApplicationInfo;
import android.hardware.camera2.params.BlackLevelPattern;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends ActionBarActivity {

	EditText editNotes;
	Button btSave, btShow;

	ListView listViewNotes;
	ArrayList<String> listNotes = new ArrayList<String>();
	String filePath = "";
	ArrayAdapter<String> adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		/*
		 * // initialise data folder path
		 * 
		 * ApplicationInfo appInfo = getApplicationInfo(); final String
		 * strDataDirPath = appInfo.dataDir;
		 * 
		 * filePath = strDataDirPath + "/notes.txt";
		 */

		// init path 4 memry crd

		String sdCardPath = Environment.getExternalStorageDirectory().getPath();
		filePath = sdCardPath + "/akhil.txt";

		// initialise ui

		editNotes = (EditText) findViewById(R.id.editText1);
		btSave = (Button) findViewById(R.id.button1);
		btShow = (Button) findViewById(R.id.button2);
		listViewNotes = (ListView) findViewById(R.id.listView1);

		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, listNotes);

		btSave.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				// String officeDirPAth=getApplicationInfo().dataDir+"/office";

				/*
				 * String officeDirPath = strDataDirPath + "/office";
				 * 
				 * File officeFilesDir = new File(officeDirPath);
				 * 
				 * if (!officeFilesDir.exists()) {
				 * 
				 * officeFilesDir.mkdir();
				 * 
				 * }
				 * 
				 * // init file of notes.txt
				 * 
				 * filePath = officeDirPath + "/notes.txt";
				 */
				// save the data

				String strNotes = editNotes.getText().toString();

				try {
					FileWriter writer = new FileWriter(filePath, true);
					writer.write(strNotes + "\n");
					writer.flush();
					writer.close();

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				editNotes.setText("");
			}

		});

		btShow.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				// openfile to read data

				try {
					FileReader reader = new FileReader(filePath);
					BufferedReader bufferReader = new BufferedReader(reader);

					while (true) {

						String s = bufferReader.readLine();
						if (s == null)
							break;

						listNotes.add(s);
					}

					bufferReader.close();
					// adapter.notifyDataSetChanged();
					listViewNotes.setAdapter(adapter);

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

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
