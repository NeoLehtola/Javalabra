package kayttoliittyma;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import sovelluslogiikka.SiirtavaPelilauta;

public class GUIPelilauta implements Runnable {

    private JButton nappi;
    private JFrame frame;
    private JLabel tyhja;
    private SiirtavaPelilauta pelilauta;
    
    public GUIPelilauta(SiirtavaPelilauta pelilauta) {
        this.pelilauta = pelilauta;
    }

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
        
        // pitääkö poistaa ensin vanhat napit?
        
        for (int i = 0; i < pelilauta.getKorkeus(); i++) {
            for (int j = 0; j < pelilauta.getLeveys(); j++) {
                if (pelilauta.getNappula(i, j).getTunniste() == -1) {
                    tyhja = new JLabel("");
                    container.add(tyhja);
                } else {
                    nappi = new JButton();
                    nappi.setText(pelilauta.getNappula(i, j).getTunniste() + "");
                    nappi.addActionListener(new NapinKuuntelija());
                    container.add(nappi);
                }
            }
        }
    }

    public JFrame getFrame() {
        return frame;
    }
}
