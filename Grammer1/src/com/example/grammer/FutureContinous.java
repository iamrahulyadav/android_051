package com.example.grammer;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class FutureContinous extends Activity {
	TextView textview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.futurecontinous);
		textview = (TextView) findViewById(R.id.textViewfuturecontinous);
		String str="\n\nपहचान :-  रहा होगा रही होगी रहे होंगे \n\n(A) Sub+will+be+v4+obj\n(N) Sub+will+not+be+v4+obj\n (I)  I.W.+will+sub+be+v4+obj+?\n (I.N)   I.W.+will+not+sub+be+v4+obj+?\n\nPractice:-\n 1. वह सो रहा होगा| \n 2. मोहन घूमने जा रहा होगा | \n 3. कल मैं अमेरिका जा रहा होऊगा | \n 4. क्या तुम कल पार्टी में जा रहे होगे |\n 5. मै शाम को थीसिस  लिख रहा होगा । \n 6.वे शाम को क्रिकेट खेल रहे होंगे । \n 7. मै शाम को थीसिस नहीं  लिख रहा होगा ।  \n 8. वे शाम को क्रिकेट नहीं खेल रहे होंगे ।  \n 9. क्या वह आपकी प्रतिक्छा कर रही होगी ? \n 10. क्या मोहन पढ़ रहा होगा ? \n 11. क्या वह कपड़े धो रहा होगा ? \n 12. क्या मोहन कार साफ कर रहा होगा ? \n 13. क्या राम पत्र लिख रहा होगा ? \n 14. क्या सीमा  नाच रही होगी ? \n 15. क्या सुरेश गाना गा रहा होगा ?";
		textview.setText(str);
		
         
	}
}
