
package kayttoliittyma;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;


public class GUI implements Runnable {
    
    private JFrame frame;

    
    


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
        // jos tämä luokin aloitusruudun, joka sitten puolestaan luo annetun kokoisen pelilaudan
        
        GUIAloitusruutu aloitus = new GUIAloitusruutu();

        container.add(aloitus);


    }
    
    public JFrame getFrame() {
        return frame;
    }
    

    
    
    

        
    
    
}
