package com.example.multimediademo;

import android.app.Activity;
import android.media.MediaPlayer;
import android.util.Log;
import android.widget.MediaController;
import android.os.Bundle;
import android.os.Environment;
import android.widget.VideoView;

public class VideoPlayerActivity extends Activity {

	VideoView videoView;
	MediaController mediaCon;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.video);
		videoView = (VideoView) findViewById(R.id.videoView1);

		mediaCon = new MediaController(this);

		videoView.setMediaController(mediaCon);

		// initialize video file path
		String filePath = Environment.getExternalStorageDirectory().getPath()
				+ "/pk.mp4";
		
		
		Log.e("path:", filePath);
		videoView.setVideoPath(filePath);
		videoView.start();

	}
}
