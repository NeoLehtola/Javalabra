package kayttoliittyma;

import java.util.Scanner;
import sovelluslogiikka.PelinLataaja;
import sovelluslogiikka.PelinTallentaja;
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
    public void kaynnista() throws Exception {
        tulostaAloitusTekstit();

        while (true) {
            int valinta = Integer.parseInt(lukija.nextLine());
            if (valinta == 1) {
                luoUusiPeli();
                break;
            } else if (valinta == 2) {
                avaaTallennettuPeli();
                break;
            } else {
                System.out.println("Valitse 1 tai 2");
            }
        }
        
//        System.out.println("Jos haluat keskeyttää pelin, paina x");
        while (true) {
            tulostaPelilauta();
            
            
            if (peli.pelaaYksiVuoroJosSiirtoSallittu(kysyKorkeus(), kysyLeveys())) {
                peli.kasvataVuorojenMaaraa();
            } else {
                System.out.println("Siirto ei ole sallittu. Anna uusi sijainti.");
            }
            if (peli.peliPaattynyt()) {
                break;
            }
        }
        System.out.println("Vuoroja " + peli.getVuorojenMaara());
        System.out.println("Pisteet " + peli.laskePisteet());

    }

    private void tulostaAloitusTekstit() {
        System.out.println("Tervetuloa pelaamaan 15-puzzlea.");
        System.out.println("Valitse 1, jos haluat aloittaa uuden pelin");
        System.out.println("Valitse 2, jos haluat avata tallennetun pelin");
    }

    private void luoUusiPeli() {

        System.out.println("Valitse laudan leveys ja korkeus"); // valintaväli täytyy lisätä

        System.out.print("Korkeus: ");
        int korkeus = Integer.parseInt(lukija.nextLine());
        System.out.print("Leveys: ");
        int leveys = Integer.parseInt(lukija.nextLine());

        this.peli = new Pelitapahtuma(korkeus, leveys, korkeus * leveys * 1000);
    }

    private void avaaTallennettuPeli() throws Exception {
        PelinLataaja lataaja = new PelinLataaja("src/sovelluslogiikka/Tallennus.txt");
        this.peli = lataaja.luoUusiPeliTallennetunPohjalta();
        if (peli == null) {
            System.out.println("Ei tallennettua peliä, luodaan uusi peli");
            luoUusiPeli();
        }   
    }
    
    // tämä muuttunee niin, että Tallentajaa ei käytetä suoraan vaan Pelitapahtuman kautta
    private void tallennaNykyinenPeli() throws Exception {
        PelinTallentaja tallentaja = new PelinTallentaja(peli, "src/sovelluslogiikka/Tallennus.txt");
        tallentaja.tallennaPeli();
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
