
package hw4;
import api.Block;
import api.Cell;
import api.Position;
import api.Shape;

/**
 * Abstract superclass for implementations of the Shape interface.
 */
public abstract class AbstractShape implements Shape
{
	/**The array of cells for the abstract shape*/
	private Cell[] cells;
	/**The position of the first cell*/
	private Position position;
	/**Constructor to create an abstract shape object */
	protected AbstractShape (Position a)
	{
		position = a;
	}
	/**Setter method to copy Cell array from sub class*/
	protected void setCells(Cell[] a)
	{
		cells = a;
	}
	/**getter method that returns each cell in the shape*/
	@Override
	public Cell[] getCells() {
		Cell[] copy = new Cell[cells.length];
		for(int i = 0; i < copy.length; i++)
			copy[i] = new Cell(cells[i]);
	    return copy;
	}
	/**Moves every cells row value down by 1*/
	@Override
	public void shiftDown() {
		position.setRow(position.row() + 1);
		for(int i = 0; i < cells.length; i++)
		{
			cells[i].setRow(cells[i].getRow()+1);
		}
		
	}
	/**Moves every cells column value left by 1*/
	@Override
	public void shiftLeft() {
		position.setCol(position.col() - 1);
		for(int i = 0; i < cells.length; i++)
		{
			cells[i].setCol(cells[i].getCol()-1);
		}
		
	}
	/**Moves every cells column value right by 1*/
	@Override
	public void shiftRight() {
		position.setCol(position.col() + 1);
		for(int i = 0; i < cells.length; i++)
		{
			cells[i].setCol(cells[i].getCol()+1);
		}
		
	}
	/**Rotates the cell about its axis of rotation counter clockwise*/
	@Override
	public void transform() {
		int row = position.row();
		int col = position.col();
		for(int i = 0; i < cells.length; i ++)
		{
			cells[i].setRow(cells[i].getRow()-row);
			cells[i].setCol(cells[i].getCol()-col);
			int r = cells[i].getRow();
			int c = cells[i].getCol();
			cells[i].setRow(-c+row);
			cells[i].setCol(r+col);
		}
		
	}
	/**Moves the blocks in the cell array up by one indicie, last one becomes the first one*/
	@Override
	public void cycle() {
		Block temp = cells[cells.length-1].getBlock();
		for(int i = cells.length-1; i >=1; i --)
		{
			cells[i].setBlock(cells[i-1].getBlock());
		}
		cells[0].setBlock(temp);
	}
	/**deep clones the shape object for testing*/
  @Override
  public Shape clone()
  {
    try
    {
      AbstractShape s = (AbstractShape)super.clone();
      s.position = new Position(position);
      s.cells = new Cell[cells.length];
      for(int i = 0; i < cells.length; i++)
      {
    	  s.cells[i] = new Cell(cells[i]);
      }
      return s;
    }
    catch (CloneNotSupportedException e)
    {
      // can't happen
      return null;
    }
  }
}
