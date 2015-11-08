package com.example.grammer;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class PastContinous extends Activity {
	TextView textview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pastcontinous);
		textview = (TextView) findViewById(R.id.textViewpastcontinous);
		String str ="\n पहचान :- रहा था,रही थी, रहे थे \n (A) sub+was/were+v4+obj\n (N)  sub+was/were+not+v4+obj\n (I) I.W+was/were+sub+v4+obj+?\n (I.N) I.W+was/were+not+sub+v4+obj+?\n 1. क्या कल बारिश हो रही थी ? \n Yesterday it was raining.\n 2. हम डिनर कर रहे थे |\n We were taking diner.\n 3. क्या वह जा रही थी ? \n Was she going? \n\nPractice:- \n 1मोहन टी वी  देख रहा था |\n 2तुम कैसे जा रहे थे ? \n 3वह पढ़ाई  नहीं कर रहा था |\n 4राधा एग्जाम क्यों नहीं दे रही थी| \n 5हम मुम्बई नहीं जा रहे थे |\n 6मोहन पेड़ो में पानी दे रहा था । \n 7वह बर्तन साफ कर रही थी । \n 8हम सोर मचा रहे थे । \n 9चिड़िया आकाश में उड़ रही थी । \n 10मेरे पापा पत्र लिख रहे थे । तुम चोर को पकड़ रहे थे । \n 11लड़के चाय पि रहे थे । \n 12तुम चोर को नहीं पकड़ रहे थे । \n 13लड़के चाय नहीं पि रहे थे । \n 14हम स्कुल नहीं जा रहे थे । \n 15वे फूल नहीं तोड़ रहे थे । \n 16क्या हम भोजन पका रहे थे ? क्या मोहन पेड़ो में पानी दे रहा था ? \n 17क्या वह बर्तन साफ कर रही थी ? \n 18क्या हम सोर मचा रहे थे ? \n 19क्या चिड़िया आकाश में उड़ रही थी ? \n 20क्या मेरे पापा पत्र लिख रहे थे ? \n 21क्या तुम चोर को पकड़ रहे थे ?";
		textview.setText(str);
		
         
	}
}
