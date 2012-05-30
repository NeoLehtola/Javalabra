package sovelluslogiikka;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * lukee pelitilanteen tiedostosta ja muodostaa pelilaudan oikeilla nappuloiden
 * sijainneilla
 *
 */
public class PelinLataaja {

    private File file;

    /**
     * metodi lataa tiedostosta tallennetun pelin ja luo sen pohjalta uuden Pelitapahtuman
     * @param tiedostoNimi 
     */
    public PelinLataaja(String tiedostoNimi) {
        file = new File(tiedostoNimi);
    }

    public Pelitapahtuma avaaTallennettuPeli() {

        SiirtavaPelilauta uusiLauta = null;

        try {
            Scanner lukija = new Scanner(file);
          
            int laudanKorkeus = 0; 
            int laudanLeveys = 0; 
            while (lukija.hasNextLine()) {
                String[] rivinTunnisteet = lukija.nextLine().split(",");
                laudanLeveys = rivinTunnisteet.length;
                laudanKorkeus++;
            }
            


        } catch (FileNotFoundException e) {
        }

        return new Pelitapahtuma(uusiLauta);
    }
    

    
    
}
