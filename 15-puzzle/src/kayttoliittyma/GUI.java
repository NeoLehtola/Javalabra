
package kayttoliittyma;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import sovelluslogiikka.Pelitapahtuma;


public class GUI implements Runnable {
    
    private JFrame frame;
    private Pelitapahtuma peli;
    
    
    public GUI(Pelitapahtuma peli) {
        this.peli = peli;
    }

    @Override
    public void run() {
        frame = new JFrame("15 puzzle");
        frame.setPreferredSize(new Dimension(peli.getPelilauta().getKorkeus() * 75, peli.getPelilauta().getLeveys() * 75));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
        
    }
    
    private void luoKomponentit(Container container) {
        // jos tämä luokin aloitusruudun, joka sitten puolestaan luo annetun kokoisen pelilaudan
        
        GUIPelilauta lauta = new GUIPelilauta(peli);
        
//        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        container.add(lauta);
//        container.add();
    }
    
    public JFrame getFrame() {
        return frame;
    }
    

    
    
    

        
    
    
}
