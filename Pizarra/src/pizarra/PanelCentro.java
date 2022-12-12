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
    private Composicion composicion;
    private Agregacion agregacion;
    private Herencia herencia;
    private Realizacion realizacion;
    private Asociacion asociacion;
    private JButton BotonLimpiar;
    private JButton BotonRectangulo;
    private JButton BotonLapiz;
    private JButton BotonComposicion;
    private JButton BotonAgregacion;
    private JButton BotonHerencia;
    private JButton BotonRealizacion;
    private JButton BotonAsociacion;
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
        BotonRectangulo.setBounds(1150, 130, 100, 40);
        this.add(BotonRectangulo);
        
        this.setLayout(null);
        ImageIcon Lapiz = new ImageIcon("src/img/pencil.png");
        BotonLapiz = new JButton();
        BotonLapiz.setIcon(Lapiz);
        BotonLapiz.setContentAreaFilled(false);
        BotonLapiz.setBounds(1150, 70, 100, 40);
        this.add(BotonLapiz);
        
        this.setLayout(null);
        ImageIcon Composicion = new ImageIcon("src/img/Composicion.png");
        BotonComposicion = new JButton();
        BotonComposicion.setIcon(Composicion);
        BotonComposicion.setContentAreaFilled(false);
        BotonComposicion.setBounds(10,10,120,70);
        this.add(BotonComposicion);
        
        this.setLayout(null);
        ImageIcon Agregacion = new ImageIcon("src/img/Agregacion.png");
        BotonAgregacion = new JButton();
        BotonAgregacion.setIcon(Agregacion);
        BotonAgregacion.setContentAreaFilled(false);
        BotonAgregacion.setBounds(10, 90, 120, 70);
        this.add(BotonAgregacion);
        
        this.setLayout(null);
        ImageIcon Herencia = new ImageIcon("src/img/Herencia.png");
        BotonHerencia = new JButton();
        BotonHerencia.setIcon(Herencia);
        BotonHerencia.setContentAreaFilled(false);
        BotonHerencia.setBounds(10, 170, 120, 70);
        this.add(BotonHerencia);
        
        this.setLayout(null);
        ImageIcon Realizacion = new ImageIcon("src/img/Realizacion.png");
        BotonRealizacion = new JButton();
        BotonRealizacion.setIcon(Realizacion);
        BotonRealizacion.setContentAreaFilled(false);
        BotonRealizacion.setBounds(10, 250,120,70);
        this.add(BotonRealizacion);
        
        this.setLayout(null);
        ImageIcon Asociacion = new ImageIcon("src/img/Asociacion.png");
        BotonAsociacion = new JButton();
        BotonAsociacion.setIcon(Asociacion);
        BotonAsociacion.setContentAreaFilled(false);
        BotonAsociacion.setBounds(10,330, 120,70);
        this.add(BotonAsociacion);
        
        
        
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