package pizarra;

import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.ArrayList;

public class PizarraVista extends JPanel{
    private final static int ANCHO = 1000;
    private final static int LARGO = 610;
    public Graphics g;
    public Graphics gp;
    private static Color color;
    public ArrayList<int[]> Lineas;
    public ArrayList<int[]> Rectangulo;
    public ArrayList<Polygon> Composicion;
    public ArrayList<Polygon> Agregacion;
    public ArrayList<Polygon> Triangulo;
    
    
    
    public PizarraVista(){
        this.setBackground(Color.white);
        this.setSize(ANCHO,LARGO);
        this.setLocation(140,10);
        
        Lineas = new ArrayList<>();
        Rectangulo = new ArrayList<>();
        Composicion = new ArrayList<>();
        Agregacion = new ArrayList<>();
        Triangulo = new ArrayList<>();
    }
    
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
    }
    

   
}
