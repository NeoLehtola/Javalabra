
package sovelluslogiikka;

import java.util.Random;

public class Pelilauta {
    
    private Nappula[][] lauta;
    private int sivunPituus;
    
    public Pelilauta(int sivunPituus) {
        this.sivunPituus = sivunPituus;
        lauta = new Nappula[sivunPituus][sivunPituus];
        AsetaNumerotJarjestykseenJaJataViimeinenTyhjaksi();
    }
    
    // tee yhteismetodi, joka asettaa alkutilan ja sitten sekoittaa, 
    // ja kutsu sitä konstruktorissa.
    private void AsetaNumerotJarjestykseenJaJataViimeinenTyhjaksi() {
        int nro = 1;
        for (int i = 0; i < sivunPituus; i++) {
            for (int j = 0; j < sivunPituus; j++) {
                lauta[i][j] = new Nappula(i, j, nro);
                if (i == sivunPituus - 1 && j == sivunPituus - 1) {
                    lauta[i][j] = new Nappula(i, j, 0);
                }
            }
        }
    }
    
    private void sekoitaNappulat() {
        Random r = new Random();
        
    }
    
//    public int getArvo(int vaaka, int pysty) {
//        return lauta[vaaka][pysty];
//    }
    
    public int getSivunPituus() {
        return sivunPituus;
    }
    
    private boolean siirraOikealle() {
        return false;
    }
    
    private boolean siirraVasemmalle() {
        return false;
    }
    
    private boolean siirraYlos() {
        return false;
    }
    
    private boolean siirraAlas() {
        return false;
    }
    
    public boolean teeSiirto() {
        return false;
    }
    
    public boolean lautaValmis() {
        return false;
    }
    

    
    

    
    
}
