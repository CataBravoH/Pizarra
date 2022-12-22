package Herramientas;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import Interfaz.*;
/**
 * Clase Lapiz representa un lapiz que dibuja trazos y se puede cambiar colores.
 * @author cata
 */

public class Lapiz {
    private int largo = 5, ancho = 5;
    private Boolean b;
    private PizarraVista pizarra;
    private Color color;
    /**
     * Crea Objeto lapiz recibiendo como parametro la vista de pizarra
     * @param p objeto pizarraVista
     */
    public Lapiz(PizarraVista p){
        pizarra = p;
        EventoRaton();
        color = Color.black;
        b= false;
    }
    /**
     * Metodo EventoRaton que utiliza metodos de MouseAdapter para crear trazos con el mouse como si fuera un lapiz
     */
    private void EventoRaton() {
        MouseAdapter adapter = new MouseAdapter(){
            @Override
            public void mouseDragged(MouseEvent e){
                pizarra.g = pizarra.getGraphics();
                if(b==true){
                    if(e.getModifiersEx() == 1024){
                        int [] nuevoLapiz = {e.getX() - 10, e.getY() - 10, largo, ancho};
                        pizarra.Lapiz.add(nuevoLapiz);
                        pizarra.Colores.add(color);
                        pizarra.repaint();
                    }    
                }
            }
            @Override
            public void mousePressed(MouseEvent e){
                if(b==true){
                    if(e.getModifiersEx() == 1024){
                        int [] nuevoLapiz = {e.getX() - 10, e.getY() - 10, largo, ancho};
                        pizarra.Lapiz.add(nuevoLapiz);
                        pizarra.Colores.add(color);
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
    /**
     * Metodo para cambiar el color de lapiz a negro
     */
    public void Negro(){
       color = Color.black;  
    }
    /**
     * Metodo para cambiar el color de lapiz a azul
     */
    public void Azul(){
        color = Color.blue;
    }
    /**
     * Metodo para cambiar el color de lapiz rojo
     */
    public void Rojo(){
        color = Color.red;
    }
    /**
     * Metodo para cambiar el color de lapiz verde
     */
    public void Verde(){
        color = Color.green;
    }
}
