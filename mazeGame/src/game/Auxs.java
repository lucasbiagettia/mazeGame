package game;

public class Auxs {
	public static int[][] generarMapa() {

		int a = (Mapa.tamano) * 2 + 7; // Mapa.getNumFilas();
		int b = (Mapa.tamano) * 2 + 17; // Mapa.getNumColumnas();

		int[][] nuevoMapa = new int[a][b];
		System.out.println("nuevomapa a b " + a + b);

		for (int i = 0; i < a; i++) {
			for (int j = 0; j < b; j++) {
				nuevoMapa[i][j] = 0;
				if (j == 0 || j == 1 
					|| j == b - 1 || j == b - 2 
					|| i == 0 || i == 1 
					|| i == a - 1 || i == a - 2) {
					// 1 = permanent
					nuevoMapa[i][j] = 1;
				}
				if (j % 2 == 1) {
					nuevoMapa[i][j]++;
				}
				if (i % 2 == 1) {
					nuevoMapa[i][j]++;
				}
				if (i == (a - 3) && j == (b - 2)) {
					nuevoMapa[i][j] = 15; // pinta salida
				}
			}
		}

		generar(2, 2, nuevoMapa);
		return nuevoMapa;
	}

	private static void generar(int a, int b, int[][] nuevoMapa) {
		
		int direccion = (int) (Math.random() * 4);
		nuevoMapa[a][b] = 4;
		// 4 es free
		recorrer(a, b, nuevoMapa);

	}

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
		return nuevoMapa[a + 2][b] == 0 || nuevoMapa[a - 2][b] == 0 ||
				
				nuevoMapa[a][b + 2] == 0 || nuevoMapa[a][b - 2] == 0;
	}

}