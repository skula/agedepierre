package com.skula.agedepierre.models;

public class Building {
	public static final int COST_TYPE_COMMODITY_FIXED = 0;
	public static final int COST_COUNT_COMMODITY_FIXED = 1;
	public static final int COST_COUNT_COMMODITY_NOT_FIXED = 2;

	private int pictId;
	private int costType;
	private int nCommodities;
	private int nCommoditiesType;
	private int nWood;
	private int nCopper;
	private int nStone;
	private int nGold;
	private int reward;

	public Building(int pictId, int costType) {
		this.pictId = pictId;
		this.costType = costType;
		this.nCommodities = 7;
	}

	public Building(int pictId, int costType, int nCommodities, int nCommoditiesType) {
		this.pictId = pictId;
		this.costType = costType;
		this.nCommodities = nCommodities;
		this.nCommoditiesType = nCommoditiesType;
	}

	public Building(int pictId, int costType, int nWood, int nCopper, int nStone,
			int nGold, int reward) {
		this.pictId = pictId;
		this.costType = costType;
		this.nWood = nWood;
		this.nCopper = nCopper;
		this.nStone = nStone;
		this.nGold = nGold;
		this.reward = reward;
	}

	public int getPictId(){
		return pictId;
	}
	
	public int getCostType() {
		return costType;
	}

	public void setCostType(int costType) {
		this.costType = costType;
	}

	public int getnCommodities() {
		return nCommodities;
	}

	public void setnCommodities(int nCommodities) {
		this.nCommodities = nCommodities;
	}

	public int getnCommoditiesType() {
		return nCommoditiesType;
	}

	public void setnCommoditiesType(int nCommoditiesType) {
		this.nCommoditiesType = nCommoditiesType;
	}

	public int getWood() {
		return nWood;
	}

	public int getCopper() {
		return nCopper;
	}

	public int getStone() {
		return nStone;
	}

	public int getGold() {
		return nGold;
	}

	public int getReward() {
		return reward;
	}
}