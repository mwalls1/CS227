
package hw4;

import java.util.ArrayList;
import java.util.List;

import api.AbstractGame;
import api.Block;
import api.Position;

/**
 * MagicTetris implementation.
 */
public class MagicTetris extends AbstractGame
{
	/**Players current score*/
  private int score = 0;
  /**The number of magic squares in the current cycle*/
  private int numMagic = 0;
  /**Determines if the games state is in gravity mode*/
  private boolean isGravity = false;
  /**
   * Constructs a game with the given width (columns) and height (rows).
   * This game will use a new instance of BasicGenerator to 
   * generate new shapes.
   * @param width
   *   width of the game grid (number of columns)
   * @param height
   *   height of the game grid (number of rows)
   */
  public MagicTetris(int width, int height)
  {
    super(width, height, new BasicGenerator());
  }
  /**Determines what rows are full and returns the positions of the block to remove
   * If gravity is on, returns the position of empty cells that have blocks aboce them*/
  @Override
  public List<Position> determinePositionsToCollapse()
  {
    // TODO
	 
	 List<Position> positions = new ArrayList<Position>();
	 List<Block> blocks = new ArrayList<Block>();
	 if(!isGravity)
	 {
		 numMagic = 0;
		 for(int i = 0; i < super.getHeight(); i ++)
		 {
			 for(int j = 0; j < super.getWidth(); j++)
			 {
				 //adds all blocks in the row
				 blocks.add(super.getBlock(i,j));
				 //checks for any non null block and if its magic
				 if(super.getBlock(i, j)!=null&&super.getBlock(i, j).isMagic())
				 {
					 numMagic++;
				 }
			 }
			 //if any blocks are null, clear the list
			 if(blocks.contains(null))
			 {
				 blocks.clear();
				 numMagic = 0;
			 }
			 else
			 {
				 //score is calculated based on the number of magic blocks removesd
				 score += Math.pow(2,numMagic);
				 //adds the positions of all the completed row blocks
				 for(int k = 0; k < super.getWidth(); k++)
				 {
					 positions.add(new Position(i,k));
				 }
			 }
			 if(numMagic>2)
				 isGravity = true;
			 blocks.clear();
		 }
		
	     return positions;
	 }
	 else
	 {
		 numMagic = 0;
		 for(int i = 1; i < super.getHeight(); i ++)
		 {
			 for(int j = 0; j < super.getWidth(); j++)
			 {
				 if(super.getBlock(i,j)==null)
				 {
					 //adds all positions that have a block directly above
					 if(super.getBlock(i-1,j)!=null)
						 positions.add(new Position(i,j));
					 for(int p = 0; p < positions.size(); p++)
					 {
						 //if there is an empty space below one of already slected positions, add that too
						 if(positions.get(p).row()+1==i&&positions.get(p).col()==j)
						 {
							 positions.add(new Position(i,j));
						 }
					 }
					 
				 }
			 }
		 }
		 
		 isGravity = false;
		 return positions;
	 }
  }

  @Override
  public int determineScore()
  {
    // TODO
    return score;
  }

}
