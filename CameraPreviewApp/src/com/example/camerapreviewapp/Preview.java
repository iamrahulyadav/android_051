package com.example.camerapreviewapp;

import java.io.IOException;

import android.content.Context;
import android.hardware.Camera;

import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class Preview extends SurfaceView implements SurfaceHolder.Callback {

	Camera cam;
	SurfaceHolder holder;

	public Preview(Context context, Camera cam) {
		super(context);

		this.cam = cam;

		holder = getHolder();

		holder.addCallback(this);
		holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);

	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// TODO Auto-generated method stub

		Camera.Parameters parameters = cam.getParameters();

		parameters.setPreviewSize(width, height);

	//	cam.setParameters(parameters);

		cam.startPreview();

	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		// TODO Auto-generated method stub

		try {
			cam.setPreviewDisplay(holder);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO Auto-generated method stub

		cam.stopPreview();
		cam.release();

	}

}
