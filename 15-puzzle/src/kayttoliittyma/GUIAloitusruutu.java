package kayttoliittyma;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import sovelluslogiikka.Pelitapahtuma;

public class GUIAloitusruutu extends JPanel {



    public GUIAloitusruutu() {

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


    
    private JButton luoUusiGuiPelilauta() {
        JButton nappi = new JButton("Valmis");
        nappi.addActionListener(new GUILaudanLuovaNapinKuuntelija());
        return nappi;
    }



    private class AlkuvalikonUusiPeliNapinKuuntelija implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            removeAll();
            JLabel label = new JLabel("vasen: korkeus, oikea: leveys");
            add(label);

            add(new GUILaudanKoonValintaRuutu());
            add(luoUusiGuiPelilauta());
            validate();
        }
    }
    
    private class GUILaudanLuovaNapinKuuntelija implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
//            removeAll();
//            GUIPelilauta pelilauta = new GUIPelilauta(new Pelitapahtuma(korkeudenValinta, leveydenValinta, korkeudenValinta*leveydenValinta*1000));
//            add(pelilauta);
//            validate();
        }
        
    }
}
