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
	public void generateMaze() {

		int a = (Map.tamano) * 2 + 7;
		int b = (Map.tamano) * 2 + 17;

		maze = new Block[a][b];
		System.out.println("newMap " + a +" x "+ b);

		for (int i = 0; i < a; i++) {
			for (int j = 0; j < b; j++) {
				maze [i][j] = Block.wall;
				if (i == 0 || j == 0 || i == a || j == b) {
					maze [i][j] = Block.permanentWall;
				}
				if ( i % 2 == 1 && j % 2 == 1 ) {
					maze [i][j] = Block.permanentWall;
				}
				if (i == a && b == j) {
					maze [i][j] = Block.end;			
				}
			}
		}

		generar(2, 2, newMaze);
		System.out.println("termino no era eterno");
	}

	private static void generar(int a, int b, int[][] nuevoMapa) {
		// inicia en (a,b)
		int direccion = (int) (Math.random() * 4);
		nuevoMapa[a][b] = 4;
		recorrer(a, b, nuevoMapa);

	}

	
	// TODO este es el algoritmo que me genera el mapa, hay que hacer que sea concordante con los tipos de blocks
	private static void recorrer(int a, int b, int[][] nuevoMapa) {
		if (verificarVacios(a, b, nuevoMapa)) {
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

	private static boolean verificarVacios(int a, int b, int[][] nuevoMapa) {
		return nuevoMapa[a + 2][b] == 0 || nuevoMapa[a - 2][b] == 0 || nuevoMapa[a][b + 2] == 0
				|| nuevoMapa[a][b - 2] == 0;
	}

}
