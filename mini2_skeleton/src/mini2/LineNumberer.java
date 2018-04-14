package mini2;

import api.Transformation;

/**
 * Transformation whose <code>apply</code> method prepends a line number to each string.  
 * For a newly created LineNumberer, the line numbers start at 1 and increase on
 * each successive call.  The line number is left-justified in a field 5 spaces wide.
 */
public class LineNumberer implements Transformation
{
  // TODO
	private int lineNum = 1;
	public String apply(String a)
	{
		String temp = "";
		temp = temp.format("%-5d"+a,lineNum);
		lineNum++;
		return temp;
	}
}