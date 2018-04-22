package hw4;

import java.awt.Color;

import api.Block;
import api.Cell;
import api.Position;
import api.Shape;


	public class SZShape extends AbstractShape
	{
		/**Position of the first cell in the shape*/
		private Position position;
		/**Array of cells in the shape*/
		private Cell[] cells;
		/**True if the shape is red, false otherwise*/
		private boolean isRed = false;
		/**Creates a shape of type 'SZ'*/
		public SZShape(Position givenPosition, boolean magic)
		{
			super(givenPosition);
			cells = new Cell[4];
			position = givenPosition;
			cells[0] = new Cell(new Block(Color.GREEN, magic), position);
			Position position1 = new Position(givenPosition.row() + 1, givenPosition.col());
			cells[1] = new Cell(new Block(Color.GREEN, false), position1);
			Position position2 = new Position(givenPosition.row() + 1, givenPosition.col()+1);
			cells[2] = new Cell(new Block(Color.GREEN, false), position2);
			Position position3 = new Position(givenPosition.row() + 2, givenPosition.col()+1);
			cells[3] = new Cell(new Block(Color.GREEN, false), position3);
			super.setCells(cells);
		}
		/**SZ shape only transforms over an axis, so it needs its to override transform*/
		@Override
		public void transform()
		{
			if(!isRed)
			{
				cells[0].setCol(cells[0].getCol()+1);
				cells[1].setCol(cells[1].getCol()+1);
				cells[2].setCol(cells[2].getCol()-1);
				cells[3].setCol(cells[3].getCol()-1);
				//Changes colors to red
				for(int i = 0; i < cells.length; i ++)
				{
					Block temp = cells[i].getBlock();
					cells[i].setBlock(new Block(Color.RED,temp.isMagic()));
				}
				isRed = true;
			}
			else
			{
				cells[0].setCol(cells[0].getCol()-1);
				cells[1].setCol(cells[1].getCol()-1);
				cells[2].setCol(cells[2].getCol()+1);
				cells[3].setCol(cells[3].getCol()+1);
				//changes colors to green
				for(int i = 0; i < cells.length; i ++)
				{
					Block temp = cells[i].getBlock();
					cells[i].setBlock(new Block(Color.GREEN,temp.isMagic()));
				}
				isRed = false;
			}
			
		}
		/**Clone of SZ shape need to be overridden because of the isRed instance variable*/
		@Override
		  public Shape clone()
		  {
		      SZShape s = (SZShape)super.clone();
		      s.position = new Position(position);
		      s.cells = new Cell[cells.length];
		      for(int i = 0; i < cells.length; i++)
		      {
		    	  s.cells[i] = new Cell(cells[i]);
		      }
		      return s;
		    }
		  }

