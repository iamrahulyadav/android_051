package com.example.assigncustomrectbox;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class MyView extends View {

	public MyView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		Paint pt = new Paint();
		Paint pt2 = new Paint();
		pt2.setColor(Color.BLACK);

		pt.setColor(Color.LTGRAY);

		RectF r = new RectF(50, 50, 250, 150);

		RectF r2 = new RectF(280, 50, 320, 150);
		RectF r3 = new RectF(340, 50, 380, 150);

		canvas.drawRect(r, pt);
		canvas.drawRect(r2, pt);
		canvas.drawRect(r3, pt);

		canvas.drawLine(280, 90, 320, 90, pt2);

		canvas.drawLine(300, 70, 300, 110, pt2);

		canvas.drawLine(350, 90, 370, 90, pt2);

	}

}
