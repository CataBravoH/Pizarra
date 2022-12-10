package pizarra;

import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Graphics;

public class PizarraVista extends JPanel{
    private final static int ANCHO = 1000;
    private final static int LARGO = 610;
    public Graphics g;
    
    
    public PizarraVista(){
        this.setBackground(Color.white);
        this.setSize(ANCHO,LARGO);
        this.setLocation(140,10);
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
               
    }
}
