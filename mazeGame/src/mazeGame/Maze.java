package mazeGame;

import program.MazeConfiguration;

public class Maze {
	private static boolean isPresent = false;
	private static Block[][] maze;

	public static Block[][] getMaze() {
		if (isPresent = false) {
			isPresent = true;
			maze = generateMaze(MazeConfiguration.size);
			return Maze.getMaze();
		} else {
			return maze;
		}
	}

	private Maze(int size) {
		isPresent = true;
		maze = generateMaze(size);
	}

	// TODO tengo que ver como resuelvo esto
	// Debería generar los bloques originales
	private static Block[][] generateMaze(int size) {
		int height = size * 2 + 7;
		int width = size * 2 + 17;
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
		return maze;
//		ver como se hace el travel;
	}

	// Este algoritmo recive el mapaBase y lo "limpia usando la función recursiva
	// travel
	private void generate(int a, int b, Block[][] maze) {
		// Ver si es necesario

	}

	private void travel(int a, int b, Block[][] maze) {
		if (maze[a - 1][b] == Block.free || maze[a + 1][b] == Block.free || maze[a][b - 1] == Block.free
				|| maze[a][b + 2] == Block.free) {

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
				}
				travel(a, b, maze);
			}
			case 1: {
				try {
					if (maze[a + 2][b] == Block.free) {
						maze[a + 1][b] = Block.free;
						a = a + 2;
						travel(a, b, maze);
					}
				} catch (Exception e) {
				}
				travel(a, b, maze);
			}
			case 2: {
				try {
					if (maze[a][b - 2] == Block.free) {
						maze[a][b - 1] = Block.free;
						b = b - 2;
						travel(a, b, maze);
					}
				} catch (Exception e) {
				}
				travel(a, b, maze);
			}
			case 3: {
				try {
					if (maze[a][b + 2] == Block.free) {
						maze[a][b + 1] = Block.free;
						b = b + 2;
						travel(a, b, maze);
					}
				} catch (Exception e) {
				}
				travel(a, b, maze);
			}

			}
		}
	}
}
