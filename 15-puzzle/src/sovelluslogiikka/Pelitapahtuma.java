package sovelluslogiikka;

/**
 * tämän luokan metodeilla ohjataan koko pelin kulkua (aloitus, pelaaminen,
 * vuorot, lopetus)
 *
 *
 */
public class Pelitapahtuma {

    private int vuorojenMaara;
    private SiirtavaPelilauta pelilauta;

    public Pelitapahtuma(SiirtavaPelilauta pelilauta) {
        this.pelilauta = pelilauta;
        this.vuorojenMaara = 0;
        // tällä hetkellä valitettavasti tallennuksesta saa etua, eli vuorojen määrät nollautuu kun 
        // lataa pelin. korjaan asian kunhan perustoiminnallisuudet on ensin kunnossa
    }
    
    public Pelitapahtuma(int laudanKorkeus, int laudanLeveys, int sekoitusMaara) {
        this.vuorojenMaara = 0;
        this.pelilauta = new SiirtavaPelilauta(laudanKorkeus, laudanLeveys, sekoitusMaara);

    }

    public int getVuorojenMaara() {
        return vuorojenMaara;
    }

    /**
     * perussetteri
     */
    public void kasvataVuorojenMaaraa() {
        vuorojenMaara++;
    }

    /**
     * tällä metodilla pääsee käsiksi SiirtavaPelilaudan metodiin teeSiirto
     *
     * @return true jos teeSiirto palauttaa true
     */
    public boolean pelaaYksiVuoroJosSiirtoSallittu(int napinKorkeus, int napinLeveys) {
        return pelilauta.teeSiirto(napinKorkeus, napinLeveys);
    }

    /**
     * pisteet lasketaan kaavalla nappuloiden määrä potenssiin 2 jaettuna
     * vuorojen määrällä * 100
     *
     * @return pistemäärä
     */
    public int laskePisteet() {
        int nappuloidenMaara = pelilauta.getKorkeus() * pelilauta.getLeveys();
        return (int) (Math.pow(nappuloidenMaara, 2) / vuorojenMaara) * 100;
    }

    public SiirtavaPelilauta getPelilauta() {
        return pelilauta;
    }

    /**
     * tällä metodilla pääsee käsiksi SiirtavaPelilaudan metodiin lautaValmis(),
     * eli tarkistetaan onko lauta järjestyksessä ja näin ollen peli loppunut
     *
     * @return true jos lautaValmis palauttaa true
     */
    public boolean peliPaattynyt() {
        return pelilauta.lautaValmis();
    }



    public void tallennaPeli(String tiedostoNimi) throws Exception {
        PelinTallentaja tallentaja = new PelinTallentaja(this, tiedostoNimi);
        tallentaja.tallennaPeli();
    }
}
