
package sovelluslogiikka;

/**
 * tämän olisi tarkoitus ohjata koko pelin kulkua (aloitus, pelaaminen, lopetus, tallennus)
 * ja kommunikoida kälin kanssa.
 * 
 */

import java.io.*;
import java.util.TreeMap;

public class Pelitapahtuma implements Serializable {
    
    private int vuorojenMaara;
    private PelilaudanKayttaja kayttaja;
    
    public Pelitapahtuma(int laudanKorkeus, int laudanLeveys) {
        this.vuorojenMaara = 0;
        this.kayttaja = new PelilaudanKayttaja(laudanKorkeus, laudanLeveys, 10000);
        
    }


    public int getVuorojenMaara() {
        return vuorojenMaara;
    }
    
    /**
     * tämä hoitaa yhden vuoron, eli tarkistaa ettei peli ole vielä päättynyt, tekee siirron
     * ja lisää vuorojen määrää yhdellä
     */
    public void pelaaYksiVuoro(int napinKorkeus, int napinLeveys) {
        if (!kayttaja.lautaValmis()) {
            if (kayttaja.teeSiirto(napinKorkeus, napinLeveys)) {
                vuorojenMaara++;
            }
        }
    }
    
    /**
     * 
     * @return 
     */
    public int laskePisteet() {
        int nappuloidenMaara = kayttaja.getKorkeus() * kayttaja.getLeveys();
        
        return (int) Math.pow(nappuloidenMaara, 2) / vuorojenMaara;
    }
    
    public void tallennaPelinTulos(String pelaajanNimi) throws Exception {
        
    }
    
    /*
     * lataaTulokset()
     * return tulokset
     */
    
    
    
}
