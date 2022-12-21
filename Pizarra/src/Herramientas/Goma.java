package Herramientas;

import Interfaz.*;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 * Clase goma, que representa una goma que borra trazos de otros objetos.
 * @author cata
 */
public class Goma {
    private int largo=10, ancho=10;
    private Boolean b;
    private PizarraVista pizarra;
    /**
     * Crea objeto goma recibiendo como parametro la vista de pizarra
     * @param p  objeto PizarraVists
     */
    public Goma(PizarraVista p){
        pizarra = p;
        EventoRaton();
        b = false;
    }
    /**
     * Metodo eventoRaton que utiliza metodos de MouseAdapter para crear trazos blancos con el mouse para borrar los otros trazos
     */
    
    private void EventoRaton(){
        MouseAdapter adapter = new MouseAdapter(){
            @Override
            public void mouseDragged(MouseEvent e){
                pizarra.g = pizarra.getGraphics();
                if(b == true){
                    if(e.getModifiersEx() == 1024){
                        int [] nuevaGoma = {e.getX() - 10, e.getY() - 10, largo, ancho};
                        pizarra.Goma.add(nuevaGoma);
                        pizarra.g.setColor(Color.white);
                        pizarra.repaint();
                    }
                }
            }
            public void mousePressed(MouseEvent e){
                if(b == true){
                    if(e.getModifiersEx() == 1024){
                        int [] nuevaGoma = {e.getX()-10,e.getY()-10,largo,ancho};
                        pizarra.Goma.add(nuevaGoma);
                        pizarra.g.setColor(Color.white);
                        pizarra.repaint();
                    }
                }
            }
            
            public void mouseReleased(MouseEvent e){
                if(b==true){
                    if(e.getModifiersEx() == 0){
                        int [] nuevaGoma = {e.getX()-10,e.getY()-10,largo,ancho};
                        pizarra.Goma.add(nuevaGoma);
                        pizarra.repaint();
                    }
                }
            }
        };
        
        pizarra.addMouseListener(adapter);
        pizarra.addMouseMotionListener(adapter);
    }
    /**
     * metodo status que recibe una variable boolean para hacer que aparezca el lapiz en la pizarra
     * @param b parametro de estado, true o false 
     */
    public void status(boolean b){
        this.b = b;
    }
    /**
     * metodo que recibe una variable de PizarraVista para ir alternando entre pizarras
     * @param p 
     */
    public void OtraPizarra(PizarraVista p){
        pizarra = p;
        EventoRaton();
    }
}
