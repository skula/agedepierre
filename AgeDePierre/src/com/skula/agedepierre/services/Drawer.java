package com.skula.agedepierre.services;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import com.skula.agedepierre.R;
import com.skula.agedepierre.cnst.PictureLibrary;

public class Drawer {
	private static final int SCREEN_WIDTH = 1280;
	private static final int SCREEN_HEIGHT = 736;
	private static final Rect SCREEN_RECT = new Rect(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);

	private int BACKGROUND_WIDTH;
	private int BACKGROUND_HEIGHT;
	
	private PictureLibrary lib;
	private Paint paint;

	private String log;
	private int x;
	private int y;
	private Rect FOCUS;

	public Drawer(Resources res) {
		this.paint = new Paint();
		this.lib = new PictureLibrary(res);

		this.x = 0;
		this.y = 0;
		this.FOCUS = new Rect(x, y, x + SCREEN_WIDTH, y + SCREEN_HEIGHT);

		this.BACKGROUND_WIDTH = lib.get(R.drawable.background).getWidth();
		this.BACKGROUND_HEIGHT = lib.get(R.drawable.background).getHeight();
	}

	public void draw(Canvas c) {
		drawBackground(c);
		drawPlop(c);
		drawCommodities(c);
		drawBuildings(c);
		drawCivilizations(c);
		drawPawns(c);
		drawPlayers(c);
		
		int w = lib.get(R.drawable.pawn).getWidth();
		int h = lib.get(R.drawable.pawn).getHeight();
		c.drawText(w+", " +h, 50, 50, paint);
	}
	
	public void drawBackground(Canvas c) {
		c.drawBitmap(lib.get(R.drawable.background), new Rect(0,0,BACKGROUND_WIDTH, BACKGROUND_HEIGHT), SCREEN_RECT, paint);
	}
	
	public void drawPlop(Canvas c) {
		Rect r = null;
		//c.drawBitmap(lib.get(R.drawable.tuile1), r, r, paint);
		
		int x = 270;
		int y = 400;
		r = new Rect(0 ,0,lib.get(R.drawable.pawn).getWidth(), lib.get(R.drawable.pawn).getHeight());
		c.drawBitmap(lib.get(R.drawable.pawn), r, new Rect(0 + x,0+ y,lib.get(R.drawable.pawn).getWidth()+ x, lib.get(R.drawable.pawn).getHeight()+ y), paint);
		
		// civ: petit: w83, h126, grand: w160, h200
		x = 636;
		y = 548;
		r = new Rect(0 ,0,lib.get(R.drawable.civ0).getWidth(), lib.get(R.drawable.civ0).getHeight());
		c.drawBitmap(lib.get(R.drawable.civ0), r, new Rect(0 + x,0+ y,lib.get(R.drawable.civ0).getWidth()+ x, lib.get(R.drawable.civ0).getHeight()+ y), paint);
		
		// buil: petit: w78, h96, grand: w135, h135
		x = 20;
		y = 603;
		r = new Rect(0 ,0,lib.get(R.drawable.build1).getWidth(), lib.get(R.drawable.build1).getHeight());
		c.drawBitmap(lib.get(R.drawable.build1), r, new Rect(0 + x,0+ y,lib.get(R.drawable.build1).getWidth()+ x, lib.get(R.drawable.build1).getHeight()+ y), paint);
	}
		
	private void drawCommodities(Canvas c){
	
	}
	
	private void drawBuildings(Canvas c){
	
	}
	
	private void drawCivilizations(Canvas c){
	
	}
	
	private void drawPawns(Canvas c){
	
	}
	
	private void drawPlayers(Canvas c){
	
	}

	private boolean isOnFocus(Rect r) {
		return FOCUS.contains(r) || Rect.intersects(FOCUS, r);
	}

	private Rect relates(Rect r) {
		return new Rect(r.left - x, r.top - y, r.right - x, r.bottom - y);
	}

	public void moveX(int dx) {
		if (this.x + dx < 0) {
			this.x = 0;
		} else if (this.x + dx > BACKGROUND_WIDTH - SCREEN_WIDTH) {
			this.x = BACKGROUND_WIDTH - SCREEN_WIDTH;
		} else {
			this.x += dx;
		}

		FOCUS = new Rect(x, y, x + SCREEN_WIDTH, y + SCREEN_HEIGHT);
	}

	public void moveY(int dy) {
		if (this.y + dy < 0) {
			this.y = 0;
		} else if (this.y + dy > BACKGROUND_HEIGHT - SCREEN_HEIGHT) {
			this.y = BACKGROUND_HEIGHT - SCREEN_HEIGHT;
		} else {
			this.y += dy;
		}

		FOCUS = new Rect(x, y, x + SCREEN_WIDTH, y + SCREEN_HEIGHT);
	}
}