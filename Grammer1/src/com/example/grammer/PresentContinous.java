package com.example.grammer;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class PresentContinous extends Activity {
	TextView textview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.presentcontinous);
		textview = (TextView) findViewById(R.id.textViewpresentcontinous);
		String str = "\n\nयदि कोई  व्यक्ति या हम एक ऐसे कार्य के बारे में बताना चाहते है जिसे हम अभी भी कर रहे है कार्य चल रही है खत्म  नहीं हुई  है. तो present continuous  का प्रयोग करेंगे\n\nपहचान :- रहा है, रही है, रहे है\n(A)   Sub+is/am/are+v4+obj\n(N)  Sub+is/am/are+not+v4+obj\n (I) I.W.+is/am/are+sub+v4+obj+?\n (I.N) \n I.W.+is/am/are+not+sub+v4+obj+?\n Note:- He, She, It, Noun singular ---I\n I--------------Am \n We, You, They, Noun Plural---Are\n \n For Examples\n 1. मै एक लैटर लिख रहा हुँ |\nI am writing a letter. \n 2. वह एक कार चला रहा है |\n He is driving a car . \n 3. अनीता गाना गा रही है |\n Anita is singing a song. \n\nSelf Practice:- \n * मैं आ रहा हुँ |\n *क्या तुम क्लास जा रहे हो ? \n * मोहन स्कूल नहीं जा रहा है |\n * मैं टी वी देख रहा हुँ|\n * राहुल पिकनिक क्यों नहीं जा रहा है |\n * तुम फिर लेट आ रहे हो |\n * नीता खाना बनाना सीख रही है |\n * क्या वह अभी नहीं सो रहा है ? \n * मोहन गाड़ी चला रहा है |\n * क्या मै अंगूर खा रही हूँ ? \n * क्या मै खेल रहा हूँ ? \n * क्या वह नहा रहा है ? \n * क्या वह खाना पका रही है? \n * क्या वे बाजार जा रहे है ? \n * वह नहा रहा है । \n * वह खाना पका रही है। \n * वे बाजार जा रहे है । \n * हम गाना गा  रहे है । \n * हम स्कूल जा रहे है । \n * वे बाजार नहीं जा रहे है । \n * हम गाना नहीं गा  रहे है \n * हम स्कूल नहीं जा रहे है । \n * हम पूजा नहीं कर रहे है ।  \n * बिल्ली दूध नहीं पी रही है । ";
		textview.setText(str);
		
         
	}
}
