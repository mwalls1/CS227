package mini2;

import api.Selector;

/**
 * Selector whose <code>select</code> method returns false for strings whose first non-whitespace
 * text is "//", and true for all other strings.
 */
public class NonLineCommentSelector implements Selector
{
  // TODO
	public boolean select(String s)
	{
		s=s.trim();
		if(s.length()==0)
			return true;
		if(s.length()>=2&&s.substring(0,2).equals("//"))
		{
			return false;
		}
		return true;
	}
}