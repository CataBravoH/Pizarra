package Interfaz;

import java.awt.BasicStroke;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.util.ArrayList;
/**
 * Clase que crea el panel de Pizarra, la pizarra en blanco y alberga los objetos que se pueden crear en ella
 * @author cata
 */
public class PizarraVista extends JPanel{
    private final static int ANCHO = 1000;
    private final static int LARGO = 610;
    public Graphics g;
    public ArrayList<int[]> Lineas;
    public ArrayList <int[]> Lineas2;
    public ArrayList<int[]> Rectangulo;
    public ArrayList<int[]> Lapiz;
    public ArrayList<int[]> Goma;
    public ArrayList<Color> Colores;
    public ArrayList<Polygon> Composicion;
    public ArrayList<Polygon> Agregacion;
    public ArrayList<Polygon> Triangulo;
    public ArrayList<BasicStroke> Realizacion;
    
    /**
     * Crea la pizarra a partir de las funciones de JPanel 
     */
    
    public PizarraVista(){
        this.setBackground(Color.white);
        this.setSize(ANCHO,LARGO);
        this.setLocation(140,10);
        
        Lapiz = new ArrayList<>();
        Goma = new ArrayList<>();
        Colores = new ArrayList<>();
        Lineas = new ArrayList<>();
        Lineas2 = new ArrayList<>();
        Rectangulo = new ArrayList<>();
        Composicion = new ArrayList<>();
        Agregacion = new ArrayList<>();
        Triangulo = new ArrayList<>();
        Realizacion = new ArrayList<>();
        
    }
    
    /**
     * Metodo que vizualiza la pizarra y le da otras funcionalidades, también recibe a los demás objetos en ella
     * @param g parametro de Graphics
     */
    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.setColor(Color.black);
        
        for(int i=0; i<Rectangulo.size(); i++){
            g.drawRect(Rectangulo.get(i)[0], Rectangulo.get(i)[1], Rectangulo.get(i)[2], Rectangulo.get(i)[3]);
        }
        for(int i=0; i<Lineas.size(); i++){
            g.drawLine(Lineas.get(i)[0],Lineas.get(i)[1], Lineas.get(i)[2], Lineas.get(i)[3]);
        }
        for(int i=0; i<Composicion.size(); i++){
            g.fillPolygon(Composicion.get(i));
        }
        for(int i=0; i<Agregacion.size(); i++){
            g.drawPolygon(Agregacion.get(i));
        }
        for(int i = 0; i < Triangulo.size(); i++) {
            g.drawPolygon(Triangulo.get(i));
        }
        for(int i=0; i<Lapiz.size(); i++){
            g.setColor(Colores.get(i));
            g.fillOval(Lapiz.get(i)[0], Lapiz.get(i)[1], Lapiz.get(i)[2], Lapiz.get(i)[3]);
        }
        
        for(int i=0; i<Goma.size(); i++){
            g.setColor(Color.white);
            g.fillOval(Goma.get(i)[0], Goma.get(i)[1], Goma.get(i)[2], Goma.get(i)[3]);
        }
        for(int i=0; i<Realizacion.size(); i++){
            Graphics2D g2d = (Graphics2D)g;
            for(int j=0; j<Lineas2.size();j++){
                g2d.setStroke(Realizacion.get(i));
                g2d.drawLine(Lineas2.get(j)[0], Lineas2.get(j)[1], Lineas2.get(j)[2], Lineas2.get(j)[3]);
            }
            
        }
    }   
}
