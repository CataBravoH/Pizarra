package pizarra;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelCentro extends JPanel{
    private final PizarraVista pizarra;
    private Lapiz lapiz;
    private JButton BotonLimpiar;
    
    
    
    
    public PanelCentro(){
        this.setLayout(null);
        this.setBackground(Color.gray);
        
        pizarra = new PizarraVista();
        this.add(pizarra);
        lapiz = new Lapiz(pizarra);
        Botones();
    }    
        
        
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
    }
    MouseListener botLapiz = new MouseListener(){
       
        @Override
        public void mouseClicked(MouseEvent e){
            System.out.println("boton apretado");
            lapiz.b = true;
        }

        @Override
        public void mousePressed(MouseEvent e) {
             
        }

        @Override
        public void mouseReleased(MouseEvent e) {
             
        }

        @Override
        public void mouseEntered(MouseEvent e) {
             
        }

        @Override
        public void mouseExited(MouseEvent e) {
             
        }
    };
    public void Botones() {
        
        this.setLayout(null);
        BotonLimpiar = new JButton("Limpiar");
        BotonLimpiar.setBounds(1150,10,100,40);
        this.add(BotonLimpiar);
        EventoDeRaton();
    }
    
    
    private void EventoDeRaton(){
        MouseListener limpiar = new MouseListener(){
            
            @Override
            public void mouseClicked(MouseEvent e){
                pizarra.g = pizarra.getGraphics();
                System.out.println("Boton limpiar");
                pizarra.g.setColor(Color.white);
                pizarra.g.fillRect(0, 0, 2000, 2000);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                
            }

            @Override
            public void mouseExited(MouseEvent e) {
                
            }
           
        
        };
        
        BotonLimpiar.addMouseListener(limpiar);
    }
   
}  