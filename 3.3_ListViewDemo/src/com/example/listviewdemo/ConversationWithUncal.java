package com.example.listviewdemo;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ConversationWithUncal extends Activity {
	ListView listView;
	ArrayAdapter<String> arrayAdapter;
	ArrayList<String> arrayList = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.conversationwtihuncal);

		arrayList
				.add("राजू  : हेलो मी. शर्मा , सायंकाल की नमस्ते. Raju : Hello Mr Sharma, good evening.");
		arrayList
				.add("मी. शर्मा  : नमस्ते राजू  बेटे. अन्दर आओ.  Mr Sharma : Good evening Raju my son. Come in.");
		arrayList
				.add("राजू  : धन्यवाद मी. शर्मा . क्या पीयूष घर पर है?  Raju : Thank you Mr Sharma. Is Piyush at home?");
		arrayList
				.add("मी. शर्मा  : नहीं, वो तो बाज़ार गया है. और बताओ, कैसे आना हुआ?  Mr Sharma : No, he has gone to market. Well, tell me, what brings you here?");
		arrayList
				.add("राजू  : आज मैं स्कूल नहीं गया था. इसलिए गृहकार्य के बारे में पूँछने आया था.  Raju : Today I couldn’t go to school. So, I wanted to ask about homework. ");
		arrayList
				.add("मी. शर्मा  : ठीक है. वह आता ही होगा. आओ तब तक बात करें.  Mr Sharma : That’s good. He would be coming in a short while. Let’s talk till then.");
		arrayList.add("राजू  : जी मी. शर्मा   Raju : Of course, Mr Sharma");
		arrayList
				.add("मी. शर्मा  : तो राजू , पढ़ाई कैसी चल रही है?  Mr Sharma : Well Raju, how is your study going on?  ");
		arrayList.add("राजू  : बिलकुल ठीक.	 Raju : It’s all right.");
		arrayList
				.add("मी. शर्मा  : तुम किस कक्षा में हो?  Mr Sharma : In which class are you?");
		arrayList.add("राजू  : कक्षा छ: में.  Raju : In class six.");
		arrayList
				.add("मी. शर्मा  : किस वर्ग में? Mr Sharma : In which section? ");
		arrayList.add("राजू  : वर्ग सी में.  Raju : In section C.");
		arrayList
				.add("मी. शर्मा  : तुम्हारे कक्षा अध्यापक कौन हैं?  Mr Sharma : Who’s your class teacher?");
		arrayList
				.add("राजू  : श्री पाठक हमारे कक्षा अध्यापक हैं.  Raju : Mr. Pathak is our class teacher. ");
		arrayList
				.add("मी. शर्मा  : वह तुम्हें क्या पढ़ाते हैं?  Mr Sharma : What does he teach you?");
		arrayList
				.add("राजू  : वह हमें विज्ञान पढ़ाते हैं.  Raju : He teaches us Science.");
		arrayList
				.add("मी. शर्मा  : तुम्हारी कक्षा में कितने छात्र हैं?  Mr Sharma : How many students are there in your class? ");
		arrayList.add("राजू  : 35 छात्र हैं.Raju : There are 35 students.");
		arrayList
				.add("मी. शर्मा  : तुम्हारी कक्षा का मॉनिटर कौन है? Mr Sharma : Who is your class monitor? ");
		arrayList.add("राजू  : शुभम् गुप्ता.  Raju : It’s Shubham Gupta.");
		arrayList
				.add("मी. शर्मा  : तुम्हारी कक्षा का सबसे अच्छा विद्यार्थी कौन है?  Mr Sharma : Who is the best student of your class? ");
		arrayList.add("राजू  : रचना कोहली.  Raju : It’s Rachna Kohli. ");
		arrayList
				.add("मी. शर्मा  : तुम्हारा सबसे पक्का दोस्त कौन है?  Mr Sharma : Who is your best friend?");
		arrayList
				.add("राजू  : पीयूष ही मेरा सबसे पक्का दोस्त है.	  Raju : It’s Piyush who is my best friend.  ");
		arrayList
				.add("मी. शर्मा  : तुम स्कूल कैसे जाते हो?  Mr Sharma : How do you go to school?");
		arrayList.add("राजू  : साइकिल से.  Raju : By cycle.");
		arrayList
				.add("मी. शर्मा  : तुम्हारे शौक क्या है?  Mr Sharma : What are your hobbies?  ");
		arrayList
				.add("राजू  : मी. शर्मा , मुझे क्रिकेट खेलना और इंटरनेट चलाना पसंद है.Raju : Mr Sharma, playing cricket and surfing internet.");
		arrayList
				.add("मी. शर्मा  : और भविष्य में तुम क्या बनना चाहते हो?  Mr Sharma : And what do you want to be in future?");
		arrayList
				.add("राजू  : मैं डॉक्टर बनना चाहता हूँ.Raju : I want to be a doctor.");
		arrayList
				.add("मी. शर्मा  : तब तो तुम्हें बहुत पढाई करनी चाहिए.  Mr Sharma : Then you will have to study hard. ");
		arrayList.add("राजू  : जी मी. शर्मा . Raju : Yes Mr Sharma.");

		listView = (ListView) findViewById(R.id.listView7);
		arrayAdapter = new ArrayAdapter<String>(ConversationWithUncal.this,
				android.R.layout.simple_list_item_1, arrayList);
		listView.setAdapter(arrayAdapter);

	}

}
