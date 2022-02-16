/**
 * 
 */
package com.interview.deckofcards.bo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.interview.deckofcards.beans.Card;
import com.interview.deckofcards.beans.Deck;
import com.interview.deckofcards.utils.DeckUtil;

/**
 * @author rawatpraveen1000@gmail.com
 *
 */
@Service
public class DeckOfCardsBO {
	private static Map<String, Deck> deckMap = new HashMap<String, Deck>();

	/**
	 * 
	 * @return
	 */
	public String generateDeckId() {
		String deckID = DeckUtil.generateRandomDeckID();
		Deck deck = Deck.newStandardDeck();
		deck.shuffle(null);

		deckMap.put(deckID, deck);
		return deckID;
	}

	/**
	 * This method gives the card and provided location else message that no card
	 * exists if deck does not have that index
	 * 
	 * @param deckID
	 * @param locationID
	 * @return
	 */
	public Map<String, String> getNextCardInTheDeck(String deckID, Integer locationID) {
		Deck deck = deckMap.get(deckID);
		Map<String, String> hmap = new HashMap<String, String>();
		try {
			if (locationID > deckMap.get(deckID).getCards().size()) {
				throw new Exception();
			}
			Card crd = deck.getCards().get(locationID);
			String card = crd.toString();
			hmap.put("card", card);
			hmap.put("nextLocationID", String.valueOf(locationID + 1));
			List cardList = deckMap.get(deckID).getCards();
			boolean flag = cardList.remove(crd);
			deckMap.get(deckID).setCards(cardList);
		} catch (Exception e) {
			hmap = new HashMap<String, String>();
			hmap.put("message", "Does not exists in the card!");
		}
		return hmap;
	}

	/**
	 * This skips the card and give next location.
	 * 
	 * @param deckID
	 * @param locationID
	 * @return
	 */
	public Map<String, String> skipNextCardInTheDeck(String deckID, Integer locationID) {
		Deck deck = deckMap.get(deckID);
		Map<String, String> hmap = new HashMap<String, String>();
		try {
			if (locationID > deckMap.get(deckID).getCards().size()) {
				throw new Exception();
			}
			hmap.put("card", deck.getCards().get(locationID).toString());
			hmap.put("nextLocationID", String.valueOf(locationID + 1));
		} catch (Exception e) {
			hmap.put("message", "Deck does not enough cards to found at index:" + locationID);
		}
		return hmap;
	}
}
