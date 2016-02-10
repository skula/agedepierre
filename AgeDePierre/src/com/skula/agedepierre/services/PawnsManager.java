package com.skula.agedepierre.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.skula.agedepierre.cnst.TouchAreas;
import com.skula.agedepierre.models.Player;

public class PawnsManager {
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

	public PawnsManager(int nPlayers) {
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
		case TouchAreas.FOOD_ID:
			if (player.getPawnLeft() > 1) {
				foodArea.add(player.getId());
				player.putPawn();
				return true;
			} else {
				return false;
			}
		case TouchAreas.WOOD_ID:
			return handleCommodityArea(player, woodArea);
		case TouchAreas.COPPER_ID:
			handleCommodityArea(player, copperArea);
		case TouchAreas.GOLD_ID:
			handleCommodityArea(player, goldArea);
		case TouchAreas.HUT_ID:
			if (hutArea == -1 && player.getPawnLeft() > 2) {
				hutArea = player.getId();
				player.putPawn();
				player.putPawn();
				return true;
			} else {
				return false;
			}
		case TouchAreas.FARM_ID:
			if (farmArea == -1 && player.getPawnLeft() > 1) {
				farmArea = player.getId();
				player.putPawn();
				return true;
			} else {
				return false;
			}
		case TouchAreas.FACTORY_ID:
			if (factoryArea == -1 && player.getPawnLeft() > 1) {
				factoryArea = player.getId();
				player.putPawn();
				return true;
			} else {
				return false;
			}
		case TouchAreas.BUILDING_1_ID:
			if (buildingAreas[0] == -1 && player.getPawnLeft() > 1) {
				buildingAreas[0] = player.getId();
				player.putPawn();
				return true;
			} else {
				return false;
			}
		case TouchAreas.BUILDING_2_ID:
			if (buildingAreas[1] == -1 && player.getPawnLeft() > 1) {
				buildingAreas[1] = player.getId();
				player.putPawn();
				return true;
			} else {
				return false;
			}
		case TouchAreas.BUILDING_3_ID:
			if (buildingAreas[2] == -1 && player.getPawnLeft() > 1) {
				buildingAreas[2] = player.getId();
				player.putPawn();
				return true;
			} else {
				return false;
			}
		case TouchAreas.BUILDING_4_ID:
			if (buildingAreas[3] == -1 && player.getPawnLeft() > 1) {
				buildingAreas[3] = player.getId();
				player.putPawn();
				return true;
			} else {
				return false;
			}
		case TouchAreas.CIVILIZATION_1_ID:
			if (civilisationAreas[0] == -1 && player.getPawnLeft() > 1) {
				civilisationAreas[0] = player.getId();
				player.putPawn();
				return true;
			} else {
				return false;
			}
		case TouchAreas.CIVILIZATION_2_ID:
			if (civilisationAreas[1] == -1 && player.getPawnLeft() > 1) {
				civilisationAreas[1] = player.getId();
				player.putPawn();
				return true;
			} else {
				return false;
			}
		case TouchAreas.CIVILIZATION_3_ID:
			if (civilisationAreas[2] == -1 && player.getPawnLeft() > 1) {
				civilisationAreas[2] = player.getId();
				player.putPawn();
				return true;
			} else {
				return false;
			}
		case TouchAreas.CIVILIZATION_4_ID:
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
		case TouchAreas.FOOD_ID:
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
		case TouchAreas.WOOD_ID:
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
		case TouchAreas.COPPER_ID:
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
		case TouchAreas.GOLD_ID:
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
		case TouchAreas.STONE_ID:
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
		case TouchAreas.HUT_ID:
			if (hutArea == player.getId()) {
				hutArea = -1;
				player.removePawns(2);
				return 2;
			} else {
				return 0;
			}
		case TouchAreas.FARM_ID:
			if (farmArea == player.getId()) {
				farmArea = -1;
				player.removePawns(1);
				return 1;
			} else {
				return 0;
			}
		case TouchAreas.FACTORY_ID:
			if (factoryArea == player.getId()) {
				factoryArea = -1;
				player.removePawns(1);
				return 1;
			} else {
				return 0;
			}
		case TouchAreas.BUILDING_1_ID:
			if (buildingAreas[0] == player.getId()) {
				buildingAreas[0] = -1;
				player.removePawns(1);
				return 0;
			} else {
				return -1;
			}
		case TouchAreas.BUILDING_2_ID:
			if (buildingAreas[1] == player.getId()) {
				buildingAreas[1] = -1;
				player.removePawns(1);
				return 1;
			} else {
				return 0;
			}
		case TouchAreas.BUILDING_3_ID:
			if (buildingAreas[2] == player.getId()) {
				buildingAreas[2] = -1;
				player.removePawns(1);
				return 1;
			} else {
				return 0;
			}
		case TouchAreas.BUILDING_4_ID:
			if (buildingAreas[3] == player.getId()) {
				buildingAreas[3] = -1;
				player.removePawns(1);
				return 1;
			} else {
				return 0;
			}
		case TouchAreas.CIVILIZATION_1_ID:
			if (civilisationAreas[0] == player.getId()) {
				civilisationAreas[0] = -1;
				player.removePawns(1);
				return 1;
			} else {
				return 0;
			}
		case TouchAreas.CIVILIZATION_2_ID:
			if (civilisationAreas[1] == player.getId()) {
				civilisationAreas[1] = -1;
				player.removePawns(1);
				return 1;
			} else {
				return 0;
			}
		case TouchAreas.CIVILIZATION_3_ID:
			if (civilisationAreas[2] == player.getId()) {
				civilisationAreas[2] = -1;
				player.removePawns(1);
				return 1;
			} else {
				return 0;
			}
		case TouchAreas.CIVILIZATION_4_ID:
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
		if (areaId == TouchAreas.FOOD_ID || areaId == TouchAreas.WOOD_ID || areaId == TouchAreas.COPPER_ID
				|| areaId == TouchAreas.STONE_ID || areaId == TouchAreas.GOLD_ID) {
			return true;
		}

		return false;
	}

	public static boolean isVillageArea(int areaId) {
		if (areaId == TouchAreas.FARM_ID || areaId == TouchAreas.HUT_ID || areaId == TouchAreas.FACTORY_ID) {
			return true;
		}

		return false;
	}

	public static boolean isBuildingArea(int areaId) {
		if (areaId == TouchAreas.BUILDING_1_ID || areaId == TouchAreas.BUILDING_2_ID
				|| areaId == TouchAreas.BUILDING_3_ID || areaId == TouchAreas.BUILDING_4_ID) {
			return true;
		}

		return false;
	}

	public static boolean isCivilizationArea(int areaId) {
		if (areaId == TouchAreas.CIVILIZATION_1_ID || areaId == TouchAreas.CIVILIZATION_2_ID
				|| areaId == TouchAreas.CIVILIZATION_3_ID || areaId == TouchAreas.CIVILIZATION_4_ID) {
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
