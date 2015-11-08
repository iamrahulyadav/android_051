package com.example.grammer;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class RulesOfEttiquette extends Activity {
	TextView textview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.rulesofettiquette);
		textview = (TextView) findViewById(R.id.textViewrulesofettiquette);
		String str =" \n\n \t\t\t\t दोस्तों किसी भी भाषा कि आत्मा होती है शिष्टाचार के नियम।" +
				" …जब तक हम शिष्टाचार के नियमो को नहीं जानगे तक हम भाषा  को महसूस ही नहीं कर सकते। …\n\n \t\t\t\t  कहते है न अगर अंग्रेजी सीखना है तो अंग्रेज बनना पड़ेगा।" +
				" …अंग्रेजो ने अपने भाषा  में अनेक शिष्टाचार के नियम बनाये जो कही-कही हिंदी के नियम से भिन्न है |\n\n \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t Rule-1\n सुबह 6 बजे से लेकर दोपहर 12" +
				" बजे तक किसी से मिलने पर हम कहेगे-\n Good morning\n \n और जाते समय कहेगे -\nok bye,have a nice /good day|\n\n \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  Rule-2\nदोपहर 12 बजे से लेकर शाम 5 बजे तक किसी से मिलने पर हम कहेगे -\nGood afternoon\n\nऔर जाते समय कहेगे -\nOk bye, have " +
				"a nice day\n\n \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tRule-3\n  शाम 5 बजे से लेकर रात 12 बजे तक किसी से मिलने पर हम कहेगे -\n Good evening\n \n " +
				"और जाते समय -\n Good night/take care और अगर सोने जा रहे हो तो साथ में कहेगे  sweet dreams \n\n \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t Rule-4\n" +
				" रात 12 बजे से लेकर सुबह 6 बजे तक मिलने पर Good morning का प्रयोग करेगे, क्योंकि रात ठीक  12 बजे के बाद तारीख बदल जाती है\n\n \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t " +
				"Rule-5\nयदि हम किसी से chat  कर रहे है तो हम starting  में कहेगे -\n hi/hello/hallo/what's up ? \n\n  " +
				"अपने मित्रो या बराबरी के लोगो के साथ तथा जिनसे बहुत ही अच्छा या दोस्ताना या मजाकिया संबंध  हो तो भी इन शब्दो का प्रयोग  कर सकते है | \n\n \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t " +
				" Rule-6\n यदि हम किसी से निवेदन करना चाहते हैं  तो please   का प्रयोग करेगे |\n इधर  आइये   please come  here . \n मेरी  मदद  किजिये " +
				" please help me .  \n उपरोक्त   वाक्यो में यदि please  का प्रयोग न करे तो यह आदेश का रूप ले लेगा | \n\n \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t Rule-7 \nयदि हम किसी व्यक्ति को कोई चीज़ offer " +
				"करना चाहते है या किसी चीज़ के लिए पूछना चाहते है तोhave  का प्रयोग करेगे -\n \n जैसे :- \n चाय लीजिये  please have tea\n मेरा मोबाइल ले लीजिये  " +
				"please have my mobile  \n\n \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t Rule-8\nयदि हमारे द्वारा कोई गलती हो जाए  तो हम कहेगे -\n Sorry . \n I " +
				" am sorry. \n I am extremely sorry. \n\n \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t Rule-9\n यदि कोई व्यक्ति हमारी मदद करे तो कहेगे -\n Thank you" +
				" . \n Thank you very much . \n Thanks a lot. \n So nice of you .\n\n \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t Rule-10\nयदि कोई हमे " +
				"thanks  कहे तो हम उसका  उत्तर जरुर देगे अन्यथा हम  असभ्य (manner less ) कहलायेगे \n It’s ok. \n Mention not. \n No mention" +
				" please. \n You are welcome. \n Its my pleasure \n\n \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t Rule-11 \n यदि हम किसी व्यक्ति को बीच  में रोकना या" +
				" टोकना चाहते है तो हम कहेगे \n excuse me . \n I am sorry. \n\n \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t Rule-12\nकभी-कभी परिस्तिथि आ जाती  है, " +
				"जहाँ  हमें  अपने से बड़े को कहना पड़ता है आप पहले ,उसी को अंग्रेजी  में हम you first  कह देते  है, जो कि एक गलत तरीका है ,बल्कि हम कहेगे after  you." +
				"\n\n \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t Rule-13 \nयदि हम किसी परिचित  व्यक्ति का हाल चाल जानना  चाहते है तो कहेगे how are you? \n और उसका उत्तर होगा  I am fine thank you. \n ( धयान रहे thank  you लगाना बहुत जरुरी है , भले  हम हिंदी में धन्यवाद न कहे ) \n\n \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t Rule-14\n यदि हम किसी अपरिचित व्यक्ति का हाल चाल  जानना  चाहते है तो हम कहेगे- \n how do you do? \n \n और उसका उत्तर  भी होगा -how do you do? \n ( थोडा अजीब रूल है ,,, लेकिन इसके पीछे कोई  कारन नहीं है ,,, हमें ऐसे ही प्रयोग करना  पड़ता है )     \n\n \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t Rule-15  यदि किसी से बहुत दिनों बाद मुलाकात तो हम कहेगे-\n long time no see.\n\n \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t Rule-16\n यदि हम अपने बड़ो को कहना चाहते है आप रहने दे मुझे करने दे ,तब  उनसे  कहेगे -Please allow me.   \n\n \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t Rule-17\n यदि किसी व्यक्ति से मिलकर अच्छा लगे तो हम उसे कहेगे-\n nice to meet you. \n Pleased to meet you. \n Glad to meet you. \n और इसका उत्तर होगा same here.\n\n \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t Rule-18\n कभी कभी हम दूसरे कि बातो को या अनेक सवालो को सुनकर या समझ नहीं पते तो उस बात को दोहराने के लिए कहते है |\n sorry what did you say. \n excuse me can you speak again. \n please repeat the question. \n आदि जो कि एक गलत तरीका है बल्कि हम कहेगे pardon  या फिर और अच्छे से कह सकते है-\n I beg your pardon.";
		textview.setText(str);
		
         
	}
}
