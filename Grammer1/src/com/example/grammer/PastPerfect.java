package com.example.grammer;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class PastPerfect extends Activity {
	TextView textview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pastperfect);
		textview = (TextView) findViewById(R.id.textViewpastperfect);
		String str ="\n\n वे सारे कार्य जो बीते हुए समय में पूर्ण रूप से हो चुके थे या खत्म हो चुके थे उसे past perfect tense  के माध्यम से बनायेंगे |\n \n पहचान :- चूका था, चुकी थी, आया था, लिया था, आयी थी, गयी थी, गये थे \n   (A)   Sub+had+v3+obj\n   (N)   Sub+had+not+v3+obj\n(I) I.W.+had+sub+v3+obj+?  \n (I.N) I.W. +had+not+sub+v3+obj+?\n \n e.g\n हम चाय ले चुके थे |\n We had taken tea. \n वह पैसे दे चुकी थी |\n He had given money. \n मै बच्चो को पढ़ा चूका था|\n I had taught the children.  \n \n Self Practice \n 1.कल तुम कहाँ गये थे ? \n 2.कल बारिश हुई थी |\n 3.कल कौन नहीं आया था ? \n 4.आपने क्या पूछा था ? \n 5.राधा नहीं आयी थी |\n 6.मैं मार्केट नहीं गयी थी |\n 7.आपने क्यों नहीं पूछा था ? \n 8.हम पिकनिक गये थे |\n 9.मोहन जा चूका था |\n 10.वह 8बजे से पहले नहा चूका था ।\n 11.पापा जी कहानी सुना चुके थे । \n 12.मोहन एक किताब लिख चूका था । \n 13.मालिक  के आने से पहले नौकर सो चूका था । \n 14.वर्ष के सुरु होने से पहले हम हॉकी खेल चुके थे । उसके शुरू  करने से पूर्व मै अपना काम पूरा कर चुकी थी । \n 15.नेता के भाषण पूरा करने से पहले भीड़  जा चुकी थी । \n 16.स्कुल के खुलने से पूर्व वह कोर्स पूरा कर चूका था । \n 17.बरसात के शुरू होने से पूर्व हम घर पहुँच गये थे ।  \n 18.रीमा ने 6 बजे से पूर्व खाना नहीं बनाया था । \n 19.सोने से पहले मैने दीपक नहीं जलाया । \n 20.मेरे घर पहुँचने तक पापा नहीं  गये थे । \n 21.बारिश के आने से पहले मकान नहीं बना था । \n 22.राहुल एक किताब नहीं  लिख चूका था । \n 23.सीमा के आने से पहले राम ऑफिस नहीं जा चूका";
		textview.setText(str);
         
	}
}
