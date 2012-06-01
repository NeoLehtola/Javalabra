
package kayttoliittyma;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
//import sovelluslogiikka.Pelitapahtuma;


public class GUI implements Runnable {
    
    private JFrame frame;

    
    @Override
    public void run() {
        frame = new JFrame("15 puzzle");
        frame.setPreferredSize(new Dimension(300, 300));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
        
    }
    
    private void luoKomponentit(Container container) {
               
        GUIAloitusruutu aloitus = new GUIAloitusruutu();
        container.add(aloitus);
        
//        GUIPelilauta pelilauta = new GUIPelilauta(new Pelitapahtuma(4, 4, 10000));
//        container.add(pelilauta);


    }
    
    public JFrame getFrame() {
        return frame;
    }
    

    
    
    

        
    
    
}
