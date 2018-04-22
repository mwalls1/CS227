package hw4;

import java.awt.Color;

import api.Block;
import api.Cell;
import api.Position;
import api.Shape;
import examples.SampleShape;

	public class TShape extends AbstractShape
	{
		/**First position of the shape*/
		private Position position;
		/**Array of cells in the shape*/
		private Cell[] cells;
		/**Creates a shape of type 'T'*/
		public TShape(Position givenPosition, boolean magic)
		{
			super(givenPosition);
			cells = new Cell[4];
			position = givenPosition;
			Position position1 = new Position(givenPosition.row() - 1, givenPosition.col());
			Position position2 = new Position(givenPosition.row(), givenPosition.col()-1);
			Position position3 = new Position(givenPosition.row(), givenPosition.col()+1);
			cells[0] = new Cell(new Block(Color.MAGENTA, magic), position1);
			cells[1] = new Cell(new Block(Color.MAGENTA, false), position2);
			cells[2] = new Cell(new Block(Color.MAGENTA, false), position);
			cells[3] = new Cell(new Block(Color.MAGENTA, false), position3);
			super.setCells(cells);
		}
}
