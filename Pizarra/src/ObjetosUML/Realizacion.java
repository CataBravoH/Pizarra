package ObjetosUML;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import Interfaz.*;
/**
 * Clase Realizacion UML, clase que dibuja un triangulo y una linea punteada
 * @author catal
 */

public class Realizacion {
    private int x,y;
    private PizarraVista pizarra;
    private Boolean b;
    private float guiones[]={10,10};
    private int ancholinea=2;
    private int cb = BasicStroke.CAP_BUTT;
    private int jr = BasicStroke.JOIN_ROUND;
    /**
     * Dibuja un objeto Realizacion en la pizarra
     * @param p parametro de pizarraVista
     */
    public Realizacion(PizarraVista p){
        pizarra = p;
        this.x=0; this.y=0;
        b=false;
        EventoRaton();
    }
    /**
     * Metodo de EventoRaton, que utiliza funciones de MouseAdapter para dibujar con el mouse el triangulo y la linea punteada
     */
    public void EventoRaton(){
        MouseAdapter adapter = new MouseAdapter(){
            @Override
            public void mouseDragged(MouseEvent e){
                if(b==true){
                    if(e.getModifiersEx() == 1024){
                        Graphics2D g2d = (Graphics2D)pizarra.g;
                        g2d.setStroke(new BasicStroke(ancholinea,cb,jr,0,guiones,0));
                        g2d.drawLine(x, y, e.getX(), e.getY());
                        g2d.setColor(Color.black);
                        pizarra.g = pizarra.getGraphics();
                        pizarra.g.setColor(Color.black);
                        if(e.getX() < x){
                            int [] puntosX = {x,x,x+10};
                            int [] puntosY = {y-10,y+10,y};
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
                        BasicStroke bs = new BasicStroke(ancholinea,cb,jr,0,guiones,0);
                        pizarra.Realizacion.add(bs);
                        int [] nuevaLinea = {x,y,e.getX(),e.getY()};
                        pizarra.Lineas2.add(nuevaLinea);
                        
                        if(e.getX() < x){
                            int [] puntosX = {x,x,x+10};
                            int [] puntosY = {y-10,y+10,y};
                            Polygon triangulo = new Polygon(puntosX,puntosY,3);
                            pizarra.Triangulo.add(triangulo);
                            pizarra.repaint();
                        }
                        else if(e.getX() >= x){
                            int [] puntosX = {x,x-10,x};
                            int [] puntosY = { y-10,y,y+10};
                            Polygon triangulo = new Polygon(puntosX, puntosY,3);
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
    /**
     * metodo que recibe una variable de PizarraVista para ir alternando entre pizarras
     * @param p 
     */
    public void OtraPizarra(PizarraVista p){
        pizarra = p;
        EventoRaton();
    }
    /**
     * metodo status que recibe una variable boolean para hacer que aparezca el lapiz en la pizarra
     * @param b parametro de estado, true o false 
     */
    public void status(boolean b){
        this.b=b;
    }
}
