
package hw4;

import java.util.Random;

import api.Generator;
import api.Position;
import api.Shape;

/**
 * Generator for Shape objects in MagicTetris.  All six shapes
 * are equally likely, and the generated shape is magic with
 * 20% probability.
 */
public class BasicGenerator implements Generator
{
	/**Random number generator to see if shape is magic and what shape it is*/
	 private Random rand = new Random();
	 /**Creates a new shape depening on the random number generators value*/
  @Override
  public Shape getNext(int width)
  {
    // TODO
	  boolean magic = false;
	  int mid = width/2;
	  int isMagic = rand.nextInt(5);
	  if(isMagic==0)
		  magic = true;
	  int shapeType = rand.nextInt(6);
	  if(shapeType == 0)
	  {
		  return new LShape(new Position(-1,mid+1),magic);
	  }
	  if(shapeType == 1)
	  {
		  return new JShape(new Position(-1,mid),magic);
	  }
	  if(shapeType == 2)
	  {
		  return new IShape(new Position(-2,mid),magic);
	  }
	  if(shapeType == 3)
	  {
		  return new OShape(new Position(-1,mid),magic);
	  }
	  if(shapeType == 4)
	  {
		  return new TShape(new Position(0,mid),magic);
	  }
	  if(shapeType == 5)
	  {
		  return new SZShape(new Position(-1,mid),magic);
	  }
	  return null;
  }
}
