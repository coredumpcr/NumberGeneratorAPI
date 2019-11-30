package com.cloudera.helper;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class LotteryGeneratorTest {


	private LotteryGenerator lg;

	@Before		
	public void setup() 
	{					
		lg = new LotteryGenerator();					
		System.out.println("Using @Before annotations ,executed before each test cases ");					
	}

	@Test
	public void validateNumberOfItemsGenerated() 
	{
		assertEquals(5, lg.generateNumbers(0, 4, 5).size());	
	}

	@Test(expected = IllegalArgumentException.class)
	public void whenIllegalRange_thenIllegalArgumentExceptionatisfied() 
	{
		lg.generateNumbers(0, 2, 5);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void whenNegativeParameters_thenIllegalArgumentExceptionatisfied() 
	{
		lg.generateNumbers(0, -2, 5);
	}

}
