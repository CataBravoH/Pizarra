package pizarra;

import java.awt.Color;
import java.awt.Polygon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Agregacion {
    private int x,y;
    private PizarraVista pizarra;
    public Boolean b;
    
    public Agregacion(PizarraVista p){
        pizarra = p;
        this.x = 0; this.y = 0;
        b = false;
        EventoRaton();
    }
    private void EventoRaton(){
        MouseAdapter adapter = new MouseAdapter(){
            @Override
            public void mouseDragged(MouseEvent e){
                if(b== true){
                    if(e.getModifiersEx() == 1024){
                        pizarra.g = pizarra.getGraphics();
                        pizarra.g.drawLine(x, y, e.getX(), e.getY());
                        pizarra.g.setColor(Color.black);                      
                        int[] puntosX = {x,x-10,x,x+10};
                        int[] puntosY = {y-10,y,y+10,y};
                        pizarra.g.drawPolygon(puntosX,puntosY,4);
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
                        int[] nuevaLinea = {x,y,e.getX(),e.getY()};
                        pizarra.Lineas.add(nuevaLinea);
                        int[] puntosX = {x,x-10,x,x+10};
                        int[] puntosY = {y-10,y,y+10,y};
                        Polygon rombo = new Polygon(puntosX,puntosY,4);
                        pizarra.Agregacion.add(rombo);
                        pizarra.repaint();
                    }
                }
            }
        };
        
        pizarra.addMouseListener(adapter);
        pizarra.addMouseMotionListener(adapter);
    }
    
    public void estado(boolean b){
        this.b =b;
    }
}