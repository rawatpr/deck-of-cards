/**
 * 
 */
package com.interview.deckofcards.beans;

import java.util.Objects;

/**
 * @author rawatpraveen1000@gmail.com
 *
 */
public final class Card {

	public enum Rank {
		ACE, DEUCE, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
	}

	public enum Suit {
		SPADES, HEARTS, DIAMOND, CLUBS
	}

	private final Rank rank;

	private final Suit suit;

	public Card(Rank rank, Suit suit) {
		this.rank = Objects.requireNonNull(rank);
		this.suit = Objects.requireNonNull(suit);
	}

	public Rank getRank() {
		return rank;
	}

	public Suit getSuit() {
		return suit;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Card))
			return false;
		Card that = (Card) obj;
		return (getRank() == that.getRank()) && (getSuit() == that.getSuit());
	}

	@Override
	public int hashCode() {
		return getRank().hashCode() * 31 + getSuit().hashCode();
	}

	@Override
	public String toString() {
		return getRank() + " of " + getSuit();
	}

}