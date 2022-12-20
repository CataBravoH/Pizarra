package Interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
/**
 * Clase de Barra de Menu, crea una barra con las funciones de Pizarras(añadir,eliminar,siguiente,anterior pizarra) y Archivo(guardar,cargar)
 * @author cata
 */

public class BarraMenu extends JMenuBar{
    private PanelCentro panel;
    private JMenu Pizarra, Archivo;
    private JMenuItem siguiente, anterior, quitar, anadir;
    private ActionListener mouse;
    /**
     * Crea la barra de menu en la ventana 
     * @param v parametro de ventana
     */
    public BarraMenu(Ventana v){
        panel = v.panel;
        v.setJMenuBar(this);
        EventoRaton();
        
        Archivo = new JMenu("Archivo");
        this.add(Archivo);
        
        Pizarra = new JMenu("Pizarra");
        this.add(Pizarra);
        anadir = new JMenuItem("Añadir Pizarra");
        anadir.addActionListener(mouse);
        Pizarra.add(anadir);
        siguiente = new JMenuItem("Siguiente Pizarra");
        siguiente.addActionListener(mouse);
        Pizarra.add(siguiente);
        anterior = new JMenuItem("Anterior Pizarra");
        anterior.addActionListener(mouse);
        Pizarra.add(anterior);
        quitar = new JMenuItem("Eliminar Pizarra");
        quitar.addActionListener(mouse);
        Pizarra.add(quitar);
        
        
        
    }
    /**
     * Metodo EventoRaton que ocupa funcione de ActionListener para interactuar con la barra de menu
     */
    private void EventoRaton(){
        mouse = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == siguiente) {
                    panel.sgtPizarra();
                }
                if(e.getSource() == anterior) {
                    panel.antPizarra();
                }
                if(e.getSource() == anadir) {
                    panel.masPizarra();
                }
                if(e.getSource() == quitar) {
                    panel.quitarPizarra();
                }
            }
        };
    }
    
}
