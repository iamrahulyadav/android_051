package com.wimc.menudesignsample;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.ImageView;
import android.widget.TextView;

public class NextActivity extends Activity {

	TextView textTitle;
	ImageView img;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.next);

		textTitle = (TextView) findViewById(R.id.textView1);
		img = (ImageView) findViewById(R.id.imageView1);
		// activate view to appear conty
		registerForContextMenu(textTitle);
		registerForContextMenu(img);

	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {

		super.onCreateContextMenu(menu, v, menuInfo);

		switch (v.getId()) {
		case R.id.textView1:
			getMenuInflater().inflate(R.menu.textmenu, menu);

			break;

		case R.id.imageView1:
			getMenuInflater().inflate(R.menu.imagemenu, menu);
		default:
			break;
		}

	}

	// menu selection
	@Override
	public boolean onContextItemSelected(MenuItem item) {

		

		int id=item.getItemId();
		
		switch (id) {
		case R.id.menuRed:
			textTitle.setTextColor(Color.RED);

			break;

		case R.id.menuGreen:
			textTitle.setTextColor(Color.GREEN);

			break;
		case R.id.menuBlue:
			textTitle.setTextColor(Color.BLUE);

			break;

		case R.id.menuImage1:
			img.setImageResource(R.drawable.grenede);

			break;

		case R.id.menuImage2:
			img.setImageResource(R.drawable.bluefrog);

			break;
		case R.id.menuImage3:
			img.setImageResource(R.drawable.logo);

			break;

		default:
			break;
		}
		return super.onContextItemSelected(item);
	}
}
