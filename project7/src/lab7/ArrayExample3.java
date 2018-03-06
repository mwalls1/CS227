package lab7;

import java.util.Arrays;
import java.util.Scanner;
import java.util.*;
public class ArrayExample3
{
  public static void main(String[] args)
  {
    String s = "3 5 7 9 -12";
    int[] result = readNumbers(s);
    System.out.println(Arrays.toString(result));
    System.out.println(Arrays.toString(getPositiveNumbers(result)));
    System.out.println(Arrays.toString(randomExperiment(10,1000)));
  }
  
  public static int[] readNumbers(String text)
  {
    Scanner scanner = new Scanner(text);
    int count = 0;
    while (scanner.hasNextInt())
    {
      scanner.nextInt();
      count +=1;
    }
    
    int[] nums = new int[count];
    scanner = new Scanner(text);
    int index = 0;
    while (scanner.hasNextInt())
    {
      int num = scanner.nextInt();
      nums[index] = num;
      index += 1;
    }
    return nums;  
  }
  public static int[] getPositiveNumbers(int[] nums)
  {
	  int count = 0;
	  for(int i = 0; i < nums.length; i++)
	  {
		  if(nums[i]>0)
			  count++;
	  }
	  int j = 0;
	  int[] pos = new int[count];
	  for(int i = 0; i < nums.length; i++)
	  {
		  if(nums[i]>0)
		  {
			  pos[j] = nums[i];
			  j++;
		  }
	  }
	  return pos;
  }
  public static int[] randomExperiment(int max, int iters)
  {
	  int[] nums = new int[iters];
	  Random rand = new Random();
	  for(int i = 0; i < iters; i ++)
	  {
		  nums[i] = rand.nextInt(max);
	  }
	  return nums;
  }
}
