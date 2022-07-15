package elements;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import mazeGame.MazeGenerator;

public class Character {
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
    
    public Direction teclaPresionada(Integer evento){
        switch (evento) {
    	case 37:
    		return Direction.left;
    	case 38:
    		return Direction.up;
    	case 39:
    		return Direction.rigth;
    	case 40:
    		return Direction.down;
    	default:
    		return null;
    	}
    }
}
