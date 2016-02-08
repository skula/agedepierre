package com.skula.agedepierre.activities.views;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

import com.skula.agedepierre.services.Drawer;
import com.skula.agedepierre.services.GameEngine;

public class BoardView extends View {
	private Paint paint;
	private Resources res;
	private Drawer drawer;
	private int x0;
	private int y0;
	
	private GameEngine gEngine;

	public BoardView(Context context, GameEngine gEngine) {
		super(context);
		this.gEngine = gEngine;
		this.res = context.getResources();
		this.drawer = new Drawer(res, gEngine);
		this.paint = new Paint();
		this.x0 = 0;
		this.y0 = 0;
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		int x = (int) event.getX();
		int y = (int) event.getY();

		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			x0 = x;
			y0 = y;
			break;
		case MotionEvent.ACTION_MOVE:
			x0 = x;
			y0 = y;
			break;
		case MotionEvent.ACTION_UP:
			x0 = 0;
			y0 = 0;
			break;
		}
		invalidate();
		return true;
	}

	@Override
	public void draw(Canvas canvas) {
		drawer.draw(canvas);
	}
}
