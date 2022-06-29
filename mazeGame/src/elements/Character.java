package elements;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import mazeGame.Mapa;
import mazeGame.Maze;

public class Character {
    Mapa lab = new Mapa();
    int [][] laberinto = Maze.getLaberinto();
    public int x = 80;
    public int y = 80;
    private final int ancho = 40;
    private final int alto  = 40;
    private final int mov   = 40;
    
    
    public void paint (Graphics grafico){
        grafico.setColor(Color.red);
        grafico.fillOval(x, y, ancho, alto);
        grafico.setColor(Color.black);
        grafico.drawOval(x, y, ancho, alto);      
        
    }
    
    public void teclaPresionada(KeyEvent evento){
        //laberinto = lab.mapa(laberinto);
        if(evento.getKeyCode()== 37){//Izquierda 
            if(laberinto[y/40][(x/40)-1]==4 ||laberinto[y/40][(x/40)-1] == 15 ){
                x -= mov;
            }
        }
        if(evento.getKeyCode()== 39){//Derecha 
            if(laberinto[y/40][(x/40)+1]==4 ||laberinto[y/40][(x/40)+1]==15){
                x += mov;
            }
        }
        if(evento.getKeyCode()== 40){//Abajo
            if(laberinto[(y/40)+1][(x/40)]==4 || laberinto[(y/40)+1][(x/40)]==15){
                y += mov;
            }
        }
        if(evento.getKeyCode()== 38){//Arriba
            if(laberinto[(y/40)-1][(x/40)]==4 || laberinto[(y/40)-1][(x/40)]==15){
                y -= mov;
        }
        }
                
    }
    
}
