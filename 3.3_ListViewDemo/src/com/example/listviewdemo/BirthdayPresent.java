package com.example.listviewdemo;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class BirthdayPresent extends Activity {
	ListView listView;
	ArrayAdapter<String> arrayAdapter;
	ArrayList<String> arrayList = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.birthdaypresetn);

		listView = (ListView) findViewById(R.id.listView4);

		arrayList.add("Rahul:	बबीता , अन्दर आईये  Babita, come in.");
		arrayList.add("Babita:	जन्मदिन मुबारक हो  Happy Birthday!");
		arrayList
				.add("Rahul:	शुक्रिया. मुझे यकीन नहीं आ रहा है कि आपको वह याद रहा  Thanks. I can't believe you remembered that.");
		arrayList
				.add("Babita:	मेरे कंप्यूटर में कैलेंडर है. वह ऐसी चीज़ें याद रखने में मेरी मदद करती है. आप क्या करने वाले है?  Well, I have a calendar in my computer. It helps me remember things like that. What are you up to?");
		arrayList
				.add("Rahul:	मैं एक किताब पढ़ रहा हूँ जो मेरे चचेरे भाई ने मुझे अपने जन्मदिन के लिए दिया था  I'm reading a book my cousin gave me for my birthday.");
		arrayList
				.add("Babita:	मुझे देखने दीजिये. मेरे पास घर में यह किताब है. मैं अभी आपको एक तोफा देना चाहती हूँ.  Let me see. Oh, I have this book at home. I want to give you a present too.");
		arrayList
				.add("Rahul:	वाह, गिटार है. मेरे पास पहले से एक है, लेकिन मुझे यह बेहतर लगता है. शुक्रिया  Wow, it's a guitar. I already have one, but I like this one better. Thank you.");
		arrayList
				.add("Babita:	धन्यवाद. क्या आप गिटार बजाना जानते है?  You're welcome. Do you know how to play the guitar?");
		arrayList
				.add("Rahul:	हाँ, मैं बजाना जानता हूँ. जब मैं छोटा था, तब मेरे पिताजी ने मुझे सिखाया था  Yeah, I know how to play. My father taught me when I was young.");
		arrayList
				.add("Babita:	क्या आप उसको अब बजायेंगे? मैं कुछ संगीत सुनना चाहती हूँ  Will you play it now? I want to listen to some music.");
		arrayList
				.add("Rahul:	ठीक है. क्या आप इसको जानती है?  OK. Do you know this one?");
		arrayList
				.add("Babita:	हाँ, मैंने उसको सुना है. मैं जब मध्य विद्यालय में थी, तब वह गाना गा सकती थी  Yeah, I've heard that one. I could sing that song when I was in middle school.");
		arrayList
				.add("Rahul:	यह पुराना वाला है. मुझे बहुत बूढा महसूस कराता है. जब में महाविद्यालय में था, तब हर वक़्त रेडियो पर बजाते थे  It's an old one. It makes me feel old. When I was in college they use to play it on the radio all the time.");

		arrayAdapter = new ArrayAdapter<String>(BirthdayPresent.this,
				android.R.layout.simple_list_item_1, arrayList);
		listView.setAdapter(arrayAdapter);

	}
}
