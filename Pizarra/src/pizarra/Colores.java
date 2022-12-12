package pizarra;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Colores extends JPanel {
    
    BotonColores botones;
    
    public Colores(){
        this.setPreferredSize(new Dimension(180,300));
        this.setBackground(Color.lightGray);
        
        this.setLayout(null);
        
        botones = new BotonColores(this);
    }
     
    
}
