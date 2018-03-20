package lab8;
import java.awt.Point;
import java.util.*;
import plotter.Plotter;
import plotter.Polyline;
import java.io.File;
import java.io.FileNotFoundException;
public class AutoLine {
	public static void main(String[] args) throws FileNotFoundException
	{
		Plotter plotter = new Plotter();
		ArrayList<Polyline> plots = readFile("hello.txt");
		for(int i = 0; i < plots.size(); i++)
		{
			plotter.plot(plots.get(i));
		}
	}
	private static ArrayList<Polyline> readFile(String filename)throws FileNotFoundException
	{
		File file = new File(filename);
		ArrayList<Polyline> lines = new ArrayList<Polyline>();
		Scanner files = new Scanner(file);
		while(files.hasNext())
		{
			String line = files.nextLine();
			System.out.println(line);
			line.trim();
			if(line.length()>0&&!line.startsWith("#"))
			{
				lines.add(createOneLine(line));
			}
		}
		files.close();
		
		return lines;
	}
	private static Polyline createOneLine(String line)
	{
		Polyline noodle;
		Scanner temp = new Scanner(line);
		if(Character.isDigit(line.charAt(0)))
		{
			int width = temp.nextInt();
			String color = temp.next();
			noodle = new Polyline(color,width);
		}
		else
		{
			String color = temp.next();
			noodle = new Polyline(color);
		}
		while(temp.hasNext())
		{
			noodle.addPoint(new Point(temp.nextInt(),temp.nextInt()));
		}
		temp.close();
		return noodle;
	}
}
