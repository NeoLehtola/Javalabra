
package kayttoliittyma;

import java.util.Scanner;
import javax.swing.SwingUtilities;
import sovelluslogiikka.Pelitapahtuma;

public class Main {
    
    public static void main(String[] args) {
        GUI gui = new GUI();
        GUIPelilauta pelilauta = new GUIPelilauta(new Pelitapahtuma(8, 8, 10000));
        SwingUtilities.invokeLater(pelilauta);
//        Scanner lukija = new Scanner(System.in);
//        Tekstikayttoliittyma t = new Tekstikayttoliittyma();
//        t.kaynnista();
      
        
    }
    
}
