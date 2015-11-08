package com.example.grammer;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class FutureIndefinite extends Activity {
	TextView textview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.futureindefinite);
		textview = (TextView) findViewById(R.id.textViewfutureindefinite);
		String str="\n\nयदि कोई व्यक्तिं या हम अपने किसी भविष्य कि योजना के बारे में बताना चाहते है तो  future  indefinite  का प्रयोग करेगे |\nपहचान :- आयेगा, जायेगा, खायेगा, खायेगी, खरीदेगी, बताएगी |\n(A) Sub+will+v1+obj\n (N) Sub+will+not+v1+obj\n (I) I.W.+will+sub+v+obj+?\n (I.N) I.W. +will+not+sub+v1+obj+?\n \n Practice:-\n 1.हम कल घूमने जायेगे |\n 2.क्या आप केक लेगे ? \n 3.राहुल कल फन सिटी नहीं जायेगा |\n 4.तुम पार्टी में कब आओगे ? \n 5.अब  से  तुम काम करोगे |\n 6.मोहन कल एडमिशन लेगा |\n 7.क्या  तुम एक काम करोगे ?\n 8.हम पार्टी में नहीं जायेगे |\n 9.क्या तुम मुझ से दोस्ती करोगे ? \n 10.राधा मंदिर नहीं जायेगी |\n 11.मै कल बाजार जाऊँगा । \n 12.विमला भोजन पकायेगी । \n 13.वह यह काम आज करेगा । \n 14 हम आज आम खायेंगे । \n 15.वह रायपुर जायेगा । \n 16.वह यह काम आज नहीं करेगा । \n 17.हम आज आम नहीं खायेंगे । \n 18.वह रायपुर नहीं जायेगा । \n 19.वह पत्र नहीं लिखेगा । \n 20.तुम कल स्कूल नहीं जाओगे । \n 21.क्या वह पत्र लिखेगा ? \n 22.क्या तुम कल स्कूल जाओगे ? \n 23.क्या मै फुटबॉल खेलूँगी ? \n 24.क्या हम रात को सोयेंगे ? \n 25.क्या वह आज शाम को घूमने जायेगा ? ";
		textview.setText(str);
		
         
	}
}
