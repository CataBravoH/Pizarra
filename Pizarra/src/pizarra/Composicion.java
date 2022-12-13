package pizarra;

import java.awt.Color;
import java.awt.Polygon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Composicion {
    private int x,y;
    private PizarraVista pizarra;
    public boolean b;
    
    public Composicion(PizarraVista p){
        pizarra = p;
        this.x =0; this.y=0;
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
                        pizarra.g.setColor(Color.black);
                        pizarra.g.drawLine(x, y, e.getX(), e.getY());
                        int [] romboX = {x,x-10,x,x+10};
                        int [] romboY = {y-10,y,y+10,y};
                        pizarra.g.fillPolygon(romboX, romboY, 4);
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
                        int [] newLine = {x,y,e.getX(),e.getY()};
                        
                        int[] romboX = {x,x-10,x,x+10};
                        int[] romboY = {y-10,y,y+10,y};
                        Polygon rombo = new Polygon(romboX,romboY,4);
                        
                        pizarra.repaint();
                    }
                }
            }
        };
        pizarra.addMouseListener(adapter);
        pizarra.addMouseMotionListener(adapter);
    }
    
    public void cambiarestado(boolean b){
        this.b =b;
    }
}
