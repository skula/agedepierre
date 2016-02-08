package com.skula.agedepierre.services;

import java.util.List;

import com.skula.agedepierre.cnst.Cnst;
import com.skula.agedepierre.enums.Phase;
import com.skula.agedepierre.enums.WindowFocus;
import com.skula.agedepierre.models.Building;
import com.skula.agedepierre.models.DiceRoll;
import com.skula.agedepierre.models.GameBoard;
import com.skula.agedepierre.models.Player;

public class GameEngine {
	public Player[] players;
	private int roundToken;
	public int token;
	private int nPlayers;
	public Phase phase;
	private GameBoard gameBoard;
	private AreasHandler areasHandler;
	private WindowFocus winFocus;

	// variables temporaires
	private int putAreaId;
	private DiceRoll diceRoll;
	private int[] commoditiesSel;
	private int buildingsRow;

	public GameEngine(int nPlayers) {
		this.nPlayers = nPlayers;
		this.putAreaId = AreasHandler.AREA_NONE;
		this.phase = Phase.PUT;
		this.token = 0;
		this.roundToken = 0;
		this.players = new Player[nPlayers];
		for (int i = 0; i < nPlayers; i++) {
			this.players[i] = new Player(i);
		}

		this.gameBoard = new GameBoard(nPlayers);
		this.areasHandler = new AreasHandler(nPlayers);
		this.diceRoll = null;
		this.winFocus = WindowFocus.BOARD;
		
		// bouchon areasHandler
		areasHandler.putPawn(players[token], AreasHandler.AREA_FARM);
		areasHandler.putPawn(players[token], AreasHandler.AREA_FACTORY);
		areasHandler.putPawn(players[token], AreasHandler.AREA_WOOD);
		areasHandler.putPawn(players[token], AreasHandler.AREA_WOOD);
		areasHandler.putPawn(players[token], AreasHandler.AREA_WOOD);
		areasHandler.putPawn(players[token], AreasHandler.AREA_WOOD);
		areasHandler.putPawn(players[token], AreasHandler.AREA_WOOD);
		areasHandler.putPawn(players[token], AreasHandler.AREA_WOOD);
		areasHandler.putPawn(players[token], AreasHandler.AREA_WOOD);
	}

	public void nextPlayer() {
		switch (phase) {
		case PUT:
			if (areAllPawnsPut()) {
				phase = Phase.USE;
				token = roundToken;
			} else {
				do {
					if (token + 1 == nPlayers) {
						token = 0;
					} else {
						token += 1;
					}
				} while (players[token].getPawnLeft() == 0);
			}
			break;
		case USE:
			break;
		case FEED:
			if (token + 1 == nPlayers) {
				token = 0;
			} else {
				token += 1;
			}

			if (token == roundToken) {
				if (roundToken + 1 == nPlayers) {
					roundToken = 0;
				} else {
					roundToken += 1;
				}
				token = roundToken;
				phase = Phase.PUT;
			}
			break;
		default:
			break;
		}

		this.putAreaId = AreasHandler.AREA_NONE;
	}

	public boolean process(int areaId) {
		switch (phase) {
		case PUT:
			return processPUT(areaId);
		case USE:
			return processUSE(areaId);
		case FEED:
			return processFEED(areaId);
		default:
			return false;
		}
	}

	private boolean processPUT(int areaId) {
		boolean res = false;
		// 1) cas de fin de population d'une zone a plusieurs pions
		if (areaId == AreasHandler.AREA_BUTTON_OK) {
			nextPlayer();
			return true;
		}
		// 2) cas de population d'une zone a plusieurs pions
		if (AreasHandler.isCommodityArea(areaId)) {
			// 2.1) cas de debut de population
			if (putAreaId == AreasHandler.AREA_NONE) {
				res = areasHandler.putPawn(players[token], areaId);
				if (res) {
					putAreaId = areaId;
				}
				return res;
			} // 2.2) cas de suite de population
			else {
				if (putAreaId != areaId) {
					return false;
				}
				return areasHandler.putPawn(players[token], areaId);
			}
		} // 3) cas de population d'une zone a pion unique
		else {
			res = areasHandler.putPawn(players[token], areaId);
			if (res) {
				nextPlayer();
			}
			return res;
		}
	}

	private boolean processUSE(int areaId) {
		int nPawns = areasHandler.removePawns(players[token], areaId);
		if (nPawns == 0) {
			return false;
		}

		switch (areaId) {
		// TODO: choix utiliser outil ou pas pour les ressources
		case AreasHandler.AREA_FOOD:
			this.diceRoll = new DiceRoll(nPawns, DiceRoll.DIVISOR_FOOD);
			this.winFocus = WindowFocus.DICES_ROLL;
			break;
		case AreasHandler.AREA_WOOD:
			this.diceRoll = new DiceRoll(nPawns, DiceRoll.DIVISOR_WOOD);
			this.winFocus = WindowFocus.DICES_ROLL;
			break;
		case AreasHandler.AREA_COPPER:
			this.diceRoll = new DiceRoll(nPawns, DiceRoll.DIVISOR_COPPER);
			this.winFocus = WindowFocus.DICES_ROLL;
			break;
		case AreasHandler.AREA_STONE:
			this.diceRoll = new DiceRoll(nPawns, DiceRoll.DIVISOR_STONE);
			this.winFocus = WindowFocus.DICES_ROLL;
			break;
		case AreasHandler.AREA_GOLD:
			this.diceRoll = new DiceRoll(nPawns, DiceRoll.DIVISOR_GOLD);
			this.winFocus = WindowFocus.DICES_ROLL;
			break;
		case AreasHandler.AREA_HUT:
			players[token].addPawn();
			break;
		case AreasHandler.AREA_FARM:
			players[token].addFarm();
			break;
		case AreasHandler.AREA_FACTORY:
			players[token].addTools(1);
			break;
		case AreasHandler.AREA_BUILDING_1:
			if (canBuyBuilding(0)) {
				if (gameBoard.getCurrentBuilding(0).getCostType() == Building.COST_TYPE_COMMODITY_FIXED) {
					resolveBuilding(0);
				} else {
					this.buildingsRow = 0;
					this.winFocus = WindowFocus.SELECT_COMMODITY;
				}
			}
			break;
		case AreasHandler.AREA_BUILDING_2:
			if (canBuyBuilding(1)) {
				if (gameBoard.getCurrentBuilding(1).getCostType() == Building.COST_TYPE_COMMODITY_FIXED) {
					resolveBuilding(1);
				} else {
					this.buildingsRow = 1;
					this.winFocus = WindowFocus.SELECT_COMMODITY;
				}
			}
			break;
		case AreasHandler.AREA_BUILDING_3:
			if (canBuyBuilding(2)) {
				if (gameBoard.getCurrentBuilding(2).getCostType() == Building.COST_TYPE_COMMODITY_FIXED) {
					resolveBuilding(2);
				} else {
					this.buildingsRow = 2;
					this.winFocus = WindowFocus.SELECT_COMMODITY;
				}
			}
			break;
		case AreasHandler.AREA_BUILDING_4:
			if (canBuyBuilding(3)) {
				if (gameBoard.getCurrentBuilding(3).getCostType() == Building.COST_TYPE_COMMODITY_FIXED) {
					resolveBuilding(3);
				} else {
					this.buildingsRow = 3;
					this.winFocus = WindowFocus.SELECT_COMMODITY;
				}
			}
			break;
		case AreasHandler.AREA_CIVILIZATION_1:
			resolveCivilization(players[token], gameBoard.removeCivilization(0));
			break;
		case AreasHandler.AREA_CIVILIZATION_2:
			resolveCivilization(players[token], gameBoard.removeCivilization(1));
			break;
		case AreasHandler.AREA_CIVILIZATION_3:
			resolveCivilization(players[token], gameBoard.removeCivilization(2));
			break;
		case AreasHandler.AREA_CIVILIZATION_4:
			resolveCivilization(players[token], gameBoard.removeCivilization(3));
			break;
		case AreasHandler.AREA_BUTTON_BACK:
			break;
		case AreasHandler.AREA_BUTTON_CANCEL:
			break;
		case AreasHandler.AREA_BUTTON_OK:
			resolveBuilding(buildingsRow);
			break;
		case AreasHandler.AREA_BUTTON_SEL_TOOL_MINUS:
			break;
		case AreasHandler.AREA_BUTTON_SEL_TOOL_PLUS:
			if (players[token].getToolsLeft() > 0) {
				players[token].useTool();
				diceRoll.addTool();
			}
			break;
		case AreasHandler.AREA_BUTTON_SEL_WOOD_MINUS:
			handleCommoditySel(Cnst.WOOD_ID, -1);
			break;
		case AreasHandler.AREA_BUTTON_SEL_WOOD_PLUS:
			handleCommoditySel(Cnst.WOOD_ID, 1);
			break;
		case AreasHandler.AREA_BUTTON_SEL_COPPER_MINUS:
			handleCommoditySel(Cnst.COPPER_ID, -1);
			break;
		case AreasHandler.AREA_BUTTON_SEL_COPPER_PLUS:
			handleCommoditySel(Cnst.COPPER_ID, 1);
			break;
		case AreasHandler.AREA_BUTTON_SEL_STONE_MINUS:
			handleCommoditySel(Cnst.STONE_ID, -1);
			break;
		case AreasHandler.AREA_BUTTON_SEL_STONE_PLUS:
			handleCommoditySel(Cnst.STONE_ID, 1);
			break;
		case AreasHandler.AREA_BUTTON_SEL_GOLD_MINUS:
			handleCommoditySel(Cnst.GOLD_ID, -1);
			break;
		case AreasHandler.AREA_BUTTON_SEL_GOLD_PLUS:
			handleCommoditySel(Cnst.GOLD_ID, 1);
			break;
		default:
			return false;
		}

		if (this.winFocus == WindowFocus.BOARD && players[token].getPawnsPlayed() == 0) {
			nextPlayer();
		}
		return true;
	}

	private boolean processFEED(int areaId) {
		// TODO: demander d'utiliser des ressources si pas assez de food
		int foodReq = players[token].getPawns() * 2;
		int food = players[token].getFood() + players[token].getFarm();
		if (food < foodReq) {
			players[token].emptyFood();
			players[token].addPoints(-10);
		} else {
			players[token].removeFood(foodReq - players[token].getFarm());
		}
		nextPlayer();
		return true;
	}

	private void handleCommoditySel(int c, int n) {
		switch (c) {
		case Cnst.WOOD_ID:
			if (commoditiesSel[Cnst.WOOD_ID] + n >= 0 && commoditiesSel[Cnst.WOOD_ID] + n <= players[token].getWood()) {
				commoditiesSel[Cnst.WOOD_ID] += n;
			}
			break;
		case Cnst.COPPER_ID:
			if (commoditiesSel[Cnst.COPPER_ID] + n >= 0
					&& commoditiesSel[Cnst.COPPER_ID] + n <= players[token].getCopper()) {
				commoditiesSel[Cnst.COPPER_ID] += n;
			}
			break;
		case Cnst.STONE_ID:
			if (commoditiesSel[Cnst.STONE_ID] + n >= 0
					&& commoditiesSel[Cnst.STONE_ID] + n <= players[token].getStone()) {
				commoditiesSel[Cnst.STONE_ID] += n;
			}
			break;
		case Cnst.GOLD_ID:
			if (commoditiesSel[Cnst.GOLD_ID] + n >= 0 && commoditiesSel[Cnst.GOLD_ID] + n <= players[token].getGold()) {
				commoditiesSel[Cnst.GOLD_ID] += n;
			}
			break;
		}
	}

	private void handleToolSel() {
		// TODO: gérer la liste des outils utilisés dans le tour. Pour l'UI?

	}

	private boolean canBuyBuilding(int id) {
		Building b = gameBoard.getCurrentBuilding(id);
		if (b.getCostType() == Building.COST_COUNT_COMMODITY_FIXED) {
			return players[token].getCommoditiesCount() >= b.getnCommodities()
					&& players[token].getCommoditiesTypesCount() >= b.getnCommoditiesType();

		} else if (b.getCostType() == Building.COST_COUNT_COMMODITY_NOT_FIXED) {
			return players[token].getWood() > 0 || players[token].getCopper() > 0 || players[token].getStone() > 0
					|| players[token].getGold() > 0;
		} else if (b.getCostType() == Building.COST_TYPE_COMMODITY_FIXED) {
			return players[token].getWood() >= b.getWood() && players[token].getStone() >= b.getStone()
					&& players[token].getCopper() >= b.getCopper() && players[token].getGold() >= b.getGold();
		}
		return false;
	}

	// TODO: a utilsier dans l'UI
	private boolean isCommoditySelOk(int id) {
		Building b = gameBoard.getCurrentBuilding(id);
		if (b.getCostType() == Building.COST_COUNT_COMMODITY_FIXED) {
			int cpt = 0;
			int cptType = 0;
			for (int i : commoditiesSel) {
				cpt += commoditiesSel[i];
				if (commoditiesSel[i] > 0) {
					cptType++;
				}
			}
			if (cpt == b.getnCommodities() && cptType == b.getnCommoditiesType()) {
				return true;
			}
			return false;
		} else if (b.getCostType() == Building.COST_COUNT_COMMODITY_NOT_FIXED) {
			int cpt = 0;
			for (int i : commoditiesSel) {
				cpt += commoditiesSel[i];
			}
			return cpt <= 7 && cpt > 0;
		} else if (b.getCostType() == Building.COST_TYPE_COMMODITY_FIXED) {
			return players[token].getWood() >= b.getWood() && players[token].getStone() >= b.getStone()
					&& players[token].getCopper() >= b.getCopper() && players[token].getGold() >= b.getGold();
		}
		return false;
	}

	private void resolveBuilding(int id) {
		Building b = gameBoard.getCurrentBuilding(id);
		if (b.getCostType() == Building.COST_COUNT_COMMODITY_FIXED) {
			int points = 0;
			for (int i : commoditiesSel) {
				switch (i) {
				case Cnst.WOOD_ID:
					points += commoditiesSel[i] * DiceRoll.DIVISOR_WOOD;
					break;
				case Cnst.COPPER_ID:
					points += commoditiesSel[i] * DiceRoll.DIVISOR_COPPER;
					break;
				case Cnst.STONE_ID:
					points += commoditiesSel[i] * DiceRoll.DIVISOR_STONE;
					break;
				case Cnst.GOLD_ID:
					points += commoditiesSel[i] * DiceRoll.DIVISOR_GOLD;
					break;
				}
			}
			players[token].addPoints(points);
			gameBoard.removeBuilding(id);
			initCommoditiesSel();
		} else if (b.getCostType() == Building.COST_COUNT_COMMODITY_NOT_FIXED) {
			int points = 0;
			for (int i : commoditiesSel) {
				switch (i) {
				case Cnst.WOOD_ID:
					points += commoditiesSel[i] * DiceRoll.DIVISOR_WOOD;
					break;
				case Cnst.COPPER_ID:
					points += commoditiesSel[i] * DiceRoll.DIVISOR_COPPER;
					break;
				case Cnst.STONE_ID:
					points += commoditiesSel[i] * DiceRoll.DIVISOR_STONE;
					break;
				case Cnst.GOLD_ID:
					points += commoditiesSel[i] * DiceRoll.DIVISOR_GOLD;
					break;
				}
			}
			players[token].addPoints(points);
			gameBoard.removeBuilding(id);
			initCommoditiesSel();
		} else if (b.getCostType() == Building.COST_TYPE_COMMODITY_FIXED) {
			players[token].addPoints(b.getReward());
			players[token].removeWood(b.getWood());
			players[token].removeCopper(b.getCopper());
			players[token].removeStone(b.getStone());
			players[token].removeGold(b.getGold());
			gameBoard.removeBuilding(id);
			initCommoditiesSel();
		}
	}

	private void resolveCivilization(Player p, int b) {
		// TODO: resolveCivilization a faire
	}

	private boolean isEndOfGame() {
		for (int i : gameBoard.getCivilizations()) {
			if (gameBoard.getCivilizations()[i] == -1) {
				return true;
			}
		}

		for (List<Building> l : gameBoard.getBuildings()) {
			if (l.size() == 0) {
				return true;
			}
		}
		return false;
	}

	private boolean areAllPawnsPut() {
		for (Player p : players) {
			if (p.getPawnLeft() != 0) {
				return false;
			}
		}
		return true;
	}

	private void initCommoditiesSel() {
		for (int i : commoditiesSel) {
			commoditiesSel[i] = 0;
		}
	}
	
	public GameBoard getGameBoard(){
		return gameBoard;
	}

	public void setAreaId(int id) {
		this.putAreaId = id;
	}

	public AreasHandler getAreasHandler() {
		return areasHandler;
	}
}
