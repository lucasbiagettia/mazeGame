import java.awt.Color;
import java.awt.Graphics;


public class BolitaAsesina2 {
    Mapa lab = new Mapa();
    
    int [][] laberinto = nuevoLaberinto.getLaberinto();
    public int x = 40* (lab.getNumColumnas()-3);
    public int y = 40* (lab.getNumFilas() -3);
    private final int ancho = 40;
    private final int alto  = 40;
    private final int mov   = 40;
    
    
    public void paint (Graphics grafico, int rand){
        grafico.setColor(Color.yellow);
        grafico.fillOval(x, y, ancho, alto);
        grafico.setColor(Color.black);
        grafico.drawOval(x, y, ancho, alto);
        int random = (int)(Math.random()*20);
            if (random%20 == 0){
            this.movimientoBolita();
        }
        
        
        
    }
    
    public void movimientoBolita(){
        
        int direccion = (int) (Math.random()*4);
        switch(direccion){
            case 0 :
                if(laberinto[y/40][(x/40)-1]==4){
                    x -= mov;
                }
                else{
                    movimientoBolita();
                }
                break; 

            case 1 :
                if(laberinto[y/40][(x/40)+1]==4){
                    x += mov;
                }
                else{
                    movimientoBolita();
                }
                break; 
                        
            case 2:
                if(laberinto[y/40-1][x/40]==4){
                    y -= mov;
                }
                else{
                    movimientoBolita();
                }
                break;
                    
            case 3:
                if(laberinto[y/40+1][x/40]==4){
                    y += mov;
                }
                else{
                    movimientoBolita();
                }
                break;
        }
    }

    void paint() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

