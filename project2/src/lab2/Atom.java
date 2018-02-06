package lab2;

public class Atom 
{
	int givenProtons;
	int givenNeutrons;
	int givenElectrons;
	public Atom(int a, int b, int c)
	{
		givenProtons = a;
		givenNeutrons = b;
		givenElectrons = c;
	}
	public int getAtomicMass()
	{
		return givenProtons+givenNeutrons;
	}
	public int getAtomicCharge()
	{
		return givenProtons-givenElectrons;
	}
	public void decay()
	{
		givenProtons-=2;
		givenNeutrons-=2;
	}
}
