
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
    
    public GUIAloitusruutu() {
        this.koonAlaraja = 3;
        this.koonYlaraja = 8;
    }
    
    private void luoKomponentit(Container container) {
        // tee layout
        JLabel teksti = new JLabel("Tervetuloa pelaamaan 15-puzzlea");
        container.add(teksti);
        
     
    }
    
    private JPanel luoValitsinTallennettuVaiUusiPeli() {
        JPanel panel = new JPanel(new GridLayout(2, 1));
        
        JButton tallennettu = new JButton();
        tallennettu.setText("Avaa tallennettu peli");
        
        JButton uusiPeli = new JButton();
        uusiPeli.setText("Aloita uusi peli");
        
        panel.add(tallennettu);
        panel.add(uusiPeli);
        
        return panel;
    }
    
    private JPanel luoLaudanKoonValitsin() {
        JPanel panel = new JPanel(new GridLayout(1, 2));
        
        JButton korkeus = new JButton(koonAlaraja + "");
        JButton leveys = new JButton(koonAlaraja + ""); 
        
        panel.add(korkeus);
        panel.add(leveys);
        
        return panel;
    }
    
    private class koonValitsinKuuntelija implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent ae) {
            
        }
        
    }
    
    
    private class tallennettuVaiUusiKuuntelija implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            
        }
        
    }
    
    
    
}
