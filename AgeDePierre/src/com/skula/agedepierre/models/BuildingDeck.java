package com.skula.agedepierre.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.skula.agedepierre.R;

public class BuildingDeck {
	private List<Building> buildings;

	public BuildingDeck() {
		buildings = new ArrayList<Building>();
		// type COST_COUNT_COMMODITY_NOT_FIXED
		buildings.add(new Building(R.drawable.building1, Building.COST_COUNT_COMMODITY_NOT_FIXED));
		buildings.add(new Building(R.drawable.building1, Building.COST_COUNT_COMMODITY_NOT_FIXED));
		buildings.add(new Building(R.drawable.building1, Building.COST_COUNT_COMMODITY_NOT_FIXED));
		// type COST_COUNT_COMMODITY_FIXED
		buildings.add(new Building(R.drawable.building2, Building.COST_COUNT_COMMODITY_FIXED, 5, 1));
		buildings.add(new Building(R.drawable.building3, Building.COST_COUNT_COMMODITY_FIXED, 5, 2));
		buildings.add(new Building(R.drawable.building4, Building.COST_COUNT_COMMODITY_FIXED, 5, 3));
		buildings.add(new Building(R.drawable.building5, Building.COST_COUNT_COMMODITY_FIXED, 5, 4));
		buildings.add(new Building(R.drawable.building6, Building.COST_COUNT_COMMODITY_FIXED, 4, 1));
		buildings.add(new Building(R.drawable.building7, Building.COST_COUNT_COMMODITY_FIXED, 4, 2));
		buildings.add(new Building(R.drawable.building8, Building.COST_COUNT_COMMODITY_FIXED, 4, 3));
		buildings.add(new Building(R.drawable.building9, Building.COST_COUNT_COMMODITY_FIXED, 4, 4));		
		// type COST_TYPE_COMMODITY_FIXED
		buildings.add(new Building(R.drawable.building10, Building.COST_COUNT_COMMODITY_NOT_FIXED, 2, 1, 0, 0, 10));
		buildings.add(new Building(R.drawable.building11, Building.COST_COUNT_COMMODITY_NOT_FIXED, 2, 0, 1, 0, 11));
		buildings.add(new Building(R.drawable.building12, Building.COST_COUNT_COMMODITY_NOT_FIXED, 1, 2, 0, 0, 11));
		buildings.add(new Building(R.drawable.building13, Building.COST_COUNT_COMMODITY_NOT_FIXED, 2, 0, 0, 1, 12));
		buildings.add(new Building(R.drawable.building14, Building.COST_COUNT_COMMODITY_NOT_FIXED, 1, 1, 1, 0, 12));
		buildings.add(new Building(R.drawable.building14, Building.COST_COUNT_COMMODITY_NOT_FIXED, 1, 1, 1, 0, 12));
		buildings.add(new Building(R.drawable.building15, Building.COST_COUNT_COMMODITY_NOT_FIXED, 1, 1, 0, 1, 13));
		buildings.add(new Building(R.drawable.building15, Building.COST_COUNT_COMMODITY_NOT_FIXED, 1, 1, 0, 1, 13));
		buildings.add(new Building(R.drawable.building16, Building.COST_COUNT_COMMODITY_NOT_FIXED, 1, 0, 2, 0, 13));
		buildings.add(new Building(R.drawable.building17, Building.COST_COUNT_COMMODITY_NOT_FIXED, 0, 2, 1, 0, 13));
		buildings.add(new Building(R.drawable.building18, Building.COST_COUNT_COMMODITY_NOT_FIXED, 0, 2, 0, 1, 14));
		buildings.add(new Building(R.drawable.building19, Building.COST_COUNT_COMMODITY_NOT_FIXED, 1, 0, 1, 1, 14));
		buildings.add(new Building(R.drawable.building19, Building.COST_COUNT_COMMODITY_NOT_FIXED, 1, 0, 1, 1, 14));
		buildings.add(new Building(R.drawable.building20, Building.COST_COUNT_COMMODITY_NOT_FIXED, 0, 1, 2, 0, 14));
		buildings.add(new Building(R.drawable.building21, Building.COST_COUNT_COMMODITY_NOT_FIXED, 0, 1, 1, 1, 15));
		buildings.add(new Building(R.drawable.building21, Building.COST_COUNT_COMMODITY_NOT_FIXED, 0, 1, 1, 1, 15));
		buildings.add(new Building(R.drawable.building22, Building.COST_COUNT_COMMODITY_NOT_FIXED, 0, 0, 2, 1, 16));
		Collections.shuffle(buildings);
	}

	public List<Building> getDeck() {
		return buildings;
	}

	public int size() {
		return buildings.size();
	}

	public Building getNextCard() {
		if (buildings.size() > 0) {
			return buildings.remove(0);
		} else {
			return null;
		}
	}
}