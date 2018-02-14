package lab5;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import balloon4.Balloon;
public class BalloonTests {
		private static final double EPSILON = 10e-07;
	    @Test
	    public void testInitial()
	    {
	      Balloon b = new Balloon(5);
	      b.blow(5);
	      assertEquals(5.0, b.getRadius(),EPSILON);
	      assertEquals(false,b.isPopped());
	    }
	    @Test
	    public void testDeflate()
	    {
	      //balloon 4 says that is rad=0, balloon is popped
	      Balloon b = new Balloon(5);
	      b.deflate();
	      assertEquals(0.0, b.getRadius(),EPSILON);
	      assertEquals(false,b.isPopped());
	    }
	    @Test
	    public void testPop()
	    {
	      Balloon b = new Balloon(5);
	      assertEquals(false,b.isPopped());
	      b.pop();
	      assertEquals(true,b.isPopped());
	    }
	    @Test
	    public void testOverBlow()
	    {
	      //balloon 1 says that radius can be greater than max, it doesnt pop
	      Balloon b = new Balloon(5);
	      assertEquals(false,b.isPopped());
	      b.blow(10);
	      assertEquals(0, b.getRadius(),EPSILON);
	      assertEquals(true,b.isPopped());
	    }
	    @Test  public void testTwoBlow()
		{
    	Balloon b = new Balloon(15);
    	assertEquals(false,b.isPopped());
    	b.blow(10);
    	assertEquals(10, b.getRadius(),EPSILON);
    	b.blow(5);
    	assertEquals(15, b.getRadius(),EPSILON);
		}
	    @Test public void blowAfterPop()
	    {
	    	Balloon b = new Balloon(15);
	    	b.blow(20);
	    	assertEquals(true,b.isPopped());
	    	assertEquals(0,b.getRadius(),EPSILON);
	    	b.blow(5);
	    	assertEquals(0,b.getRadius(),EPSILON);
	    }
}
	    
