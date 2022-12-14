package pizarra;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Asociacion {
    private int x,y;
    private PizarraVista pizarra;
    public Boolean b;
    
    public Asociacion(PizarraVista p){
        pizarra = p;
        this.x=0; this.y=0;
        b = false;
        EventoRaton();
    }
    public void EventoRaton(){
        MouseAdapter adapter = new MouseAdapter(){
            @Override
            public void mouseDragged(MouseEvent e){
                if(b==true){
                    if(e.getModifiersEx() == 1024){
                        pizarra.g = pizarra.getGraphics();
                        pizarra.g.drawLine(x, y, e.getX(), e.getY());
                        pizarra.g.setColor(Color.black);
                        pizarra.repaint();
                    }
                }
            }
            @Override
            public void mousePressed(MouseEvent e){
                if(b==true){
                    x = e.getX();
                    y = e.getY();
                }
            }
            @Override
            public void mouseReleased(MouseEvent e){
                if(b==true){
                    if(e.getModifiersEx() == 0){
                        int [] nuevaLinea = {x,y,e.getX(),e.getY()};
                        pizarra.Lineas.add(nuevaLinea);
                        pizarra.repaint();
                    }
                }
            }
        };
        pizarra.addMouseListener(adapter);
        pizarra.addMouseMotionListener(adapter);
    }
    
    public void estado(boolean b){
        this.b = b;
    }
}
