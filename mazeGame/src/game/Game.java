package game;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

import elements.Character;
import elements.Enemy;
import mazeGame.Block;
import mazeGame.MazeGenerator;
import userInterface.IKeyboardObserver;
import userInterface.VentanaInicio;

public class Game extends Component implements IKeyboardObserver {
	MazeGenerator mazeGenerator;
	Block[][] maze;
	Character character;
	Enemy enemy;
	Integer movements;

	public Game() {
		mazeGenerator = new MazeGenerator();
		maze = mazeGenerator.getNewMaze();
		character = new Character();
		if (MazeGameConfiguration.withEnemy) {
			enemy = new Enemy();
		}
		setFocusable(true);
	}

	public void playGame() {
		movements = 0;

	}

	public void paint(Graphics graphics) {
		paintMaze(graphics);
		character.paint(graphics, 2, 2);
		if (enemy != null) {
			enemy.paint(graphics, 6, 6);
		}
	}

	public void paintMaze(Graphics graphics) {
		int height = MazeGameConfiguration.columns;
		int width = MazeGameConfiguration.rows;
		int dimension = MazeGameConfiguration.blockDimension;
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				switch (maze[i][j]) {
				case free:
					graphics.setColor(Color.white);
					graphics.fillRect(i*dimension, j*dimension, dimension, dimension);
					break;
				case wall:
					graphics.setColor(Color.blue);
					graphics.fillRect(i*dimension, j*dimension, dimension, dimension);
					break;
				case permanentWall:
					graphics.setColor(Color.blue);
					graphics.fillRect(i*dimension, j*dimension, dimension, dimension);
					break;
				case end:
					graphics.setColor(Color.white);
					graphics.fillRect(i*dimension, j*dimension, dimension, dimension);
					break;
				}
			}
		}
	}

	public static void main(String[] args) {
		VentanaInicio.main(args);
	}

	@Override
	public void receiveEvent(int keyCode) {
		// TODO enviar eventos a todos los componentes

		// TODO Auto-generated method stub

	}
}
