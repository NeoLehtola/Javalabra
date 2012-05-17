package sovelluslogiikka;

import sovelluslogiikka.Pelilauta;

public class PelilaudanKayttaja {

    private Pelilauta pelilauta;
    private final int SIVUNALARAJA = 3;
    private final int SIVUNYLARAJA = 8;

    public PelilaudanKayttaja() {
    }

    private boolean tarkistaOnkoSallittuAlkuarvo(int sivu) {
        return SIVUNALARAJA <= sivu && sivu <= SIVUNYLARAJA;

    }
}
