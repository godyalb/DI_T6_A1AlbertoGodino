package lanzaayuda;

import java.awt.Container;
import java.awt.event.ActionEvent;
import static java.lang.System.exit;
import java.net.URL;
import javax.help.HelpSet;
import javax.help.JHelp;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LanzaAyuda 
{
    JFrame frame;
    JPanel panel;
    JButton button;
    JTextField texfield;
    Container contentPane;
    JMenuBar menuBar;
    JMenu menu1, menu2;
    JMenuItem item1,item2;
    
    public static void main(String[] args) 
    {
        LanzaAyuda sd = new LanzaAyuda();
        sd.launchFrame();
    }
    
    void launchFrame()
    {
        frame = new JFrame("Lanza Ayuda");
        panel = new JPanel();
        texfield = new JTextField("Texto por defecto");
        button = new JButton("Pulsar");
        menuBar = new JMenuBar();
        menu1 = new JMenu("Ayuda");
        menu2 = new JMenu("Salir");
        item1 = new JMenuItem("Desplegar ayuda de la aplicacion");
        item2 = new JMenuItem("Salir");
        menu1.add(item1);
        menu2.add(item2);
        menuBar.add(menu1);
        menuBar.add(menu2);
        contentPane = frame.getContentPane();
        panel.add(texfield);
        panel.add(button);
        panel.add(menuBar);
        item1.addActionListener((ActionEvent e) -> {
            ayuda();
        });
        item2.addActionListener((e) -> {
            exit(0);
        });
        contentPane.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
    
    //Metodo que realiza la carga de la ventana de ayuda
    public void ayuda()
    {
        JHelp helpViewer = null;
        try 
        {
	    ClassLoader cl = LanzaAyuda.class.getClassLoader();
            URL url = HelpSet.findHelpSet(cl,"lanzaayuda/fichero_helpset.hs");
            helpViewer = new JHelp(new HelpSet(cl, url));
        } 
        catch (Exception e) 
        {
            System.err.println("Error al cargar el fichero Helpset");
        }

        JFrame frame = new JFrame();
        frame.setSize(500,500);
        frame.getContentPane().add(helpViewer);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }
}
