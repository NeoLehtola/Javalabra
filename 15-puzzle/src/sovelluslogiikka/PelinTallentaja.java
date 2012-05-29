package sovelluslogiikka;

/**
 * Tämä luokka hoitaa pelitilanteen tallentamisen
 */
import java.io.*;
import java.util.Scanner;

public class PelinTallentaja {

    private Pelitapahtuma peli;
    private File file;

    public PelinTallentaja(Pelitapahtuma peli, String tiedostoNimi) {
        this.peli = peli;
        file = new File(tiedostoNimi);

    }

    /**
     * tallentaa pelitilanteen tiedostoon, eli pelilaudan nappuloiden tunnisteet
     * pilkulla erotettuna
     */
    public void tallennaPeli() {
        try {
            PrintWriter pw = new PrintWriter(file);
            for (int i = 0; i < peli.getPelilauta().getKorkeus(); i++) {
                for (int j = 0; j < peli.getPelilauta().getLeveys(); j++) {
                    pw.print(peli.getPelilauta().getNappula(i, j).getTunniste() + ",");
                }
                pw.println();

            }
            pw.close();
        } catch (FileNotFoundException e) {
        }



    }

    public File getFile() {
        return file;
    }
}
