package hw4;

import java.awt.Color;

import api.Block;
import api.Cell;
import api.Position;

public class OShape extends AbstractShape
{
	/**Position of the first cell in the shape*/
	private Position position;
	/**Array of cells in the shape*/
	private Cell[] cells;
	/**Creates a shape of type 'O'*/
	public OShape(Position givenPosition, boolean magic)
	{
		super(givenPosition);
		cells = new Cell[4];
		position = givenPosition;
		cells[0] = new Cell(new Block(Color.YELLOW, magic), position);
		Position position1 = new Position(givenPosition.row(), givenPosition.col()+1);
		cells[1] = new Cell(new Block(Color.YELLOW, false), position1);
		Position position2 = new Position(givenPosition.row() + 1, givenPosition.col());
		cells[2] = new Cell(new Block(Color.YELLOW, false), position2);
		Position position3 = new Position(givenPosition.row() + 1, givenPosition.col()+1);
		cells[3] = new Cell(new Block(Color.YELLOW, false), position3);
		super.setCells(cells);
	}
	/**This shape doesnt move, so need its own transform*/
	@Override
	public void transform()
	{
		//do nothing
	}
}