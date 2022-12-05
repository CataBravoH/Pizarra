package pizarra;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Lapiz {
    public int largo = 10, ancho = 10;
    public boolean b = true;
    PizarraVista pizarra;
    
    public Lapiz(PizarraVista p){
        pizarra = p;
        eventoMouse();
    }

    private void eventoMouse() {
        MouseAdapter a = new MouseAdapter(){
        
        public void mouseDragged(MouseEvent e){
            pizarra.g = pizarra.getGraphics();
            if(b==true){
                if(e.getModifiersEx() == 1024){
                    pizarra.g.setColor(Color.BLACK);
                    pizarra.g.fillOval(e.getX(), e.getY(), largo, largo);
                }
                else if(e.getModifiersEx() == 4096){
                    pizarra.g.setColor(Color.white);
                    pizarra.g.fillOval(e.getX(), e.getY(), ancho,ancho);
                }
            }
        }
        
        };
        
        pizarra.addMouseListener(a);
        pizarra.addMouseListener(a);
            
    }
}