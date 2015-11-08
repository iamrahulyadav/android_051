package com.example.grammer;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Emotions extends Activity {
	TextView textview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.emotions);
		textview = (TextView) findViewById(R.id.textViewemotions);
		String str="\n\nआज हम अंग्रेज़ी में भावनाओं की अभिव्यक्ति वाले शब्द लेकर आए हैं, जैसे, ख़ुशी, ग़म, आशा, निराशा वग़ैरह. अंग्रेज़ी में भावना के लिए इमोशन्स (Emotions) का प्रयोग करते हैं. \n\nविभिन्न शब्दकोशों में इमोशन की अभिव्यक्ति के लिए ये शब्द दिए गए हैं. आइए देखते हैं हमारी भावनाएं क्या कहती हैं और इनका प्रयोग कैसे करते हैं? \n\nAcceptance (ऐक्सेप्टैंस) यानि स्वीकृति या स्वीकरण या रज़ामंदी\nप्रयोग: The idea rapidly gained acceptance in the political circle. \n\nAffection (अफ़ेक्शन) अनुराग, स्नेह\nप्रयोग: Teachers have deep affection for their students. \n\nAnger (ऐंगर) क्रोध, रोष, ग़ुस्सा\nप्रयोग: He has a lot of anger towards his father who treated him badly as a child. या I cannot hold my anger. \n\nAnnoyance (अनोयांस) संतापन, नाराज़गी, \n प्रयोग: I can understand your annoyance. She is fit for childcare. \n\nAnxiety (ऐंज़ाइटी) चिंता, फ़िक्र\nप्रयोग: Her son is a source of considerable anxiety. \n\nApathy (अपैथी) उदासीनता, भावशून्यता\nप्रयोग: I attended such a class where apathy existed among  the students and teachers. \n\nAwe (एव) श्रृद्धायुक्त विस्मय, रौब, भय\nप्रयोग: The sight of the saint filled the people with awe. या वर्ब के तौर पर I was awed but not frightened at coming near the lion in the zoo. \n\nBoredom (बोरडम) ऊब, ऊबाऊपन, नीरस्ता, उचाट\nप्रयोग: They came out in stormy weather out of sheer boredom. \n\nCompassion (कमपैशन) करूणा, तरस, रहम\nप्रयोग:The company does not show any compassion towards their employees at this hour of great depression. \n\nContempt (कौंटेम्पट) तिरस्कार, हिक़ारत, अपमान, घृणा\nप्रयोग: She makes no attempt to conceal her contempt for beggars. \n\nCuriosity (क्यूरियोसिटी) कुतूहल, जिज्ञासा, जानने की दिलचस्पी\nप्रयोग: I am burning with curiosity—who will win the series in New Zealand. \n\nDepression (डिप्रेशन) दबाव-तनाव, उदासी, अवनति\nप्रयोग: It is hard to get out from depression very quickly. It’s advisable to take professional help if you’re suffering from depression. \n\nDesire (डिज़ायर) ख़्वाहिश, अभिलाशा, इच्छा, कामना\nप्रयोग: He does not have much desire for wealth. It’s difficult to suppress the desire of the people for a long. It’s an old saying, first deserve then desire. \n\nDisappointment (डिसअप्वांइंटमेंट) निराशा, विफलता, मायूसी\nप्रयोग: To my disappointment, he decided to leave me. It was a great disappointment for the people to watch India losing. \n\nDisgust (डिसगस्ट) विरक्ति, घृणा, खीज\nप्रयोग: He left the hall in sheer disgust. Doesn’t all these violence on TV disgust you.";
		textview.setText(str);
         
	}
}
