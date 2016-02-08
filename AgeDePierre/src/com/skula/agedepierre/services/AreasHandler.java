package com.skula.agedepierre.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.skula.agedepierre.models.Player;

public class AreasHandler {
	public static final int AREA_NONE = -1;
	// zones des denrées
	public static final int AREA_FOOD = 0;
	public static final int AREA_WOOD = 1;
	public static final int AREA_COPPER = 2;
	public static final int AREA_STONE = 3;
	public static final int AREA_GOLD = 4;
	// zones du village
	public static final int AREA_FARM = 5;
	public static final int AREA_HUT = 6;
	public static final int AREA_FACTORY = 7;
	// zones batiments
	public static final int AREA_BUILDING_1 = 8;
	public static final int AREA_BUILDING_2 = 9;
	public static final int AREA_BUILDING_3 = 10;
	public static final int AREA_BUILDING_4 = 11;
	// zones civilization
	public static final int AREA_CIVILIZATION_1 = 12;
	public static final int AREA_CIVILIZATION_2 = 13;
	public static final int AREA_CIVILIZATION_3 = 14;
	public static final int AREA_CIVILIZATION_4 = 15;

	// zones boutons
	public static final int AREA_BUTTON_BACK = 16;
	public static final int AREA_BUTTON_OK = 17;
	public static final int AREA_BUTTON_CANCEL = 18;
	public static final int AREA_BUTTON_SEL_TOOL_PLUS = 19;
	public static final int AREA_BUTTON_SEL_TOOL_MINUS = 20;
	public static final int AREA_BUTTON_SEL_WOOD_PLUS = 21;
	public static final int AREA_BUTTON_SEL_COPPER_PLUS = 22;
	public static final int AREA_BUTTON_SEL_STONE_PLUS = 23;
	public static final int AREA_BUTTON_SEL_GOLD_PLUS = 24;
	public static final int AREA_BUTTON_SEL_WOOD_MINUS = 25;
	public static final int AREA_BUTTON_SEL_COPPER_MINUS = 26;
	public static final int AREA_BUTTON_SEL_STONE_MINUS = 27;
	public static final int AREA_BUTTON_SEL_GOLD_MINUS = 28;

	private int nPlayers;
	private List<Integer> foodArea;
	private List<Integer> woodArea;
	private List<Integer> copperArea;
	private List<Integer> stoneArea;
	private List<Integer> goldArea;

	private int hutArea;
	private int farmArea;
	private int factoryArea;

	private int[] buildingAreas;
	private int[] civilisationAreas;

	public AreasHandler(int nPlayers) {
		this.nPlayers = nPlayers;

		this.foodArea = new ArrayList<Integer>();
		this.woodArea = new ArrayList<Integer>();
		this.copperArea = new ArrayList<Integer>();
		this.stoneArea = new ArrayList<Integer>();
		this.goldArea = new ArrayList<Integer>();

		this.hutArea = -1;
		this.farmArea = -1;
		this.factoryArea = -1;

		this.buildingAreas = new int[nPlayers];
		for (int i = 0; i < nPlayers; i++) {
			this.buildingAreas[i] = -1;
		}

		this.civilisationAreas = new int[4];
		for (int i = 0; i < 4; i++) {
			this.civilisationAreas[i] = -1;
		}
	}

	public boolean putPawn(Player player, int areaId) {
		switch (areaId) {
		case AREA_FOOD:
			if (player.getPawnLeft() > 1) {
				foodArea.add(player.getId());
				player.putPawn();
				return true;
			} else {
				return false;
			}
		case AREA_WOOD:
			return handleCommodityArea(player, woodArea);
		case AREA_COPPER:
			handleCommodityArea(player, copperArea);
		case AREA_GOLD:
			handleCommodityArea(player, goldArea);
		case AREA_HUT:
			if (hutArea == -1 && player.getPawnLeft() > 2) {
				hutArea = player.getId();
				player.putPawn();
				player.putPawn();
				return true;
			} else {
				return false;
			}
		case AREA_FARM:
			if (farmArea == -1 && player.getPawnLeft() > 1) {
				farmArea = player.getId();
				player.putPawn();
				return true;
			} else {
				return false;
			}
		case AREA_FACTORY:
			if (factoryArea == -1 && player.getPawnLeft() > 1) {
				factoryArea = player.getId();
				player.putPawn();
				return true;
			} else {
				return false;
			}
		case AREA_BUILDING_1:
			if (buildingAreas[0] == -1 && player.getPawnLeft() > 1) {
				buildingAreas[0] = player.getId();
				player.putPawn();
				return true;
			} else {
				return false;
			}
		case AREA_BUILDING_2:
			if (buildingAreas[1] == -1 && player.getPawnLeft() > 1) {
				buildingAreas[1] = player.getId();
				player.putPawn();
				return true;
			} else {
				return false;
			}
		case AREA_BUILDING_3:
			if (buildingAreas[2] == -1 && player.getPawnLeft() > 1) {
				buildingAreas[2] = player.getId();
				player.putPawn();
				return true;
			} else {
				return false;
			}
		case AREA_BUILDING_4:
			if (buildingAreas[3] == -1 && player.getPawnLeft() > 1) {
				buildingAreas[3] = player.getId();
				player.putPawn();
				return true;
			} else {
				return false;
			}
		case AREA_CIVILIZATION_1:
			if (civilisationAreas[0] == -1 && player.getPawnLeft() > 1) {
				civilisationAreas[0] = player.getId();
				player.putPawn();
				return true;
			} else {
				return false;
			}
		case AREA_CIVILIZATION_2:
			if (civilisationAreas[1] == -1 && player.getPawnLeft() > 1) {
				civilisationAreas[1] = player.getId();
				player.putPawn();
				return true;
			} else {
				return false;
			}
		case AREA_CIVILIZATION_3:
			if (civilisationAreas[2] == -1 && player.getPawnLeft() > 1) {
				civilisationAreas[2] = player.getId();
				player.putPawn();
				return true;
			} else {
				return false;
			}
		case AREA_CIVILIZATION_4:
			if (civilisationAreas[3] == -1 && player.getPawnLeft() > 1) {
				civilisationAreas[3] = player.getId();
				player.putPawn();
				return true;
			} else {
				return false;
			}
		default:
			return false;
		}
	}

	private boolean handleCommodityArea(Player player, List<Integer> c) {
		if (player.getPawnLeft() < 1 || c.size() == 7) {
			return false;
		}

		if (nPlayers == 2) {
			if (getOtherThan(c, player.getId()) > 0) {
				return false;
			}
			c.add(player.getId());
			player.putPawn();
			return true;
		} else if (nPlayers == 3) {
			if (getOtherThan(c, player.getId()) > 1) {
				return false;
			}
			c.add(player.getId());
			player.putPawn();
			return true;
		} else {
			c.add(player.getId());
			player.putPawn();
			return true;
		}
	}

	public int removePawns(Player player, int areaId) {
		int cpt = 0;
		List<Integer> tmp = new ArrayList<Integer>();
		switch (areaId) {
		case AREA_FOOD:
			for (Integer i : foodArea) {
				if (i != player.getId()) {
					tmp.add(i);
				} else {
					cpt++;
				}
			}
			foodArea = tmp;
			player.removePawns(cpt);
			return cpt;
		case AREA_WOOD:
			for (Integer i : woodArea) {
				if (i != player.getId()) {
					tmp.add(i);
				} else {
					cpt++;
				}
			}
			woodArea = tmp;
			player.removePawns(cpt);
			return cpt;
		case AREA_COPPER:
			for (Integer i : copperArea) {
				if (i != player.getId()) {
					tmp.add(i);
				} else {
					cpt++;
				}
			}
			copperArea = tmp;
			player.removePawns(cpt);
			return cpt;
		case AREA_GOLD:
			for (Integer i : goldArea) {
				if (i != player.getId()) {
					tmp.add(i);
				} else {
					cpt++;
				}
			}
			goldArea = tmp;
			player.removePawns(cpt);
			return cpt;
		case AREA_STONE:
			for (Integer i : goldArea) {
				if (i != player.getId()) {
					tmp.add(i);
				} else {
					cpt++;
				}
			}
			stoneArea = tmp;
			player.removePawns(cpt);
			return cpt;
			// TODO: gérer le nombre de pions dans le village en fonction du
			// nombre de joueurs
		case AREA_HUT:
			if (hutArea == player.getId()) {
				hutArea = -1;
				player.removePawns(2);
				return 2;
			} else {
				return 0;
			}
		case AREA_FARM:
			if (farmArea == player.getId()) {
				farmArea = -1;
				player.removePawns(1);
				return 1;
			} else {
				return 0;
			}
		case AREA_FACTORY:
			if (factoryArea == player.getId()) {
				factoryArea = -1;
				player.removePawns(1);
				return 1;
			} else {
				return 0;
			}
		case AREA_BUILDING_1:
			if (buildingAreas[0] == player.getId()) {
				buildingAreas[0] = -1;
				player.removePawns(1);
				return 0;
			} else {
				return -1;
			}
		case AREA_BUILDING_2:
			if (buildingAreas[1] == player.getId()) {
				buildingAreas[1] = -1;
				player.removePawns(1);
				return 1;
			} else {
				return 0;
			}
		case AREA_BUILDING_3:
			if (buildingAreas[2] == player.getId()) {
				buildingAreas[2] = -1;
				player.removePawns(1);
				return 1;
			} else {
				return 0;
			}
		case AREA_BUILDING_4:
			if (buildingAreas[3] == player.getId()) {
				buildingAreas[3] = -1;
				player.removePawns(1);
				return 1;
			} else {
				return 0;
			}
		case AREA_CIVILIZATION_1:
			if (civilisationAreas[0] == player.getId()) {
				civilisationAreas[0] = -1;
				player.removePawns(1);
				return 1;
			} else {
				return 0;
			}
		case AREA_CIVILIZATION_2:
			if (civilisationAreas[1] == player.getId()) {
				civilisationAreas[1] = -1;
				player.removePawns(1);
				return 1;
			} else {
				return 0;
			}
		case AREA_CIVILIZATION_3:
			if (civilisationAreas[2] == player.getId()) {
				civilisationAreas[2] = -1;
				player.removePawns(1);
				return 1;
			} else {
				return 0;
			}
		case AREA_CIVILIZATION_4:
			if (civilisationAreas[3] == player.getId()) {
				civilisationAreas[3] = -1;
				player.removePawns(1);
				return 1;
			} else {
				return 0;
			}
		default:
			return 0;
		}
	}

	private static int getOtherThan(List<Integer> list, int id) {
		List<Integer> res = new ArrayList<Integer>();
		for (Integer i : list) {
			if (i != id && !res.contains(i)) {
				res.add(i);
			}
		}
		return res.size();
	}

	public static boolean isCommodityArea(int areaId) {
		if (areaId == AREA_FOOD || areaId == AREA_WOOD || areaId == AREA_COPPER || areaId == AREA_STONE
				|| areaId == AREA_GOLD) {
			return true;
		}

		return false;
	}

	public static boolean isVillageArea(int areaId) {
		if (areaId == AREA_FARM || areaId == AREA_HUT || areaId == AREA_FACTORY) {
			return true;
		}

		return false;
	}

	public static boolean isBuildingArea(int areaId) {
		if (areaId == AREA_BUILDING_1 || areaId == AREA_BUILDING_2 || areaId == AREA_BUILDING_3
				|| areaId == AREA_BUILDING_4) {
			return true;
		}

		return false;
	}

	public static boolean isCivilizationArea(int areaId) {
		if (areaId == AREA_CIVILIZATION_1 || areaId == AREA_CIVILIZATION_2 || areaId == AREA_CIVILIZATION_3
				|| areaId == AREA_CIVILIZATION_4) {
			return true;
		}

		return false;
	}

	public int[] getBuildingAreas() {
		return buildingAreas;
	}

	public int getBuildingArea(int i) {
		return buildingAreas[i];
	}

	public int[] getCivilizationAreas() {
		return civilisationAreas;
	}

	public int getCivilizationArea(int i) {
		return civilisationAreas[i];
	}

	@Override
	public String toString() {
		return "foodArea=" + foodArea + "\n" + "woodArea=" + woodArea + "\n" + "copperArea=" + copperArea + "\n"
				+ "stoneArea=" + stoneArea + "\n" + "goldArea=" + goldArea + "\n" + "hutArea=" + hutArea + "\n"
				+ "farmArea=" + farmArea + "\n" + "factoryArea=" + factoryArea + "\n" + "buildingAreas="
				+ Arrays.toString(buildingAreas) + "\n" + "civilisationAreas=" + Arrays.toString(civilisationAreas);
	}

	public int getHutArea() {
		return hutArea;
	}

	public int getFactoryArea() {
		return factoryArea;
	}

	public int getFarmArea() {
		return farmArea;
	}

	public List<Integer> getWoodArea() {
		return woodArea;
	}

	public List<Integer> getFoodArea() {
		return foodArea;
	}

	public List<Integer> getCopperArea() {
		return copperArea;
	}

	public List<Integer> getStoneArea() {
		return stoneArea;
	}

	public List<Integer> getGoldArea() {
		return goldArea;
	}
}
