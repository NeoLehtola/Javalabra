
package sovelluslogiikka;

/**
 * Tämä luokka hoitaa pelitilanteen ja pisteiden tallentamisen
 */

import java.io.File;
import java.util.Scanner;

public class PelinTallentaja {
    
    private Pelitapahtuma peli;
    
    public PelinTallentaja(Pelitapahtuma peli) {
        this.peli = peli;        
    }
    
    public void tallennaPeli(File tiedosto) {
        
    }
    
    public void avaaTallennettuPeli(File tiedosto) throws Exception {
        Scanner lukija = new Scanner(tiedosto);
//        int[][] tilanne = 
        
        
    }
    
}
