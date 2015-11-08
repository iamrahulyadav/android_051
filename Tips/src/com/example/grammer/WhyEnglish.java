package com.example.grammer;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class WhyEnglish extends Activity {
	TextView textview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.whyenglish);
		textview = (TextView) findViewById(R.id.textViewpastindefinite);
		String str="\n\nकिसी बीती हुए घटना को  सिलसिले वार बताने के लिए  past indefinite का प्रयोग किया जाता है |\n पहचान :- आया, गया, खाया, पिया, आयी, बताई आदि \n\n यदि कोई व्यक्ति या हम अपनी कोई पुराणी आदत को बताना चाहते है तो past indefinite का प्रयोग किया जाता है |\n पहचान :- ता था, ती  थी, ते थे \n (A) sub+v2+obj\n(I)sub+did+not+v1+obj\n (I) IW+did+sub+v1+obj+?\n (I.N) I.W+did+not+sub+v1+obj+?\n\nPractice:- \n 1. आज तुमने क्या किया |\n 2.  पापा आज ऑफिस नहीं गये |\n 3.  आपने मुझे क्यों बुलाया |\n 4.  तुम घर कब गये ? \n 5.  वह गिर गया |\n 6.  मैंने पैसे खो दिया |\n 7.  मोहन नहीं आता था |\n 8.  5 साल पहले मैं  क्रिकेट खेलता था |\n 9.  राहुल कोचिंग से चला गया |\n 10.  राधा यहाँ नहीं आया करती थी |\n 11.  हमने फल खाये । \n 12.  वे मेरे घर आये । \n 13.  तुमने हमेशा मुझे डाटा । \n 14.  वह मेरा नाम भूल गया । \n 15.  मोहन रोया । \n 16.  हम भोपाल में रहे थे । वह भिलाई में नहीं पढ़ी । \n 17.  उसने मुझे गाली  नहीं दी । \n 18.  हमने फल  नहीं खाये । \n 19.  वे मेरे घर  नहींआये । \n 20.  तुमने हमेशा मुझे नहीं  चाहा  । \n 21.  वह मेरा नाम  नहीं भूल गया । \n 22.  क्या वे मेरे घर आये ? \n 23.  क्या तुमने हमेशा मुझे डाटा ? \n 24.  क्या वह मेरा नाम भूल गया ?";
		textview.setText(str);
		
         
	}
}
