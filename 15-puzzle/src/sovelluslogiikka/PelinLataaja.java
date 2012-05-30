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
    public Pelitapahtuma luoUusiPeliTallennetunPohjalta() {
        if (!tiedostossaOnTallennettuPeli()) {
            return null;
        }
        
        

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
            
        } catch (FileNotFoundException e) {
        }
        SiirtavaPelilauta uusiLauta = null;

        return new Pelitapahtuma(uusiLauta);
    }
    
    private boolean tiedostossaOnTallennettuPeli() {
        
        return false;
    }
    
    private SiirtavaPelilauta luoUusiLauta(int laudanLeveys) {
        return null;
    }
    

    public File getFile() {
        return file;
    }
    

    
    
}
