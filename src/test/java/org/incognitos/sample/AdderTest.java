package org.incognitos.sample;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AdderTest {
	
	private Adder adder;
	
	@Before
	public void prepareAdder() {
		adder = new Adder();
	}
	
	@Test
	public void testAdd() {
		int sum = adder.add(1, 1);
		assertEquals("Sum of 1 + 1 is 2", 2, sum);
	}

}
