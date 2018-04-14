package lab9;

import java.io.File;
import java.util.ArrayList;

public class FileLister2
{
  public static void main(String[] args)
  {
    // Choose the directory you want to list.
    // If running in Eclipse, "." will just be the current project directory.
    // Use ".." to list the whole workspace directory, or enter a path to
    // some other directory.
    File rootDirectory = new File(".");

    ArrayList<String> result = findFiles(rootDirectory);
    System.out.println(result);
  }

  /**
   * Returns a list of files beneath the given file or directory.
   * 
   * @param file
   * @return
   */
  public static ArrayList<String> findFiles(File file)
  {
    // create an empty array list...
    ArrayList<String> arr = new ArrayList<String>();
    if (!file.isDirectory()) {
		// Base case: f is a file, so just print its name
		arr.add(file.getName());
	} else {
		// Recursive case: f is a directory, so go through the
		// files and directories it contains, and recursively call
		// this method on each one
		for (File f : file.listFiles())
	      {
	      arr.addAll(findFiles(f));
	      }
	}

    return arr;
  }

  /**
   * Recursive helper method includes an array list as an argument. Filenames
   * are added to the array list as they are found.
   * 
   * @param file
   * @param list
   */
  private static void findFiles(File file, ArrayList<String> list)
  {
    if (!file.isDirectory())
    {
      // base case
      list.add(file.getName());
    }
    else
    {
      // recursively search the subdirectory
      for (File f : file.listFiles())
      {
        findFiles(f, list);
      }
    }
  }
  
  

}
