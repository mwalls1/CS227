package lab8;
import java.util.*;
public class NoDuplicates {
	public static void main(String[] args)
	{
		ArrayList<String> list = new ArrayList<String>();
		list.add("hi");
		list.add("hi");
		list.add("hello");
		System.out.println(list.toString());
		removeDuplicates(list);
		System.out.println(list.toString());
	}
	public static void removeDuplicates(ArrayList words)
	{
		ArrayList<String> temp = new ArrayList<String>();
		for(int i = 0; i < words.size(); i ++)
		{
			if(!temp.contains(words.get(i)))
			{
				temp.add(words.get(i).toString());
			}
		}
		words.clear();
		words.addAll(temp);
	}
}
