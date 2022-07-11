package mazeGame;

public class Maze {
	Mapa mapa = new Mapa();
	public boolean hayMapa = false;
	public Block[][] maze;

	public static int[][] getLaberinto() {
		return laberinto;
	}

	public int[][] mapa(int[][] laberinto) {
		if (!hayMapa) {
			laberinto = generateMaze();
			hayMapa = true;
			return laberinto;
		} else {
			return laberinto;
		}
	}

	// TODO tengo que ver como resuelvo esto
	// Debería generar los bloques originales
	private Block[][] generateMap (int size) {
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
		return generate(2, 2, maze);
	}

	// TODO este es el algoritmo que me genera el mapa, hay que hacer que sea
	// concordante con los tipos de blocks

	private Block[][] generate(int a, int b, Block[][] maze) {

		int direccion = (int) (Math.random() * 4);
		// 0 arriba
		// 1 abajo
		// 2 derecha
		// 3 izquierda
		switch (direccion) {
		case 0: {
			if (nuevoMapa[a - 2][b] == 0) {
				nuevoMapa[a - 1][b] = 4;
				nuevoMapa[a - 2][b] = 4;
				a = a - 2;
				recorrer(a, b, nuevoMapa);
			}
			recorrer(a, b, nuevoMapa);
		}
		case 1: {
			if (nuevoMapa[a + 2][b] == 0) {
				nuevoMapa[a + 1][b] = 4;
				nuevoMapa[a + 2][b] = 4;
				a = a + 2;
				recorrer(a, b, nuevoMapa);
			}
			recorrer(a, b, nuevoMapa);
		}
		case 2: {
			if (nuevoMapa[a][b + 2] == 0) {
				nuevoMapa[a][b + 1] = 4;
				nuevoMapa[a][b + 1] = 4;
				b = b + 2;
				recorrer(a, b, nuevoMapa);
			}
			recorrer(a, b, nuevoMapa);
		}
		case 3: {
			if (nuevoMapa[a][b - 2] == 0) {
				nuevoMapa[a][b - 1] = 4;
				nuevoMapa[a][b - 2] = 4;
				b = b - 2;
				recorrer(a, b, nuevoMapa);
			}
			recorrer(a, b, nuevoMapa);
		}
		}
	}

}
