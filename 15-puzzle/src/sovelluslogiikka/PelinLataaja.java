package sovelluslogiikka;

import java.io.File;
import java.util.Scanner;

/**
 * lukee pelitilanteen tiedostosta ja muodostaa pelilaudan oikeilla nappuloiden
 * sijainneilla
 *
 */


/* Näillä näkymin tää luokka häipyy. yhdistän tallentajaan
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

    /**
     * 
     * @return uusi pelitapahtuma, jossa pelilauta tallennetun mukainen
     */
    


    public Pelitapahtuma luoUusiPeliTallennetunPohjalta() throws Exception {

        Scanner lukija = new Scanner(file);
        
        int laudanKorkeus = lukija.nextInt();
        int laudanLeveys = lukija.nextInt();
        int vuorojenMaara = lukija.nextInt();
        lukija.close();
        
        int[] tunnisteet = keraaTunnisteet(laudanKorkeus, laudanLeveys);
        SiirtavaPelilauta uusiPelilauta = new SiirtavaPelilauta(luoLauta(laudanKorkeus, laudanLeveys, tunnisteet));
        
        
        
        return new Pelitapahtuma(uusiPelilauta, vuorojenMaara);
    }
    
    private int[] keraaTunnisteet(int laudanKorkeus, int laudanLeveys) throws Exception {
        Scanner lukija = new Scanner(file);
        lukija.nextLine();
        int[] tunnisteet = new int[laudanKorkeus*laudanLeveys];
        for (int i = 0; i < tunnisteet.length; i++) {
            tunnisteet[i] = lukija.nextInt();
        }
        return tunnisteet;
    }
    
    private Nappula[][] luoLauta(int laudanKorkeus, int laudanLeveys, int[] tunnisteet) {
        Nappula[][] lauta = new Nappula[laudanKorkeus][laudanLeveys];
        int seuraavaTunniste = 0; 
        
        for (int i = 0; i < lauta.length; i++) {
            for (int j = 0; j < lauta[i].length; j++) {
                lauta[i][j] = new Nappula(tunnisteet[seuraavaTunniste]);
                seuraavaTunniste++;
            }
        }
        return lauta;
    }
    

    

    

    public File getFile() {
        return file;
    }
    

    
    
}
