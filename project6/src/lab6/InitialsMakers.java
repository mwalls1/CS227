package lab6;
import java.util.*;
public class InitialsMakers 
{
	public static void main(String[] args)
	  {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter your full name: ");
		System.out.println("Your initials: " +initials(scan.nextLine()));
		System.out.print("Enter a sentence: ");
		System.out.println("Index of first vowel: "+vowelPos(scan.nextLine()));
		scan.close();
	  }
	  
	  public static String initials(String text)
	  {
		 String initialsOfName = "";
		 Scanner name = new Scanner(text);
		  while(name.hasNext())
		  {
			  initialsOfName += name.next().substring(0,1);
		  }
		  name.close();
		  return initialsOfName;
	  }
	  public static int vowelPos(String text)
	  {
		  for(int i = 1; i < text.length()+1; i ++)
		  {
			  if("aeiouAEIOU".indexOf(text.substring(i-1, i))>=0)
			  {
				  return i-1;
			  }
		  }
		  return -1;
	  }
}
