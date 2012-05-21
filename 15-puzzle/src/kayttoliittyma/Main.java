
package kayttoliittyma;

//import java.util.Scanner;
import sovelluslogiikka.PelilaudanKayttaja;
//import javax.swing.SwingUtilities;

public class Main {
    
    public static void main(String[] args) {
//        GUI gui = new GUI();
//        SwingUtilities.invokeLater(gui);

        Tekstikayttoliittyma t = new Tekstikayttoliittyma(new PelilaudanKayttaja(4, 4, 10000));
        t.tulostaPelilauta();
        
    }
    
}
