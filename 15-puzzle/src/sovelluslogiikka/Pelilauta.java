package sovelluslogiikka;

public class Pelilauta {

    private Nappula[][] lauta;
    private int leveys;
    private int korkeus;
    private final int SIVUNALARAJA = 3;
    private final int SIVUNYLARAJA = 8;

    public Pelilauta(int korkeus, int leveys) {
        asetaSallittuKorkeusJaLeveys(korkeus, leveys);
        lauta = new Nappula[korkeus][leveys];
        asetaNumerotJarjestykseenJaJataViimeinenTyhjaksi();
    }

    private boolean onSallittuSivunPituus(int sivu) {
        return SIVUNALARAJA <= sivu && sivu <= SIVUNYLARAJA;
    }

    private void asetaSallittuKorkeusJaLeveys(int korkeus, int leveys) {
        if (!onSallittuSivunPituus(korkeus) || !onSallittuSivunPituus(leveys)) {
            throw new IllegalArgumentException("Korkeuden ja leveyden oltava  väliltä " + SIVUNALARAJA + "-" + SIVUNYLARAJA);
        }
        this.korkeus = korkeus;
        this.leveys = leveys;


    }

    private void asetaNumerotJarjestykseenJaJataViimeinenTyhjaksi() {
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

    public int getSIVUNALARAJA() {
        return SIVUNALARAJA;
    }

    public int getSIVUNYLARAJA() {
        return SIVUNYLARAJA;
    }
}
