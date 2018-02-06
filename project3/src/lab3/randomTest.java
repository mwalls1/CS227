package lab3;
import java.util.*;
public class randomTest 
{
	public static void main (String[] args)
	{
		Random rand = new Random();
		System.out.println(rand.nextInt(6));
		System.out.println(rand.nextInt(6));
		System.out.println(rand.nextInt(6));
		System.out.println(rand.nextInt(6));
		Random rands = new Random(137);
		System.out.println(rands.nextInt(6));
		System.out.println(rands.nextInt(6));
		System.out.println(rands.nextInt(6));
		System.out.println(rands.nextInt(6));
	}
}
