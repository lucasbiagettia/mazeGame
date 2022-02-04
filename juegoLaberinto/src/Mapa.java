import java.awt.Color;
import java.awt.Graphics;

public class Mapa {
    
    public static void setTamano(int tamano) {
        Mapa.tamano = tamano;
    }
    
    public static int tamano;// = VentanaInicio.tamano.getValue();
    private int fila = 0;
    private int columna = 0;
    
    public int numFilas = (tamano) *2+7; // 27
    public int numColumnas = (tamano)*2+17 ; // 33
    private final int anchoBloque = 40;
    private final int altoBloque  = 40;
    public int [][] nuevoMapa;


    
    
    

    public int getNumFilas() {
        return numFilas;
        
    }

    public int getNumColumnas() {
        return numColumnas;
    }

    
    
    

    
    int [][] laberinto = nuevoLaberinto.laberinto;
 
    public final void paint (Graphics grafico){
        System.out.println("NumFilas "+ numFilas +" numColumnas "+ numColumnas);
        System.out.println("El tamaño es "+ tamano);
        for (fila =1; fila <numFilas-1; fila++){
            for(columna=1; columna<numColumnas-1; columna++){
                if (laberinto [fila][columna]!=4){
                        grafico.setColor(Color.blue);
                        grafico.fillRect((columna)*anchoBloque, (fila)*altoBloque, anchoBloque, altoBloque);                          
                }
                if (laberinto [fila][columna]==15){
                        grafico.setColor(Color.green);
                        grafico.fillRect((columna)*anchoBloque, (fila)*altoBloque, anchoBloque, altoBloque);
                }
            }
        }
    }
}
