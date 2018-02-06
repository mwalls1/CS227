package lab2;

public class AtomTest 
{
	public static void main (String[] args)
	{
		Atom myAtom = new Atom(92,146,92);
		System.out.println(myAtom.getAtomicMass());
		System.out.println(myAtom.getAtomicCharge());
		myAtom.decay();
		System.out.println(myAtom.getAtomicMass());
		System.out.println(myAtom.getAtomicCharge());
	}
}
