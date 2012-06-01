package kayttoliittyma;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class GUILaudanKoonValintaRuutu extends JPanel {
    
    private int koonAlaraja;
    private int koonYlaraja;
    private int korkeudenValinta = koonAlaraja;
    private int leveydenValinta = koonAlaraja;

    public GUILaudanKoonValintaRuutu() {
        this.koonAlaraja = 3;
        this.koonYlaraja = 8;
        luoKomponentit();
    }

    private void luoKomponentit() {
        GridLayout layout = new GridLayout(3, 1);
        setLayout(layout);

    }

    private JPanel luoLaudanKoonValitsin() {
        JPanel panel = new JPanel(new GridLayout(1, 2));


        JButton korkeus = new JButton(koonAlaraja + "");
        JButton leveys = new JButton(koonAlaraja + "");
        korkeus.addActionListener(new KoonValitsinKuuntelija(korkeus));
        leveys.addActionListener(new KoonValitsinKuuntelija(leveys));

        panel.add(korkeus);
        panel.add(leveys);

        return panel;
    }
    
        // mites nuo valinnat otetaan tuosta talteen???
    private class KoonValitsinKuuntelija implements ActionListener {

        private JButton nappi;

        KoonValitsinKuuntelija(JButton nappi) {
            this.nappi = nappi;
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            int nro = Integer.parseInt(nappi.getText());
            if (nro < koonYlaraja) {
                nro++;
                nappi.setText(nro + "");
            }
            // tälle metodille pitäis jotenkin saattaa tiedoksi, onko kyseessä korkeus vai leveys.
            korkeudenValinta++;
            
            
        }
    }
}
