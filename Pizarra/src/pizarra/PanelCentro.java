package pizarra;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

public class PanelCentro extends JPanel{
    private PizarraVista pizarra;
    private Lapiz lapiz;
    
    public PanelCentro(){
        this.setLayout(null);
        this.setBackground(Color.gray);
        
        pizarra = new PizarraVista();
        lapiz = new Lapiz(pizarra);
        this.add(pizarra);
    }
    public void paint(Graphics g){
        super.paint(g);
    }
    MouseListener botLapiz = new MouseListener(){
       
        public void mouseClicked(MouseEvent e){
            System.out.println("boton apretado");
            lapiz.b = true;
        }

        @Override
        public void mousePressed(MouseEvent e) {
             
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            ; 
        }

        @Override
        public void mouseEntered(MouseEvent e) {
             
        }

        @Override
        public void mouseExited(MouseEvent e) {
             
        }
    };
    
   
}  