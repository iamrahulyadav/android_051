package com.example.listviewdemo;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Clinic extends Activity {
	ListView listView;
	ArrayAdapter<String> arrayAdapter;
	ArrayList<String> arrayList = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.clinic);

		listView = (ListView) findViewById(R.id.listView6);


		arrayList.add("मरीज़ : नमस्ते डॉक्टर साहब.  Patient : Good evening doctor.");
		arrayList.add("डॉक्टर : नमस्ते. बैठिये.  Doctor : Good evening doctor. Please be seated.");
		arrayList.add("मरीज़ : धन्यवाद.  Patient : Thank you.");
		arrayList.add("डॉक्टर : आपका नाम?  Doctor : Your name?");
		arrayList.add("मरीज़ : शान्तनु मिश्र.  Patient : Shantanu Mishra.");
		arrayList.add("डॉक्टर : उम्र?  Doctor : Age?");
		arrayList.add("मरीज़ : बत्तीस वर्ष.  Patient : Thirty two years.");
		arrayList.add("डॉक्टर : क्या तकलीफ़ है?  Doctor : What’s the problem?");
		arrayList.add("मरीज़ : मुझे बुखार है और खांसी भी.  Patient : I have fever and coughing also.  (डॉक्टर नब्ज़ पकड़ता है.)Doctor feels the pulse.)");
		arrayList.add("डॉक्टर : कब से?  Doctor : Since when?");
		arrayList.add("मरीज़ : कल रात से.  Patient : Since last night.");
		arrayList.add("डॉक्टर : क्या कंपकंपी लगती है?  Doctor : Do you feel shivering?");
		arrayList.add("मरीज़ : हाँ, बुखार चढ़ने के समय.  Patient : Yes, at the time of rising of temperature.");
		arrayList.add("डॉक्टर : मुँह दिखाइए. जीभ बाहर निकालिए.Doctor : Show your mouth. Take out the tongue.");
		arrayList.add("(डॉक्टर टॉर्च से मुँह और जीभ का निरीक्षण करता है.)   (Doctor checks the mouth and tongue with the help of torch.)");
		arrayList.add("डॉक्टर : खांसी सूखी है?  Doctor : Is it dry cough?");
		arrayList.add("मरीज़ : हाँ. Patient : Yes.");
		arrayList.add("डॉक्टर : कोई और दिक्कत?  Doctor : Any other problem?");
		arrayList.add("मरीज़ : हाँ, डॉक्टर साहब. बहुत कमजोरी लगती है और भूख नहीं लगती है. सिरदर्द भी है.  Patient : Yes, doctor. I feel much weakness and there is lack of appetite. I have a headache also.");
		arrayList.add("डॉक्टर : मैं दवाएं लिख रहा हूँ. किसी मेडिकल स्टोर से ले लीजिये. मॉडर्न पैथोलॉजी से खून की जांच करवा लें. आजकल मलेरिया बहुत आम है.  Doctor : I’m prescribing the medicines. Buy them from any medical store. Get your blood tested at Modern Pathology. Nowadays malaria is very common.");
		arrayList.add(" मरीज़ : जी डॉक्टर साहब. कोई कफ़ सीरप भी लिख दीजियेगा. रात में खांसी के कारण सो नहीं पाता हूँ. Patient : Yes, doctor. Also prescribe some cough syrup. I can’t sleep at night because of coughing.");	
		arrayList.add("डॉक्टर : मैंने पहले ही लिख दिया है. लापरवाही मत कीजियेगा. रक्त जांच की रिपोर्ट कल मुझे अवश्य दिखाइएगा.    Doctor :  I have already prescribed it. Don’t be careless. Please do show me the blood report tomorrow.");
		arrayList.add("मरीज़ : जी डॉक्टर साहब. कोई परहेज़? Patient : Yes, doctor. Any precaution?	");
		arrayList.add("डॉक्टर : सादा भोजन. लें. आराम करें. नियमित दवा लें. और कोई ख़ास परहेज़ नहीं. Doctor : Take light food and complete rest. Take medicine regularly. No any specific precaution.");
		arrayList.add("मरीज़ : जी अच्छा. आपकी फीस?  Patient :Yes, sure. Your fee?");
		arrayList.add("डॉक्टर : उस काउंटर पर जमा कर दें.  Doctor : Deposit it at that counter.");
		arrayList.add("मरीज़ : अच्छा धन्यवाद डॉक्टर साहब.  Patient : O.K. Thank you doctor.");
		arrayList.add("डॉक्टर : ठीक है. अपना ख्याल रखें.   Doctor : It’s all right. Take care. ");
		
		arrayAdapter = new ArrayAdapter<String>(Clinic.this,
				android.R.layout.simple_list_item_1, arrayList);
		listView.setAdapter(arrayAdapter);

	}
}
