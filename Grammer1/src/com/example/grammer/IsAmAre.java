package com.example.grammer;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class IsAmAre extends Activity{

	TextView textview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.isamare);
		textview = (TextView) findViewById(R.id.textViewIsAmAre);
		String str1 = "\n\nअंग्रेजी भाषा में  is/am/are (इज/ऍम/आर) का प्रयोग सबसे आसान वाक्य बनाने में किया जाता है. इन तीनों का प्रयोग वर्तमान काल में simple " +
				"sentences बनाने में किया जाता है. जब वाक्य के अंत में 'हूँ' ,'है' या 'हैं' हो और ये वाक्य में मुख्य क्रिया का काम करते हो तो वाक्य के कर्ता के अनुसार is/am/are" +
				" का उपयोग किया जाता है.\n\n(मैं)am,You(तुम) व  बहुवचन are (है) \n singular एकवचन 	is (है) \n\n उदाहरण :\n" +
				"मैं एक डॉक्टर हूँ .\t- I am a doctor. \n सामान्यतः बोलचाल में संक्षिप्त करने के लिए इनका उपयोग इस प्रकार किया जाता है. \n मैं एक डॉक्टर हूँ. " +
				"\n I'm a doctor.\n\nहम बहुत गरीब हैं. \n We’re very poor. \n\nआप एक अध्यापक हो.\nYou’re a teacher. \n\nवह एक गायक है." +
				" \nHe's a singer/She's a singer. \n\nयह आपका पेन है.\n It's your pen. \n\nNegative sentences (नकारात्मक वाक्य)" +
				" बनाने के लिए is/are/am के बाद ‘not’ का प्रयोग किया जाता है.\n\nमैं एक डॉक्टर नही हूँ. \n I'm not a doctor. \n\nहम बहुत गरीब नहीं हैं. " +
				"\n We’re not very poor. \n\nआप एक अध्यापक नही हो.\nYou’re not a teacher. \n\nवह एक गायक नही  है. " +
				"\n He's not a singer/She's not a singer. \n\nवे किसान नहीं है.\nThey're not farmers. " +
				"\n\nInterrogative sentences (प्रशनवाचक वाक्य) बनाने के लिए is/are/am को वाक्य के शुरू में लगाया जाता है. \n\nक्या मैं एक डॉक्टर हूँ ?. " +
				"\n Am I a doctor? \n\nक्या हम बहुत गरीब हैं. ? \nWe’re very poor? \n\nक्या आप एक अध्यापक हो. ? " +
				"\nAre You a teacher? \n\nक्या वह एक गायक है? \n Is He a singer/ Is She a singer? \n\nक्या यह आपका पेन है? \nIs It your pen?";
		String str = str1;
		textview.setText(str.toString());

	}

}
