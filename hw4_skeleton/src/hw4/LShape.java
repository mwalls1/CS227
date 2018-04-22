package hw4;

import java.awt.Color;

import api.Block;
import api.Cell;
import api.Position;

	public class LShape extends AbstractShape
	{
		/**Position of the first cell*/
		private Position position;
		/**Array of the shapes cell*/
		private Cell[] cells;
		/**Creates a shape of type 'L'*/
		public LShape(Position givenPosition, boolean magic)
		{
			super(givenPosition);
			cells = new Cell[4];
			position = givenPosition;
			cells[0] = new Cell(new Block(Color.ORANGE, magic), position);
			Position position1 = new Position(givenPosition.row() + 1, givenPosition.col()-2);
			cells[1] = new Cell(new Block(Color.ORANGE, false), position1);
			Position position2 = new Position(givenPosition.row() + 1, givenPosition.col()-1);
			cells[2] = new Cell(new Block(Color.ORANGE, false), position2);
			Position position3 = new Position(givenPosition.row() + 1, givenPosition.col());
			cells[3] = new Cell(new Block(Color.ORANGE, false), position3);
			super.setCells(cells);
		}
}
