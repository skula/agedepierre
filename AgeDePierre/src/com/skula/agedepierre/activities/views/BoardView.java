package com.skula.agedepierre.activities.views;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

import com.skula.agedepierre.cnst.TouchAreas;
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

	private int getArea(int x, int y) {
		switch (gEngine.getWinFocus()) {
		case BOARD:
			if (TouchAreas.FOOD.contains(x, y)) {
				return TouchAreas.FOOD_ID;
			}
			if (TouchAreas.WOOD.contains(x, y)) {
				return TouchAreas.WOOD_ID;
			}
			if (TouchAreas.COPPER.contains(x, y)) {
				return TouchAreas.COPPER_ID;
			}
			if (TouchAreas.STONE.contains(x, y)) {
				return TouchAreas.STONE_ID;
			}
			if (TouchAreas.GOLD.contains(x, y)) {
				return TouchAreas.GOLD_ID;
			}
			if (TouchAreas.FARM.contains(x, y)) {
				return TouchAreas.FARM_ID;
			}
			if (TouchAreas.HUT.contains(x, y)) {
				return TouchAreas.HUT_ID;
			}
			if (TouchAreas.FACTORY.contains(x, y)) {
				return TouchAreas.FACTORY_ID;
			}
			if (TouchAreas.BTN_PUT_COMMODITY_CONFIRM.contains(x, y)) {
				return TouchAreas.BTN_PUT_COMMODITY_CONFIRM_ID;
			}
			if (TouchAreas.BUILDING_1.contains(x, y)) {
				return TouchAreas.BUILDING_1_ID;
			}
			if (TouchAreas.BUILDING_2.contains(x, y)) {
				return TouchAreas.BUILDING_2_ID;
			}
			if (TouchAreas.BUILDING_3.contains(x, y)) {
				return TouchAreas.BUILDING_3_ID;
			}
			if (TouchAreas.BUILDING_4.contains(x, y)) {
				return TouchAreas.BUILDING_4_ID;
			}
			if (TouchAreas.CIVILIZATION_1.contains(x, y)) {
				return TouchAreas.CIVILIZATION_1_ID;
			}
			if (TouchAreas.CIVILIZATION_2.contains(x, y)) {
				return TouchAreas.CIVILIZATION_2_ID;
			}
			if (TouchAreas.CIVILIZATION_3.contains(x, y)) {
				return TouchAreas.CIVILIZATION_3_ID;
			}
			if (TouchAreas.CIVILIZATION_4.contains(x, y)) {
				return TouchAreas.CIVILIZATION_4_ID;
			}
			if (TouchAreas.BTN_PUT_COMMODITY_CONFIRM.contains(x, y)) {
				return TouchAreas.BTN_PUT_COMMODITY_CONFIRM_ID;
			}
		case SELECT_COMMODITY:
			if (TouchAreas.BTN_SEL_WOOD.contains(x, y)) {
				return TouchAreas.BTN_SEL_WOOD_ID;
			}
			if (TouchAreas.BTN_SEL_COPPER.contains(x, y)) {
				return TouchAreas.BTN_SEL_COPPER_ID;
			}
			if (TouchAreas.BTN_SEL_STONE.contains(x, y)) {
				return TouchAreas.BTN_SEL_STONE_ID;
			}
			if (TouchAreas.BTN_SEL_GOLD.contains(x, y)) {
				return TouchAreas.BTN_SEL_GOLD_ID;
			}
			if (TouchAreas.BTN_SEL_COMMODITY_RESET.contains(x, y)) {
				return TouchAreas.BTN_SEL_COMMODITY_RESET_ID;
			}
			if (TouchAreas.BTN_SEL_COMMODITY_CONFIRM.contains(x, y)) {
				return TouchAreas.BTN_SEL_COMMODITY_CONFIRM_ID;
			}
		case DICES_ROLL:
			if (TouchAreas.BTN_SEL_TOOL.contains(x, y)) {
				return TouchAreas.BTN_SEL_TOOL_ID;
			}
			if (TouchAreas.BTN_SEL_TOOL_RESET.contains(x, y)) {
				return TouchAreas.BTN_SEL_TOOL_RESET_ID;
			}
			if (TouchAreas.BTN_SEL_TOOL_CONFIRM.contains(x, y)) {
				return TouchAreas.BTN_SEL_TOOL_CONFIRM_ID;
			}
		}
		return TouchAreas.NONE;
	}

	@Override
	public void draw(Canvas canvas) {
		drawer.draw(canvas);
	}
}
