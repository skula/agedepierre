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
		this.map.put(R.drawable.pawn, BitmapFactory.decodeResource(res, R.drawable.pawn));
		this.map.put(R.drawable.civ0, BitmapFactory.decodeResource(res, R.drawable.civ0));
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
	}

	public Bitmap get(int id) {
		return map.get(id);
	}
}