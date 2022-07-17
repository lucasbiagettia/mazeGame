package mazeGame;

import game.MazeGameConfiguration;

public class MazeGenerator {
	int count = 0;

	public MazeGenerator() {
	}

	// TODO tengo que ver como resuelvo esto
	// Debería generar los bloques originales
	public Block[][] getNewMaze() {
		Block[][] maze;
		int height = MazeGameConfiguration.columns;
		int width = MazeGameConfiguration.rows;
		maze = new Block[height][width];

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				maze[i][j] = Block.wall;

				if (i % 2 == 1 && j % 2 == 1) {
					maze[i][j] = Block.free;
				}

				if (i == height - 1 && j == width - 1) {
					maze[i][j] = Block.end;
				}

				if (i % 2 == 0 && j % 2 == 0) {
					maze[i][j] = Block.permanentWall;
				}

				if (i == 0 || j == 0 || i == height || j == width) {
					maze[i][j] = Block.permanentWall;
				}
			}
		}
		travel(1, 1, maze);
		return maze;
//		ver como se hace el travel;
	}

	// Este algoritmo recive el mapaBase y lo "limpia usando la función recursiva
	// travel
	private Boolean verifyEnd(int a, int b, Block[][] maze) {
		int countFree = 0;

		if (maze[a - 1][b] == Block.free)
			countFree++;
		if (maze[a + 1][b] == Block.free)
			countFree++;
		if (maze[a][b - 1] == Block.free)
			countFree++;
		if (maze[a][b + 1] == Block.free)
			countFree++;
		return countFree >=3;
	}

	private void travel(int a, int b, Block[][] maze) {
		count++;
		// TODO de esta verificacion
		if (!verifyEnd(a, b, maze)) {
			int direccion = (int) (Math.random() * 4);
			// 0 up
			// 1 down
			// 2 right
			// 3 left

			switch (direccion) {
			case 0: {
				try {
					if (maze[a - 2][b] == Block.free) {
						maze[a - 1][b] = Block.free;
						a = a - 2;
						travel(a, b, maze);
					}
				} catch (Exception e) {
					System.out.println("Exception");
				}
				travel(a, b, maze);
				break;
			}
			case 1: {
				try {
					if (maze[a + 2][b] == Block.free) {
						maze[a + 1][b] = Block.free;
						a = a + 2;
						travel(a, b, maze);
					}
				} catch (Exception e) {
					System.out.println("Exception");
				}
				travel(a, b, maze);
				break;
			}
			case 2: {
				try {
					if (maze[a][b - 2] == Block.free) {
						maze[a][b - 1] = Block.free;
						b = b - 2;
						travel(a, b, maze);
					}
				} catch (Exception e) {
					System.out.println("Exception");
				}
				travel(a, b, maze);
				break;
			}
			case 3: {
				try {
					if (maze[a][b + 2] == Block.free) {
						maze[a][b + 1] = Block.free;
						b = b + 2;
						travel(a, b, maze);
					}
				} catch (Exception e) {
					System.out.println("Exception");
				}
				travel(a, b, maze);
				break;
			}
			}
		}
	}
}
