package com.example.listviewdemo;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ShoppingConversation extends Activity {
	ListView listView;
	ArrayAdapter<String> arrayAdapter;
	ArrayList<String> arrayList = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.shoppingconversation);

		
		
		arrayList.add("Rani: आपने आज क्या किया?  Rani, what did you do today?");
		arrayList.add("Rani:	मैं आज खरीददारी करने गयी थी  I went shopping.");
		arrayList.add("Rakesh:	क्या आपने कुछ खरीदा ?  Did you buy anything?");
		arrayList.add("Rani:	मैंने कुछ चीज़ें खरीदी  Yes, I bought a few things.");
		arrayList.add("Rakesh:	आपने क्या खरीदा?  What did you buy?");
		arrayList.add("Rani:	मैंने यह कोट खरीदा. क्या आपको यह पसन्द है?  I bought this coat. Do you like it?");
		arrayList.add("Rakesh: हाँ, मुझे यह बहुत पसन्द है. यह बहुत खूबसूरत है. आपने यह कहाँ खरीदा?  Yeah, I like it a lot. It's very pretty. Where did you buy it?");
		arrayList.add("Rani:	5th स्ट्रीट पर माल में  At the mall on 5th street.");
		arrayList.add("Rakesh:	क्या यह महँगा था?  Was it expensive?");
		arrayList.add("Rani:	नहीं, यह महँगा नहीं था. यह सेल पर सिर्फ बारह सौ रूपए के लिए था  No, it wasn't expensive. It was on sale for 1200 rupees.");
		arrayList.add("Rakesh:	वो सस्ता है  That's cheap.");
		arrayList.add("Rani:	मुझे पता है. वह बहुत ही अच्छा सौदा था.  I know. It was a really good deal.");
		arrayList.add("Rakesh: मुझे नहीं लगता कि आपको थोडी देर के लिए यह पहनना पड़ेगा. आजकल बहुत ही गरम रहा है.  I don't think you'll need to wear it for a while. It's been really hot lately.");
		
		listView = (ListView) findViewById(R.id.listView8);
		arrayAdapter = new ArrayAdapter<String>(ShoppingConversation.this,
				android.R.layout.simple_list_item_1, arrayList);
		listView.setAdapter(arrayAdapter);

	}

}
