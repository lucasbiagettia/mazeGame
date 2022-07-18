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
		return countFree >= 3;
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

	// ACA EMPIEZA
	public static Block[][] generarMapa() {

		Block[][] nuevoMapa;
		int a = MazeGameConfiguration.columns;
		int b = MazeGameConfiguration.rows;
		nuevoMapa = new Block[a][b];

		for (int i = 0; i < a; i++) {
			for (int j = 0; j < b; j++) {
				nuevoMapa[i][j] = Block.type0;
				if (j == 0 || j == b - 1 || i == 0 || i == a - 1) {
					nuevoMapa[i][j] = Block.type1;
				}
				if (i % 2 == 1 && j % 2 == 1) {
					nuevoMapa[i][j] = Block.type2;
				}
				if (i == (a - 2) && j == (b - 2)) {
					nuevoMapa[i][j] = Block.type3;
				}
			}
		}

		generar(1, 1, nuevoMapa);
		return nuevoMapa;
	}

	private static void generar(int a, int b, Block[][] nuevoMapa) {
		int direccion = (int) (Math.random() * 4);
		nuevoMapa[a][b] = Block.type4;

		// 4 es free
		recorrer(a, b, nuevoMapa);

	}

	private static void recorrer(int a, int b, Block[][] nuevoMapa) {
		if (verificarVacios(a, b, nuevoMapa)) {
			int direccion = (int) (Math.random() * 4);
			// 0 arriba
			// 1 abajo
			// 2 derecha
			// 3 izquierda
			try {
				switch (direccion) {
				case 0: {
					if (nuevoMapa[a - 2][b] == Block.type0) {
						nuevoMapa[a - 1][b] = Block.type4;
						nuevoMapa[a - 2][b] = Block.type4;
						a = a - 2;
						recorrer(a, b, nuevoMapa);
					}
				}
				case 1: {
					if (nuevoMapa[a + 2][b] == Block.type0) {
						nuevoMapa[a + 1][b] = Block.type4;
						nuevoMapa[a + 2][b] = Block.type4;
						a = a + 2;
					}
				}
				case 2: {
					if (nuevoMapa[a][b + 2] == Block.type0) {
						nuevoMapa[a][b + 1] = Block.type4;
						nuevoMapa[a][b + 1] = Block.type4;
						b = b + 2;
						recorrer(a, b, nuevoMapa);
					}
				}
				case 3: {
					if (nuevoMapa[a][b - 2] == Block.type0) {
						nuevoMapa[a][b - 1] = Block.type4;
						nuevoMapa[a][b - 2] = Block.type4;
						b = b - 2;
						recorrer(a, b, nuevoMapa);
					}
				}
				}
			} catch (Exception e) {
				
			}
			recorrer(a, b, nuevoMapa);
		}
	}

	private static boolean verificarVacios(int a, int b, Block[][] nuevoMapa) {
		boolean result = true;
		try {
		result = nuevoMapa[a + 2][b] == Block.type0 || nuevoMapa[a - 2][b] == Block.type0 ||

				nuevoMapa[a][b + 2] == Block.type0 || nuevoMapa[a][b - 2] == Block.type0;
	
		}catch (Exception e) {
			
		}
		return result;
	}

}
