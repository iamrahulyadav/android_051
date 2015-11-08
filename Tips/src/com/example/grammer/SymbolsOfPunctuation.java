package com.example.grammer;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class SymbolsOfPunctuation extends Activity {
	TextView textview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.symbolsofpunctuation);
		textview = (TextView) findViewById(R.id.textViewsymbolsofpunctuation);
		String str = "\n\n1.   पूर्ण विराम (|) (Full Stop) \n  This punctuation mark comes after the end of a sentence in Hindi. It is different than English full stop/period (.) and  it is represented by a vertical bar(|).\n Example: गीता एक गाना गाती  है|  Geeta sings a song. \n \n 2.  अल्प विराम (,) (Comma) \n This punctuation mark is used when a sentence contain two similar clauses or a compound sentence contain similar sub-sentences. It is is used just like its English counterpart. \n  Examples :\na. १९, सितम्बर, १९५६ (19, September, 1956) \n b. राकेश आपनी सारी सम्पति, भूमि और मन-मर्यादा खो गया| (Rakesh had lost all of his property, land and reputation) \n c. वो बच्चा, जो कल रो रहा था, आज हस रहा है| (The child, who was yesterday crying, is smiling today) \n \n 3.  अर्ध विराम (;) (Semicolon) \n This punctuation mark is used when sentences in compound and mixed sentences are of opposite nature, or in between similar sentences, or emphasis on particular sentences, or after the main sentence, a example sentences is given etc. \n  Example: \n a. वो मुझे बहुत मानता भी है; वो मेरी बुराई भी करता है| (He respect me a lot; He says also bad about me) \n \n 4.  प्रशनवाचक चिन्ह (?) (Question Mark) \n This punctuation mark is used after a question is asked or a doubt is shown. \n Example: \nक्या आप मेरे साथ चलेंगे? (Would you go with me?) \n \n 5. विस्मयादिवाचक चिन्ह (!) (Exclamation Mark) \n This punctuation mark is used just like in English, to express surprise, happiness, anger, sigh, to address someone etc.  \n Examples: \n a. अरे! तुम कब आये? (Hey! When did you come?) \n b. सुशील! इधर आओ| (Sushil! Come Here.) \n \n 6.  निर्देशक (—) (Dash) \n This punctuation mark is used after something is spoken, written or to represent a pause after name in conversation or to define a word or sentence. \n  Examples: \n a. रमेश – तुम हिंदी पड़ते भी हो या नहीं? (Ramesh: Do you study Hindi or not?) \n b. मेहनत से सब कुछ मिल सकता है| – धन-दोलत. सुख, यश आदि| (Through hard work, everything could be gained : Money, happiness, reputation etc). \n \n 7.  योजक (‐) (Hyphen) \n This punctuation mark is used when there is comparison with सा, सी (like) or in opposite words pair, analogy, similar word pair etc. \n Examples: \n a. हाथी सा मोटा| (Fat like an Elephant) \n b. कभी-कभी (Sometime) \n \n 8.  उद्धरण चिन्ह (” “) (Quotation Mark) \n This punctuation mark is used when a quote is given or a particular part of written work is represented in original. \n Example: \nमहात्मा गाँधी ने कहा ” सत्य ही ईश्वर है|” (Mahatma Gandhi said “Truth is God” ) \n\n 9.  विवरण चिन्ह (:-) (Sign of Following) \n This punctuation mark is used when further information, details, examples etc has/have to follow. \n Example: \n a. संज्ञा के तीन मुख्य भेद हैं जेसे :- \n (Noun is of three main types like : )";
		textview.setText(str);
		
         
	}
}
