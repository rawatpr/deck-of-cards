/**
 * 
 */
package com.interview.deckofcards.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.interview.deckofcards.beans.Deck;
import com.interview.deckofcards.bo.DeckOfCardsBO;

/**
 * @author rawatpraveen1000@gmail.com
 * 
 *         This class contains the rest enpoints for various CRUD operations.
 *
 */
@RestController
public class DeckOfCardsController {

	Logger logger = LogManager.getLogger(DeckOfCardsController.class);
	@Autowired
	private DeckOfCardsBO deckofCardsBO = null;

	/**
	 * This method generates a new Deck Id every time it is called. Also it keeps
	 * track of deckId to the deck it has created.
	 * 
	 * @return {@link Map<String,String>}
	 */
	@PostMapping("/generate-new-deck-id")
	public Map<String, String> generateNewDeckID() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("DeckID", deckofCardsBO.generateDeckId());
		return map;
	}

	@GetMapping("/getnext-card-in-deck")
	public Map<String, String> getNextCardInTheDeck(@RequestParam String deckID, @RequestParam int locationID) {
		return deckofCardsBO.getNextCardInTheDeck(deckID, locationID);
	}
	
	/**
	 * This skips the card and give next location.
	 * 
	 * @param deckID
	 * @param locationID
	 * @return
	 */
	@GetMapping("/skipnext-card-in-deck")
	public Map<String, String> skipNextCardInTheDeck(String deckID, Integer locationID) {
		return deckofCardsBO.skipNextCardInTheDeck(deckID, locationID);
	}
	
}
