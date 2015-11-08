package com.example.customizwdview;

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
		pt.setColor(Color.LTGRAY);

		canvas.drawCircle(40, 40, 10, pt);

		canvas.drawCircle(100, 40, 10, pt);

		RectF r = new RectF(30, 30, 120, 120);

		canvas.drawArc(r, 45,90, false, pt);
		
		canvas.drawText("Hello", 50, 80, pt);
		
		
		
	}

}
