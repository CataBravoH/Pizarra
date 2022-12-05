package pizarra;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class PanelCentro extends JPanel{
    private PizarraVista pizarra;
    
    public PanelCentro(){
        pizarra = new PizarraVista(10,10,Color.WHITE);
    }
    public void paint(Graphics g){
        super.paint(g);
        if(pizarra != null) pizarra.paint(g);
    }
}
