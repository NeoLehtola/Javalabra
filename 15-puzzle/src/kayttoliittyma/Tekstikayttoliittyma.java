
package kayttoliittyma;

import java.util.Scanner;
import sovelluslogiikka.PelilaudanKayttaja;

/* tämähän ei nyt vielä ollenkaan toimi, kun en ole saanut päätettyä missä kohti se 
 * pelilauta oikein pitää luoda. tarvitsisin sitä ennen kuin se on luotu. 
 */

public class Tekstikayttoliittyma {
    
    private PelilaudanKayttaja kayttaja;
    
    
    public Tekstikayttoliittyma() {
       
    }

    // tästä private?
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
    
    /**
     * tämä metodi käynnistää koko pelin
     */
    public void kaynnista() {
        tulostaAloitustekstitJaLuoPelilauta();

    }
    
    private void tulostaAloitustekstitJaLuoPelilauta() {
        Scanner lukija = new Scanner(System.in);
        System.out.println("Tervetuloa pelaamaan 15-puzzlea.");
        System.out.println("Valitse laudan leveys ja korkeus väliltä " + kayttaja.getSIVUNALARAJA() + "-" + kayttaja.getSIVUNYLARAJA());
        System.out.println("Korkeus: ");
        int korkeus = Integer.parseInt(lukija.nextLine());
        System.out.println("Leveys: ");
        int leveys = Integer.parseInt(lukija.nextLine());
        
        
        
    }

    
}
