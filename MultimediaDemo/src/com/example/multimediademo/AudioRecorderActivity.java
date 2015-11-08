package com.example.multimediademo;

import java.io.IOException;

import android.app.Activity;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class AudioRecorderActivity extends Activity {

	Button btRecord, btStop;
	MediaRecorder recorder;
	EditText editFileName;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.record);

		btRecord = (Button) findViewById(R.id.button1);
		btStop = (Button) findViewById(R.id.button2);
		editFileName = (EditText) findViewById(R.id.editText1);

		// inint recoreder and set all properties

		recorder = new MediaRecorder();

		btRecord.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				try {
					recorder.reset();
					recorder.setAudioSource(MediaRecorder.AudioSource.MIC);

					recorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);

					recorder.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT);

					String str = editFileName.getText().toString();

					String filePath = Environment.getExternalStorageDirectory()
							.getPath() + "/" + str + ".mp3";
					recorder.setOutputFile(filePath);
					recorder.prepare();
					recorder.start();

				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

		btStop.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				recorder.stop();
				recorder.reset();
				editFileName.setText("");

			}
		});

	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		recorder.release();

	}

}
