package com.example.grammer;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class OneGlassWater extends Activity {
	TextView textview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.oneglasswater);
		textview = (TextView) findViewById(R.id.textViewoneglass);
		String str = "\n\n\t\t\tएक प्रोफ़ेसर ने अपने हाथ में पानी से भरा एक ग्लास पकड़ते हुए कक्षा शुरू की . उन्होंने उसे ऊपर उठा कर सभी छात्रों को दिखाया और पूछा , ‘ आपके हिसाब से ग्लास का वज़न कितना होगा?’ ’50gm ….100gm …125gm’ …छात्रों ने उत्तर दिया. ‘ \n\n\t\t\tजब तक मैं इसका वज़न ना कर लूँ मुझे इसका सही वज़न नहीं बता सकता’. प्रोफ़ेसर ने कहा. ‘ पर मेरा सवाल है: यदि मैं इस ग्लास को थोड़ी देर तक इसी तरह उठा कर पकडे रहूँ तो क्या होगा ?’ \n\t\t\t   ‘कुछ नहीं’ …छात्रों ने कहा. ‘अच्छा , अगर मैं इसे मैं इसी तरह एक घंटे तक उठाये रहूँ तो क्या होगा ?’ , प्रोफ़ेसर ने पूछा. ‘आपका हाथ दर्द होने लगेगा’, एक छात्र ने कहा. ‘ \n\t\t\t तुम सही हो, अच्छा अगर मैं इसे इसी तरह पूरे दिन उठाये रहूँ तो का होगा?’ ‘ आपका हाथ सुन्न हो सकता है, आपकी मांसपेशियों में भारी तनाव आ सकता है , लकवा मार सकता है और पक्का आपको अस्पताल जाना पड़ सकता है’….किसी छात्र ने कहा, और बाकी सभी हंस पड़े… \n\t\t\t ’बहुत अच्छा , पर क्या इस दौरान ग्लास का वज़न बदला?’ प्रोफ़ेसर ने पूछा. उत्तर आया ..’नहीं’ ‘ तब भला हाथ में दर्द और मांशपेशियों में तनाव क्यों आया?’ छात्रों अचरज में पड़ गए. फिर प्रोफ़ेसर ने पूछा ‘ अब दर्द से निजात पाने के लिए मैं क्या करूँ?’ ‘ ग्लास को नीचे रख दीजिये! एक छात्र ने कहा. \n\t\t\t ’ बिलकुल सही!’ प्रोफ़ेसर ने कहा. जीवन की समस्याएं भी कुछ इसी तरह होती हैं. इन्हें कुछ देर तक अपने दिमाग में रखिये और लगेगा की सब कुछ ठीक है.उनके बारे में ज्यदा देर सोचिये और आपको पीड़ा होने लगेगी.और इन्हें और भी देर तक अपने दिमाग में रखिये और ये आपको paralyze करने लगेंगी. और आप कुछ नहीं कर पायेंगे. \n\t\t\tअपने जीवन में आने वाली चुनातियों और समस्याओं के बारे में सोचना ज़रूरी है, पर उससे भी ज्यादा ज़रूरी है दिन के अंत में सोने जाने से पहले उन्हें नीचे रखना.इस तरह से, आप तनाव में नहीं रहेंगे, आप हर रोज़ मजबूती और ताजगी के साथ उठेंगे और सामने आने वाली किसी भी चुनौती का सामना कर सकेंगे.";
		textview.setText(str);
         
	}
}
