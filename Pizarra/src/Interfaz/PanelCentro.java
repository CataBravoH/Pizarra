package Interfaz;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import ObjetosUML.*;
import Herramientas.*;
/**
 * Clase Panel del centro que contiene las demás clases para darle visualizarlas de distintas maneras y darle su funcion correspondiente
 * @author cata
 */
public class PanelCentro extends JPanel{
    private ArrayList<PizarraVista> pizarras; // Arreglo de pizarras donde se crearan.
    private PizarraVista pizarra;
    private int indP;
    private int cantP;
    private Lapiz lapiz;
    private Goma goma;
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
    private JButton BotonGoma;
    private JButton BotonRojo, BotonVerde, BotonAzul, BotonNegro;
    
   
    /**
     * Se crea el panel a partir de las funciones de JPanel, se inicializa todas los objetos para visualizalos en el panel
     */
    public PanelCentro(){
        this.setLayout(null);
        this.setBackground(Color.lightGray);
        
        pizarras = new ArrayList<PizarraVista>();
        pizarras.add(new PizarraVista());
        indP =0;
        pizarra = pizarras.get(indP);
        this.add(pizarra);
        cantP = pizarras.size();
        
        lapiz = new Lapiz(pizarra);
        goma = new Goma(pizarra);
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
    /**
     * Metodo que se encarga de pasar a la siguiente pizarra una vez ya creada
     */
    public void sgtPizarra(){
        if(indP < pizarras.size() - 1){
            this.remove(pizarra);
            indP += 1;
            pizarra = pizarras.get(indP);
            this.add(pizarra);
            this.repaint();
            lapiz.OtraPizarra(pizarra);
            rectangulo.OtraPizarra(pizarra);
            agregacion.OtraPizarra(pizarra);
            asociacion.OtraPizarra(pizarra);
            composicion.OtraPizarra(pizarra);
            herencia.OtraPizarra(pizarra);
            realizacion.OtraPizarra(pizarra);
            goma.OtraPizarra(pizarra);
        }
    }
    /**
     * Metodo que se encarga de pasar a la anterior pizarra
     */
    public void antPizarra(){
        if(indP > 0){
            this.remove(pizarra);
            indP -= 1;
            pizarra = pizarras.get(indP);
            this.add(pizarra);
            this.repaint();
            lapiz.OtraPizarra(pizarra);
            rectangulo.OtraPizarra(pizarra);
            agregacion.OtraPizarra(pizarra);
            asociacion.OtraPizarra(pizarra);
            composicion.OtraPizarra(pizarra);
            herencia.OtraPizarra(pizarra);
            realizacion.OtraPizarra(pizarra);
            goma.OtraPizarra(pizarra);
        }
    }
    /**
     * Metodo que agrega una pizarra
     */
    public void masPizarra(){
        if(indP == pizarras.size() - 1){
            pizarras.add(new PizarraVista());
            cantP = pizarras.size();
            sgtPizarra();
        }
    }
    /**
     * Metodo que elimina una pizarra
     */
    public void quitarPizarra(){
        int indQuitar = indP;
        if(indQuitar != 0){
            antPizarra();
            pizarras.remove(indQuitar);
            cantP = pizarras.size();
        }
    }
    /**
     * Metodo que crea los botones en el panel, le da imagen, nombre o color según corresponda
     */
    public void Botones() {
        
        this.setLayout(null);
        BotonLimpiar = new JButton("Limpiar");
        BotonLimpiar.setBounds(1150,10,110,60);
        this.add(BotonLimpiar);
        
        this.setLayout(null);
        ImageIcon Cuadrado = new ImageIcon("src/img/Cuadrado.png");
        BotonRectangulo = new JButton();
        BotonRectangulo.setIcon(Cuadrado);
        BotonRectangulo.setContentAreaFilled(false);
        BotonRectangulo.setBounds(10, 450, 120, 100);
        this.add(BotonRectangulo);
        
        this.setLayout(null);
        ImageIcon Lapiz = new ImageIcon("src/img/pencil.png");
        BotonLapiz = new JButton();
        BotonLapiz.setIcon(Lapiz);
        BotonLapiz.setContentAreaFilled(false);
        BotonLapiz.setBounds(1150, 90, 110, 60);
        this.add(BotonLapiz);
        
        this.setLayout(null);
        ImageIcon Goma = new ImageIcon("src/img/eraser.png");
        BotonGoma = new JButton();
        BotonGoma.setIcon(Goma);
        BotonGoma.setBounds(1150,160,110,60);
        this.add(BotonGoma);
        
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
        BotonTexto.setBounds(1150,250,110,60);
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
    
    /**
     * Metodo Evento de Raton que utiliza funciones de MouseListener para que actuen los botones cuando se hace click en ellos
     */
    private void EventoDeRaton(){
        MouseListener botlimpiar = new MouseListener(){         
            @Override
            public void mouseClicked(MouseEvent e){
                System.out.println("Boton limpiar");
                for(int i=0; i<pizarras.size(); i++){
                    pizarra.Lapiz.removeAll(pizarra.Lapiz);
                    pizarra.Rectangulo.removeAll(pizarra.Rectangulo);
                    pizarra.Agregacion.removeAll(pizarra.Agregacion);
                    pizarra.Composicion.removeAll(pizarra.Composicion);
                    pizarra.Lineas.removeAll(pizarra.Lineas);
                    pizarra.Lineas2.removeAll(pizarra.Lineas2);
                    pizarra.Colores.removeAll(pizarra.Colores);
                    pizarra.Goma.removeAll(pizarra.Goma);
                    pizarra.Triangulo.removeAll(pizarra.Triangulo);
                    pizarra.Realizacion.removeAll(pizarra.Realizacion);
                }
                pizarra.repaint();
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
                rectangulo.status(true);
                lapiz.status(false);
                agregacion.status(false);
                herencia.status(false);
                composicion.status(false);
                asociacion.status(false);
                realizacion.status(false);
                goma.status(false);
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
                lapiz.status(true);
                rectangulo.status(false);
                agregacion.status(false);
                herencia.status(false);
                composicion.status(false);
                asociacion.status(false);
                realizacion.status(false);
                goma.status(false);
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
                agregacion.status(true);
                lapiz.status(false);
                rectangulo.status(false);
                herencia.status(false);
                composicion.status(false);
                asociacion.status(false);
                realizacion.status(false);
                goma.status(false);
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
                composicion.status(true);
                agregacion.status(false);
                lapiz.status(false);
                rectangulo.status(false);
                herencia.status(false);
                asociacion.status(false);
                realizacion.status(false);
                goma.status(false);
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
                herencia.status(true);
                composicion.status(false);
                agregacion.status(false);
                lapiz.status(false);
                rectangulo.status(false);
                asociacion.status(false);
                realizacion.status(false);
                goma.status(false);
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
                asociacion.status(true);
                herencia.status(false);
                composicion.status(false);
                agregacion.status(false);
                lapiz.status(false);
                rectangulo.status(false);
                realizacion.status(false);
                goma.status(false);
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
                realizacion.status(true);
                asociacion.status(false);
                herencia.status(false);
                composicion.status(false);
                agregacion.status(false);
                lapiz.status(false);
                rectangulo.status(false);
                goma.status(false);
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
        
        MouseListener botColorNegro = new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e){
                System.out.println("Boton Color Negro");
                lapiz.status(true);
                lapiz.Negro();
                realizacion.status(false);
                asociacion.status(false);
                herencia.status(false);
                composicion.status(false);
                agregacion.status(false);
                rectangulo.status(false);
                goma.status(false);
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
        MouseListener botColorAzul = new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e){
                System.out.println("Boton Color Azul");
                lapiz.status(true);
                lapiz.Azul();
                realizacion.status(false);
                asociacion.status(false);
                herencia.status(false);
                composicion.status(false);
                agregacion.status(false);
                rectangulo.status(false);
                goma.status(false);
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
        MouseListener botColorRojo = new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e){
                System.out.println("Boton Color Rojo");
                lapiz.status(true);
                lapiz.Rojo();
                realizacion.status(false);
                asociacion.status(false);
                herencia.status(false);
                composicion.status(false);
                agregacion.status(false);
                rectangulo.status(false);
                goma.status(false);
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
        MouseListener botColorVerde = new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e){
                System.out.println("Boton Color Verde");
                lapiz.status(true);
                lapiz.Verde();
                realizacion.status(false);
                asociacion.status(false);
                herencia.status(false);
                composicion.status(false);
                agregacion.status(false);
                rectangulo.status(false);
                goma.status(false);
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
        MouseListener botGoma = new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e){
                System.out.println("Boton Goma");
                goma.status(true);
                lapiz.status(false);
                realizacion.status(false);
                asociacion.status(false);
                herencia.status(false);
                composicion.status(false);
                agregacion.status(false);
                rectangulo.status(false);
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
        
        BotonLimpiar.addMouseListener(botlimpiar);
        BotonLapiz.addMouseListener(botLapiz);
        BotonGoma.addMouseListener(botGoma);
        BotonRectangulo.addMouseListener(botRectangulo);
        BotonAgregacion.addMouseListener(botAgregacion);
        BotonComposicion.addMouseListener(botComposicion);
        BotonHerencia.addMouseListener(botHerencia);
        BotonAsociacion.addMouseListener(botAsociacion);
        BotonRealizacion.addMouseListener(botRealizacion);
        BotonNegro.addMouseListener(botColorNegro);
        BotonAzul.addMouseListener(botColorAzul);
        BotonRojo.addMouseListener(botColorRojo);
        BotonVerde.addMouseListener(botColorVerde);
    }
   
}  