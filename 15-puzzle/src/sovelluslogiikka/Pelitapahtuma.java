
package sovelluslogiikka;

/**
 * tämän olisi tarkoitus ohjata koko pelin kulkua (aloitus, pelaaminen, lopetus, tallennus)
 * ja kommunikoida kälin kanssa.
 * luokka on vielä niin pahasti kesken, ettei sille ole kovin montaa järkevää testiä.
 * 
 */



public class Pelitapahtuma {
    
    private int vuorojenMaara;
    private SiirtavaPelilauta kayttaja;
    
    public Pelitapahtuma(int laudanKorkeus, int laudanLeveys, int sekoitusMaara) {
        this.vuorojenMaara = 0;
        this.kayttaja = new SiirtavaPelilauta(laudanKorkeus, laudanLeveys, sekoitusMaara);
        
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
    
    
    
}
