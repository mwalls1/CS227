package lab4;

/**
 * Edit this import to test a different version
 */
import java.util.*;
import postage1.PostageUtil;;

public class postageScanner
{
  /**
   * Tests the postage calculation utility.
   * @param args
   */
  public static void main(String[] args)
  {
	  Scanner scan = new Scanner(System.in);
	  System.out.print("Enter the weight of the letter: ");
	  double weight = scan.nextDouble();
	  System.out.println("A "+weight+" letter costs: "+PostageUtil.computePostage(weight));
   
  }

}