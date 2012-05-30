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
    private ArrayList<Integer> tunnisteetTalteen;

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
    
    // tää on nyt niin valtava metodi että pitää vielä pilkkoa
    public Pelitapahtuma luoUusiPeliTallennetunPohjalta() throws Exception {
        if (!tiedostossaOnTallennettuPeli()) {
            return null;
        }
        SiirtavaPelilauta uusiLauta = null;
        
        
        

        try {
            Scanner lukija = new Scanner(file);
                              
            int laudanLeveys = 0; 
            this.tunnisteetTalteen = new ArrayList<Integer>(); 
            
            while (lukija.hasNextLine()) {
                String[] rivinTunnisteet = lukija.nextLine().split(",");
                laudanLeveys = rivinTunnisteet.length;
                for (int i = 0; i < rivinTunnisteet.length; i++) {
                    tunnisteetTalteen.add(Integer.parseInt(rivinTunnisteet[i]));                    
                }
            }
            uusiLauta = new SiirtavaPelilauta(luoUusiLauta(laudanLeveys));
            
        } catch (FileNotFoundException e) {
        }
        

        return new Pelitapahtuma(uusiLauta);
    }
    
    // nyt tää tarkistaa että tiedostossa on ylipäätään jotain, ei sitä onko siellä peli. MUUTA!!!
    private boolean tiedostossaOnTallennettuPeli() throws FileNotFoundException {
        Scanner lukija = new Scanner(file);
        
        int merkkeja = 0;

        while (lukija.hasNext()) {
            lukija.next();
            merkkeja++;
        }     
        return merkkeja > 0;
    }
    
    private Nappula[][] luoUusiLauta(int laudanLeveys) {
        int indeksi = 0;
        Nappula[][] lauta = new Nappula[tunnisteetTalteen.size() / laudanLeveys][laudanLeveys];
        for (int i = 0; i < lauta.length; i++) {
            for (int j = 0; j < lauta[i].length; j++) {
                lauta[i][j] = new Nappula(tunnisteetTalteen.get(indeksi));
                indeksi++;
            }
        }
        
        return lauta;
    }
    

    public File getFile() {
        return file;
    }
    

    
    
}
