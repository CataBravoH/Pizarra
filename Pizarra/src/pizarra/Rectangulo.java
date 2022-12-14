package pizarra;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Rectangulo {
    private int x,y;
    private PizarraVista pizarra;
    public boolean b;
    
    public Rectangulo(PizarraVista p){
        pizarra = p;
        this.x =0; this.y =0;
        b = false;
        EventoRaton();
    }
    
    private void EventoRaton(){
        MouseAdapter adapter = new MouseAdapter(){
            @Override
            public void mouseDragged(MouseEvent e){
                if(b==true){
                    if(e.getModifiersEx() == 1024){
                        pizarra.g = pizarra.getGraphics();
                        pizarra.g.setColor(Color.black);
                        pizarra.g.drawRect(x, y, e.getX() - x, e.getY() - y);
                        pizarra.repaint();
                    }
                    
                }
                
            }
            @Override
            public void mousePressed(MouseEvent e){
                if(b==true){
                    x = e.getX();
                    y = e.getY();
                    pizarra.g = pizarra.getGraphics();
                    pizarra.g.setColor(Color.BLACK);
                    pizarra.g.drawRect(x, y, e.getX() - x, e.getY() - y);
                }
            }
            public void mouseReleased(MouseEvent e){
                if(b==true){
                    if(e.getModifiersEx() == 0){
                        int [] nuevoRectangulo = {x,y,e.getX()-x,e.getY()-y};
                        pizarra.Rectangulo.add(nuevoRectangulo);
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
