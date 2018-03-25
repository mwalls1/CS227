package hw3;

import java.util.ArrayList;
import java.util.Random;
import api.Direction;
import api.Move;
import api.TilePosition;
/**
 * @author Mason Walls
 */
/**
 * Utility class containing some elements of the basic logic for performing
 * moves in a game of "Threes".
 */
public class GameUtil {

	/**
	 * Constructor does nothing, since this object is stateless.
	 */
	public GameUtil() {
		// do nothing
	}

	/**
	 * Returns the result of merging the two given tile values, or zero if they
	 * can't be merged. The rules are: a 1 can be merged with a 2, and two values
	 * greater than 2 can be merged if they match. The result of a merge is always
	 * the sum of the tile values.
	 * 
	 * @param a
	 *            given tile value
	 * @param b
	 *            given tile value
	 * @return result of merging the two values, or zero if no merge is possible
	 */
	public int mergeValues(int a, int b) {
		if (a > 0 && b > 0 && (a + b == 3) || (a >= 3 && b == a)) {
			return a + b;
		} else {
			return 0;
		}
	}

	/**
	 * 
	 * Returns the score for a single tile value. Tiles with value less than 3 have
	 * score zero. All other values result from starting with value 3 and doubling N
	 * times, for some N; the score is 3 to the power N + 1. For example: the value
	 * 48 is obtained from 3 by doubling N = 4 times (48 / 3 is 16, which is 2 to
	 * the 4th), so the score is 3 to the power 5, or 243.
	 * 
	 * @param value
	 *            tile value for which to compute the score
	 * @return score for the given gile value
	 */
	public int getScoreForValue(int value) {
		int numDoubles = 0;
		int num = 3;
		if(value<3)
			return 0;
		if(value==3)
			return 3;
		//calculates how many times 3 is doubled
		while(num<value)
		{
			num=num*2;
			numDoubles++;
		}
		//score is value to the power of times doubled + 1
		return (int)Math.pow(3, numDoubles+1);
	}

	/**
	 * Returns a new size x size array with two nonzero cells. The nonzero cells
	 * consist of a 1 and a 2, placed randomly in the grid using the given Random
	 * instance.
	 * 
	 * @param size
	 *            width and height of the new array
	 * @param rand
	 *            random number generator to use for positioning the nonzero cells
	 * @return new size x size array
	 */
	public int[][] initializeNewGrid(int size, Random rand) {
		int[][] grid = new int[size][size];
		int numCells = size * size;

		// To select two distinct cells, think of the numCells cells as ordered
		// left to right within rows, with the rows ordered top to bottom.
		// First select two distinct integers between 0 and numCells
		int first = rand.nextInt(numCells);
		int second = rand.nextInt(numCells - 1);
		if (second >= first) {
			second += 1;
		}

		// Then, divide by size to get the row, mod by size to get column,
		// put a 1 in the first and a 2 in the other
		grid[first / size][first % size] = 1;
		grid[second / size][second % size] = 2;

		return grid;
	}

	/**
	 * Returns the total score for the given grid. The grid is not modified.
	 * 
	 * @param grid
	 *            given grid
	 * @return sum of scores for the values in the grid
	 */
	public int calculateTotalScore(int[][] grid) {
		int total = 0;
		for (int row = 0; row < grid.length; ++row) {
			for (int col = 0; col < grid[0].length; ++col) {
				total += getScoreForValue(grid[row][col]);
			}
		}
		return total;
	}

	/**
	 * Makes a copy of the given 2D array. The array must be nonempty and
	 * rectangular.
	 * 
	 * @param grid
	 *            given 2D array to copy
	 * @return copy of the given array
	 */
	public int[][] copyGrid(int[][] grid) {
		int[][] ret = new int[grid.length][grid[0].length];
		for (int row = 0; row < grid.length; ++row) {
			for (int col = 0; col < grid[0].length; ++col) {
				ret[row][col] = grid[row][col];
			}
		}
		return ret;
	}

	/**
	 * 
	 * Generate a new tile value using the given instance of Random. Values are
	 * generated such that there are 40% 1's, 40% 2's, 10% 3's, and 10% 6's.
	 * 
	 * @param rand
	 *            random number generator to use
	 * @return the value 1, 2, 3, or 6 with the specified probability
	 */
	public int generateRandomTileValue(Random rand) {
		// TODO
		//generates 1-100 then checks ranges to assign a value
		int n = rand.nextInt(10)+1;
		if(n==10)
			return 6;
		else if(n==9)
			return 3;
		else if(n<9&&n>4)
			return 2;
		else
			return 1;
	}

	/**
	 * Generates a position for a new tile. The new position is on the side of the
	 * grid opposite that of the previous move and is randomly selected from
	 * available positions in the given grid. The value of the tile is zero
	 * (typically filled in later by an associated Game instance). The given grid is
	 * not modified. If <code>lastMove</code> is null, this method returns null.
	 * 
	 * @param grid
	 *            given square array
	 * @param rand
	 *            random number generator to use
	 * @param lastMove
	 *            given direction
	 * @return new tile position
	 */
	public TilePosition generateRandomTilePosition(int[][] grid, Random rand, Direction lastMove) {
		// TODO
		TilePosition tile;
		int loc;
		//if no move, do nothing
		if(lastMove==null)
			return null;
		else if(lastMove==Direction.LEFT)
		{
			do
			{
				loc = rand.nextInt(grid[0].length);
			}while(grid[loc][grid.length-1]>0);//makes sure that a new tile cannot override an existing one
			tile = new TilePosition(loc,grid.length-1,0);
		}
		else if(lastMove==Direction.RIGHT)
		{
			do
			{
				loc = rand.nextInt(grid[0].length);
			}while(grid[loc][0]>0);//makes sure that a new tile cannot override an existing one
			tile = new TilePosition(loc,0,0);
		}
		else if(lastMove==Direction.UP)
		{
			do
			{
				loc = rand.nextInt(grid[0].length);
			}while(grid[grid.length-1][loc]>0);//makes sure that a new tile cannot override an existing one
			tile = new TilePosition(grid.length-1,loc,0);
		}
		else
		{
			do
			{
				loc = rand.nextInt(grid.length);
			}while(grid[0][loc]>0);//makes sure that a new tile cannot override an existing one
			tile = new TilePosition(0,loc,0);
		}
		return tile;
	}

	/**
	 * Shifts the array elements to the left according to the rules of the Threes
	 * game. This method only operates on a one-dimensional array of integers
	 * representing the tile values in one row or column. The Game class can use
	 * this method to shift a row or column in any direction by copying that row or
	 * column, either forward or backward, into a temporary one-dimensional array to
	 * be passed to this method. The rules are that if there is a pair of adjacent
	 * cells that can be merged, and has no empty (zero) cells to its left, then the
	 * leftmost such pair of cells is merged and everything to its right is shifted
	 * left by one cell. Otherwise, if there is an empty cell, then everything to
	 * the right of the leftmost empty cell is shifted left by one cell. Otherwise,
	 * the array is unmodified and an empty list is returned.
	 * <p>
	 * The new value for a pair of merged cells is determined by the method
	 * <code>mergeValues</code>. The method returns a list of Move objects
	 * representing the moved cells. All returned Move objects will have unspecified
	 * row/column and direction (typically filled in later by the associated Game
	 * instance). The list is in no particular order.
	 * 
	 * @param arr
	 *            array to be shifted
	 * @return list of all moves and/or merges performed in the shift
	 */
	public ArrayList<Move> shiftArray(int[] arr) {
		// TODO
		ArrayList<Move> moves = new ArrayList<Move>();
		boolean allZeroes = true;
		for(int i = 0; i < arr.length; i ++)
		{
			if(arr[i]!=0)
				allZeroes = false;//if all are zeroes, no moves performed
		}
		if(allZeroes)
			return moves;
		if (arr[0] == 0) {//if row/col starts with 0, then no merge happens
			for (int i = 0; i < arr.length - 1; i++)
			{
				arr[i] = arr[i + 1];
				if(!(arr[i]==0&&arr[i+1]==0))
					moves.add(new Move(i+1,i,arr[i]));//adding new move if the two tiles arent 0
			}
			arr[arr.length - 1] = 0;
		} else {
				if (mergeValues(arr[0], arr[1]) > 0) {//if first two values can merge, do it
					arr[0] = mergeValues(arr[0], arr[1]);
					moves.add(new Move(1,0,arr[1],arr[0],arr[0]));
					for (int j = 1; j < arr.length - 1; j++)//shift the rest of the array because they cant merge
					{
						arr[j] = arr[j + 1];
						if(!(arr[j]==0&&arr[j+1]==0))
								moves.add(new Move(j+1,j,arr[j]));
					}
					arr[arr.length - 1] = 0;
				}
				else
				{
					for(int i = 1; i < arr.length-1; i ++)//go throught the rest of the array starting at 1 cause no merge
					{
						if (mergeValues(arr[i], arr[i+1]) > 0&&arr[i-1]!=0)//if they can merge and no 0 at the left, do it
						{
							moves.add(new Move(i+1,i,arr[i+1],arr[i],mergeValues(arr[i], arr[i+1])));//new merge move
							arr[i] = mergeValues(arr[i], arr[i+1]);
							arr[i+1]=0;
							
							for (int j = i+1; j < arr.length-1; j++)//shift down the rest of the array
							{
								arr[j] = arr[j + 1];
								if(!(arr[j]==0&&arr[j+1]==0))
										moves.add(new Move(j+1,j,arr[j]));//add moves if a non zero tile is moving
							}
							arr[arr.length - 1] = 0;
						}
						else if(arr[i]==0)
						{
							arr[i] = arr[i+1];//moves a tile if the cell behind it is zero
							if(!(arr[i]==0&&arr[i+1]==0))
								moves.add(new Move(i+1,i,arr[i]));
							arr[i+1] = 0;//sets old cell to 0
						}
					}
				}
				
			}
		return moves;
	}

}
