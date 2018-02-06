package hw1;

public class SampleCabTest 
{
	public static void main(String[] args)
	  {
	    // constructs a new cab with a base fare of $2.00 
	    // and a per-mile rate of $3.00
	    Cab t = new Cab(3, 5);
	    
	    // initially the total miles, total cash, current rate, 
	    // and meter should be zero
	    t.pickUp();
	    t.drive(1);
	    t.dropOff();
	    t.dropOff();
	    t.dropOff();
	    t.dropOff();
	    t.dropOff();
	    t.dropOff();
	    t.dropOff();
	    t.dropOff();
	    t.dropOff();
	    
	    System.out.println(t.getTotalCash());
	  }
}
