package sovelluslogiikka;

public class Pelilauta {
    
    /*
     * Pelilauta on yliluokka, ja se luo laudan ja antaa alkuarvot,
     * mutta ei tiedä sekoituksista ja siirroista mitään. Aliluokka hoitaa nämä.
     */

    private Nappula[][] lauta;
    private int leveys;
    private int korkeus;

    public Pelilauta(int korkeus, int leveys) {
        this.korkeus = korkeus;
        this.leveys = leveys;
        lauta = new Nappula[korkeus][leveys];
        asetaNappulatJarjestykseenJaJataViimeinenTyhjaksi();
    }



    /**
     * konstruktorin apumetodi, joka laittaa alussa nappulat numerotunnisteen mukaiseen järjestykseen
     * ja jättää viimeisen nappulan tyhjäksi (eli tunnisteen arvoksi -1)
     */
    private void asetaNappulatJarjestykseenJaJataViimeinenTyhjaksi() {
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
    
    public void setNappula(int korkeus, int leveys, int tunniste) {
        
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
