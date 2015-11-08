package com.example.baloongame;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.SurfaceHolder;

public class GameThread extends Thread {

	SurfaceHolder holder;
	Context context;
	
	Rect rect=null;

	public boolean isRunning = true;

	public static int gameHeight, gameWidth;

	ArrayList<Sprite> listBalloons = new ArrayList<Sprite>();
	ArrayList<Sprite> listArrows = new ArrayList<Sprite>();
	Bitmap bmpBalloon1 = null;
	Bitmap bmpArrow = null;

	public GameThread(SurfaceHolder holder, Context contex) {
		// TODO Auto-generated constructor stub

		this.holder = holder;
		this.context = contex;

	}// eof constructor

	void initSprite() {
		// init sprite
		 rect = new Rect(0, gameHeight - 100, 100, gameHeight);
		bmpBalloon1 = BitmapFactory.decodeResource(context.getResources(),
				R.drawable.balloon1);
		bmpArrow = BitmapFactory.decodeResource(context.getResources(),
				R.drawable.arrow1);
		for (int i = 0; i < 5; i++) {
			Sprite ballon = new Sprite(bmpBalloon1);
			ballon.x = 200 + i * 100;
			ballon.y = 10;
			ballon.vx = 10;
			ballon.vy = 20;
			ballon.timeToLive = 40 * i;
			listBalloons.add(ballon);

			

			
		}
	}

	@Override
	public void run() {

		while (true) {

			// draw sprite
			Canvas canvas = null;
			try {
				canvas = holder.lockCanvas();
				synchronized (holder) {

					draw(canvas);
					
					updateScreen();
					checkCollision();
				}
				updateScreen();
			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				holder.unlockCanvasAndPost(canvas);
			}

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}// eof run

	void draw(Canvas canvas) {
		Paint paint = new Paint();
		paint.setColor(Color.CYAN);
		canvas.drawColor(paint.getColor());
		/*
		 * arrow.draw(canvas); ballon.draw(canvas);
		 */
		for (Sprite s : listBalloons) {
			s.draw(canvas);
		}

		for (Sprite s : listArrows) {
			s.draw(canvas);
		}
		// draw a rect
		
		paint.setColor(Color.MAGENTA);
		canvas.drawRect(rect, paint);

	}

	void updateScreen() {
		for (Sprite s : listBalloons) {

			if (s.timeToLive <= 0) {
				s.moveDown();
			} else
				s.timeToLive--;
			if(s.y>gameHeight)
				s.y=200;
		}
		for (Sprite s : listArrows) {
			s.moveRight();
			if(s.x>gameWidth)
				listArrows.remove(s);
		}
	}
	
	void checkCollision()
	{
		for(Sprite arrow:listArrows)
		{
			for(Sprite ballon:listBalloons)
			{
				if(arrow.getRect().intersect(ballon.getRect()))
				{
					listBalloons.remove(ballon);
					break;
				}
			}
		}
		if(listBalloons.size()<3)
		{
			for (int i = 0; i < 5; i++) {
				Sprite ballon = new Sprite(bmpBalloon1);
				ballon.x = 200 + i * 100;
				ballon.y = 10;
				ballon.vx = 10;
				ballon.vy = 20;
				ballon.timeToLive = 40 * i;
				listBalloons.add(ballon);
			}
		}
	}
	 public boolean onTouchEvent(MotionEvent event) {
	    	// TODO Auto-generated method stub
	    	
		 
		 int x=(int) event.getX();
		 int y=(int) event.getY();
		 
		 if(rect.contains(x, y))
		 {
			 Sprite arrow = new Sprite(bmpArrow);
				arrow.x = 0;
				arrow.y = 500;
				arrow.vx = 20;
				arrow.vy = 40;
				// arrow.timeToLive = 40 * i;
				listArrows.add(arrow);
				
		 }
		 
		 
		 
		 return true;
	    
	    }

}
