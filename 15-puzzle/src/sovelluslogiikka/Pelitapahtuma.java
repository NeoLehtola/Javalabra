package sovelluslogiikka;

/**
 * tämän luokan metodeilla ohjataan koko pelin kulkua (aloitus, pelaaminen, vuorot, lopetus)
 * 
 *
 */
public class Pelitapahtuma {

    private int vuorojenMaara;
    private SiirtavaPelilauta pelilauta;
    private PelinTallentaja tallentaja;

    public Pelitapahtuma(int laudanKorkeus, int laudanLeveys, int sekoitusMaara) {
        this.vuorojenMaara = 0;
        this.pelilauta = new SiirtavaPelilauta(laudanKorkeus, laudanLeveys, sekoitusMaara);
        this.tallentaja = new PelinTallentaja();

    }

    public int getVuorojenMaara() {
        return vuorojenMaara;
    }
    
    public void kasvataVuorojenMaaraa() {
        vuorojenMaara++;
    }

    /**
     * 
     * @return
     */
    public boolean pelaaYksiVuoroJosSiirtoSallittu(int napinKorkeus, int napinLeveys) {
        return pelilauta.teeSiirto(napinKorkeus, napinLeveys);
    }

    /**
     * pisteet lasketaan kaavalla nappuloiden määrä potenssiin 2 jaettuna
     * vuorojen määrällä
     *
     * @return pistemäärä
     */
    public int laskePisteet() {
        int nappuloidenMaara = pelilauta.getKorkeus() * pelilauta.getLeveys();
        return (int) Math.pow(nappuloidenMaara, 2) / vuorojenMaara;
    }

    public SiirtavaPelilauta getPelilauta() {
        return pelilauta;
    }

    public boolean peliPaattynyt() {
        return pelilauta.lautaValmis();
    }
    
    public void avaaTallennettuPeli() {
        
    }
    
    public void tallennaPeli(String nimi) {
        
    }
}
