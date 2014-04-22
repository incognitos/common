package org.incognitos.pattern.singleton;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public enum Einstein {
	INSTANCE;
	
	private static List<String> quotes;
	
	private static Random random;
	
	static {
		quotes = new ArrayList<String>();
		quotes.add("Insanity: doing the same thing over and over again and expecting different results.");
		quotes.add("The difference between stupidity and genius is that genius has its limits.");
		quotes.add("We cannot solve our problems with the same thinking we used when we created them.");
		quotes.add("The true sign of intelligence is not knowledge but imagination.");
		quotes.add("A man should look for what is, and not for what he thinks should be.");
	}
	
	public String quote() {
		int index = random.nextInt(quotes.size());
		return quotes.get(index);
	}
	

}
