package pizarra;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Rectangulo {
    private int x,y;
    private int tamanoR = 20, tamanoL = 20;
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
                    }
                    
                }
                
            }
            @Override
            public void mousePressed(MouseEvent e){
                pizarra.g = pizarra.getGraphics();
                x = e.getX(); y = e.getY();
                pizarra.g.setColor(Color.black);
                pizarra.g.drawRect(x, y, 5, 5);
            }
            public void mouseReleased(MouseEvent e){
                pizarra.g = pizarra.getGraphics();
                if(b==true){
                    if(e.getModifiersEx() == 0){
                        pizarra.g.drawRect(x,y,e.getX()-x, e.getY()-y);
                    }
                }
            }
        };
        
        pizarra.addMouseListener(adapter);
        pizarra.addMouseMotionListener(adapter);
    }
    
    public void cambiarestado(boolean b){
        this.b = b;
    }
    
}
