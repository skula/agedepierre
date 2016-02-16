package com.skula.agedepierre.services;

import java.util.List;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import com.skula.agedepierre.R;
import com.skula.agedepierre.cnst.DrawerAreas;
import com.skula.agedepierre.cnst.PictureLibrary;
import com.skula.agedepierre.cnst.TouchAreas;
import com.skula.agedepierre.models.Building;
import com.skula.agedepierre.models.GameBoard;
import com.skula.agedepierre.models.Player;
import com.skula.agedepierre.models.Point;

public class Drawer {
	private static final int SCREEN_WIDTH = 1280;
	private static final int SCREEN_HEIGHT = 736;

	private int BACKGROUND_WIDTH;
	private int BACKGROUND_HEIGHT;

	private GameEngine gEngine;
	private PictureLibrary lib;
	private Paint paint;

	private String log;

	public Drawer(Resources res, GameEngine gEngine) {
		this.paint = new Paint();
		this.lib = new PictureLibrary(res);

		this.gEngine = gEngine;

		this.BACKGROUND_WIDTH = lib.get(R.drawable.background).getWidth();
		this.BACKGROUND_HEIGHT = lib.get(R.drawable.background).getHeight();
	}

	public void draw(Canvas c) {
		drawBackground(c);
		drawPlayer(c);
		drawCommodities(c);
		drawBuildings(c);
		// drawCivilizations(c);
		drawPawns(c);
		// drawPlayers(c);

		//drawTouchAreas(c);
		drawPic(c, R.drawable.civ, new Point(0,0));
	}

	private void drawPlayer(Canvas c) {
		paint.setTextSize(18f);
		paint.setColor(Color.BLACK);
		Player p = gEngine.getPlayerUIItem();
		drawPic(c, R.drawable.paper, new Point(0,0));
		int pId = 0;
		switch (p.getId()) {
		case 0:
			pId =  R.drawable.item_pawn_red;
			break;
		case 1:
			pId = R.drawable.item_pawn_blue;
			break;
		case 2:
			pId = R.drawable.item_pawn_yellow;
			break;
		case 3:
			pId = R.drawable.item_pawn_green;
			break;
		}
		drawPic(c, pId, new Point(125,15));
		c.drawText(""+p.getPawnLeft(), 160, 40, paint);
		drawPic(c, R.drawable.item_farm, new Point(30,60));
		c.drawText(""+p.getFarm(), 70, 85, paint);
		drawPic(c, R.drawable.item_food, new Point(100,60));
		c.drawText(""+p.getFood(), 140, 85, paint);
		drawPic(c, R.drawable.item_building, new Point(170,60));
		c.drawText(""+p.getBuildings().size(), 210, 85, paint);
		
		drawPic(c, R.drawable.item_wood, new Point(30,100));
		c.drawText(""+p.getWood(), 70, 125, paint);
		drawPic(c, R.drawable.item_copper, new Point(90,100));
		c.drawText(""+p.getCopper(), 130, 125, paint);
		drawPic(c, R.drawable.item_stone, new Point(150,100));
		c.drawText(""+p.getStone(), 190, 125, paint);
		drawPic(c, R.drawable.item_gold, new Point(210,100));
		c.drawText(""+p.getGold(), 250, 125, paint);
		
		drawPic(c, R.drawable.item_tool, new Point(30,145));
	}

	private void drawTouchAreas(Canvas c) {
		paint.setStyle(Paint.Style.STROKE);
		paint.setColor(Color.WHITE);
		c.drawRect(TouchAreas.FOOD, paint);
		c.drawRect(TouchAreas.WOOD, paint);
		c.drawRect(TouchAreas.COPPER, paint);
		c.drawRect(TouchAreas.STONE, paint);
		c.drawRect(TouchAreas.GOLD, paint);
		c.drawRect(TouchAreas.BTN_PUT_COMMODITY_CONFIRM, paint);
		// village, paint);
		c.drawRect(TouchAreas.FARM, paint);
		c.drawRect(TouchAreas.HUT, paint);
		c.drawRect(TouchAreas.FACTORY, paint);
		// buildings, paint);
		c.drawRect(TouchAreas.BUILDING_1, paint);
		c.drawRect(TouchAreas.BUILDING_2, paint);
		c.drawRect(TouchAreas.BUILDING_3, paint);
		c.drawRect(TouchAreas.BUILDING_4, paint);
		// civilisations, paint);
		c.drawRect(TouchAreas.CIVILIZATION_1, paint);
		c.drawRect(TouchAreas.CIVILIZATION_2, paint);
		c.drawRect(TouchAreas.CIVILIZATION_3, paint);
		c.drawRect(TouchAreas.CIVILIZATION_4, paint);
		// fenetre de choix des ressources, paint);
		c.drawRect(TouchAreas.BTN_SEL_WOOD, paint);
		c.drawRect(TouchAreas.BTN_SEL_COPPER, paint);
		c.drawRect(TouchAreas.BTN_SEL_STONE, paint);
		c.drawRect(TouchAreas.BTN_SEL_GOLD, paint);
		c.drawRect(TouchAreas.BTN_SEL_COMMODITY_RESET, paint);
		c.drawRect(TouchAreas.BTN_SEL_COMMODITY_CONFIRM, paint);
		// fenetre lancé de dés, paint);
		c.drawRect(TouchAreas.BTN_SEL_TOOL, paint);
		c.drawRect(TouchAreas.BTN_SEL_TOOL_RESET, paint);
		c.drawRect(TouchAreas.BTN_SEL_TOOL_CONFIRM, paint);
		c.drawRect(TouchAreas.BTN_SEL_PLAYER, paint);
	}

	public void drawBackground(Canvas c) {
		c.drawBitmap(lib.get(R.drawable.background), new Rect(0, 0, BACKGROUND_WIDTH, BACKGROUND_HEIGHT), new Rect(0,
				0, SCREEN_WIDTH, SCREEN_HEIGHT), paint);
	}

	private void drawCommodities(Canvas c) {
		paint.setColor(Color.WHITE);
		paint.setTextSize(22f);
		GameBoard gBoard = gEngine.getGameBoard();
		c.drawText("" + gBoard.getWood(), DrawerAreas.COUNT_LEFT_WOOD.getX(), DrawerAreas.COUNT_LEFT_WOOD.getY(), paint);
		c.drawText("" + gBoard.getCopper(), DrawerAreas.COUNT_LEFT_COPPER.getX(), DrawerAreas.COUNT_LEFT_COPPER.getY(),
				paint);
		paint.setColor(Color.BLACK);
		c.drawText("" + gBoard.getStone(), DrawerAreas.COUNT_LEFT_STONE.getX(), DrawerAreas.COUNT_LEFT_STONE.getY(),
				paint);
		c.drawText("" + gBoard.getGold(), DrawerAreas.COUNT_LEFT_GOLD.getX(), DrawerAreas.COUNT_LEFT_GOLD.getY(), paint);
	}

	private void drawBuildings(Canvas c) {
		GameBoard gBoard = gEngine.getGameBoard();
		paint.setColor(Color.WHITE);
		paint.setTextSize(18f);
		int cpt = 1;
		for (List<Building> l : gBoard.getBuildings()) {
			if (l.size() > 0) {
				switch (cpt) {
				case 1:
					drawPic(c, l.get(0).getPictId(), DrawerAreas.TILE_BUILDING_1);
					c.drawText("x " + l.size(), DrawerAreas.TILE_BUILDING_1.clone(100, 115).getX(),
							DrawerAreas.TILE_BUILDING_1.clone(100, 115).getY(), paint);
					break;
				case 2:
					drawPic(c, l.get(0).getPictId(), DrawerAreas.TILE_BUILDING_2);
					c.drawText("x " + l.size(), DrawerAreas.TILE_BUILDING_2.clone(100, 115).getX(),
							DrawerAreas.TILE_BUILDING_2.clone(100, 115).getY(), paint);
					break;
				case 3:
					drawPic(c, l.get(0).getPictId(), DrawerAreas.TILE_BUILDING_3);
					c.drawText("x " + l.size(), DrawerAreas.TILE_BUILDING_3.clone(100, 115).getX(),
							DrawerAreas.TILE_BUILDING_3.clone(100, 115).getY(), paint);
					break;
				case 4:
					drawPic(c, l.get(0).getPictId(), DrawerAreas.TILE_BUILDING_4);
					c.drawText("x " + l.size(), DrawerAreas.TILE_BUILDING_4.clone(100, 115).getX(),
							DrawerAreas.TILE_BUILDING_4.clone(100, 115).getY(), paint);
					break;
				}
			}
			cpt++;
		}
	}

	private void drawCivilizations(Canvas c) {
		GameBoard gBoard = gEngine.getGameBoard();
		int cpt = 1;
		for (int i : gBoard.getCivilizations()) {
			switch (cpt) {
			case 1:
				drawPic(c, i, DrawerAreas.TILE_CIVILIZATION_1);
				break;
			case 2:
				drawPic(c, i, DrawerAreas.TILE_CIVILIZATION_2);
				break;
			case 3:
				drawPic(c, i, DrawerAreas.TILE_CIVILIZATION_3);
				break;
			case 4:
				drawPic(c, i, DrawerAreas.TILE_CIVILIZATION_4);
				break;
			}
			cpt++;
		}

	}

	private void drawPawns(Canvas c) {
		PawnsManager pm = gEngine.getPawnsManager();

		// village
		if (pm.getHutArea() >= 0) {
			drawPic(c, getPawnPict(pm.getHutArea()), DrawerAreas.PAWN_HUT_1);
			drawPic(c, getPawnPict(pm.getHutArea()), DrawerAreas.PAWN_HUT_2);
		}
		if (pm.getFarmArea() >= 0) {
			drawPic(c, getPawnPict(pm.getFarmArea()), DrawerAreas.PAWN_FARM);
		}
		if (pm.getFactoryArea() >= 0) {
			drawPic(c, getPawnPict(pm.getFactoryArea()), DrawerAreas.PAWN_FACTORY);
		}

		// chasse
		// TODO: a faire

		// ressources
		int cpt = 1;
		for (int i : pm.getWoodArea()) {
			if (i >= 0) {
				switch (cpt) {
				case 1:
					drawPic(c, getPawnPict(i), DrawerAreas.PAWN_WOOD_1);
					break;
				case 2:
					drawPic(c, getPawnPict(i), DrawerAreas.PAWN_WOOD_2);
					break;
				case 3:
					drawPic(c, getPawnPict(i), DrawerAreas.PAWN_WOOD_3);
					break;
				case 4:
					drawPic(c, getPawnPict(i), DrawerAreas.PAWN_WOOD_4);
					break;
				case 5:
					drawPic(c, getPawnPict(i), DrawerAreas.PAWN_WOOD_5);
					break;
				case 6:
					drawPic(c, getPawnPict(i), DrawerAreas.PAWN_WOOD_6);
					break;
				case 7:
					drawPic(c, getPawnPict(i), DrawerAreas.PAWN_WOOD_7);
					break;
				}
				cpt++;
			}
		}
		cpt = 1;
		for (int i : pm.getCopperArea()) {
			if (i >= 0) {
				switch (cpt) {
				case 1:
					drawPic(c, getPawnPict(i), DrawerAreas.PAWN_COPPER_1);
					break;
				case 2:
					drawPic(c, getPawnPict(i), DrawerAreas.PAWN_COPPER_2);
					break;
				case 3:
					drawPic(c, getPawnPict(i), DrawerAreas.PAWN_COPPER_3);
					break;
				case 4:
					drawPic(c, getPawnPict(i), DrawerAreas.PAWN_COPPER_4);
					break;
				case 5:
					drawPic(c, getPawnPict(i), DrawerAreas.PAWN_COPPER_5);
					break;
				case 6:
					drawPic(c, getPawnPict(i), DrawerAreas.PAWN_COPPER_6);
					break;
				case 7:
					drawPic(c, getPawnPict(i), DrawerAreas.PAWN_COPPER_7);
					break;
				}
				cpt++;
			}
		}
		cpt = 1;
		for (int i : pm.getStoneArea()) {
			if (i >= 0) {
				switch (cpt) {
				case 1:
					drawPic(c, getPawnPict(i), DrawerAreas.PAWN_STONE_1);
					break;
				case 2:
					drawPic(c, getPawnPict(i), DrawerAreas.PAWN_STONE_2);
					break;
				case 3:
					drawPic(c, getPawnPict(i), DrawerAreas.PAWN_STONE_3);
					break;
				case 4:
					drawPic(c, getPawnPict(i), DrawerAreas.PAWN_STONE_4);
					break;
				case 5:
					drawPic(c, getPawnPict(i), DrawerAreas.PAWN_STONE_5);
					break;
				case 6:
					drawPic(c, getPawnPict(i), DrawerAreas.PAWN_STONE_6);
					break;
				case 7:
					drawPic(c, getPawnPict(i), DrawerAreas.PAWN_STONE_7);
					break;
				}
				cpt++;
			}
		}
		cpt = 1;
		for (int i : pm.getStoneArea()) {
			if (i >= 0) {
				switch (cpt) {
				case 1:
					drawPic(c, getPawnPict(i), DrawerAreas.PAWN_GOLD_1);
					break;
				case 2:
					drawPic(c, getPawnPict(i), DrawerAreas.PAWN_GOLD_2);
					break;
				case 3:
					drawPic(c, getPawnPict(i), DrawerAreas.PAWN_GOLD_3);
					break;
				case 4:
					drawPic(c, getPawnPict(i), DrawerAreas.PAWN_GOLD_4);
					break;
				case 5:
					drawPic(c, getPawnPict(i), DrawerAreas.PAWN_GOLD_5);
					break;
				case 6:
					drawPic(c, getPawnPict(i), DrawerAreas.PAWN_GOLD_6);
					break;
				case 7:
					drawPic(c, getPawnPict(i), DrawerAreas.PAWN_GOLD_7);
					break;
				}
				cpt++;
			}
		}

		// batiments
		for (int i : pm.getBuildingAreas()) {
			switch (i) {
			case 0:
				drawPic(c, getPawnPict(i), DrawerAreas.PAWN_BUILDING_1);
				break;
			case 1:
				drawPic(c, getPawnPict(i), DrawerAreas.PAWN_BUILDING_2);
				break;
			case 2:
				drawPic(c, getPawnPict(i), DrawerAreas.PAWN_BUILDING_3);
				break;
			case 3:
				drawPic(c, getPawnPict(i), DrawerAreas.PAWN_BUILDING_4);
				break;
			default:
				break;
			}
		}

		// civilisations
		for (int i : pm.getCivilizationAreas()) {
			switch (i) {
			case 0:
				drawPic(c, getPawnPict(i), DrawerAreas.PAWN_CIVILIZATION_1);
				break;
			case 1:
				drawPic(c, getPawnPict(i), DrawerAreas.PAWN_CIVILIZATION_2);
				break;
			case 2:
				drawPic(c, getPawnPict(i), DrawerAreas.PAWN_CIVILIZATION_3);
				break;
			case 3:
				drawPic(c, getPawnPict(i), DrawerAreas.PAWN_CIVILIZATION_4);
				break;
			default:
				break;
			}
		}
	}

	private int getPawnPict(int playerId) {
		switch (playerId) {
		case 0:
			return R.drawable.pawn_red;
		case 1:
			return R.drawable.pawn_blue;
		case 2:
			return R.drawable.pawn_yellow;
		case 3:
			return R.drawable.pawn_green;
		default:
			return 0;
		}
	}

	private void drawPlayers(Canvas c) {

	}

	private void drawPic(Canvas c, int id, Point p) {
		Rect src = new Rect(0, 0, lib.get(id).getWidth(), lib.get(id).getHeight());
		Rect dest = new Rect(0 + p.getX(), 0 + p.getY(), lib.get(id).getWidth() + p.getX(), lib.get(id).getHeight()
				+ p.getY());
		c.drawBitmap(lib.get(id), src, dest, paint);
	}
}