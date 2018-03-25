package hw3;

import java.util.Arrays;
import java.util.Random;

import api.Direction;
import ui.ConsoleUI;

public class GameTest {
	public static void main(String[] args)
	{
		Game g = new Game(5, new GameUtil(), new Random(42));
		int[] arr = {1, 2, 3, 4, 5};
		System.out.println("Before:");
		ConsoleUI.printGrid(g);
		g.updateRowOrColumn(arr, 2, Direction.DOWN);
		System.out.println("After:");
		ConsoleUI.printGrid(g);
	}

}
