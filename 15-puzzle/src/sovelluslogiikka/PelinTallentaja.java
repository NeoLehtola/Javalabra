
package sovelluslogiikka;

/**
 * Tämä luokka hoitaa pelitilanteen ja pisteiden tallentamisen
 */

import java.io.*;
import java.util.Scanner;

public class PelinTallentaja {
    
    private Pelitapahtuma peli;
    
    public PelinTallentaja(Pelitapahtuma peli) {
         this.peli = peli;
    }
    
    
    /**
     * tallentaa pelitilanteen tiedostoon, eli pelilaudan nappuloiden tunnisteet pilkulla erotettuna
     */
    public void tallennaPeli()  {
        
        try {
        File file = new File("Tallennus.txt");
        PrintWriter pw = new PrintWriter(file);
        
        for (int i = 0; i < peli.getPelilauta().getKorkeus(); i++) {
            for (int j = 0; j < peli.getPelilauta().getLeveys(); j++) {
                pw.print(peli.getPelilauta().getNappula(i, j).getTunniste() + ",");
            }
            pw.println();
        }
        } catch (FileNotFoundException e) {
            
        }
        
    }
    
 
    
}
