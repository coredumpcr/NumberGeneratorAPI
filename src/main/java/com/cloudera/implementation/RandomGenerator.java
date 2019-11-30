package com.cloudera.implementation;

import java.util.Random;

public interface RandomGenerator 
{
	int next();
	
	public static int  nextValue()
	{
		Random random = new Random();
	    return random.ints(0, Integer.MAX_VALUE)
			      .findFirst()
			      .getAsInt();
	}
}
