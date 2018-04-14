package mini2;

import api.Combiner;

/**
 * Combiner that appends the first letter of a string onto
 * the accumulator.  If the string is empty, returns the 
 * accumulator.
 */
public class FirstLetterCombiner implements Combiner<String>
{
  // TODO
	public String combine(String a, String b)
	{
		String temp;
		b.trim();
		if(b.length()==0)
			return a;
		else
			temp = a + b.substring(0, 1);
		return temp;
	}
}
