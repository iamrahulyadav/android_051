package com.example.grammer;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class PresentIndefinite extends Activity {
	TextView textview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.presentindefinite);
		textview = (TextView) findViewById(R.id.textViewpresentindefinite);
		String str = "\n\nPresent indefinite एक महत्वपूर्ण grammar है, इसका प्रयोग हम 20 से 30 प्रतिशत करते है ,लेकिन हमें एक बात का ध्यान रखना है की present indefinite सबसे कठिन tense है |\nPresent indefinite का प्रयोग:- \n\n1. हम अपनी आदत |\n2. किसी भी News  paper  का headline |\n 3. कहानी या चुटकुला सुनाने के लिए |\n 4. किसी वस्तु कि दर या कीमत |\n 5. भविष्य की कोई घटना जो  तयशुदा समय में हो | \n 6. किसी वाक्य में खास शब्द आ जाये जैसे रोज , हरदीन , अक्सर, हमेशा ,हर मंगलवार इत्यादि | \n\nUniversal truth. \n1. किसी भी  Match  या Program का आँखों देखा प्रसारण अर्थात live commentary. \n 2. Professional कोर्स कि पूरी पढ़ाई present indefinite से कि जाती है |\n\nपहचान:-  ता है,ती है,ते हैं \n (A)  Sub+v1+ s/es+obj\nNote:- He, she, it, n.s ----- s/es लगेगा |\n I, we ,you ,they ,n.p ----- s/es नहीं लगेगा |\n (N) Sub+do/does+not+v1+obj\n (I)  I.W+do/does+sub+v1+obj+?\n (I.N)  I.W+do/does+not+sub+v1+obj+?\n He, she, it, n.s ---does लगेगा |\n I, we, you, they, n.p ---do लगेगा |\n\nInterrogative  words(I.W)-- वे सारे शब्द जिसके माध्यम से हम कोई प्रशन  बनाते है Interrogative  wordsकहलाते है |\nजैसे :- \nकब when\n कहां where\n कैसे how\n कौन who\n क्या  what\n\ne.g\n * गीता एक गाना गाती  है | Geeta sings a song. \n * हम क्रिकेट खेलते हैं | We play cricket. \n * मैं 6 बजे उठता हुँ | I wake up at 6 ‘o’ clock. \n\nSelf Practice:- \n * मैं 7 बजे आती हुँ|\n * मैं रोज़ क्रिकेट नहीं खेलता हुँ |\n * आप कहाँ काम करते है ? \n * क्या तुम ट्यूशन जाते हो ? \n * तुम क्यों नहीं आते हो ? \n * राधा होम वर्क नहीं करती है | \n * खाना कौन पकाता है ? \n * मोहन हमेशा देर से आता है |\n * मै आपको नहीं जानता हुँ |\n * आप किस क्लास में पढ़ते है |\n * मै ऑफिस जाती हूँ । \n * वह सुबह नहाती है । \n * वह रोता है । \n * हम खेलते है । \n * हम गाना गाते है। \n * मै नास्ता नहीं करती हूँ ।\n * मै सुबह जल्दी नहीं उठता हूँ । \n * वे सेब नहीं खाते है । \n * वर्षा नहीं होती है । \n * मै बहुत तेज नहीं हँसती हूँ । \n * क्या मै नास्ता करती हूँ  ? \n * क्या मै सुबह जल्दी उठता हूँ ? \n * क्या वे सेब खाते है ? \n * क्या वर्षा होती है ? \n * क्या मै बहुत तेज हँसती हूँ ? ";
		textview.setText(str);
		
         
	}
}
