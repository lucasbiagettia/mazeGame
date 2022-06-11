package game;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import elements.BolitaAsesina2;
import elements.Personaje;
import mazeGame.Mapa;

public class Juego extends JPanel {

    Mapa mapa = new Mapa();
    Personaje personaje = new Personaje ();
    BolitaAsesina2 bolitaAsesina = new BolitaAsesina2 ();
    private static boolean conBolitaAsesina = false;
    public static boolean inicioAbierta = true;
    public static int mov = 0;
    private static boolean termino = false;
    public static boolean perdio= false;
    

    public static void setInicioAbierta(boolean inicioAbierta) {
        Juego.inicioAbierta = inicioAbierta;
    }
    

    static void setConBolitaAsesina(boolean conBolitaAsesina) {
        Juego.conBolitaAsesina = conBolitaAsesina;
    }

    

    
    
    public Juego(){
        
        int movimientos = 0;
        
        addKeyListener(new KeyListener(){
            private String movimientos;
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                personaje.teclaPresionada(e);
                mov++;
                if (conBolitaAsesina){
                    bolitaAsesina.movimientoBolita();
                    
                    if (bolitaAsesina.x == personaje.x & bolitaAsesina.y == personaje.y){
                        perdio = true;
                        termino = true;
                    }

                }
                if (personaje.x == 40* (mapa.getNumColumnas()-2) && personaje.y == 40* (mapa.getNumFilas()-3)){
                    conBolitaAsesina = false;
                    perdio = false;
                    termino = true;
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        
        setFocusable(true);
        
    }
    
    public void paint (Graphics grafico){
        mapa.paint(grafico);
        personaje.paint(grafico);
        if (conBolitaAsesina){
           int a = 1;
           bolitaAsesina.paint(grafico, a);
           a++;
           a = a%10;
    
        }
    }

    public static void main(String[] args){
        VentanaInicio.main(args);
        
        while (inicioAbierta){
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        
        
        JFrame ventana = new JFrame ("Primer laberinto");
        Juego game = new Juego();
        
        ventana.add(game);
        int alto = (Mapa.tamano )*2+7; //Mapa.getNumFilas();
        int ancho = (Mapa.tamano )*2+17; //Mapa.getNumColumnas();
        
        
        ventana.setSize(ancho*40,(alto +1)*40);
        ventana.setLocation(300,200);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
        
        
        while(!termino){
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            ventana.repaint();
        }
        VentanaSalida.main(args);
        
    }
}
