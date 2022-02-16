/**
 * 
 */
package com.interview.deckofcards.beans;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Component;

/**
 * @author rawatpraveen1000@gmail.com
 *
 */
@Component
public class Deck {

	private List<? extends Card> cards;

	public Deck(Collection<? extends Card> cards) {
		this.cards = new ArrayList<>(cards);
	}

	public List<? extends Card> getCards() {
		return cards;
	}

	public void setCards(List<? extends Card> cards) {
		this.cards = cards;
	}

	public void shuffle(Random random) {
		if (random == null)
			random = ThreadLocalRandom.current();
		Collections.shuffle(cards, random);
	}

	public static Deck newStandardDeck() {
		List<Card> cards = new ArrayList<>();
		for (Card.Rank rank : Card.Rank.values()) {
			for (Card.Suit suit : Card.Suit.values()) {
				cards.add(new Card(rank, suit));
			}
		}
		return new Deck(cards);
	}

}