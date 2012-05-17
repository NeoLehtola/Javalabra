
package sovelluslogiikka;


public class Pelilauta {
    
    private Nappula[][] lauta;

    private int leveys;
    private int korkeus;
    
    public Pelilauta(int korkeus, int leveys) {

        this.leveys = leveys;
        this.korkeus = korkeus;
        
        lauta = new Nappula[korkeus][leveys];
        AsetaNumerotJarjestykseenJaJataViimeinenTyhjaksi();
    }
    
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
    

   
    public Nappula getNappula(int korkeus, int leveys) {
        return lauta[korkeus][leveys];
    }
    
  
    public int getLeveys() {
        return leveys;
    }
    
    public int getKorkeus() {
        return korkeus;
    }
    




 

    public Nappula[][] getLauta() {
        return lauta;
    }
    

    
    

    
    
}
