package com.example.listviewdemo;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class BuyShirt extends Activity {
	ListView listView;
	ArrayAdapter<String>arrayAdapter;
	ArrayList<String>arrayList = new ArrayList<String>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.buyingshirt);
		arrayList.add("-> Customer: I’d like to buy a shirt. (मुझे एक क़मीज़ खरीदनी है.)");
		arrayList.add("-> Shop keeper: What type of shirt do you want? (आपको कैसी क़मीज़ चाहिए?)");
		arrayList.add("-> Customer: I want cotton shirt. (मुझे एक सूती क़मीज़ चाहिए.)");
		arrayList.add("-> Shop keeper: You can find it here. (आप यहाँ देख सकते हैं.)");
		arrayList.add("-> Customer: I’m just looking. (मैं बस देख रहा हूँ)");
		arrayList.add("-> How much is this? (यह कितने का है?)");
		arrayList.add("-> Shop keeper: It costs Rs.1000/- .(यह हज़ार रुपये का है.)");
		arrayList.add("-> Customer: It’s too expensive.(यह बहुत महँगा है.)");
		arrayList.add("-> Shop keeper: But the material is very good. (पर कपड़ा बहुत अच्छा है.)");
		arrayList.add("-> You give Rs. 900/-.(आप नौ सौ दीजिए.)");
		arrayList.add("-> Customer: Do you accept credit cards? (क्या आप क्रेडिट कार्ड स्वीकार करते हैं?)");

	    arrayList.add("-> Shop keeper: Of course .Give me .(जरुर,मुझे दीजिए.)");
	    arrayList.add("-> What else do you want? (आपको और क्या चाहिए ?)");
        arrayList.add("-> Customer: That’s all, thanks.(बस इतना ही, धन्यवाद)");
        arrayList.add("-> Shop keeper: Come again.(फिर आईएगा.)");
        arrayList.add("-> Customer: Sure.(बेशक.)");

		listView = (ListView) findViewById(R.id.listView1);
		arrayAdapter = new ArrayAdapter<String>(BuyShirt.this, android.R.layout.simple_list_item_1, arrayList);
		listView.setAdapter(arrayAdapter);
		
	}

}
