package elements;
import java.awt.Color;
import java.awt.Graphics;

import game.MazeGameConfiguration;

public class Enemy {
    
    public void paint (Graphics graphics, int x, int y){
        graphics.setColor(Color.red);
        graphics.fillOval(x, y, MazeGameConfiguration.blockDimension, MazeGameConfiguration.blockDimension);
        graphics.setColor(Color.black);
        graphics.drawOval(x, y, MazeGameConfiguration.blockDimension, MazeGameConfiguration.blockDimension);      
        
    }
}
