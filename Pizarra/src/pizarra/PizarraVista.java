package pizarra;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

public class PizarraVista extends JPanel{
    private final static int ANCHO = 1150;
    private final static int LARGO = 630;
    private Color color;
    int x,y;
    
    public PizarraVista(int x, int y, Color color){
        this.x = x; this.y = y;
        this.color = color;
    }
    
    @Override
    public void paint(Graphics g){
        g.setColor(color);
        g.fillRect(x, y, ANCHO, LARGO);
               
    }
}
