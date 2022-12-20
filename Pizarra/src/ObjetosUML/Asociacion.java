package ObjetosUML;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import Interfaz.*;
/**
 * Clase Asociacion UML, clase que dibuja una linea 
 * @author cata
 */
public class Asociacion {
    private int x,y;
    private PizarraVista pizarra;
    private Boolean b;
    /**
     * Dibuja el objeto Asociacion en la pizarra
     * @param p parametro de pizarraVista
     */
    public Asociacion(PizarraVista p){
        pizarra = p;
        this.x=0; this.y=0;
        b = false;
        EventoRaton();
    }
    /**
     * Metodo EventoRato, que utiliza funciones de MouseAdapter para dibujar con el mouse una linea
     */
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
    /**
     * Metodo que recibe una variable de Pizarra para ir alternando entre pizarras
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
        this.b =b;
    }
}
