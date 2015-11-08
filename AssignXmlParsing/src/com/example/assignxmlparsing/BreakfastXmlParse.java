package com.example.assignxmlparsing;

import java.io.FileReader;
import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class BreakfastXmlParse extends ListActivity {

	ListView listViewFood;
	ArrayList<Breakfast> listFoodData = new ArrayList<Breakfast>();
	ArrayAdapter<Breakfast> adapter;

	Breakfast bk;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		listViewFood = getListView();
		adapter = new ArrayAdapter<Breakfast>(this,
				android.R.layout.simple_list_item_1, listFoodData);
		listViewFood.setAdapter(adapter);

		// init parser

		String filePath = getApplicationInfo().dataDir + "/breakfast.xml";

		listViewFood.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {

				Breakfast s = adapter.getItem(arg2);
				Toast.makeText(
						BreakfastXmlParse.this,
						s.getName() + ":" + s.getPrice() + ":"
								+ s.getDescription() + ":" + s.getCalories(), 3)
						.show();

			}

		});

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
						&& parser.getName().equals("food")) {

					String name = "";
					String price = "";
					String calorie = "";
					String desc = "";

					bk = new Breakfast(name, price, desc, calorie);

					// read each inner tag of plant tag
					while (true) {

						// if encounter eof plant tag
						if (eventType == XmlPullParser.END_TAG
								&& parser.getName().equals("food")) {
							break;
						}
						// if it is start of common tag
						if (eventType == XmlPullParser.START_TAG
								&& parser.getName().equals("name"))

						{
							// read text of common tag
							eventType = parser.next();
							if (eventType == XmlPullParser.TEXT) {

								name = parser.getText();
								bk.setName(name);
								// listPlantData.add(parser.getText());
								// adapter.notifyDataSetChanged();

								Log.e("plant name", parser.getText());
							}
						}// eof common if
						if (eventType == XmlPullParser.START_TAG
								&& parser.getName().equals("price"))

						{
							// read text of common tag
							eventType = parser.next();
							if (eventType == XmlPullParser.TEXT) {

								price = parser.getText();
								bk.setPrice(price);
								// listPlantData.add(parser.getText());
								// adapter.notifyDataSetChanged();
								Log.e("xml Price", parser.getText());
							}

						}

						if (eventType == XmlPullParser.START_TAG
								&& parser.getName().equals("description"))

						{
							// read text of common tag
							eventType = parser.next();
							if (eventType == XmlPullParser.TEXT) {

								desc = parser.getText();
								bk.setDescription(desc);
								// listPlantData.add(parser.getText());
								// adapter.notifyDataSetChanged();
								Log.e("xml Price", parser.getText());
							}

						}

						if (eventType == XmlPullParser.START_TAG
								&& parser.getName().equals("calories"))

						{
							// read text of common tag
							eventType = parser.next();
							if (eventType == XmlPullParser.TEXT) {

								calorie = parser.getText();
								bk.setCalories(calorie);
								// listPlantData.add(parser.getText());
								// adapter.notifyDataSetChanged();
								Log.e("xml Price", parser.getText());
							}

						}

						eventType = parser.next();
					}// eof food while

					listFoodData.add(bk);
					adapter.notifyDataSetChanged();

				}
				eventType = parser.next();

			}// eof while

			reader.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}