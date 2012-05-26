package kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import sovelluslogiikka.Pelitapahtuma;

public class NapinKuuntelija implements ActionListener {

    private Pelitapahtuma peli;
    private int napinKorkeus;
    private int napinLeveys;

    public NapinKuuntelija(Pelitapahtuma peli, int napinKorkeus, int napinLeveys) {
        this.peli = peli;
        this.napinKorkeus = napinKorkeus;
        this.napinLeveys = napinLeveys;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!peli.peliPaattynyt()) {
            if (peli.pelaaYksiVuoroJosSiirtoSallittu(napinKorkeus, napinLeveys)) {
                peli.kasvataVuorojenMaaraa();
            }
        }
    }
}
