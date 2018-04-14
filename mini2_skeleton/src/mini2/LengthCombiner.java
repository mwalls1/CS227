package mini2;

import api.Combiner;

/**
 * Adds the length of the given string to the accumulator
 * and returns the result.
 */
public class LengthCombiner implements Combiner<Integer>
{
  // TODO
	public Integer combine(Integer a, String b)
	{
		return a+b.length();
	}
}
