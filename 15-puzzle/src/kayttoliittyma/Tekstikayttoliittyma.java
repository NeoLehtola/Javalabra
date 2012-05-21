
package kayttoliittyma;

import java.util.Scanner;
import sovelluslogiikka.PelilaudanKayttaja;

public class Tekstikayttoliittyma {
    
    private PelilaudanKayttaja kayttaja;
    
    
    public Tekstikayttoliittyma(PelilaudanKayttaja kayttaja) {
        this.kayttaja = kayttaja;
        
    }
//    // missä vaiheessa tämä valinta suoritetaan, jos laudan koko 
//    // pitää määrittää jo konstruktorin parametrin parametreina?
//    public void valitseLaudanKoko(Scanner lukija) throws Exception {
//        System.out.println("Tervetuloa pelaamaan 15-puzzlea");
//        System.out.println("Voit valita pelilaudan leveyden ja korkeuden");
//        System.out.println("väliltä " + kayttaja.getSIVUNALARAJA() + " - " + kayttaja.getSIVUNYLARAJA());
//        
//    }
    
    public void tulostaPelilauta() {
        for (int i = 0; i < kayttaja.getKorkeus(); i++) {
            for (int j = 0; j < kayttaja.getLeveys(); j++) {
                int nro = kayttaja.getNappula(i, j).getTunniste();
                if (nro == -1) {
                    System.out.print("   ");
                    continue;
                }
                if (nro < 10) {
                    System.out.print(" ");
                }
                System.out.print(nro + " ");
            }
            System.out.println("");
        }
    }

    
}
