
package sovelluslogiikka;

import java.util.Random;

public class Pelilauta {
    
    private Nappula[][] lauta;

    private int leveys;
    private int korkeus;
    
    public Pelilauta(int korkeus, int leveys) {
        // sivun pituuden sopivuuden tarkistus on siirretty Pelilogiikkaan.
        // pelilauta luodaan aina Pelilogiikka-luokan kautta
        this.leveys = leveys;
        this.korkeus = korkeus;
        
        lauta = new Nappula[korkeus][leveys];
        AsetaNumerotJarjestykseenJaJataViimeinenTyhjaksi();
    }
    
    

    
    // tee yhteismetodi, joka asettaa alkutilan ja sitten sekoittaa, 
    // ja kutsu sitä konstruktorissa.
    private void AsetaNumerotJarjestykseenJaJataViimeinenTyhjaksi() {
        int nro = 1;
        for (int i = 0; i < korkeus; i++) {
            for (int j = 0; j < leveys; j++) {
                lauta[i][j] = new Nappula(nro);
                nro++;
                if (i == korkeus - 1 && j == leveys - 1) {
                    lauta[i][j] = new Nappula(-1);
                }
            }
        }
    }
    
    private void sekoitaNappulat() {
        Random r = new Random();
        for (int i = 0; i < 10000; i++) {
            int siirronKorkeus = r.nextInt(korkeus);
            int siirronLeveys = r.nextInt(leveys);
            this.teeSiirto(siirronKorkeus, siirronLeveys);
            
        }
              
    }
   
    public Nappula getNappula(int korkeus, int leveys) {
        return lauta[korkeus][leveys];
    }
    

    
    public int getLeveys() {
        return leveys;
    }
    
    public int getKorkeus() {
        return korkeus;
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
        if (napinLeveys + 1 >= leveys) {
            return false;
        }
        
        if (lauta[napinKorkeus][napinLeveys + 1].getArvo() == -1) {
            lauta[napinKorkeus][napinLeveys + 1] = lauta[napinKorkeus][napinLeveys];
            lauta[napinKorkeus][napinLeveys] = new Nappula(-1);
            return true;
        }
      
        return false;
    }
    
    protected boolean siirraVasemmalle(int napinKorkeus, int napinLeveys) {
        if (napinLeveys - 1 < 0) {
            return false;
        }
        
        if (lauta[napinKorkeus][napinLeveys - 1].getArvo() == -1) {
            lauta[napinKorkeus][napinLeveys - 1] = lauta[napinKorkeus][napinLeveys];
            lauta[napinKorkeus][napinLeveys] = new Nappula(-1);
            return true;
        }
        
        return false;
    }
    
    protected boolean siirraYlos(int napinKorkeus, int napinLeveys) {
        if (napinKorkeus - 1 < 0) {
            return false;
        }
        
        if (lauta[napinKorkeus - 1][napinLeveys].getArvo() == -1) {
            lauta[napinKorkeus - 1][napinLeveys] = lauta[napinKorkeus][napinLeveys];
            lauta[napinKorkeus][napinLeveys] = new Nappula(-1);
            return true;
        }
        
        return false;
    }
    
    protected boolean siirraAlas(int napinKorkeus, int napinLeveys) {
        if (napinKorkeus + 1 >= korkeus) {
            return false;
        }
        
        if (lauta[napinKorkeus + 1][napinLeveys].getArvo() == -1) {
            lauta[napinKorkeus + 1][napinLeveys] = lauta[napinKorkeus][napinLeveys];
            lauta[napinKorkeus][napinLeveys] = new Nappula(-1);
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

 

    public Nappula[][] getLauta() {
        return lauta;
    }
    

    
    

    
    
}
