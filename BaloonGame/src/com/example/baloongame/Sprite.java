package com.example.baloongame;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

public class Sprite {

	int x, y; // currnt position

	int vx, vy; // displacement
	
	int timeToLive=0;
	private Bitmap texture;

	private int getHeight() {
		return texture.getHeight();
	}

	private int getWidth() {
		return texture.getWidth();
	}

	public Sprite(Bitmap texture) {
		// TODO Auto-generated constructor stub

		this.texture = texture;

	}

	public void draw(Canvas c) {
		c.drawBitmap(texture, x, y, null);

	}

	public Rect getRect() {

		int x2 = x + texture.getWidth();
		int y2 = y + texture.getHeight();

		Rect r = new Rect(x, y, x2, y2);

		return r;
	}
	void moveDown()
	{
		y=y+vy;
	}
	void moveRight()
	{
		x=x+vx;
	}

}
