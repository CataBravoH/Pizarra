package pizarra;

import java.awt.Color;
import java.awt.Polygon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Herencia {
    private int x,y;
    PizarraVista pizarra;
    public Boolean b;
    
    public Herencia(PizarraVista p){
        pizarra = p;
        this.x = 0; this.y = 0;
        b = false;
        EventoRaton();
    }
    
    private void EventoRaton(){
        MouseAdapter adapter = new MouseAdapter(){
            @Override
            public void mouseDragged(MouseEvent e){
                if(b==true){
                    if(e.getModifiersEx()== 1024){
                        pizarra.g = pizarra.getGraphics();
                        pizarra.g.drawLine(x, y, e.getX(), e.getY());
                        pizarra.g.setColor(Color.black);
                        if(e.getX() < x){
                            int [] puntosX = {x,x,x+10};
                            int [] puntosY = {y-10, y+10,y};
                            pizarra.g.drawPolygon(puntosX, puntosY, 3);
                            pizarra.repaint();
                        }
                        else if(e.getX() >= x){
                            int [] puntosX = {x,x-10,x};
                            int [] puntosY = {y-10,y,y+10};
                            pizarra.g.drawPolygon(puntosX, puntosY, 3);
                            pizarra.repaint();
                        }
                    }
                }
            }
            public void mousePressed(MouseEvent e){
                if(b == true){
                    x = e.getX();
                    y = e.getY();
                }
            }
            public void mouseReleased(MouseEvent e){
                if(b==true){
                    if(e.getModifiersEx() == 0){
                        int [] nuevaLinea = {x,x,x+10};
                        pizarra.Lineas.add(nuevaLinea);
                        if(e.getX() < x){
                            int [] puntosX = {x,x,x+10};
                            int [] puntosY = {y-10,y+10,y};
                            Polygon triangulo = new Polygon(puntosX,puntosY,3);
                            pizarra.Triangulo.add(triangulo);
                            pizarra.repaint();
                        }
                        else if(e.getX() >= x){
                            int [] puntosX = {x,x-10,x};
                            int [] puntosY = {y-10,y,y+10};
                            Polygon triangulo = new Polygon(puntosX,puntosY,3);
                            pizarra.Triangulo.add(triangulo);
                            pizarra.repaint();
                        }
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
    public void OtraPizarra(PizarraVista p){
        pizarra = p;
        EventoRaton();
    }
}
