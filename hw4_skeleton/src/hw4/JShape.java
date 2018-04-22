package hw4;

import java.awt.Color;

import api.Block;
import api.Cell;
import api.Position;

public class JShape extends AbstractShape
{
	/**Position of the first cell in the shape*/
	private Position position;
	/**Array of the shapes cells*/
	private Cell[] cells;
	/**Creates a shape of type 'J'*/
	public JShape(Position givenPosition, boolean magic)
	{
		super(givenPosition);
		cells = new Cell[4];
		position = givenPosition;
		Position positionS = new Position(givenPosition.row(),givenPosition.col()-1);
		cells[0] = new Cell(new Block(Color.BLUE, magic), positionS);
		Position position1 = new Position(givenPosition.row() + 1, givenPosition.col()-1);
		cells[1] = new Cell(new Block(Color.BLUE, false), position1);
		Position position2 = new Position(givenPosition.row() + 1, givenPosition.col());
		cells[2] = new Cell(new Block(Color.BLUE, false), position2);
		Position position3 = new Position(givenPosition.row() + 1, givenPosition.col()+1);
		cells[3] = new Cell(new Block(Color.BLUE, false), position3);
		super.setCells(cells);
	}
}
