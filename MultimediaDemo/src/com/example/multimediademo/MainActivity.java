package com.example.multimediademo;

import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class MainActivity extends ActionBarActivity {

	Button btPlay, btStop;
	MediaPlayer mPlayer;
	SeekBar seek;
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btPlay = (Button) findViewById(R.id.button1);
		btStop = (Button) findViewById(R.id.button2);
		seek = (SeekBar) findViewById(R.id.seekBar1);

		// two ways to add media id or uri

		// mPlayer=MediaPlayer.create(context, uri)

		mPlayer = MediaPlayer.create(this, R.raw.waka);

		btPlay.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				mPlayer.start();
				SeekTask task = new SeekTask();
				task.execute();
			}
		});

		btStop.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (mPlayer.isPlaying())
					mPlayer.pause();

			}
		});

		seek.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				// TODO Auto-generated method stub

				if (fromUser)
					mPlayer.seekTo(progress * 1000);

			}
		});

	}

	class SeekTask extends AsyncTask<Integer, Integer, Integer> {

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();

			seek.setMax(mPlayer.getDuration() / 1000);

		}

		@Override
		protected Integer doInBackground(Integer... params) {
			// TODO Auto-generated method stub
			while (mPlayer.isPlaying()) {

				int time = mPlayer.getCurrentPosition() / 1000;
				publishProgress(time);

				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

			return 1;
		}

		@Override
		protected void onProgressUpdate(Integer... values) {
			// TODO Auto-generated method stub

			super.onProgressUpdate(values);

			int pos = values[0];
			seek.setProgress(pos);
		}

	}

}
