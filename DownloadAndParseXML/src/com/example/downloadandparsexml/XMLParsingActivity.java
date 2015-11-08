package com.example.downloadandparsexml;

import java.io.FileReader;
import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class XMLParsingActivity extends ListActivity {

	ListView listViewPlants;
	ArrayList<String> listPlantData = new ArrayList<String>();
	ArrayAdapter<String> adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		listViewPlants = getListView();
		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, listPlantData);
		listViewPlants.setAdapter(adapter);

		// init parser

		String filePath = getApplicationInfo().dataDir + "/plant.xml";
		Log.e("path:", filePath);

		try {
			XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
			factory.setNamespaceAware(true);

			XmlPullParser parser = factory.newPullParser();
			// attach file with parser
			FileReader reader = new FileReader(filePath);
			parser.setInput(reader);

			// start parsing
			int eventType = parser.next();

			while (eventType != XmlPullParser.END_DOCUMENT) {
				// check if we are at start of plant tag

				if (eventType == XmlPullParser.START_TAG
						&& parser.getName().equals("PLANT")) {

					// read each inner tag of plant tag
					while (true) {
						// if encounter eof plant tag
						if (eventType == XmlPullParser.END_TAG
								&& parser.getName().equals("PLANT")) {
							break;
						}
						// if it is start of common tag
						if (eventType == XmlPullParser.START_TAG
								&& parser.getName().equals("COMMON")) {
							// read text of common tag
							eventType = parser.next();
							if (eventType == XmlPullParser.TEXT) {
								listPlantData.add(parser.getText());
								adapter.notifyDataSetChanged();
								Log.e("xml", parser.getText());
							}
						}// eof common if
						eventType = parser.next();
					}// eof plant while

				}// eof plant if
				eventType = parser.next();

			}// eof while
			reader.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
