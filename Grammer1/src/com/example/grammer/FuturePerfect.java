package com.example.grammer;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class FuturePerfect extends Activity {
	TextView textview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.futureperfect);
		textview = (TextView) findViewById(R.id.textViewfutureperfect);
		String str ="\n\n वे सारे कार्य जिसे हम आने वाले भविष्य में पूर्ण रूप से कर लेंगे, Future Perfect के  माध्यम से बनायेंगे \n\n पहचान :- चूका होगा, चूकि होगी, चूके होंगे, आया होगा, बताया होगा \n  (A) Sub+will+have+v3+obj\n  (N) Sub+will+not+have+v3+obj\n  (I) I.W.+will+sub+have+v3+obj+?\n  (I.N) I.W.+will+not+sub+have+v3+obj+?\n \n  e.g \n मै 2015 तक B.com. कर चूका होऊँगा |\n  \n  I will have completed B.com by 2015. \n \n वह खाना पका चूका होगा |\n  \n  He will have cooked food. \n \n  Self Practice:- \n 1. वह सो चूका होगा |\n 2. हम घर सजा चुके होंगे |\n 3. वह भाषण दे चूका होगा |\n 4.  क्या अनीता गाना गा चुकी होगी ? \n  5. क्या वे स्कूल जा चुके होंगे ? \n 6. मोहन नहीं आया होगा |\n 7. क्या राहुल ने कुछ नहीं बताया होगा ? \n  8. मै सनिवार तक यह काम समाप्त कर चुकूँगा । \n 9. मोहन 2010 तक अपनी पढ़ाई समाप्त कर चुकेगा । \n 10.  सूरज ढलने से पहले पक्छी सो चुकेंगे । \n  11. मेरे वहाँ  पहुंचने से पहले वह जा चुकेगा । \n 12. तुम्हारे जाने से पहले दीदी खाना बना चुकी होगी । \n 13. पुलिस  के आने से पहले चोर भाग चुके होंगे । \n 14. तुम दो बजे तक अपने घर तक पहुंच चुके होगे । ";
		textview.setText(str);
         
	}
}
