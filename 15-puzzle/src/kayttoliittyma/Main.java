
package kayttoliittyma;

import java.util.Scanner;
//import javax.swing.SwingUtilities;

public class Main {
    
    public static void main(String[] args) {
//        GUI gui = new GUI();
//        SwingUtilities.invokeLater(gui);
        Scanner lukija = new Scanner(System.in);
        Tekstikayttoliittyma t = new Tekstikayttoliittyma();
        t.kaynnista(lukija);
      
        
    }
    
}
