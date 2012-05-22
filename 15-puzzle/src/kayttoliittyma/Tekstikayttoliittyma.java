
package kayttoliittyma;

import java.util.Scanner;
import sovelluslogiikka.Pelitapahtuma;



public class Tekstikayttoliittyma {
    
    private Pelitapahtuma peli;
    
    
    public Tekstikayttoliittyma() {
       
    }

   
    private void tulostaPelilauta() {
        for (int i = 0; i < peli.getPelilauta().getKorkeus(); i++) {
            for (int j = 0; j < peli.getPelilauta().getLeveys(); j++) {
                int nro = peli.getPelilauta().getNappula(i, j).getTunniste();
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
        tulostaAloitustekstitJaLuoUusiPeli(lukija);
        
        while (!peli.peliPaattynyt()) {
            tulostaPelilauta();
            
            kysyKorkeusJaLeveys(lukija);
            
//            if (peli.pelaaYksiVuoroJosSiirtoSallittu(siirrKorkeus, siirrLeveys)) {
//                peli.kasvataVuorojenMaaraa();
//            }
        }
        System.out.println(peli.getVuorojenMaara());

    }
    
    private void tulostaAloitustekstitJaLuoUusiPeli(Scanner lukija) {
        System.out.println("Tervetuloa pelaamaan 15-puzzlea.");
        System.out.println("Valitse laudan leveys ja korkeus"); // valintaväli täytyy lisätä
        
        System.out.print("Korkeus: ");
        int korkeus = Integer.parseInt(lukija.nextLine());
        System.out.print("Leveys: ");
        int leveys = Integer.parseInt(lukija.nextLine());
        
        this.peli = new Pelitapahtuma(korkeus, leveys, korkeus*leveys*1000);       
    }
    
    private void kysyKorkeusJaLeveys(Scanner lukija) {
                    
         System.out.print("Anna siirrettävän korkeus: " + "(" + peli.getPelilauta().getKorkeus() + "-");
         int siirrKorkeus = Integer.parseInt(lukija.nextLine());
         System.out.print("Anna siirrettävän leveys: ");
         int siirrLeveys = Integer.parseInt(lukija.nextLine());
    }

    
}
