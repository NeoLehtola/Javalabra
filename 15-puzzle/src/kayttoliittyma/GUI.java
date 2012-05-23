
package kayttoliittyma;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import sovelluslogiikka.SiirtavaPelilauta;

public class GUI implements Runnable {
    
    private JFrame frame;
    private SiirtavaPelilauta pelilauta;

    @Override
    public void run() {
        frame = new JFrame("15 puzzle");
        frame.setPreferredSize(new Dimension(400, 400));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
        
    }
    
    private void luoKomponentit(Container container) {
        
    }
    
    public JFrame getFrame() {
        return frame;
    }
    
}
