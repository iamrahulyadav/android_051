package com.example.grammer;

import java.util.ArrayList;

import android.support.v7.app.ActionBarActivity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivityTips extends ActionBarActivity {

	ListView tenseList;
	ArrayList<String> tense = new ArrayList<String>();
	customAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainpagetips);
        tenseList = (ListView) findViewById(R.id.listViewmain);
        
       tense.add("500 Rs नोट कि कीमत …");
       tense.add("Borrow, Lend, Hire, Rent के प्रयोग ");
       tense.add("American vs British English");
       tense.add("English क्यों सीखे?");
       tense.add("ENGLISH बोलने के लिए GRAMMAR कितना आवश्यक है");
       tense.add("How to start conversations in English?");
       tense.add("Rules of Etiquette ");
       tense.add("Symbols Of Punctuation");
       tense.add("The Management Guru 'Lord Ganesha'");
       tense.add("आत्म निरीक्षण");
       tense.add("इंग्लिश सिखने के लिए सही तकनीक को जाने");
       tense.add("काँच की  जार  और दो कप चाय");
       tense.add("कैसे बने  Hello,Ok,Bye,Thanks,Please...");
       tense.add("क्या आप एक गिलास पानी का वजन उठा सकते है ?");
        tense.add("क्या इंग्लिश एक हौउआ है ?");
        tense.add("भावनाएं कितनी महत्वपूर्ण...?");
        tense.add("हम अपनी सोच कैसे बदले ?");
        tense.add("Tongue - Twisters.");
        tense.add("Top 9 Tips For Improving Your  English");
        tense.add("Common Errors");
        
        
        
        adapter = new customAdapter(MainActivityTips.this, R.layout.relativetense,
				tense);
        
        tenseList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				
				Intent intent ;
				switch (arg2) {
				case 0:
					intent = new Intent(MainActivityTips.this, ValueOf500.class);
					startActivity(intent);
					break;
			
				case 1:
					intent = new Intent(MainActivityTips.this, BorrowLendHire.class);
					startActivity(intent);
					break;
				case 2:
					intent = new Intent(MainActivityTips.this, AmericanVsBritishEnglish.class);
					startActivity(intent);
					break;
				case 3:
					intent = new Intent(MainActivityTips.this, WhyEnglish.class);
					startActivity(intent);
					break;
				case 4:
					intent = new Intent(MainActivityTips.this, EnglishGrammar.class);
					startActivity(intent);
					break;
				case 5:
					intent = new Intent(MainActivityTips.this, ConversationStart.class);
					startActivity(intent);
					break;
				case 6:
					intent = new Intent(MainActivityTips.this, RulesOfEttiquette.class);
					startActivity(intent);
					break;
				case 7:
					intent = new Intent(MainActivityTips.this, SymbolsOfPunctuation.class);
					startActivity(intent);
					break;
				case 8:
					intent = new Intent(MainActivityTips.this, ManagementGuru.class);
					startActivity(intent);
					break;
				case 9:
					intent = new Intent(MainActivityTips.this, SelfIntrospection.class);
					startActivity(intent);
					break;
				case 10:
					intent = new Intent(MainActivityTips.this, EnglishTecknik.class);
					startActivity(intent);
					break;
				case 11:
					intent = new Intent(MainActivityTips.this, GlassJar.class);
					startActivity(intent);
					break;
				case 12:
					intent = new Intent(MainActivityTips.this, HelloOk.class);
					startActivity(intent);
					break;
				case 13:
					intent = new Intent(MainActivityTips.this, OneGlassWater.class);
					startActivity(intent);
					break;
				case 14:
					intent = new Intent(MainActivityTips.this, EnglishBugaboo.class);
					startActivity(intent);
					break;
				case 15:
					intent = new Intent(MainActivityTips.this, Emotions.class);
					startActivity(intent);
					break;
				case 16:
					intent = new Intent(MainActivityTips.this, ChangeThinking.class);
					startActivity(intent);
					break;
				case 17:
					intent = new Intent(MainActivityTips.this,ToungeTwister.class);
					startActivity(intent);
					break;
				case 18:
					intent = new Intent(MainActivityTips.this, Top9Tips.class);
					startActivity(intent);
					break;
				case 19:
					intent = new Intent(MainActivityTips.this, CommonErrors.class);
					startActivity(intent);
					break;
				default:
					break;
				}
			
				
			}
		});
		tenseList.setAdapter(adapter);
    }

	public class customAdapter extends BaseAdapter {

		Context context;
		int resource;
		ArrayList<String> tenseList;

		public customAdapter(Context context, int resource,
				ArrayList<String> tenseList) {
			super();
			this.context = context;
			this.resource = resource;
			this.tenseList = tenseList;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return tenseList.size();
		}

		@Override
		public String getItem(int position) {
			// TODO Auto-generated method stub
			return tenseList.get(position);
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(final int position, View convertView,
				ViewGroup parent) {
			// TODO Auto-generated method stub
			String emp = tenseList.get(position);

			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

			View itemview = inflater.inflate(resource, null);

			ImageView image = (ImageView) itemview
					.findViewById(R.id.imageView1);
			TextView textView = (TextView) itemview
					.findViewById(R.id.textView1);
			ColorDrawable divcolor = new ColorDrawable(Color.DKGRAY);
			//MainActivity.this.tenseList.setDivider(divcolor);
			//MainActivity.this.tenseList.setDividerHeight(2);
		//	textView.setBackgroundColor((position & 1) == 1 ? Color.WHITE : Color.LTGRAY);
			switch (position) {
			case 0:
				image.setImageResource(R.drawable.l1);
				break;
			case 1:
				image.setImageResource(R.drawable.l2);
				break;
			case 2:
				image.setImageResource(R.drawable.l3);
				break;
			case 3:
				image.setImageResource(R.drawable.l4);
				break;
			case 4:
				image.setImageResource(R.drawable.l5);
				break;
			case 5:
				image.setImageResource(R.drawable.l6);
				break;
			case 6:
				image.setImageResource(R.drawable.l7);
				break;
			case 7:
				image.setImageResource(R.drawable.l8);
				break;
			case 8:
				image.setImageResource(R.drawable.l9);
				break;
			case 9:
				image.setImageResource(R.drawable.l10);
				break;
			case 10:
				image.setImageResource(R.drawable.l11);
				break;
			
			case 11:
				image.setImageResource(R.drawable.l12);
				break;
			case 12:
				image.setImageResource(R.drawable.l13);
				break;
			case 13:
				image.setImageResource(R.drawable.l14);
				break;
			case 14:
				image.setImageResource(R.drawable.l15);
				break;
			case 15:
				image.setImageResource(R.drawable.l16);
				break;
			case 16:
				image.setImageResource(R.drawable.l17);
				break;
			
			default:
				break;
			}

			
			textView.setText(tenseList.get(position).toString());
			return itemview;
		}
	}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
