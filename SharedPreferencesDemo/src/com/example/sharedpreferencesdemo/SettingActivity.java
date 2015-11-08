package com.example.sharedpreferencesdemo;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.MediaStore.Audio.Radio;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class SettingActivity extends Activity {

	EditText editOldPass, editNewPass;
	Button btChangePass, btChangeTheme;
	RadioGroup rgTheme;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.settings);
		editNewPass = (EditText) findViewById(R.id.editText2);
		editOldPass = (EditText) findViewById(R.id.editText1);
		btChangePass = (Button) findViewById(R.id.button1);
		btChangeTheme = (Button) findViewById(R.id.button2);
		rgTheme = (RadioGroup) findViewById(R.id.radioGroup1);

		btChangePass.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				SharedPreferences sp = getSharedPreferences("myappdata",
						MODE_PRIVATE);
				String oldPass = sp.getString("password", null);
				String oldPass1 = editOldPass.getText().toString();
				String newPass = editNewPass.getText().toString();

				Log.e("pass:", oldPass + ":" + oldPass1 + ":" + newPass);
				if (oldPass1.equals(oldPass)) {
					SharedPreferences.Editor edit = sp.edit();

					edit.putString("password", newPass);

					edit.commit();
					finish();
				}
			}
		});
		btChangeTheme.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				int radioId = rgTheme.getCheckedRadioButtonId();

				SharedPreferences sp1 = getSharedPreferences("myappdata",
						MODE_PRIVATE);

				int id = sp1.getInt("theme", 0);

				int theme = 3;
				rgTheme.check(id);
				switch (radioId) {
				case R.id.radio0:
					theme = 1;
					break;
				case R.id.radio1:
					theme = 2;
					break;
				case R.id.radio2:
					theme = 3;
					break;
				default:
					break;
				}

				SharedPreferences.Editor ed = sp1.edit();
				ed.putInt("theme", theme);

				ed.commit();
				finish();
			}
		});
	}

}
