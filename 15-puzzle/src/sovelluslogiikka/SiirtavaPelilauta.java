package sovelluslogiikka;

import java.util.Random;

/**
 * Tämä luokka perii Pelilauta-luokan, lisäte siihen sekoittamisen ja
 * nappuloiden siirtämisen. Nimensä mukaisesti tämä luokka siis varsinaisesti
 * käyttää pelilautaa.
 */
public class SiirtavaPelilauta extends Pelilauta {

    private int sekoitusMaara;

    /**
     * tämä konstruktori on kokonaan uuden pelin luomista varten
     * @param korkeus
     * @param leveys
     * @param sekoitusMaara 
     */
    public SiirtavaPelilauta(int korkeus, int leveys, int sekoitusMaara) {
        super(korkeus, leveys);
        this.sekoitusMaara = sekoitusMaara;
        sekoitaNappulat();
    }
    
    /**
     * tämä konstruktori on tallennetun pelin lataamista varten
     * @param lauta 
     */
    // muokkaa niin että parametriksi taulukollinen int-tunnisteita?
    public SiirtavaPelilauta(Nappula[][] lauta) {
        super(lauta);
    }
    

    /**
     * Lauta sekoitetaan nimenomaan tekemällä sallittuja siirtoja, sillä pelilaudan
     * on oltava ratkaistavissa.
     */
    private void sekoitaNappulat() {
        Random r = new Random();
        for (int i = 0; i < sekoitusMaara; i++) {
            int siirronKorkeus = r.nextInt(super.getKorkeus());
            int siirronLeveys = r.nextInt(super.getLeveys());
            this.teeSiirto(siirronKorkeus, siirronLeveys);

        }

    }

    /**
     * parametreina annetaan siirrettävän nappulan NYKYINEN SIJAINTI; metodin
     * täytyy tarkistaa, onko parametrina saadun nappulan oikealla puolella
     * tyhjä nappi. protected vain siksi että metodeja pystyisi testaamaan
     * suoraan
     *
     * @param napinKorkeus
     * @param napinLeveys
     * @return true jos siirto onnistuu, muuten false
     */
    protected boolean siirraOikealle(int napinKorkeus, int napinLeveys) {
        if (napinLeveys + 1 >= getLeveys()) {
            return false;
        }

        if (getLauta()[napinKorkeus][napinLeveys + 1].getTunniste() == -1) {
            getLauta()[napinKorkeus][napinLeveys + 1] = getLauta()[napinKorkeus][napinLeveys];
            getLauta()[napinKorkeus][napinLeveys] = new Nappula(-1);
            return true;
        }

        return false;
    }

    /**
     * 
     * @param napinKorkeus
     * @param napinLeveys
     * @return true jos siirto onnistuu
     */
    protected boolean siirraVasemmalle(int napinKorkeus, int napinLeveys) {
        if (napinLeveys - 1 < 0) {
            return false;
        }

        if (getLauta()[napinKorkeus][napinLeveys - 1].getTunniste() == -1) {
            getLauta()[napinKorkeus][napinLeveys - 1] = getLauta()[napinKorkeus][napinLeveys];
            getLauta()[napinKorkeus][napinLeveys] = new Nappula(-1);
            return true;
        }

        return false;
    }
    // muokkaan siirtometodit lopullisesti jahka ehdin
    
//    /**
//     * jos siirretään vasemmalle, suunta oltava -1, jos oikealle, suunta 1
//     * @param napinKorkeus
//     * @param napinLeveys
//     * @param suunta
//     * @return 
//     */
//    protected boolean siirraVaakasuunnassa(int napinKorkeus, int napinLeveys, int suunta) {
//       if  (getLauta()[napinKorkeus][napinLeveys + suunta].getTunniste() == -1) {
//            getLauta()[napinKorkeus][napinLeveys + suunta] = getLauta()[napinKorkeus][napinLeveys];
//            getLauta()[napinKorkeus][napinLeveys] = new Nappula(-1);
//            return true;
//       }
//    
//        return false;
//    }
    
//    /**
//     * jos siirretään ylös, suunta -1, jos alas, suunta 1
//     * @param napinKorkeus
//     * @param napinLeveys
//     * @param suunta
//     * @return 
//     */
//    protected boolean siirraPystysuunnassa(int napinKorkeus, int napinLeveys, int suunta) {
//        if (getLauta()[napinKorkeus + suunta][napinLeveys].getTunniste() == -1) {
//            getLauta()[napinKorkeus + suunta][napinLeveys] = getLauta()[napinKorkeus][napinLeveys];
//            getLauta()[napinKorkeus][napinLeveys] = new Nappula(-1);
//            return true;
//        }
//        
//        return false;
//    }

    /**
     * 
     * @param napinKorkeus
     * @param napinLeveys
     * @return true jos siirto onnistuu
     */
    protected boolean siirraYlos(int napinKorkeus, int napinLeveys) {
        if (napinKorkeus - 1 < 0) {
            return false;
        }

        if (getLauta()[napinKorkeus - 1][napinLeveys].getTunniste() == -1) {
            getLauta()[napinKorkeus - 1][napinLeveys] = getLauta()[napinKorkeus][napinLeveys];
            getLauta()[napinKorkeus][napinLeveys] = new Nappula(-1);
            return true;
        }

        return false;
    }

    /**
     * 
     * @param napinKorkeus
     * @param napinLeveys
     * @return true jos siirto onnistuu
     */
    protected boolean siirraAlas(int napinKorkeus, int napinLeveys) {
        if (napinKorkeus + 1 >= getKorkeus()) {
            return false;
        }

        if (getLauta()[napinKorkeus + 1][napinLeveys].getTunniste() == -1) {
            getLauta()[napinKorkeus + 1][napinLeveys] = getLauta()[napinKorkeus][napinLeveys];
            getLauta()[napinKorkeus][napinLeveys] = new Nappula(-1);
            return true;
        }

        return false;
    }

    /**
     * tarkistaa siirrettävän napin koordinaatit
     * @param napinKorkeus
     * @param napinLeveys
     * @return true jos nappi laudalla, false jos nappi on laudan ulkopuolella
     */
    private boolean siirrettavaksiPyydettyNappiOnLaudalla(int napinKorkeus, int napinLeveys) {
        return napinKorkeus <= getKorkeus() && napinLeveys <= getLeveys() && napinKorkeus >= 0 && napinLeveys >= 0;
            

    }

    /**
     * kokoava julkinen metodi, joka tarkistaa mihin suuntaan pystytään
     * siirtymään, ja tekee siirron
     *
     * @param napinKorkeus
     * @param napinLeveys
     * @return true jos siirto johonkin suuntaan onnistuu
     */
    public boolean teeSiirto(int napinKorkeus, int napinLeveys) {
        if (!siirrettavaksiPyydettyNappiOnLaudalla(napinKorkeus, napinLeveys)) {
            return false;
        }

        return voikoNappiaSiirtaaJohonkinSuuntaan(napinKorkeus, napinLeveys);


    }

    /**
     * tarkistaa, voiko annettua nappia siirtää mihinkään suuntaan
     * @param napinKorkeus
     * @param napinLeveys
     * @return true jos jokin siirto onnistuu
     */
    private boolean voikoNappiaSiirtaaJohonkinSuuntaan(int napinKorkeus, int napinLeveys) {
        return siirraOikealle(napinKorkeus, napinLeveys) || siirraVasemmalle(napinKorkeus, napinLeveys) || (siirraYlos(napinKorkeus, napinLeveys)) || (siirraAlas(napinKorkeus, napinLeveys));

    }

    /**
     * tarkistaa ovatko nappulat järjestyksessä ja peli päättynyt
     *
     * @return true jos peli päättynyt
     */
    public boolean lautaValmis() {
        int nro = 1;
        for (int i = 0; i < getKorkeus(); i++) {
            for (int j = 0; j < getLeveys(); j++) {
                if (i == getKorkeus() - 1 && j == getLeveys() - 1) {
                    return true;
                }

                if (getNappula(i, j).getTunniste() != nro) {
                    return false;
                }
                nro++;
            }
        }

        return true;
    }

    public int getSekoitusMaara() {
        return sekoitusMaara;
    }

    /**
     * tällä voi valita montako kertaa laudan nappuloita siirretään
     * sekoitusvaiheessa hyödyllisempi testivaiheessa kuin varsinaisessa pelissä
     *
     * @param sekoitusMaara
     */
    public void setSekoitusMaara(int sekoitusMaara) {
        this.sekoitusMaara = sekoitusMaara;
    }
}
