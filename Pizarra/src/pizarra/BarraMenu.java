package pizarra;

import javax.swing.JMenu;
import javax.swing.JMenuBar;


public class BarraMenu extends JMenuBar{
    private JMenu Pizarra, Archivo;
    
    
    public BarraMenu(Ventana v){
        v.setJMenuBar(this);
        
        Archivo = new JMenu("Archivo");
        this.add(Archivo);
        
        Pizarra = new JMenu("Pizarra");
        this.add(Pizarra);
        
    }
}
