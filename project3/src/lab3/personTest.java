package lab3;

public class personTest 
{
	public static void main (String[] args)
	{
		Person man = new Person("Mark",6);
		System.out.println(man.getName());
		System.out.println(man.getAge());
		System.out.println(man.getNameLength());
	}
}
