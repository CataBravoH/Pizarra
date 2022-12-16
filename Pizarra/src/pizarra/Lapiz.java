package pizarra;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Lapiz {
    private int largo = 10, ancho = 10;
    public Boolean b;
    private PizarraVista pizarra;
    private Color color;
    public Boolean bc;
    
    public Lapiz(PizarraVista p){
        pizarra = p;
        EventoRaton();
        color = Color.black;
        b= true;
    }

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
    
    public void OtraPizarra(PizarraVista p){
        pizarra = p;
        EventoRaton();
    }
    
    public void Negro(boolean b){
        this.bc = b;
        if(b == true){
            color = Color.black;
        }
    }
    public void Azul(boolean b){
        this.bc = b;
        if(b == true){
            color = Color.blue;
        }
    }
    public void Rojo(boolean b){
        this.bc = b;
        if(b == true){
            color = Color.red;
        }
    }
    public void Verde(boolean b){
        this.bc = b;
        if(b == true){
            color = Color.green;
        }
    }
}
