package com.example.listviewdemo;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class WhrereAreYouFrom extends Activity {
	ListView listView;
	ArrayAdapter<String>arrayAdapter;
	ArrayList<String>arrayList = new ArrayList<String>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.whereareufromt);
		
		arrayList.add("-> Mahesh: नमस्ते  Hello.");
		arrayList.add("-> Priti: नमस्ते  Hi.");
		arrayList.add("-> Mahesh: आप कैसे है?  How are you?");
		arrayList.add("-> Priti:	मैं अच्छा/अच्छी हूँ. आप कैसे है?                 I'm good. How are you?");
		arrayList.add("->Mahesh:	अच्छा. क्या आप अंग्रेजी बोलते है?  Good. Do you speak English?");
		arrayList.add("-> Priti:	थोडा बहुत. क्या आप अमरीकी है?                  A little. Are you American?");
		arrayList.add("->Mahesh:	जी हाँ   Yes.");
		arrayList.add("-> Priti:	आप कहाँ से है?  Where are you from?");
		arrayList.add("-> Mahesh:	मैं दिल्ली  से हूँ  I'm from Delhi.");
		arrayList.add("-> Priti:	आप को मिलकर अच्छा लगा  Nice to meet you.");

	    arrayList.add("-> Mahesh:	आप को मिलकर भी अच्छा लगा   Nice to meet you too.");
	   
		listView = (ListView) findViewById(R.id.listView2);
		arrayAdapter = new ArrayAdapter<String>(WhrereAreYouFrom.this, android.R.layout.simple_list_item_1, arrayList);
		listView.setAdapter(arrayAdapter);
		
	}

}
