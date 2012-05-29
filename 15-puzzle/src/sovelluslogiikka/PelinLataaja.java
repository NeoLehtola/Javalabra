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

    public PelinLataaja(String tiedostoNimi) {
        file = new File(tiedostoNimi);
    }

    public Pelitapahtuma avaaTallennettuPeli() {

        SiirtavaPelilauta lauta = null;

        try {
            Scanner lukija = new Scanner(file);

            int laudanKorkeus = 0; 
            int laudanLeveys = 0; 
            while (lukija.hasNextLine()) {
                String[] rivinTunnisteet = lukija.nextLine().split(",");
            }

        } catch (FileNotFoundException e) {
        }

        return new Pelitapahtuma(lauta);
    }
}
