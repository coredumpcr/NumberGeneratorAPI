package com.cloudera.helper;

import java.util.HashSet;
import java.util.Set;

import com.cloudera.implementation.RandomGenerator;

public class LotteryGenerator 
{

	/**
	 * This Method will return a Set with random values within the specified range
	 * 
	 * @param from First Value of the Range
	 * @param to   Last Value of the Range
	 * @param number amount of values
	 * @return
	 */
	public Set<Integer> generateNumbers(int from, int to, int number) {
		
		if(from < 0 || to < 0 || (to-from) + 1 < number)
			throw new IllegalArgumentException();
		
		Set<Integer> result = new HashSet<Integer>();
		for(int i = 0; i < number; i++)
		{
			result.add(getRandom(from, to, RandomGenerator.nextValue(), result));
		}

		return result;
	}

	
    /**
     * 
     * This Method will return an unique random value and will insert it into the Set
     * 
     * @param from
     * @param to
     * @param random
     * @param result
     * @return
     */
	private int getRandom(int from, int to, int random, Set<Integer> result) {
		int randomValue = (random % (to + 1)) + from;
		boolean foundUniqueValue = false;


		while(!foundUniqueValue)
		{
			if(!result.contains(randomValue) && randomValue <= to)
			{
				result.add(randomValue);
				foundUniqueValue = true;
			}
			else
				randomValue = (RandomGenerator.nextValue() % (to + 1)) + from;
		}

		return randomValue;

	}


//	public static void main(String[] args) {
//		LotteryGenerator lg = new LotteryGenerator();
//		int from = 0; 
//		int to = 29;
//		System.out.println(lg.generateNumbers(0,3, 4));
//		System.out.println(lg.generateNumbers(0,5, 4));
//		System.out.println(lg.generateNumbers(1000,6000, 4500));
//		System.out.println(lg.generateNumbers(1,3, 4));
//		System.out.println(lg.generateNumbers(from,to, 29));
//	}

}

