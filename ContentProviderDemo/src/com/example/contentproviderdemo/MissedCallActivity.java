package com.example.contentproviderdemo;

import java.util.ArrayList;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CallLog;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MissedCallActivity extends ActionBarActivity {

	ListView listViewData;

	ArrayList<String> listData = new ArrayList<String>();
	ArrayAdapter<String> adapter;
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		listViewData = (ListView) findViewById(R.id.listView1);

		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, listData);
		listViewData.setAdapter(adapter);

		ContentResolver resolver = getContentResolver();

		// to read sms data the uri is

		// Uri u = ContactsContract.Contacts.CONTENT_URI;
		// Uri u = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;

		Uri u = Uri.parse("content://call_log/calls");

		Log.e("missed call log uri is", u.toString());
		

		Cursor cursor = resolver.query(u, null, null, null, null);

		// cursor.getColumnCount();
		// cursor.getColumnName(columnIndex);

		for (int i = 0; i < cursor.getColumnCount(); i++) {
			String s = cursor.getColumnName(i);

			Log.e("missed  call name", s);

		}
		
		cursor.close();

		// get cursor with using coloumn name

		String colName[] = { "number","name","type" };

		cursor = resolver.query(u, colName, null, null, null);

		while (cursor.moveToNext()) {
			String number = cursor.getString(0);
			String name = cursor.getString(1);
			

			String type = cursor.getString(2);

			String data = number + ":" + name+ ":" +type ;
			
			if( Integer.parseInt(type)==3)
			{

			listData.add(data);
			}
		}
		cursor.close();
		adapter.notifyDataSetChanged();

	}
}
