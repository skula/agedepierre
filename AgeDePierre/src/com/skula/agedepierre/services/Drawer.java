package com.skula.agedepierre.services;

import java.util.List;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import com.skula.agedepierre.R;
import com.skula.agedepierre.cnst.DrawerAreas;
import com.skula.agedepierre.cnst.PictureLibrary;
import com.skula.agedepierre.models.Building;
import com.skula.agedepierre.models.GameBoard;
import com.skula.agedepierre.models.Point;

public class Drawer {
	private static final int SCREEN_WIDTH = 1280;
	private static final int SCREEN_HEIGHT = 736;
	private static final Rect SCREEN_RECT = new Rect(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);

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
		// drawCommodities(c);
		//drawBuildings(c);
		//drawCivilizations(c);
		drawPawns(c);
		// drawPlayers(c);

		int w = lib.get(R.drawable.pawn_blue).getWidth();
		int h = lib.get(R.drawable.pawn_blue).getHeight();
		c.drawText(w + ", " + h, 50, 50, paint);
	}

	public void drawBackground(Canvas c) {
		c.drawBitmap(lib.get(R.drawable.background), new Rect(0, 0, BACKGROUND_WIDTH, BACKGROUND_HEIGHT), SCREEN_RECT,
				paint);
	}

	private void drawCommodities(Canvas c) {

	}

	private void drawBuildings(Canvas c) {
		GameBoard gBoard = gEngine.getGameBoard();
		int cpt = 1;
		for (List<Building> l : gBoard.getBuildings()) {
			if (l.size() > 0) {
				switch (cpt) {
				case 1:
					drawPic(c, l.get(0).getPictId(), DrawerAreas.TILE_BUILDING_1);
					break;
				case 2:
					drawPic(c, l.get(0).getPictId(), DrawerAreas.TILE_BUILDING_2);
					break;
				case 3:
					drawPic(c, l.get(0).getPictId(), DrawerAreas.TILE_BUILDING_3);
					break;
				case 4:
					drawPic(c, l.get(0).getPictId(), DrawerAreas.TILE_BUILDING_4);
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
		AreasHandler ah = gEngine.getAreasHandler();

		// village
		if (ah.getHutArea() >= 0) {
			drawPic(c, getPawnPict(ah.getHutArea()), DrawerAreas.PAWN_HUT_1);
			drawPic(c, getPawnPict(ah.getHutArea()), DrawerAreas.PAWN_HUT_2);
		}
		if (ah.getFarmArea() >= 0) {
			drawPic(c, getPawnPict(ah.getFarmArea()), DrawerAreas.PAWN_FARM);
		}
		if (ah.getFactoryArea() >= 0) {
			drawPic(c, getPawnPict(ah.getFactoryArea()), DrawerAreas.PAWN_FACTORY);
		}

		// chasse
		// TODO: a faire

		// ressources
		int cpt = 1;
		for (int i : ah.getWoodArea()) {
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
		for (int i : ah.getCopperArea()) {
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
		for (int i : ah.getStoneArea()) {
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
		for (int i : ah.getStoneArea()) {
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
		for (int i : ah.getBuildingAreas()) {
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
		for (int i : ah.getCivilizationAreas()) {
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