package com.example.listviewdemo;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class AskDirection extends Activity {
	ListView listView;
	ArrayAdapter<String> arrayAdapter;
	ArrayList<String> arrayList = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.askdirection);

		arrayList.add("->Ritika:	नमस्ते गौरव Hi Gaurav.");
		arrayList
				.add("-> Gaurav:	नमस्ते रितिका ,क्या चल रहा है? Hi Ritika. What's up?");
		arrayList
				.add("-> Ritika:	मैं हवाई अड्डे को ढूंढ रही हूँ. क्या आप मुझे बता सकते है कि वहाँ कैसे जाना है? I'm looking for the airport. Can you tell me how to get there?");
		arrayList
				.add("->Gaurav:	नहीं, माफ़ कीजिये. मुझे पता नहीं No, sorry. I don't know.");
		arrayList
				.add("->Ritika:	मुझे लगता है कि हवाई अड्डा जाने के लिए मैं subway ले सकती हूँ. क्या आपको पता है कि subway कहाँ है?  I think I can take the subway to the airport. Do you know where the subway is?");
		arrayList.add("->Gaurav:	बिलकुल, वो वहाँ है  Sure, it's over there.");
		arrayList
				.add("->Ritika:	कहाँ? मुझे दिख नहीं रही है.  Where? I don't see it.");
		arrayList.add("-> Gaurav:	सड़क के उस पार Across the street.");
		arrayList
				.add("->Ritika:	अच्छा, अब देख रही हूँ. शुक्रिया.  Oh, I see it now. Thanks.");
		arrayList.add("->Gaurav:	कोई बात नहीं  No problem.");
		arrayList
				.add("->Ritika:	क्या आपको पता है कि यहाँ आसपास कहीं शौचालय है या नहीं?  Do you know if there's a restroom around here?");
		arrayList
				.add("->Ritika:	क्या आपको पता है कि यहाँ आसपास कहीं शौचालय है या नहीं?  Do you know if there's a restroom around here?");
		arrayList
				.add("->Ritika:	क्या आपको पता है कि यहाँ आसपास कहीं शौचालय है या नहीं?  Do you know if there's a restroom around here?");
		arrayList
				.add("->Ritika:	क्या आपको पता है कि यहाँ आसपास कहीं शौचालय है या नहीं?  Do you know if there's a restroom around here?");
		arrayList
				.add("->Gaurav:	हाँ, यहाँ एक है. वह दुकान के अन्दर है  Yes, there's one here. It's in the store.");
		arrayList.add("->Ritika:	शुक्रिया  Thank you.");
		arrayList.add("->Gaurav:	अच्छा, विदा लेता/लेती हूँ  Bye.");
		arrayList.add("->Ritika:	अच्छी बात है  Bye bye.");

		listView = (ListView) findViewById(R.id.listView3);
		arrayAdapter = new ArrayAdapter<String>(AskDirection.this,
				android.R.layout.simple_list_item_1, arrayList);
		listView.setAdapter(arrayAdapter);

	}
}
