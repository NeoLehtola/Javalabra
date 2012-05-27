package kayttoliittyma;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import sovelluslogiikka.Pelitapahtuma;
import sovelluslogiikka.SiirtavaPelilauta;

public class GUIPelilauta extends JPanel {

    private JButton nappi;
    private JLabel tyhja;
    private Pelitapahtuma peli;
    private SiirtavaPelilauta pelilauta;

    public GUIPelilauta(Pelitapahtuma peli) {
        this.peli = peli;
        this.pelilauta = peli.getPelilauta();
        luoKomponentit();
    }



    private void luoKomponentit() {
        GridLayout layout = new GridLayout(pelilauta.getKorkeus(), pelilauta.getLeveys());
        setLayout(layout);
        piirraNappulat();
 
        
    }

    private void piirraNappulat() {

        this.removeAll();

        for (int i = 0; i < pelilauta.getKorkeus(); i++) {
            for (int j = 0; j < pelilauta.getLeveys(); j++) {
                if (pelilauta.getNappula(i, j).getTunniste() == -1) {
                    tyhja = new JLabel("");
                    this.add(tyhja);
                } else {
                    nappi = new JButton();                  
                    nappi.addActionListener(new NapinKuuntelija());
                    nappi.setText(pelilauta.getNappula(i, j).getTunniste() + "");
                    this.add(nappi);
                }
            }
        }
    }



    /**
     * luokan sisäinen apuluokka
     */
    private class NapinKuuntelija implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton nappi = (JButton) e.getSource();
            Dimension size = nappi.getSize();

            // nää saattaa olla väärinpäin, hahmotusongelmia...
            int korkeus = nappi.getY() / size.height;
            int leveys = nappi.getX() / size.width;
            


            if (!peli.peliPaattynyt()) {
                if (peli.pelaaYksiVuoroJosSiirtoSallittu(korkeus, leveys)) {
                    peli.kasvataVuorojenMaaraa();
                }
            }

            pelilauta = peli.getPelilauta();
            piirraNappulat();
            validate();
            

        }
    }
}
