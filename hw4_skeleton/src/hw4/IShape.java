package hw4;

import java.awt.Color;

import api.Block;
import api.Cell;
import api.Position;

public class IShape extends AbstractShape
{
	/**Position of the first cell*/
	private Position position;
	/**Array of the cells*/
	private Cell[] cells;
	/**Creates a shape of type 'I'*/
	public IShape(Position givenPosition, boolean magic)
	{
		super(givenPosition);
		cells = new Cell[3];
		position = givenPosition;
		cells[0] = new Cell(new Block(Color.CYAN, magic), position);
		Position position1 = new Position(givenPosition.row() + 1, givenPosition.col());
		cells[1] = new Cell(new Block(Color.CYAN, false), position1);
		Position position2 = new Position(givenPosition.row() + 2, givenPosition.col());
		cells[2] = new Cell(new Block(Color.CYAN, false), position2);
		super.setCells(cells);
	}
}
