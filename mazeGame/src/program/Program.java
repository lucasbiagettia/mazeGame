package program;

import robado.MazeGenerator;

public class Program {
	
	public static void main(String[] args) {
		MazeGenerator mazeGenerator = new MazeGenerator();
		String stringmaze = mazeGenerator.getSymbolicMaze();
		
		//		JFrame gameWindow = new JFrame ("Primer laberinto");
//        Game game = new Game();
//        gameWindow.add(game);
//        game.playGame();
//        gameWindow.setSize(MazeGameConfiguration.rows*MazeGameConfiguration.blockDimension,MazeGameConfiguration.size*MazeGameConfiguration.blockDimension);
//        gameWindow.setLocation(300,200);
//        gameWindow.setVisible(true);
//        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
	}

}
