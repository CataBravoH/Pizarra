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
        
        @Override
        public void mouseDragged(MouseEvent e){
            pizarra.g = pizarra.getGraphics();
            if(b==true){
                if(e.getModifiersEx() == 1024){
                    pizarra.g.setColor(Color.BLACK);
                    pizarra.g.fillOval(e.getX(), e.getY(), largo, largo);
                }
                
            }
        }
        
        };
        
        pizarra.addMouseListener(a);
        pizarra.addMouseMotionListener(a);
            
    }
}
