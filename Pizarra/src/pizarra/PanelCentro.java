package pizarra;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class PanelCentro extends JPanel{
    private final PizarraVista pizarra;
    private Lapiz lapiz;
    private Rectangulo rectangulo;
    private JButton BotonLimpiar;
    private JButton BotonRectangulo;
    private JButton BotonLapiz;
    private LineBorder Aborder;
    private LineBorder Bborder;
   
    
    public PanelCentro(){
        this.setLayout(null);
        this.setBackground(Color.gray);
        
        pizarra = new PizarraVista();
        this.add(pizarra);
        lapiz = new Lapiz(pizarra);
        rectangulo = new Rectangulo(pizarra);
        
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
        
        this.setLayout(null);
        ImageIcon Cuadrado = new ImageIcon("src/img/Cuadrado.png");
        BotonRectangulo = new JButton();
        BotonRectangulo.setIcon(Cuadrado);
        BotonRectangulo.setContentAreaFilled(false);
        BotonRectangulo.setBounds(1150, 70, 100, 40);
        this.add(BotonRectangulo);
        Aborder = new LineBorder(Color.ORANGE);
        Bborder = new LineBorder(Color.lightGray);
        BotonRectangulo.setBorder(Aborder);
        
        this.setLayout(null);
        ImageIcon Lapiz = new ImageIcon("src/img/pencil.png");
        BotonLapiz = new JButton();
        BotonLapiz.setIcon(Lapiz);
        BotonLapiz.setContentAreaFilled(false);
        BotonLapiz.setBounds(1150, 130, 100, 40);
        this.add(BotonLapiz);
        Aborder = new LineBorder(Color.MAGENTA);
        Bborder = new LineBorder(Color.lightGray);
        BotonLapiz.setBorder(Aborder);
        
        
        
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
        
        MouseListener botRectangulo = new MouseListener(){
            
            @Override
            public void mouseClicked(MouseEvent e){
                System.out.println("Boton rectangulo");
                lapiz.b = false;
                rectangulo.b = true;
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
        BotonRectangulo.addMouseListener(botRectangulo);
    }
   
}  