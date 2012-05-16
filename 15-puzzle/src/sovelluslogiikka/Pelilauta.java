
package sovelluslogiikka;

import java.util.Random;

public class Pelilauta {
    
    private Nappula[][] lauta;
    private final int SIVUNALARAJA = 3;
    private final int SIVUNYLARAJA = 8;
    private int leveys;
    private int korkeus;
    
    public Pelilauta(int korkeus, int leveys) {
       
        if (tarkistaOnkoSallittuAlkuarvo(leveys)) {
            this.leveys = leveys;
        }
        if (tarkistaOnkoSallittuAlkuarvo(korkeus)) {
            this.korkeus = korkeus;
        }
        
        lauta = new Nappula[korkeus][leveys];
        AsetaNumerotJarjestykseenJaJataViimeinenTyhjaksi();
    }
    
    
    private boolean tarkistaOnkoSallittuAlkuarvo(int sivu) {
        return SIVUNALARAJA <= sivu && sivu <= SIVUNYLARAJA;
                 
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
    public boolean siirraOikealle(int napinKorkeus, int napinLeveys) {
        if (napinLeveys + 1 == leveys) {
            return false;
        }
        
        if (lauta[napinKorkeus][napinLeveys + 1].getArvo() == -1) {
            lauta[napinKorkeus][napinLeveys + 1] = lauta[napinKorkeus][napinLeveys];
            lauta[napinKorkeus][napinLeveys] = new Nappula(-1);
            return true;
        }
      
        return false;
    }
    
    private boolean siirraVasemmalle(int korkeus, int leveys) {
        return false;
    }
    
    private boolean siirraYlos(int korkeus, int leveys) {
        return false;
    }
    
    private boolean siirraAlas(int korkeus, int leveys) {
        return false;
    }
    
    public boolean teeSiirto(int korkeus, int leveys) {
        return false;
    }
    
    public boolean lautaValmis() {
        return false;
    }
    

    
    

    
    
}
