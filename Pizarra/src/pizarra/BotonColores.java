package pizarra;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class BotonColores extends JPanel {
    private JButton BotonRojo;
    private JButton BotonVerde;
    private JButton BotonAzul;
    private JButton BotonNegro;
    
    private Colores color;
    private LineBorder gBorder;
    private LineBorder lBorder;
    
    public BotonColores (Colores c){
        color = c;
        gBorder = new LineBorder(Color.green);
        lBorder = new LineBorder(Color.lightGray);
        
        BotonNegro = new JButton();
        BotonNegro.setFocusable(false);
        BotonNegro.setBounds(35,15,30,30);
        BotonNegro.setBackground(Color.black);
        
        BotonNegro.setBorder(gBorder);
        
        BotonNegro.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e){
                System.out.println("Negro");
                cleanColor();
                BotonNegro.setBorder(gBorder);
                PizarraVista.setColor(Color.black);
            }
        });
        
        BotonRojo = new JButton();
        BotonRojo.setFocusable(false);
        BotonRojo.setBounds(75,15,30,30);
        BotonRojo.setBackground(Color.red);
        
        BotonRojo.setBorder(gBorder);
        
        BotonRojo.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e){
                System.out.println("Rojo");
                cleanColor();
                BotonRojo.setBorder(gBorder);
                PizarraVista.setColor(Color.red);
            }
        });
        
        BotonAzul = new JButton();
        BotonAzul.setFocusable(false);
        BotonAzul.setBounds(115,15,30,30);
        BotonAzul.setBackground(Color.blue);
        
        BotonAzul.setBorder(gBorder);
        
        BotonAzul.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e){
                System.out.println("Azul");
                cleanColor();
                BotonAzul.setBorder(gBorder);
                PizarraVista.setColor(Color.blue);
            }
        });
        
        BotonVerde = new JButton();
        BotonVerde.setFocusable(false);
        BotonVerde.setBounds(35,55,30,30);
        BotonVerde.setBackground(Color.green);
        
        BotonVerde.setBorder(gBorder);
        
        BotonVerde.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e){
                System.out.println("Verde");
                cleanColor();
                BotonVerde.setBorder(gBorder);
                PizarraVista.setColor(Color.green);
            }
        });
        
        color.add(BotonNegro);
        color.add(BotonAzul);
        color.add(BotonRojo);
        color.add(BotonVerde);
    }
    
    public void cleanColor(){
        BotonNegro.setBorder(lBorder);
        BotonRojo.setBorder(lBorder);
        BotonAzul.setBorder(lBorder);
        BotonVerde.setBorder(lBorder);
    }
}
