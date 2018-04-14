package mini2;

import api.Combiner;

/**
 * Combiner whose <code>combine</code> method, given an Integer n and a string, 
 * returns n if the string is a blank line or a line containing
 * a single curly brace; otherwise returns n + 1.  (A curly brace on a line whose
 * only other text is an end-of-line comment is treated as just a curly brace.)
 * Using a SlocCounter in the reduce method has the general effect of counting 
 * the number of "source lines of code" that are actual program statements,
 * assuming that line comments and javadoc comments have already been
 * filtered out.
 */
public class SlocCounter implements Combiner<Integer>
{
  // TODO
	public Integer combine(Integer a, String b)
	{
		b = b.trim();
		if(b.length()==0)
			return a;
		if(b.contains("//"))
			return a;
		if(b.equals("}")||b.equals("{"))
			return a;
		else return a+1;
	}
}