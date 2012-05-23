
package kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import sovelluslogiikka.Pelitapahtuma;


public class TapahtumanKuuntelija implements ActionListener {
    
    private Pelitapahtuma peli;
    
    public TapahtumanKuuntelija(Pelitapahtuma peli) {
        this.peli = peli;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
