package com.example.listviewdemo;

import java.util.ArrayList;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {
	ListView conversationList;
	ArrayList<Conversation> conversation = new ArrayList<Conversation>();
	customAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		conversationList = (ListView) findViewById(R.id.listView2);

		conversation.add(new Conversation(
				"A conversation on buying a shirt (एक शर्ट खरीदने पर बातचीत)"));
		conversation.add(new Conversation(
				"Ask Directions (दिशाएँ पूछना कि बातचीत)"));
		conversation.add(new Conversation(
				"Birthday present (जन्मदिन तोफ़ा कि बातचीत)"));
		conversation.add(new Conversation(
				"Conversation At A Clinic (एक क्लीनिक में बातचीत बातचीत)"));
		conversation
				.add(new Conversation(
						"Conversation Between An Mr Sharma And A Boy (एक चाचा और एक लड़का बीच बातचीत)"));
		conversation.add(new Conversation(
				"I went shopping ( खरीददारी कि बातचीत)"));
		conversation.add(new Conversation(
				"I'm a student (मैं एक विद्यार्थी हूँ कि बातचीत)"));
		conversation.add(new Conversation(
				"Studying for exams (परीक्षाओं के लिए पढ़ना कि बातचीत)"));
		conversation.add(new Conversation(
				"Where are you from ? (आप कहाँ से है? बातचीत)"));

		adapter = new customAdapter(MainActivity.this, R.layout.textview, conversation);
		conversationList.setAdapter(adapter);

		// attach listview listener
		conversationList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Intent intent;

				switch (arg2) {
				case 0:
					 intent = new Intent(MainActivity.this,
							BuyShirt.class);
					startActivity(intent);

					break;
				case 1:
					 intent = new Intent(MainActivity.this, AskDirection.class);
					startActivity(intent);
					break;
				case 2:
					 intent= new Intent(MainActivity.this, BirthdayPresent.class);
					startActivity(intent);
					break;
					
				case 3:
					 intent= new Intent(MainActivity.this, Clinic.class);
					startActivity(intent);
					break;
				case 4:
					 intent= new Intent(MainActivity.this, ConversationWithUncal.class);
					startActivity(intent);
					break;
				case 5:

					break;
				case 6:

					break;
				case 7:

					break;
				case 8:
					Intent inte = new Intent(MainActivity.this,
							WhrereAreYouFrom.class);
					startActivity(inte);
					break;
				default:
					
					break;
				}

			
			}
		});

	}

	public class customAdapter extends BaseAdapter {

		Context context;
		int resource;
		ArrayList<Conversation> conversationList;

		public customAdapter(Context context, int resource,
				ArrayList<Conversation> conversationList) {
			super();
			this.context = context;
			this.resource = resource;
			this.conversationList = conversationList;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return conversationList.size();
		}

		@Override
		public Conversation getItem(int position) {
			// TODO Auto-generated method stub
			return conversationList.get(position);
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(final int position, View convertView,
				ViewGroup parent) {
			// TODO Auto-generated method stub
			Conversation emp = conversationList.get(position);

			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

			View itemview = inflater.inflate(resource, null);

			ImageView image = (ImageView) itemview
					.findViewById(R.id.image);
			TextView textView = (TextView) itemview
					.findViewById(R.id.textView1);
			textView.setText(conversationList.get(position).getContent());
			return itemview;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		// getMenuInflater().inflate(R.menu.homemenu, menu);
		return false;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.

		return super.onOptionsItemSelected(item);
	}

}
