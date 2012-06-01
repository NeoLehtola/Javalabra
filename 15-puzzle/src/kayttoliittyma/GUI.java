package kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.*;
import sovelluslogiikka.Pelitapahtuma;
//import sovelluslogiikka.Pelitapahtuma;

public class GUI implements Runnable {

    private JFrame frame;
    private Pelitapahtuma peli;
    
    @Override
    public void run() {
        frame = new JFrame("15 puzzle");


        frame.setPreferredSize(new Dimension(300, 300));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        luoKomponentit(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);

    }

    private void luoKomponentit(Container container) {

        
        container.setLayout(new BorderLayout());

        peli = new Pelitapahtuma(4, 4, 10000);
        GUIPelilauta pelilauta = new GUIPelilauta(peli);
        container.add(pelilauta, BorderLayout.CENTER);      
        container.add(pelilauta.getVuorot(), BorderLayout.SOUTH);
    }



    public JFrame getFrame() {
        return frame;
    }
}
