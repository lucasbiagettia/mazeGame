package elements;
import java.awt.Color;
import java.awt.Graphics;

import game.MazeGameConfiguration;

public class Character {
    
    public void paint (Graphics graphics, int x, int y){
        graphics.setColor(Color.yellow);
        graphics.fillOval(x, y, MazeGameConfiguration.blockDimension, MazeGameConfiguration.blockDimension);
    }
}
