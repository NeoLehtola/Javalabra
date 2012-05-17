package sovelluslogiikka;

import java.util.Random;



public class PelilaudanKayttaja extends Pelilauta {


    public PelilaudanKayttaja(int korkeus, int leveys) {
        super(korkeus, leveys);       
        sekoitaNappulat();
    }
    
    private void sekoitaNappulat() {
        Random r = new Random();
        for (int i = 0; i < 10000; i++) {
            int siirronKorkeus = r.nextInt(super.getKorkeus());
            int siirronLeveys = r.nextInt(super.getLeveys());
            this.teeSiirto(siirronKorkeus, siirronLeveys);

        }

    }
        /**
     * parametreina annetaan siirrettävän nappulan NYKYINEN SIJAINTI;
     * metodin täytyy tarkistaa, onko parametrina saadun nappulan oikealla puolella
     * tyhjä nappi
     * 
     * @param napinKorkeus
     * @param napinLeveys
     * @return 
     */
    
        protected boolean siirraOikealle(int napinKorkeus, int napinLeveys) {
        if (napinLeveys + 1 >= getLeveys()) {
            return false;
        }
        
        if (getLauta()[napinKorkeus][napinLeveys + 1].getArvo() == -1) {
            getLauta()[napinKorkeus][napinLeveys + 1] = getLauta()[napinKorkeus][napinLeveys];
            getLauta()[napinKorkeus][napinLeveys] = new Nappula(-1);
            return true;
        }
      
        return false;
    }
    
    protected boolean siirraVasemmalle(int napinKorkeus, int napinLeveys) {
        if (napinLeveys - 1 < 0) {
            return false;
        }
        
        if (getLauta()[napinKorkeus][napinLeveys - 1].getArvo() == -1) {
            getLauta()[napinKorkeus][napinLeveys - 1] = getLauta()[napinKorkeus][napinLeveys];
            getLauta()[napinKorkeus][napinLeveys] = new Nappula(-1);
            return true;
        }
        
        return false;
    }
    
    protected boolean siirraYlos(int napinKorkeus, int napinLeveys) {
        if (napinKorkeus - 1 < 0) {
            return false;
        }
        
        if (getLauta()[napinKorkeus - 1][napinLeveys].getArvo() == -1) {
            getLauta()[napinKorkeus - 1][napinLeveys] = getLauta()[napinKorkeus][napinLeveys];
            getLauta()[napinKorkeus][napinLeveys] = new Nappula(-1);
            return true;
        }
        
        return false;
    }
    
    protected boolean siirraAlas(int napinKorkeus, int napinLeveys) {
        if (napinKorkeus + 1 >= getKorkeus()) {
            return false;
        }
        
        if (getLauta()[napinKorkeus + 1][napinLeveys].getArvo() == -1) {
            getLauta()[napinKorkeus + 1][napinLeveys] = getLauta()[napinKorkeus][napinLeveys];
            getLauta()[napinKorkeus][napinLeveys] = new Nappula(-1);
            return true;
        }
        
        return false;
    }
    
    public boolean teeSiirto(int napinKorkeus, int napinLeveys) {
        if (siirraOikealle(napinKorkeus, napinLeveys)) {
            return true;
        }
        if (siirraVasemmalle(napinKorkeus, napinLeveys)) {
            return true;
        }
        if (siirraYlos(napinKorkeus, napinLeveys)) {
            return true;
        }
        if (siirraAlas(napinKorkeus, napinLeveys)) {
            return true;
        }
        
        return false;
    }
    

    public boolean lautaValmis() {
        return false;
    }
}
