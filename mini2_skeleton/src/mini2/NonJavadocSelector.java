package mini2;

import api.Selector;

/**
 * Selector that returns false if the current string is
 * within a javadoc comment, true otherwise.  Using a NonJavadocSelector
 * in the filter method of a StringList has the effect of removing all
 * javadoc comments.  Note that we are assuming that javadoc comments
 * always start and end on different lines, and that no executable
 * code ever appears on the same line as a javadoc comment.
 */
public class NonJavadocSelector implements Selector
{
  // TODO
	private boolean inComment = false;
	public boolean select(String a)
	{
		if(a.contains("/**"))
		{
			inComment = true;
			return false;
		}
		if(a.contains("*/"))
		{
			inComment = false;
			return false;
		}
		if(inComment)
		{
			return false;
		}
		return true;
	}
}
