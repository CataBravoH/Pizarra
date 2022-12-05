package pizarra;
import javax.swing.JFrame;
import java.awt.BorderLayout;

public class Ventana extends JFrame{
    
    private final static int ANCHO_VENTANA = 1300;
    private final static int LARGO_VENTANA = 700;
    private BarraMenu Menu;
 
    public Ventana() {
        
        this.setLayout(new BorderLayout());
        setTitle("Pizarra");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        PanelCentro pc = new PanelCentro(); 
        this.setSize(ANCHO_VENTANA, LARGO_VENTANA);
        this.add(pc,BorderLayout.CENTER);
        Menu = new BarraMenu(this);
        this.setVisible(true);
    }
}
