package com.example.grammer;

import android.R.string;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class AmericanVsBritishEnglish extends Activity {
	TextView textview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.americanvsbritish);
		textview = (TextView) findViewById(R.id.textViewamericanvsbritish);
		String str="\n\n  अमेरिकी और ब्रिटिश अंग्रेजी के बीच के बीच तीन प्रमुख मतभेद रहे हैं: \n Pronunciation---स्वर और व्यंजन दोनों में मतभेद है, साथ ही साथ stress " +
				"and intonation\n Vocabulary-------nouns औरverbs में मतभेद, विशेष रूप से phrasal क्रिया के उपयोग में \n Spelling " +
				"-मतभेद आम तौर पर कुछ उपसर्ग और प्रत्यय रूपों में पाए जाते हैं|\n \n Use of the Present Perfect\n ब्रिटिश अंग्रेजी में Present Perfect" +
				" का प्रयोग हाल के समय में हुआ है कि एक कार्य  व्यक्त करने के लिए प्रयोग किया जाता है. \n उदाहरण के लिए:\n I've lost my pen. Can you help me" +
				" look for it? \n In American English the following is also possible: \n I lost my pen . Can you help me look for it? " +
				"\n ब्रिटिश अंग्रेजी में ऊपर के  विचार को गलत माना जाएगा. \n \n ------Other differences involving the use of the present perfect" +
				" in British English and simple past in American English include already, just and yet. \n \n British English: \n I've just had lunch\n I've already seen that film\n Have you finished your homework yet? \n American English: \n I just had lunch OR I've just had lunch\n I've already seen that film OR I already saw that film. " +
				"\n Have your finished your homework yet? OR Did you finish your homework yet? \n \n Possession\n अंग्रेजी में 'रखना ' " +
						"को व्यक्त करने के दो रूप हैं. Have or Have got\n \n Do you have a car? \n Have you got a car? \n He hasn't got any friends." +
						" \n He doesn't have any friends. \n She has a beautiful new home. \n She's got a beautiful new home. " +
						"\n \n While both forms are correct (and accepted in both British and American English), " +
						"have got (have you got, he hasn't got, etc.) is generally the preferred form in British English while most " +
						"speakers of American English employ the have (do you have, he doesn't have etc.) " +
						"\n \n The Verb GetThe past participle of the verb get is gotten in American English. " +
						"Example He's gotten much better at playing tennis. British English - He's got much better at playing tennis. " +
						"\n \n शायद ब्रिटिश और अमेरिकी अंग्रेजी के बीच बड़े मतभेद शब्दावली के चुनाव में निहित है|\n \n # American English - hood\n British English - bonnet\n \n # American English - trunk\n British English - boot\n \n # American English - truck\n British English - lorry\n \n Prepositions\n There are also a few differences in preposition use including the following: \n \n # American English - on the weekendBritish English - at the weekend\n \n # American English - on a team\n British English - in a team\n \n # American English - please write me soon\n British English - please write to me soon\n \n Past Simple/Past Participles\n \n The following verbs have two acceptable forms of the past simple/past participle in both American and British English, however, the irregular form is generally more common in British English (the first form of the two) and the regular form is more common to American English. \n \n #Burn\n Burnt OR burned\n \n # Dream\n dreamt OR dreamed\n \n # Lean\n leant OR leaned\n \n # Learn\n learnt OR learned\n \n #Smell\n smelt OR smelled\n \n # Spell\n spelt OR spelled\n \n # Spill\n spilt OR spilled\n \n # Spoil\n spoilt OR spoiled\n \n Spelling\n Here are some general differences between British and American spellings: \n \n Words ending in -or (American) -our (British) color, colour, humor, humour, flavor, flavour etc. \n Words ending in -ize (American) -ise (British) recognize, recognise, patronize, patronise etc. \n The best way to make sure that you are being consistent in your spelling is to use the spell check on your word processor (if you are using the computer of course) and choose which variety of English you would like. As you can see, there are really very few differences between standard British English and standard American English. However, the largest difference is probably that of the choice of vocabulary and pronunciation.";
		textview.setText(str);
         
	}
}
