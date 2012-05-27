
package kayttoliittyma;

//import java.util.Scanner;
import javax.swing.SwingUtilities;
import sovelluslogiikka.Pelitapahtuma;

public class Main {
    
    public static void main(String[] args) {
        GUI gui = new GUI(new Pelitapahtuma(5, 5, 10000));
        SwingUtilities.invokeLater(gui);
        
        
        
//        Scanner lukija = new Scanner(System.in);
//        Tekstikayttoliittyma t = new Tekstikayttoliittyma();
//        t.kaynnista();
      
        
    }
    
}
