package unitTests;

import game.MazeGameConfiguration;
import maze_generator.Block;
import maze_generator.MazeGenerator;

public class MazePrinter {

	public static void main(String[] args) {
		MazeGameConfiguration.rows = 10;
		MazeGameConfiguration.columns = 15;
		MazeGenerator mg = new MazeGenerator();
		mg.generateMaze();
		Block[][] maze = mg.getMaze();
		for (Block[] blocks : maze) {
			for(Block block : blocks) {
				if(block == Block.WALL) {
					System.out.print("*");
				}else {
					System.out.print(" ");
				}
			}
			System.out.println("");
		}
	}
}
