package com.wimc.customadapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class DetailActivity extends Activity{
TextView text1,text2;
Button btBack;

@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detail);
		
		text1=(TextView)findViewById(R.id.textView1);
		text2=(TextView)findViewById(R.id.textView2);
		btBack=(Button)findViewById(R.id.button1);
		Intent intent = getIntent();
		Item item=(Item)intent.getSerializableExtra("myinfo");
		
		text1.setText(item.getName()+":"+item.getPrice());
		text2.setText(item.getQuantity()+":"+item.getCategory());
		btBack.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}
}
