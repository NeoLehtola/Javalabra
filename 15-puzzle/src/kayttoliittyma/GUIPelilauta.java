package kayttoliittyma;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import sovelluslogiikka.Pelitapahtuma;
import sovelluslogiikka.SiirtavaPelilauta;

public class GUIPelilauta implements Runnable {

    private JButton nappi;
    private JFrame frame;
    private JLabel tyhja;
    private Pelitapahtuma peli;
    private SiirtavaPelilauta pelilauta;
    
    public GUIPelilauta(Pelitapahtuma peli) {
        this.peli = peli;
        this.pelilauta = peli.getPelilauta();
    }

    @Override
    public void run() {
        frame = new JFrame("15 puzzle");
        // laske koko nappulan halutun koon mukaan, KORJAA!!! nyt toimii vain neliön mallisille
        frame.setPreferredSize(new Dimension(pelilauta.getKorkeus()*70, pelilauta.getLeveys()*70));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        luoKomponentit(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        GridLayout layout = new GridLayout(pelilauta.getKorkeus(), pelilauta.getLeveys());
        container.setLayout(layout);
        // pitääkö poistaa ensin vanhat napit?
        
        for (int i = 0; i < pelilauta.getKorkeus(); i++) {
            for (int j = 0; j < pelilauta.getLeveys(); j++) {
                if (pelilauta.getNappula(i, j).getTunniste() == -1) {
                    tyhja = new JLabel("");
                    container.add(tyhja);
                } else {
                    nappi = new JButton();
                    nappi.setText(pelilauta.getNappula(i, j).getTunniste() + "");
                    nappi.addActionListener(new NapinKuuntelija(peli, i, j));
                    container.add(nappi);
                }
            }
        }
    }

    public JFrame getFrame() {
        return frame;
    }
}
