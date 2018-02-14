package hw2;

/**
 * Simplified model of American baseball.
 * 
 * THIS CODE WILL NOT COMPILE UNTIL YOU HAVE ADDED STUBS FOR ALL METHODS
 * SPECIFIED IN THE JAVADOC
 * 
 * @author Mason Walls
 *HW 2 baseball
 */
public class CS227Baseball {
	public static final int BALL = 0;
	public static final int STRIKE = 1;
	public static final int POP_FLY = 2;
	public static final int MAX_STRIKES = 3;
	public static final int MAX_BALLS = 4;
	public static final int MAX_OUTS = 3;
	private boolean isOver = false;//If game is over or not
	private int numBalls = 0;//number of balls outside of strike zone, specific to one batter
	private int numStrikes = 0;//number of strikes thrown to one batter
	private int numOuts = 0;//number of outs for the team
	private int team1Score = 0;//team 1 score
	private int team2Score = 0;//team 2 score
	private boolean isTopInning = true;//true if its the first half of the inning
	private int inningNum = 1;//starts at 1, records current inning being played
	private int totalInnings;//max number of innings
	private boolean[] Base = new boolean[4];

	/**constructs a CS227 Baseball object with a set amount of innings.
	 * 
	 * @param givenNumInnings The number of innings in the game*/
	public CS227Baseball(int givenNumInnings) {
		//makes sure all bases are false/empty
		for (int i = 0; i < 4; i++)
			Base[i] = false;
		isTopInning = true;
		totalInnings = givenNumInnings;
	}

	// Takes outcome, and accounts for strike, ball, pop fly
	// if strikes>2 or balls>3, player is out or moves the bases
	/**
	 * A pith where the player doesnt advance any bases
	 * 
	 * @param outcome What happens with the pitch
	 */
	public void pitch(int outcome) {
		if (!isOver) {
			//Adds 1 to balls
			if (outcome == 0)
				numBalls++;
			if (outcome == 1)
				numStrikes++;
			//pop fly is an instant out
			if (outcome == 2) {
				numOuts++;
				numStrikes = 0;
				numBalls = 0;
			}
			//makes sure batter is struck out
			if (numStrikes == 3) {
				numOuts++;
				numStrikes = 0;
				numBalls = 0;
			}
			//make sure a walk is given
			if (numBalls == 4) {
				advanceRunners(true);
				numBalls=0;
			}
			//switches sides if outs=3
			if (numOuts == 3) {
				numBalls = 0;
				numStrikes = 0;
				numOuts = 0;
				if (!isTopInning)
					inningNum++;
				isTopInning = !isTopInning;
				for (int i = 0; i < 4; i++)
					Base[i] = false;
			}
			//makes sure game ends without extra innings
			if (inningNum > totalInnings)
			{
				isOver = true;
			}
		}

	}

	// Sets num strikes to 0, and calls advanceRunners, numBases times
	/**
	 * A pitch were all bases move a given number of times
	 * @param numBases The number of bases the player(s) move
	 */
	public void pitchWithHit(int numBases) 
	{
		if (!isOver) 
		{
			numBalls=0;
			numStrikes = 0;
			//first advance is always true
				advanceRunners(true);
				//the rest are not, for loop to iterate
				//-1 because the first one is accounted for
				for(int i = 0; i<numBases-1;i++)
				{
					advanceRunners(false);
				}
		}
	}

	// Calls advanceRunnesre numBases times, and sees if there is a runner on
	// whichBaseFielded-1, if so, they are out
	/**
	 * A pith where players advance bases and the fielding team throws the ball to try and get an out
	 * @param numBases The number of bases the player(s) move
	 * @param whichBaseFielded The base at which the ball is thrown to
	 */
	public void pitchWithHitAndOut(int numBases, int whichBaseFielded) {
		if (!isOver) {
			numStrikes = 0;
			//first advance always has a runner
			advanceRunners(true);
			//iterates through remaining hits, no runner added to base 1
			for(int i = 0; i<numBases-1;i++)
			{
				advanceRunners(false);
			}
			//making sure an out is recorded if ball is at a base with the runner
			if (whichBaseFielded == 4 && Base[3] == true) {
				numOuts++;
				Base[3] = false;
				if (isTopInning)
					team1Score--;
				else
					team2Score--;
			} else if (Base[whichBaseFielded - 1]) {
				numOuts++;
				Base[whichBaseFielded - 1] = false;
			}
			//switching sides
			if (numOuts == 3) {
				numBalls = 0;
				numStrikes = 0;
				numOuts = 0;
				if (!isTopInning)
					inningNum++;
				isTopInning = !isTopInning;
				for (int i = 0; i < 4; i++)
					Base[i] = false;
			}
			//makes sure game doesnt go to extra innings
			if (inningNum > totalInnings)
			{
				isOver = true;
			}
		}
	}

	// Base[3] is home plate. If someone is there they get removed
	// Starting from array position 2, if true, set false, and move him up
	// if a new player is added, Base[0]=true
	/**
	 * Moves every player one base
	 * @param newPlayerOnFirst Adds a player to first base if true
	 */
	public void advanceRunners(boolean newPlayerOnFirst) {
		if (!isOver) {
			if (Base[3])
				Base[3] = false;
			for (int i = 2; i >= 0; i--) {
				if (Base[i] == true) {
					Base[i] = false;
					Base[i + 1] = true;
				}

			}
			if (newPlayerOnFirst)
				Base[0] = true;
			if (Base[3]) {
				if (isTopInning)
					team1Score++;
				else
					team2Score++;
			}
		}
	}

	// returns strikes
	/**
	 * Redturn the number of strikes for the batter
	 * @return Number of strikes of the current batter
	 */
	public int getStrikes() {
		return numStrikes;
	}

	// returns balls
	/**
	 * Return the number of balls for the batter
	 * @return Number of balls of the current batter
	 */
	public int getBalls() {
		return numBalls;
	}

	// returns inning number
	/**
	 * Return the current inning number
	 * @return The inning that is being played
	 */
	public int getInning() {
		return inningNum;
	}

	// returns if it is the top of the inning
	/**
	 * Returns if it the top of the inning
	 * @return True if it is the top of the current inning
	 */
	public boolean isTop() {
		return isTopInning;
	}

	// returns if the game is over
	/**
	 * Returns if the game is over
	 * @return True if the max number of innings is exceeded
	 */
	public boolean isOver() {
		return isOver;
	}

	// returns true if player is on first
	/**
	 * Returns true if there is a player on first
	 * @return player on first
	 */
	public boolean playerOnFirst() {
		return Base[0];
	}

	// returns true if player on second
	/**
	 * Returns true if there is a player on second
	 * @return player on second
	 */
	public boolean playerOnSecond() {
		return Base[1];
	}

	// returns true if player on third
	/**
	 * Returns true if there is a player on third
	 * @return player on third
	 */
	public boolean playerOnThird() {
		return Base[2];
	}

	// ifTop, return team1, !itTop, return team 2
	/**
	 * Returns the score of the given team
	 * @param team the given teams score
	 * @return score of team
	 */
	public int getScore(boolean team) {
		if (team)
			return team1Score;
		else
			return team2Score;
	}

	// return outs
	/**
	 * Returns the number of outs
	 * @return Number of outs
	 */
	public int getOuts() {
		return numOuts;
	}

	/**
	 * Returns a three-character string representing the players on base, in the
	 * order first, second, and third, where 'X' indicates a player is present and
	 * 'o' indicates no player. For example, the string "XXo" means that there are
	 * players on first and second but not on third.
	 * 
	 * @return three-character string showing players on base
	 */
	public String getBases() {
		return (playerOnFirst() ? "X" : "o") + (playerOnSecond() ? "X" : "o") + (playerOnThird() ? "X" : "o");
	}

	/**
	 * Returns a one-line string representation of the current game state. The
	 * format is:
	 * 
	 * <pre>
	 *    ooo Inning:1 (T) Score:0-0 Balls:0 Strikes:0 Outs:0
	 * </pre>
	 * 
	 * The first three characters represent the players on base as returned by the
	 * <code>getBases()</code> method. The 'T' after the inning number indicates
	 * it's the top of the inning, and a 'B' would indicate the bottom.
	 * 
	 * @return one-line string representation of the game state
	 */
	public String toString() {
		String bases = getBases();
		String topOrBottom = (isTop() ? "T" : "B");
		String fmt = "%s Inning:%d (%s) Score:%d-%d Balls:%d Strikes:%d Outs:%d";
		return String.format(fmt, bases, getInning(), topOrBottom, getScore(true), getScore(false), getBalls(),
				getStrikes(), getOuts());
	}

	/**
	 * Returns a multi-line string representation of the current game state. The
	 * format is:
	 * 
	 * <pre>
	 *     o - o    Inning:1 (T)
	 *     |   |    Score:0-0
	 *     o - H    Balls:0 Strikes:0 Outs:0
	 * </pre>
	 * 
	 * The 'T' after the inning number indicates it's the top of the inning, and a
	 * 'B' would indicate the bottom.
	 * 
	 * @return multi-line string representation of current game state
	 */
	public String toDisplayString() {
		String firstChar = (playerOnFirst() ? "X" : "o");
		String secondChar = (playerOnSecond() ? "X" : "o");
		String thirdChar = (playerOnThird() ? "X" : "o");
		String topOrBottom = (isTopInning ? "T" : "B");
		String firstLine = String.format("%s - %s    Inning:%d (%s)\n", secondChar, firstChar, getInning(),
				topOrBottom);
		String secondLine = String.format("|   |    Score:%d-%d\n", getScore(true), getScore(false));
		String thirdLine = String.format("%s - H    Balls:%d Strikes:%d Outs:%d\n", thirdChar, getBalls(), getStrikes(),
				getOuts());
		return firstLine + secondLine + thirdLine;
	}

}
