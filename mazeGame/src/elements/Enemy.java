package elements;
import java.awt.Color;
import java.awt.Graphics;

import mazeGame.MazeGenerator;


public class Enemy {
//    Mapa lab = new Mapa();
    
    private final int ancho = 40;
    private final int alto  = 40;
    private final int mov   = 40;
    
//    el enemigo no se deberìa pintar él mismo sino game
//    public void paint (Graphics grafico, int rand){
//        grafico.setColor(Color.yellow);
//        grafico.fillOval(x, y, ancho, alto);
//        grafico.setColor(Color.black);
//        grafico.drawOval(x, y, ancho, alto);
//        int random = (int)(Math.random()*20);
//            if (random%20 == 0){
//            this.movimientoBolita();
//        }
//              
//        
//    }
    
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
}

