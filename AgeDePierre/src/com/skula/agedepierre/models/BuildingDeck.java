package com.skula.agedepierre.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BuildingDeck {
	private List<Building> buildings;

	public BuildingDeck() {
		buildings = new ArrayList<Building>();
		buildings.add(new Building(0, Building.COST_COUNT_COMMODITY_FIXED, 1, 1, 1, 0, 12));
		buildings.add(new Building(0, Building.COST_COUNT_COMMODITY_FIXED, 0, 2, 0, 1, 14));
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