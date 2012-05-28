
package sovelluslogiikka;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class TallennetunPelinAvaaja {
    
       /**
     * lukee pelitilanteen tiedostosta ja muodostaa pelilaudan oikeilla nappuloiden sijainneilla
     * 
     */
    public void avaaTallennettuPeli() {
        // kesken!!!!
        try {
        File file = new File("Tallennus.txt");
        Scanner lukija = new Scanner(file);
    
        // taulukon koko pitää laskea eri tavalla, koska peli-olio luodaan vasta kun tiedosto on luettu
  //      Nappula[][] tallennettuLauta = new Nappula[peli.getPelilauta().getKorkeus()][peli.getPelilauta().getLeveys()];
        
        while (lukija.hasNextLine()) {
            String rivi = lukija.nextLine();
            String[] rivinTunnisteet = rivi.split(",");                     
        }
        
        } catch (FileNotFoundException e) {
            
        }
        
    }
    
}
