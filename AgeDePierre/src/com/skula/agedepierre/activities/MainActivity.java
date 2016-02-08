package com.skula.agedepierre.activities;

import android.app.Activity;
import android.os.Bundle;

import com.skula.agedepierre.activities.views.BoardView;
import com.skula.agedepierre.services.GameEngine;


public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(new BoardView(this, new GameEngine(2)));
	}
}