package com.skula.agedepierre.activities.views;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

import com.skula.agedepierre.services.Drawer;

public class BoardView extends View {
	private Paint paint;
	private Resources res;
	private Drawer drawer;
	private int x0;
	private int y0;
	

	public BoardView(Context context) {
		super(context);
		this.res = context.getResources();
		this.drawer = new Drawer(res);
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
			drawer.moveX(x0 - x);
			drawer.moveY(y0 - y);
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
