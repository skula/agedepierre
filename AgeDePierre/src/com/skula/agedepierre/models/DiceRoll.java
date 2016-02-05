package com.skula.agedepierre.models;

import java.util.Random;

public class DiceRoll {
	public static final int DIVISOR_FOOD = 2;
	public static final int DIVISOR_WOOD = 3;
	public static final int DIVISOR_COPPER = 4;
	public static final int DIVISOR_STONE = 5;
	public static final int DIVISOR_GOLD = 6;
	
	private int[] dices;
	private int sum;
	private int divisor;

	public static void main(String[] args) {
		DiceRoll dr = new DiceRoll(4, DIVISOR_GOLD);
		System.out.println(dr);
		dr.addTool();
		System.out.println(dr);
	}

	public DiceRoll(int nDices, int divisor) {
		this.divisor = divisor;
		this.dices = new int[nDices];
		Random r = new Random();
		this.sum = 0;
		for (int i = 0; i < nDices; i++) {
			dices[i] = r.nextInt(6) + 1;
			sum += dices[i];
		}
	}

	public void addTool(){
		sum += 1;
	}
	
	public int getCommodityCount() {
		return sum / divisor;
	}

	public int[] getDices() {
		return dices;
	}

	public void setDices(int[] dices) {
		this.dices = dices;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public int getDivisor() {
		return divisor;
	}

	public void setDivisor(int divisor) {
		this.divisor = divisor;
	}

	@Override
	public String toString() {
		String res = "";
		int cpt=0;
		for(int i : dices){
			if(cpt>0){
				res+=" + ";			
			}
			cpt++;
			res+=i+"";
		}
		
		res+=" : " + sum + "/" + divisor + " = " + getCommodityCount();
		return res;
	}
}
