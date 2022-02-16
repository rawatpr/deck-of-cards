/**
 * 
 */
package com.interview.deckofcards.utils;

import java.security.SecureRandom;

/**
 * @author rawatpraveen1000@gmail.com
 *
 */
public class DeckUtil {

	public static String generateRandomDeckID() {
		String easy = RandomString.digits + "ACEFGHJKLMNPQRUVWXYabcdefhijkprstuvwx";
		RandomString deckID = new RandomString(23, new SecureRandom(), easy);

		return deckID.nextString();
	}

}
