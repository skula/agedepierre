package com.skula.agedepierre.models;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CivilizationDeck {
	private List<Integer> cards;

	public CivilizationDeck() {
		cards = new ArrayList<Integer>();
		cards.add(0);
		cards.add(1);
		cards.add(2);
		cards.add(3);
		cards.add(4);
		cards.add(5);
		cards.add(6);
		cards.add(7);
		cards.add(8);
		cards.add(9);
		cards.add(10);
		Collections.shuffle(cards);
	}

	public List<Integer> getDeck() {
		return cards;
	}

	public int size() {
		return cards.size();
	}

	public int getNextCard() {
		if (cards.size() > 0) {
			return cards.remove(0);
		} else {
			return -1;
		}
	}
}
