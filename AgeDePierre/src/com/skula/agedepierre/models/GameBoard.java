package com.skula.agedepierre.models;

import java.util.ArrayList;
import java.util.List;

public class GameBoard {
	private static final int DEFAULT_BUILDINGS_COUNT = 7;
	private static final int DEFAULT_FOOD_COUNT = 100;
	private static final int DEFAULT_WOOD_COUNT = 28;
	private static final int DEFAULT_COPPER_COUNT = 18;
	private static final int DEFAULT_STONE_COUNT = 12;
	private static final int DEFAULT_GOLD_COUNT = 7;

	// ressources
	private int nFood;
	private int nWood;
	private int nCopper;
	private int nStone;
	private int nGold;

	// batiments et civilisations
	private List<List<Building>> buildings;
	private CivilizationDeck civilizationDeck;
	private int civilizations[];

	public static void main(String[] args) {
		GameBoard gb = new GameBoard(2);
		System.out.println(gb);
	}

	public GameBoard(int nPlayers) {
		// initialisation des ressources
		this.nFood = DEFAULT_FOOD_COUNT;
		this.nWood = DEFAULT_WOOD_COUNT;
		this.nCopper = DEFAULT_COPPER_COUNT;
		this.nStone = DEFAULT_STONE_COUNT;
		this.nGold = DEFAULT_GOLD_COUNT;

		// initialisation des batiments
		BuildingDeck buildingDeck = new BuildingDeck();
		this.buildings = new ArrayList<List<Building>>();
		for (int i = 0; i < nPlayers; i++) {
			List<Building> tmp = new ArrayList<Building>();
			for (int j = 0; j < DEFAULT_BUILDINGS_COUNT; j++) {
				tmp.add(buildingDeck.getNextCard());
			}
			buildings.add(tmp);
		}
		// initialisation des civilisations
		this.civilizationDeck = new CivilizationDeck();
		this.civilizations = new int[4];
		this.civilizations[0] = civilizationDeck.getNextCard();
		this.civilizations[1] = civilizationDeck.getNextCard();
		this.civilizations[2] = civilizationDeck.getNextCard();
		this.civilizations[3] = civilizationDeck.getNextCard();
	}

	public int getFood() {
		return nFood;
	}

	public void removeFood(int nFood) {
		if (this.nFood - nFood < 0) {
			this.nFood = 0;
		} else {
			this.nFood -= nFood;
		}
	}

	public int getWood() {
		return nWood;
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

	public void removeGold(int nGold) {
		if (this.nGold - nGold < 0) {
			this.nGold = 0;
		} else {
			this.nGold -= nGold;
		}
	}

	public int[] getCivilizations() {
		return civilizations;
	}

	public int removeCivilization(int i) {
		int res = civilizations[i];
		civilizations[i] = -1;
		return res;
	}

	public Building removeBuilding(int iRow) {
		List<Building> l = buildings.get(iRow);
		return l.remove(l.size() - 1);
	}

	public Building getCurrentBuilding(int iRow) {
		List<Building> l = buildings.get(iRow);
		return l.get(l.size() - 1);
	}

	public void updateCivilizations() {
		int tmp[] = new int[4];
		for (int i = 0; i < 4; i++) {
			tmp[i] = -1;
		}

		int cpt = 0;
		for (int i = 3; i >= 0; i--) {
			if (civilizations[i] != -1) {
				tmp[cpt] = civilizations[i];
				cpt++;
			}
		}

		for (int i = cpt - 1; i < 4; i++) {
			if (tmp[i] == -1) {
				tmp[i] = civilizationDeck.getNextCard();
			}
		}

		cpt = 0;
		for (int i = 3; i >= 0; i--) {
			civilizations[i] = tmp[cpt];
			cpt++;
		}
	}

	public List<List<Building>> getBuildings() {
		return buildings;
	}

	@Override
	public String toString() {
		return "F=" + nFood + ", W=" + nWood + ", C=" + nCopper + ", S="
				+ nStone + ", G=" + nGold + "\n" + "Civ="
				+ civilizationDeck.size();
	}

}
