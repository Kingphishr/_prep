package ctci_test;

import static org.junit.Assert.*;

import org.junit.Test;

import ctci.Ch1_3__URLify;

public class Ch1_3__URLifyTest {
	
	Ch1_3__URLify test = new Ch1_3__URLify();
	String correct_answer = "Mr%20John%20Smith";
	
	@Test
	public void evaluateUrlify_1() {
		String urlified = test.urlify("Mr John Smith    ", 13);
		assertEquals(correct_answer, urlified);
	}

}
