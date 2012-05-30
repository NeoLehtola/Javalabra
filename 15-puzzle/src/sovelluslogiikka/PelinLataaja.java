package sovelluslogiikka;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * lukee pelitilanteen tiedostosta ja muodostaa pelilaudan oikeilla nappuloiden
 * sijainneilla
 *
 */

// huom! Tämä luokka tulee muuttumaan vielä melkoisen paljon!!! järkevöitän tätä
public class PelinLataaja {

    private File file;


    /**
     * metodi lataa tiedostosta tallennetun pelin ja luo sen pohjalta uuden Pelitapahtuman
     * @param tiedostoNimi 
     */
    public PelinLataaja(String tiedostoNimi) {
        file = new File(tiedostoNimi);
    }

    /**
     * 
     * @return uusi pelitapahtuma, jossa pelilauta tallennetun mukainen
     */
    

    // tää menee nyt niin uusiksi
    public Pelitapahtuma luoUusiPeliTallennetunPohjalta() throws Exception {

        Scanner lukija = new Scanner(file);
        
        int laudanKorkeus = lukija.nextInt();
        int laudanLeveys = lukija.nextInt();
        int vuorojenMaara = lukija.nextInt();
        
        int[] tunnisteet = keraaTunnisteet(lukija, laudanKorkeus, laudanLeveys);
        
        lukija.close();
        
        return null;
    }
    
    private int[] keraaTunnisteet(Scanner lukija, int laudanKorkeus, int laudanLeveys) {
        int[] tunnisteet = new int[laudanKorkeus*laudanLeveys];
        for (int i = 0; i < tunnisteet.length; i++) {
            tunnisteet[i] = lukija.nextInt();
        }
        return tunnisteet;
    }
    

    

    

    public File getFile() {
        return file;
    }
    

    
    
}
