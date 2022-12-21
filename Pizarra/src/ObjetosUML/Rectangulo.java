package ObjetosUML;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import Interfaz.*;
/**
 * Clase Rectangulo, clase que dibuja un rectangulo
 * @author catal
 */
public class Rectangulo {
    private int x,y;
    private PizarraVista pizarra;
    private boolean b;
    /**
     * Dibuja un objeto Rectangulo en la pizarra
     * @param p parametro de pizarraVista
     */
    public Rectangulo(PizarraVista p){
        pizarra = p;
        this.x =0; this.y =0;
        b = false;
        EventoRaton();
    }
    /**
     * Metodo de EventoRaton, que utiliza funciones de MouseAdapter para dibujar con el mouse un rectangulo
     */
    private void EventoRaton(){
        MouseAdapter adapter = new MouseAdapter(){
            @Override
            public void mouseDragged(MouseEvent e){
                if(b==true){
                    if(e.getModifiersEx() == 1024){
                        pizarra.g = pizarra.getGraphics();
                        pizarra.g.setColor(Color.black);
                        pizarra.g.drawRect(x, y, e.getX() - x, e.getY() - y);
                        pizarra.g.drawLine(x, y+30, e.getX() , y+30 );
                        pizarra.g.drawLine(x, y+100, e.getX(), y+100);
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
                    pizarra.g.drawLine(x, y+30, e.getX() , y+30 );
                    pizarra.g.drawLine(x, y+100, e.getX(), y+100);
                }
            }
            public void mouseReleased(MouseEvent e){
                if(b==true){
                    if(e.getModifiersEx() == 0){
                        int [] nuevoRectangulo = {x,y,e.getX()-x,e.getY()-y};
                        pizarra.Rectangulo.add(nuevoRectangulo);
                        int [] nuevaLinea = {x, y+30, e.getX() , y+30 };
                        pizarra.Lineas.add(nuevaLinea);
                        int [] nuevaLinea2 = {x, y+100, e.getX(), y+100};
                        pizarra.Lineas.add(nuevaLinea2);
                        pizarra.repaint();
                        
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
