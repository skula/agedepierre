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
		this.map.put(R.drawable.tuile1, BitmapFactory.decodeResource(res, R.drawable.tuile1));
		this.map.put(R.drawable.pawn, BitmapFactory.decodeResource(res, R.drawable.pawn));
		this.map.put(R.drawable.civ0, BitmapFactory.decodeResource(res, R.drawable.civ0));
		this.map.put(R.drawable.build1, BitmapFactory.decodeResource(res, R.drawable.build1));
	}

	public Bitmap get(int id) {
		return map.get(id);
	}
}