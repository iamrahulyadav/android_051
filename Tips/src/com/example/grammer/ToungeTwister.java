package com.example.grammer;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ToungeTwister extends Activity {
	TextView textview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tonguetwister);
		textview = (TextView) findViewById(R.id.textViewtonguetwister);
		String str="\n\nA tongue-twister is a sequence of words that is difficult to pro-nounce quickly and correctly. Even native English speakers find the tongue-twisters on this page difficult to say quickly. Try them yourself. Try to say them as fast as possible, but correctly! \n• A proper copper coffee pot. \n• Around the rugged rocks the ragged  rascals ran. \n• Long legged ladies last longer. \n• Pink lorry, yellow lorry. \n• Red leather, yellow leather, red leather, yellow  leather. \n• She sells sea-shells on the sea-shore. \n• The sixth sick Sheik's sixth sheep is sick.\n• Swan swam over the pond. \n• Swim swan swim! \n• Swan swam back again .\n• Well swum swan! \n• Three grey geese in green fields grazing. \n• We surely shall see the sun shine soon. \n• A box of biscuits, a box of mixed biscuits, mixed biscuits and a biscuit mixer. \n• A proper copper coffee pot. \n• How much wood would a wood-chuck chuck if a wood-chuck could chuck wood? \n• A wood-chuck, if a wood-chuck could chuck wood, would chuck as much wood as a wood-chuck could chuck if a wood-chuck could chuck wood. \n• Long legged ladies last longer. \n• Three grey geese in green fields grazing. \n• We surely shall see the sun shine soon. \n• Round and round the rugged rock the ragged rascal ran. \n• What noise annoys an oyster? Any noise annoys an oyster, but noisy noise annoys an oyster most. \n• Red leather, yellow leather, red leather, yellow leather.\n• Red lorry, yellow lorry.\n";
		textview.setText(str);
		
         
	}
}
