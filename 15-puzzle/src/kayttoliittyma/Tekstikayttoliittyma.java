package kayttoliittyma;

import java.util.Scanner;
import sovelluslogiikka.Pelitapahtuma;

public class Tekstikayttoliittyma {

    private Pelitapahtuma peli;
    private Scanner lukija;

    public Tekstikayttoliittyma() {
        this.lukija = new Scanner(System.in);
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
    public void kaynnista() {
        
        // tässä pitää valita, haluaako avata vanhan pelin vai aloittaa uuden
        // tee muutos!!!!
        
        tulostaAloitustekstitJaLuoUusiPeli();

        while (!peli.peliPaattynyt()) {
            tulostaPelilauta();          

            if (peli.pelaaYksiVuoroJosSiirtoSallittu(kysyKorkeus(), kysyLeveys())) {
                peli.kasvataVuorojenMaaraa();
            } else {
                System.out.println("Siirto ei ole sallittu. Anna uusi sijainti.");
            }
        }
        System.out.println("Vuoroja " + peli.getVuorojenMaara());
        System.out.println("Pisteet " + peli.laskePisteet());

    }

    private void tulostaAloitustekstitJaLuoUusiPeli() {
        System.out.println("Tervetuloa pelaamaan 15-puzzlea.");
        System.out.println("Valitse laudan leveys ja korkeus"); // valintaväli täytyy lisätä

        System.out.print("Korkeus: ");
        int korkeus = Integer.parseInt(lukija.nextLine());
        System.out.print("Leveys: ");
        int leveys = Integer.parseInt(lukija.nextLine());

        this.peli = new Pelitapahtuma(korkeus, leveys, korkeus * leveys * 1000);
    }

    private int kysyKorkeus() {
        System.out.print("Anna siirrettävän korkeus: (0 - " + (peli.getPelilauta().getKorkeus() - 1) + ")");
        return Integer.parseInt(lukija.nextLine());
    }

    private int kysyLeveys() {
        System.out.print("Anna siirrettävän leveys: (0 - " + (peli.getPelilauta().getLeveys() - 1) + ")");
        return Integer.parseInt(lukija.nextLine());
    }
}
