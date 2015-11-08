package com.example.assignrebootmessage;

import com.example.assignrebootmessage.R.bool;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	EditText editText;
	Button btOk;

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {

		if (keyCode == KeyEvent.KEYCODE_BACK) {
			// preventing default implementation previous to
			// android.os.Build.VERSION_CODES.ECLAIR
			return true;
		}

		return super.onKeyDown(keyCode, event);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		editText = (EditText) findViewById(R.id.editText1);
		btOk = (Button) findViewById(R.id.button1);

		btOk.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				String pass = editText.getText().toString();

				if (pass.equals("abcd")) {

					finish();

				}

				else
					Toast.makeText(MainActivity.this, "enter correct password",
							5);

			}
		});

	}

}
