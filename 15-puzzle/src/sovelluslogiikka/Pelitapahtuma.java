package sovelluslogiikka;

/*
 * tämän olisi tarkoitus ohjata koko pelin kulkua (aloitus, pelaaminen, lopetus,
 * tallennus) ja kommunikoida kälin kanssa. luokka on vielä niin pahasti kesken,
 * ettei sille ole kovin montaa järkevää testiä.
 *
 */
public class Pelitapahtuma {

    private int vuorojenMaara;
    private SiirtavaPelilauta pelilauta;

    public Pelitapahtuma(int laudanKorkeus, int laudanLeveys, int sekoitusMaara) {
        this.vuorojenMaara = 0;
        this.pelilauta = new SiirtavaPelilauta(laudanKorkeus, laudanLeveys, sekoitusMaara);

    }

    public int getVuorojenMaara() {
        return vuorojenMaara;
    }

    /**
     * 
     * @return
     */
    public boolean pelaaYksiVuoroJosSiirtoSallittuEikaPeliLoppunut(int napinKorkeus, int napinLeveys) {
        vuorojenMaara++;
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
}
