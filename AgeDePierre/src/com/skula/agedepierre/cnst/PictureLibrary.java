package com.skula.agedepierre.cnst;

import java.util.HashMap;
import java.util.Map;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.skula.agedepierre.R;

public class PictureLibrary {
	private Map<Integer, Bitmap> map;

	@SuppressLint("UseSparseArrays")
	public PictureLibrary(Resources res) {
		this.map = new HashMap<Integer, Bitmap>();
		this.map.put(R.drawable.background, BitmapFactory.decodeResource(res, R.drawable.background));
		this.map.put(R.drawable.pawn_blue, BitmapFactory.decodeResource(res, R.drawable.pawn_blue));
		this.map.put(R.drawable.pawn_green, BitmapFactory.decodeResource(res, R.drawable.pawn_green));
		this.map.put(R.drawable.pawn_yellow, BitmapFactory.decodeResource(res, R.drawable.pawn_yellow));
		this.map.put(R.drawable.pawn_red, BitmapFactory.decodeResource(res, R.drawable.pawn_red));
		this.map.put(R.drawable.civilization_1, BitmapFactory.decodeResource(res, R.drawable.civilization_1));
		this.map.put(R.drawable.building1, BitmapFactory.decodeResource(res, R.drawable.building1));
		this.map.put(R.drawable.building2, BitmapFactory.decodeResource(res, R.drawable.building2));
		this.map.put(R.drawable.building3, BitmapFactory.decodeResource(res, R.drawable.building3));
		this.map.put(R.drawable.building4, BitmapFactory.decodeResource(res, R.drawable.building4));
		this.map.put(R.drawable.building5, BitmapFactory.decodeResource(res, R.drawable.building5));
		this.map.put(R.drawable.building6, BitmapFactory.decodeResource(res, R.drawable.building6));
		this.map.put(R.drawable.building7, BitmapFactory.decodeResource(res, R.drawable.building7));
		this.map.put(R.drawable.building8, BitmapFactory.decodeResource(res, R.drawable.building8));
		this.map.put(R.drawable.building9, BitmapFactory.decodeResource(res, R.drawable.building9));
		this.map.put(R.drawable.building10, BitmapFactory.decodeResource(res, R.drawable.building10));
		this.map.put(R.drawable.building11, BitmapFactory.decodeResource(res, R.drawable.building11));
		this.map.put(R.drawable.building12, BitmapFactory.decodeResource(res, R.drawable.building12));
		this.map.put(R.drawable.building13, BitmapFactory.decodeResource(res, R.drawable.building13));
		this.map.put(R.drawable.building14, BitmapFactory.decodeResource(res, R.drawable.building14));
		this.map.put(R.drawable.building15, BitmapFactory.decodeResource(res, R.drawable.building15));
		this.map.put(R.drawable.building16, BitmapFactory.decodeResource(res, R.drawable.building16));
		this.map.put(R.drawable.building17, BitmapFactory.decodeResource(res, R.drawable.building17));
		this.map.put(R.drawable.building18, BitmapFactory.decodeResource(res, R.drawable.building18));
		this.map.put(R.drawable.building19, BitmapFactory.decodeResource(res, R.drawable.building19));
		this.map.put(R.drawable.building20, BitmapFactory.decodeResource(res, R.drawable.building20));
		this.map.put(R.drawable.building21, BitmapFactory.decodeResource(res, R.drawable.building21));
		this.map.put(R.drawable.building22, BitmapFactory.decodeResource(res, R.drawable.building22));
		this.map.put(R.drawable.paper, BitmapFactory.decodeResource(res, R.drawable.paper));
		this.map.put(R.drawable.item_building, BitmapFactory.decodeResource(res, R.drawable.item_building));
		this.map.put(R.drawable.item_farm, BitmapFactory.decodeResource(res, R.drawable.item_farm));
		this.map.put(R.drawable.item_tool, BitmapFactory.decodeResource(res, R.drawable.item_tool));
		this.map.put(R.drawable.item_food, BitmapFactory.decodeResource(res, R.drawable.item_food));
		this.map.put(R.drawable.item_wood, BitmapFactory.decodeResource(res, R.drawable.item_wood));
		this.map.put(R.drawable.item_copper, BitmapFactory.decodeResource(res, R.drawable.item_copper));
		this.map.put(R.drawable.item_stone, BitmapFactory.decodeResource(res, R.drawable.item_stone));
		this.map.put(R.drawable.item_stone, BitmapFactory.decodeResource(res, R.drawable.item_stone));
		this.map.put(R.drawable.item_gold, BitmapFactory.decodeResource(res, R.drawable.item_gold));
		this.map.put(R.drawable.item_pawn_blue, BitmapFactory.decodeResource(res, R.drawable.item_pawn_blue));
		this.map.put(R.drawable.item_pawn_green, BitmapFactory.decodeResource(res, R.drawable.item_pawn_green));
		this.map.put(R.drawable.item_pawn_red, BitmapFactory.decodeResource(res, R.drawable.item_pawn_red));
		this.map.put(R.drawable.item_pawn_yellow, BitmapFactory.decodeResource(res, R.drawable.item_pawn_yellow));
	}

	public Bitmap get(int id) {
		return map.get(id);
	}
}