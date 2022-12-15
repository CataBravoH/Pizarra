package pizarra;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Realizacion {
    private int x,y;
    private PizarraVista pizarra;
    public Boolean b;
    private float guiones[]={10,10};
    private int ancholinea=3;
    
    public Realizacion(PizarraVista p){
        pizarra = p;
        this.x=0; this.y=0;
        b=false;
        EventoRaton();
    }
    public void EventoRaton(){
        MouseAdapter adapter = new MouseAdapter(){
            @Override
            public void mouseDragged(MouseEvent e){
                if(b==true){
                    if(e.getModifiersEx() == 1024){
                        Graphics2D g2d = (Graphics2D)pizarra.g;
                        g2d.setStroke(new BasicStroke(ancholinea,BasicStroke.CAP_BUTT,BasicStroke.JOIN_ROUND,0,guiones,0));
                        g2d.drawLine(x, y, e.getX(), e.getY());
                        g2d.setColor(Color.black);
                        pizarra.gp = pizarra.getGraphics();
                        pizarra.gp.setColor(Color.black);
                        if(e.getX() < x){
                            int [] puntosX = {x,x,x+10};
                            int [] puntosY = {y-10,y+10,y};
                            pizarra.gp.drawPolygon(puntosX, puntosY, ancholinea);
                            pizarra.repaint();
                        }
                        else if(e.getX() >= x){
                            int [] puntosX = {x,x-10,x};
                            int [] puntosY = {y-10,y,y+10};
                            pizarra.gp.drawPolygon(puntosX, puntosY, ancholinea);
                            pizarra.repaint();
                        }
                    }
                }
            }
            public void mousePressed(MouseEvent e){
                if(b==true){
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
    public void OtraPizarra(PizarraVista p){
        pizarra = p;
        EventoRaton();
    }
}
