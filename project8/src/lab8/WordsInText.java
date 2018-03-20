package lab8;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordsInText
{
  public static void main(String[] args) throws FileNotFoundException
  {
    File file = new File("story.txt");
    Scanner scan = new Scanner(file);
    while(scan.hasNextLine())
    {
    	String line = scan.nextLine();
    	Scanner temp = new Scanner(line);
    	int words = 0;
    	while(temp.hasNext())
    	{
    		String word = temp.next();
    		words++;
    	}
    	temp.close();
    	System.out.println(words);
    }
    scan.close();
  }
  
}
