
package kayttoliittyma;

import java.util.Scanner;
import sovelluslogiikka.SiirtavaPelilauta;

/* tämähän ei nyt vielä ollenkaan toimi, kun en ole saanut päätettyä missä kohti se 
 * pelilauta oikein pitää luoda. tarvitsisin sitä ennen kuin se on luotu. 
 */

public class Tekstikayttoliittyma {
    
    private SiirtavaPelilauta kayttaja;
    
    
    public Tekstikayttoliittyma() {
       
    }

   
    private void tulostaPelilauta() {
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
    public void kaynnista(Scanner lukija) {
        tulostaAloitustekstitJaLuoPelilauta(lukija);
        while (!kayttaja.lautaValmis()) {
            tulostaPelilauta();
            System.out.print("Anna siirrettävän korkeus: ");
            int siirrKorkeus = Integer.parseInt(lukija.nextLine());
            System.out.print("Anna siirrettävän leveys: ");
            int siirrLeveys = Integer.parseInt(lukija.nextLine());
            kayttaja.teeSiirto(siirrKorkeus, siirrLeveys);
        }

    }
    
    private void tulostaAloitustekstitJaLuoPelilauta(Scanner lukija) {
        System.out.println("Tervetuloa pelaamaan 15-puzzlea.");
        System.out.println("Valitse laudan leveys ja korkeus"); // valintaväli täytyy lisätä
        System.out.print("Korkeus: ");
        int korkeus = Integer.parseInt(lukija.nextLine());
        System.out.print("Leveys: ");
        int leveys = Integer.parseInt(lukija.nextLine());
        this.kayttaja = new SiirtavaPelilauta(korkeus, leveys, korkeus*leveys*1000);
        
        
    }

    
}
