package com.example.grammer;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class BorrowLendHire extends Activity {
	TextView textview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.borrowlendhire);
		textview = (TextView) findViewById(R.id.textViewborrow);
		String str="\n\nअमरीका में किराए पर लेने के लिए ‘टू रेंट’ का प्रयोग करते हैं तो ब्रितानी अंग्रेज़ी में ‘टू लेट’ का प्रयोग करते हैं \n borrow (बौरो), lend (लेन्ड), hire (हायर) और rent(रेंट)\n ये सारे शब्द उधार और किराए पर देने और \n लेने के लिए प्रयोग किए जाते हैं लेकिन इनके प्रयोग पर पता चलता है कि कहां किसका प्रयोग होगा. \n जिस में पैसा शामिल न हो| \n  borrow (बौरो) यानी उधार लेना या कुछ समय के लिए लेना जैसे— Can I borrow your bike? \n \n lend (लेन्ड) का अर्थ होता है उधार देना, थोड़े समय के लिए देना|\n I can lend you the  bike. \nइसका प्रयोग इस प्रकार भी होता है| \n I can lend a jacket to you if you need one. \nइस में दो ऑब्जेक्ट   के प्रयोग के साथ टू (to ) शामिल है| \n जहाँ भुगतान ज़रूरी हो| \n पैसे के मामले में| \n\n बौरो (borrow) का अर्थ तो आप जानते ही हैं अब प्रयोग देखें — A lot of businessmen borrow heavily these days to boost their business. \n लेन्ड (lend)- There are lots of NGOs which are specially set up to lend to farmers and small industries like hand loom and power loom. \n लोन (loan), आज कल लोन का ज़माना है, घर ख़रीदना हो या गाड़ी बैंक वाले उधार देने के लिए तैयार बैठे हैं मानों मुफ़्त में पैसे बांट रहे हों. \n प्रयोग—Ashok has applied for the loan to buy his son a new car. \n डेट (debt) इसका उच्चारण करते समय ध्यान रखें कि यहाँ बी का उच्चारण नहीं किया जाता है और झटके से बोला जाता है जैस ‘चल’ ‘हट’. डेट\n किसी भी क़र्ज़ को कहते हैं वह पैसे का हो या जायदाद का. जैसे—He took the loan from the bank but could not pay back his debt. \n \n चीज़ के मामले में \n \n ‘हायर’ या ‘रेंट’- चीज़ों के मामले में अमरीका में रेंट का आम तौर पर प्रयोग किया जाता है. \n प्रयोग—We hired a taxi to reach Airport in time. \n \n ‘रेंट’ (Rent) का संज्ञा के तौर पर भी प्रयोग होता है, जैसे— Don’t forget to pay the rent in time. Rents in Delhi are extremely high in comparison to other cities in India. \n \n ‘लीज़’ (Lease) का प्रयोग ज़मीन जायदाद में अकसर देखने में आता है. जैसे—The lady decided to lease the ground floor after her children shifted in the new apartment. \n \n मौर्टगेज (Mortgage) का अर्थ बंधक गिरवी, रेहन या बंधक या रेहन रखना वग़ैरह. यानी यह संज्ञा और क्रिया दोनों में प्रचलित है. I mortgaged my house to buy the new car. \n \n स्पौनसर (Sponsor) का कई अर्थ है लेकिन आजकल ख़र्च देने उठाने वाले के लिए इसका प्रयोग अधिक होता है. जैसे-- I am yet to find a sponsor to organise the seminar.";
		textview.setText(str);
		
         
	}
}
