package com.skula.agedepierre.models;

import java.util.ArrayList;
import java.util.List;

public class Player {
	private static final int DEFAULT_FOOD_COUNT = 12;
	private static final int DEFAULT_PAWNS_COUNT = 5;
	private int id;
	private int nPawns;
	private int nPawnsPlayed;
	private int nTools;
	private int nToolsUsed;
	private int nFarm;
	private int score;

	private int nFood;
	private int nWood;
	private int nCopper;
	private int nStone;
	private int nGold;

	private List<Integer> buildings;
	private List<Integer> civilizations;

	public static void main(String[] args) {

	}

	public Player(int id) {
		this.id = id;
		this.nPawns = DEFAULT_PAWNS_COUNT;
		this.nPawnsPlayed = 0;
		this.nTools = 0;
		this.nToolsUsed = 0;
		this.nFarm = 0;
		this.score = 0;
		this.nFood = DEFAULT_FOOD_COUNT;
		this.nWood = 0;
		this.nCopper = 0;
		this.nStone = 0;
		this.nGold = 0;
		this.buildings = new ArrayList<Integer>();
		this.civilizations = new ArrayList<Integer>();
	}

	public int getCommoditiesCount() {
		int cpt = nWood;
		cpt += nCopper;
		cpt += nStone;
		cpt += nGold;
		return cpt;
	}

	public int getCommoditiesTypesCount() {
		int cptType = 0;
		if (nWood > 0) {
			cptType++;
		}
		if (nCopper > 0) {
			cptType++;
		}
		if (nStone > 0) {
			cptType++;
		}
		if (nGold > 0) {
			cptType++;
		}
		return cptType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPawns() {
		return nPawns;
	}

	public void removePawns(int n) {
		nPawnsPlayed -= n;
	}

	public int putPawn() {
		return nPawnsPlayed++;
	}

	public int getPawnLeft() {
		return nPawns - nPawnsPlayed;
	}

	public int getPawnsPlayed() {
		return nPawnsPlayed;
	}

	public void addPawn() {
		this.nPawns++;
	}

	public int getTools() {
		return nTools;
	}

	public int getToolsLeft() {
		return nTools - nToolsUsed;
	}

	public void addTools(int nTools) {
		this.nTools += nTools;
	}

	public void useTool() {
		this.nToolsUsed++;
	}

	public void initTools() {
		this.nToolsUsed = 0;
	}

	public int getFarm() {
		return nFarm;
	}

	public void addFarm() {
		this.nFarm++;
	}

	public int getScore() {
		return score;
	}

	public void addPoints(int nPoints) {
		this.score += nPoints;
	}

	public int getFood() {
		return nFood;
	}

	public void addFood(int nFood) {
		this.nFood += nFood;
	}

	public void removeFood(int nFood) {
		if (this.nFood - nFood < 0) {
			this.nFood = 0;
		} else {
			this.nFood -= nFood;
		}
	}

	public void emptyFood() {
		this.nFood = 0;
	}

	public int getWood() {
		return nWood;
	}

	public void addWood(int nWood) {
		this.nWood += nWood;
	}

	public void removeWood(int nWood) {
		if (this.nWood - nWood < 0) {
			this.nWood = 0;
		} else {
			this.nWood -= nWood;
		}
	}

	public int getCopper() {
		return nCopper;
	}

	public void addCopper(int nCopper) {
		this.nCopper += nCopper;
	}

	public void removeCopper(int nCopper) {
		if (this.nCopper - nCopper < 0) {
			this.nCopper = 0;
		} else {
			this.nCopper -= nCopper;
		}
	}

	public int getStone() {
		return nStone;
	}

	public void addStone(int nStone) {
		this.nStone += nStone;
	}

	public void removeStone(int nStone) {
		if (this.nStone - nStone < 0) {
			this.nStone = 0;
		} else {
			this.nStone -= nStone;
		}
	}

	public int getGold() {
		return nGold;
	}

	public void addGold(int nGold) {
		this.nGold += nGold;
	}

	public void removeGold(int nGold) {
		if (this.nGold - nGold < 0) {
			this.nGold = 0;
		} else {
			this.nGold -= nGold;
		}
	}

	public List<Integer> getBuildings() {
		return buildings;
	}

	public void addBuilding(int building) {
		this.buildings.add(building);
	}

	public List<Integer> getCivilizations() {
		return civilizations;
	}

	public void addCivilization(int civilization) {
		this.civilizations.add(civilization);
	}
}
