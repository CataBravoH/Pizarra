package pizarra;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.*;

public class BarraMenu extends JMenuBar{
    private JMenu Pizarra, Limpiar;
    private JMenuItem Siguiente,Anterior,Eliminar;
    
    public BarraMenu(Ventana v){
        v.setJMenuBar(this);
        
        Pizarra = new JMenu("Pizarra");
        this.add(Pizarra);
        
        
        Limpiar = new JMenu("Limpiar");
        this.add(Limpiar);
    }
}
