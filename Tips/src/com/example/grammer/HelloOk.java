package com.example.grammer;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class HelloOk extends Activity {
	TextView textview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hellook);
		textview = (TextView) findViewById(R.id.textViewhello);
		String str="\n\nHello, Ok, Bye, Thanks, Please... ये इंग्लिश के शायद सबसे ज्यादा यूज़ होने वाले वर्ड्स में से हैं। लेकिन क्या आप जानते हैं कि ये वर्ड्स कब और कैसे चलन में आए या फिर इनके पीछे की कहानी क्या है? चलिए, हम बताते हैं : \n\n Ok:\nAll Correct की शॉर्ट फॉर्म है OK।\n23 मार्च 1839 में पहली बार OK शब्द को अमेरिकी अखबार बॉस्टन मॉर्निंग पोस्ट में छापा गया था। OK का मतलब था ऑल करेक्ट। माना जाता है कि उस वक्त पढ़े-लिखे लोगों में गलत स्पेलिंग लिखने का फैशन था और उन्होंने All correct को Oll Korrekt लिखा। जिसे छोटा करके बॉस्टन मॉर्निंग पोस्ट ने OK कर दिया। तब से लेकर आज तक हम सब 'ओके' ही बोलते हैं।\n\nThanks:\n Thank You शब्द आया है Think से।\n माना जाता है कि सबका चहेता Thank You आया है Think शब्द से। इसका मूल मतलब था कि आपने जो मेरे लिए किया, मैं उसे याद रखूंगा। कहा जाता है कि इसका ऑरिजन जर्मन वर्ड thankojan से हुआ। I Thank You बाद में छोटा होकर रह गया Thank You। वैसे, छोटा-सा दिखने वाला यह शब्द असर काफी बड़ा करता है। जिसको दिल से थैंक्स बोला जाता है, वह आपका मुरीद हो जाता है।\n\nHello:\n hollo, halloo जैसे शब्दों से मिला है Hello. \n1885 में चलन में आया हलो। ग्राहम बेल के मशहूर आविष्कार ने हमें न सिर्फ टेलिफोन (1876) दिया, बल्कि हलो जैसा प्यारा वर्ड भी दिया। हालांकि उससे पहले भी वक्त पर holla, hollo, halloo, hullo, hulloo आदि शब्द चलन में रहे। इन शब्दों का मीनिंग भी 'रुको' या 'ध्यान दो' ही था। लेकिन 0 बड़ा होने की वजह से उन्हें बोलने में एक चीखने का अहसास होता था। इसलिए फोन ईजाद किए जाने के बाद hullo, hulloo आदि बन गए hello, जो आज तक हम और खूब यूज करते हैं न सिर्फ फोन पर, बल्कि आमने-सामने भी।\n\nPlease:\nif you please की शॉर्ट फॉर्म है please. \nहमारी जुबान पर चढ़ा हुआ please लैटिन के placere से आता है, जिसका मतलब है to be acceptable और approved of। ज्यादातर यूरोपीय भाषाओं में Please से मिलते-जुलते शब्द हैं जैसे कि फ्रेंच में si il vous plait और स्पेनिश में por favor का मतलब भी प्लीज जैसा ही है। अगर लिटरल मीनिंग पर जाएं तो please का मतलब है कि आप इस काम को करने के लिए मजबूर नहीं हैं। वैसे, अगर आप प्लीज कहकर किसी से काम को कहते हैं तो सामने वाला बमुश्किल ही मना कर पाता है। तो एक तरह से यह भी ऑर्डर ही है, बस विनम्र तरीके से।\n\nGood Bye:\nGod Be With You फ्रेज से बना है Good Bye. \nBye-Bye सबसे पहले 1700 के शुरू में बच्चों को सुलाने के लिए लोरी के तौर पर नर्सरी फ्रेज में यूज हुआ, इसलिए इसके लिए baby talk शब्द भी यूज किया जाता है। Bye के कई मीनिंग होते हैं। यह वर्ड क्रिकेट और गोल्फ में भी यूज होता है। जहां तक Good Bye की बात है तो यह God be with you से बना है। बाद में God बदलकर good हो गया। वजह शायद good day, good night जैसे फ्रेजों का चलन रहा। इसी से मिलते जुलते Ta-Ta शब्द को पॉप्युलर बनाया 1941 में बीबीसी रेडियो ने|";
		textview.setText(str);
         
	}
}
