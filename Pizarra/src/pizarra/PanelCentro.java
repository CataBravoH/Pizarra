package pizarra;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

public class PanelCentro extends JPanel{
    private PizarraVista pizarra;
    private Lapiz lapiz;
    
    public PanelCentro(){
        pizarra = new PizarraVista(10,10,Color.WHITE);
        lapiz = new Lapiz(pizarra);
    }
    public void paint(Graphics g){
        super.paint(g);
        if(pizarra != null) pizarra.paint(g);
    }
}  