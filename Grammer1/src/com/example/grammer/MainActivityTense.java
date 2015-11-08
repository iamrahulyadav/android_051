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


public class MainActivityTense extends ActionBarActivity {

	ListView tenseList;
	ArrayList<String> tense = new ArrayList<String>();
	customAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainpagetense);
        tenseList = (ListView) findViewById(R.id.listViewmain);
        
       tense.add("Is Am Are");
       tense.add("Present Indefinite");
       tense.add("Present Continuous");
       tense.add("Present Perfect");
       tense.add("Past Indefinite");
       tense.add("Past Continuous");
       tense.add("Past Perfect");
       tense.add("Future Indefinite");
       tense.add("Future Continuous");
       tense.add("Future Perfect");
       
       
        
        adapter = new customAdapter(MainActivityTense.this, R.layout.relativetense,
				tense);
        
        tenseList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				
				Intent intent ;
				switch (arg2) {
				case 0:
					intent = new Intent(MainActivityTense.this, IsAmAre.class);
					startActivity(intent);
					break;
			
				case 1:
					intent = new Intent(MainActivityTense.this, PresentIndefinite.class);
					startActivity(intent);
					break;
				case 2:
					intent = new Intent(MainActivityTense.this, PresentContinous.class);
					startActivity(intent);
					break;
				case 3:
					intent = new Intent(MainActivityTense.this, PresentPerfect.class);
					startActivity(intent);
					break;
				case 4:
					intent = new Intent(MainActivityTense.this, PastIndefinite.class);
					startActivity(intent);
					break;
				case 5:
					intent = new Intent(MainActivityTense.this, PastContinous.class);
					startActivity(intent);
					break;
				case 6:
					intent = new Intent(MainActivityTense.this, PastPerfect.class);
					startActivity(intent);
					break;
				case 7:
					intent = new Intent(MainActivityTense.this, FutureIndefinite.class);
					startActivity(intent);
					break;
				case 8:
					intent = new Intent(MainActivityTense.this, FutureContinous.class);
					startActivity(intent);
					break;
				case 9:
					intent = new Intent(MainActivityTense.this, FuturePerfect.class);
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
