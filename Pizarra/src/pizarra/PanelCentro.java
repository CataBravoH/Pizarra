package pizarra;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelCentro extends JPanel{
    private final PizarraVista pizarra;
    private Lapiz lapiz;
    private Rectangulo rectangulo;
    private Composicion composicion;
    private Agregacion agregacion;
    private Herencia herencia;
    private Realizacion realizacion;
    private Asociacion asociacion;
    private Texto texto;
    private JButton BotonLimpiar;
    private JButton BotonRectangulo;
    private JButton BotonLapiz;
    private JButton BotonComposicion;
    private JButton BotonAgregacion;
    private JButton BotonHerencia;
    private JButton BotonRealizacion;
    private JButton BotonAsociacion;
    private JButton BotonTexto;
    private JButton BotonRojo, BotonVerde, BotonAzul, BotonNegro;
    
   
    
    public PanelCentro(){
        this.setLayout(null);
        this.setBackground(Color.gray);
        
        pizarra = new PizarraVista();
        this.add(pizarra);
        lapiz = new Lapiz(pizarra);
        rectangulo = new Rectangulo(pizarra);
        agregacion = new Agregacion(pizarra);
        composicion = new Composicion(pizarra);
        herencia = new Herencia(pizarra);
        asociacion = new Asociacion(pizarra);
        realizacion = new Realizacion(pizarra);
        
        Botones();
    }    
               
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
    }
    
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
        
        this.setLayout(null);
        BotonTexto = new JButton("Texto");
        BotonTexto.setBounds(1150,250,100,40);
        this.add(BotonTexto);
        
        this.setLayout(null);
        BotonNegro = new JButton();
        BotonNegro.setBounds(1150,350,50,50);
        BotonNegro.setBackground(Color.black);
        this.add(BotonNegro);
        
        this.setLayout(null);
        BotonRojo = new JButton();
        BotonRojo.setBounds(1220,350,50,50);
        BotonRojo.setBackground(Color.red);
        this.add(BotonRojo);
        
        this.setLayout(null);
        BotonAzul = new JButton();
        BotonAzul.setBounds(1150,430,50,50);
        BotonAzul.setBackground(Color.blue);
        this.add(BotonAzul);
        
        this.setLayout(null);
        BotonVerde = new JButton();
        BotonVerde.setBounds(1220,430,50,50);
        BotonVerde.setBackground(Color.green);
        this.add(BotonVerde);
        
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
                agregacion.b = false;
                herencia.b = false;
                composicion.b = false;
                asociacion.b = false;
                realizacion.b = false;
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
        MouseListener botLapiz = new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e){
                System.out.println("Boton Lapiz");
                lapiz.b = true;
                rectangulo.b = false;
                agregacion.b = false;
                herencia.b = false;
                composicion.b = false;
                asociacion.b = false;
                realizacion.b = false;
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
        MouseListener botAgregacion = new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e){
                System.out.println("Boton agregacion");
                agregacion.b = true;
                lapiz.b = false;
                rectangulo.b = false;
                herencia.b = false;
                composicion.b = false;
                asociacion.b = false;
                realizacion.b = false;
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
        MouseListener botComposicion = new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e){
                System.out.println("Boton composicion");
                composicion.b = true;
                agregacion.b = false;
                lapiz.b = false;
                rectangulo.b = false;
                herencia.b = false;
                asociacion.b = false;
                realizacion.b = false;
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
        
        MouseListener botHerencia = new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e){
                System.out.println("Boton Herencia");
                herencia.b = true;
                composicion.b = false;
                agregacion.b = false;
                lapiz.b = false;
                rectangulo.b = false;
                asociacion.b = false;
                realizacion.b = false;
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
        MouseListener botAsociacion = new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e){
                System.out.println("Boton Asociacion");
                asociacion.b = true;
                herencia.b = false;
                composicion.b = false;
                agregacion.b = false;
                lapiz.b = false;
                rectangulo.b = false;
                realizacion.b = false;
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
        
        MouseListener botRealizacion = new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e){
                System.out.println("Boton Realizacion");
                realizacion.b = true;
                asociacion.b = false;
                herencia.b = false;
                composicion.b = false;
                agregacion.b = false;
                lapiz.b = false;
                rectangulo.b = false;
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
        BotonLapiz.addMouseListener(botLapiz);
        BotonRectangulo.addMouseListener(botRectangulo);
        BotonAgregacion.addMouseListener(botAgregacion);
        BotonComposicion.addMouseListener(botComposicion);
        BotonHerencia.addMouseListener(botHerencia);
        BotonAsociacion.addMouseListener(botAsociacion);
        BotonRealizacion.addMouseListener(botRealizacion);
        
    }
   
}  