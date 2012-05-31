package kayttoliittyma;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import sovelluslogiikka.Pelitapahtuma;

public class GUIAloitusruutu extends JPanel {

    private Pelitapahtuma peli;
    private int koonAlaraja;
    private int koonYlaraja;
    private int korkeudenValinta = koonAlaraja;
    private int leveydenValinta = koonAlaraja;

    public GUIAloitusruutu() {
        this.koonAlaraja = 3;
        this.koonYlaraja = 8;
        luoKomponentit();
    }

    private void luoKomponentit() {
        GridLayout layout = new GridLayout(3, 1);
        setLayout(layout);
        JLabel teksti = new JLabel("Tervetuloa pelaamaan 15-puzzlea");
        add(teksti);
        add(luoValitsinTallennettuVaiUusiPeli());


    }

    private JPanel luoValitsinTallennettuVaiUusiPeli() {
        JPanel panel = new JPanel(new GridLayout(2, 1));

        JButton tallennettu = new JButton();
        tallennettu.setText("Avaa tallennettu peli");

        JButton uusiPeli = new JButton();
        uusiPeli.setText("Aloita uusi peli");
        uusiPeli.addActionListener(new AlkuvalikonUusiPeliNapinKuuntelija());

        panel.add(tallennettu);
        panel.add(uusiPeli);

        return panel;
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
    
    private JButton luoUusiGuiPelilauta() {
        JButton nappi = new JButton("Valmis");
        nappi.addActionListener(new GUILaudanLuovaNapinKuuntelija());
        return nappi;
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

    private class AlkuvalikonUusiPeliNapinKuuntelija implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            removeAll();
            JLabel label = new JLabel("vasen: korkeus, oikea: leveys");
            add(label);

            add(luoLaudanKoonValitsin());
            add(luoUusiGuiPelilauta());
            validate();
        }
    }
    
    private class GUILaudanLuovaNapinKuuntelija implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            removeAll();
            GUIPelilauta pelilauta = new GUIPelilauta(new Pelitapahtuma(korkeudenValinta, leveydenValinta, korkeudenValinta*leveydenValinta*1000));
            add(pelilauta);
            validate();
        }
        
    }
}
