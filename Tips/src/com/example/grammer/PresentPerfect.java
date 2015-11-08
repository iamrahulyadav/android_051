package com.example.grammer;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class PresentPerfect extends Activity {
	TextView textview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.presentperfect);
		textview = (TextView) findViewById(R.id.textViewpresentperfect);
		String str = "\n\n वे सारे कार्य जो वर्तमान में पूर्ण हो चुके है,जो खत्म हो चुके है, अब करने के लिए कुछ बचा नहीं है ,उसे present perfect tense से बनाया जाता है |\n \n पहचान:- चुका है, चुकी है, आया है, गया है, मिले है आदि \n (A)    Sub+have/has+v3+obj\n (N)    Sub+have/has+not+v3+obj\n (I)      I.W.+have/has+sub+v3+obj+?\n (I.N)  I.W.+have/has+not+sub+v3+obj+?\n (I.N)  I.W.+have/has+sub+not+v3+obj+?\n \n Note:- He, she, it, noun singular के साथ has लगेगा |\n I, we, you, they, noun plural के साथ have लगेगा |\n1.  हम चाय ले चुके है |\n we have taken tea. \n2. मैं एक लैटर लिख चूका हुँ| \n I have written a letter. \n 3. वह Plane से आया है |\n He has come by plane . \n\nSelf Practice :- \n * वह शादी कर चुकी है |\n * क्या तुमने सर से परमिशन ली है ? \n * ट्रेन प्लेटफॉर्म no. 2 पर आ चुकी है |\n * फर्स्ट कौन आया है ? \n * तुम यहाँ क्यों आये हो ? \n * मैंने पैसे नहीं चुराए है \n * राधा नहीं गयी है |\n * क्या वह बाइक खरीद चुका है ? \n * बच्चे गाना गा चुके है|\n * वह सो चूका है । \n * अभी 7 बजे है । \n * हम हॉकी खेल चुके है । \n * राम ने  सारे  कपड़े धो चूका है । \n * उसने तुम्हे एक उपहार भेजा है । \n * राम अभी आया है । \n * वह लंच नही खा चूका है । \n * उसने तुम्हे धोखा नहीं दिया । \n * सीता  सारे कपड़े नहीं धो चुकी है । \n * राधा ने पत्र नहीं पढ़ा है । \n * मैने अपना काम पूरा नहीं किया है । \n * क्या हम हॉकी खेल चुके है ? \n * क्या राम ने  सारे  कपड़े धो चूका है ? \n * क्या उसने तुम्हे एक उपहार भेजा है ?  \n * क्या राम अभी आया है? \n * क्या सीता खाना बना चुकी है ? ";
		textview.setText(str);
         
	}
}
