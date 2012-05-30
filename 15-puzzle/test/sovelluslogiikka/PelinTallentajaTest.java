/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikka;

import java.io.File;
import java.util.Scanner;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author pklehtol
 */
public class PelinTallentajaTest {

    private Pelitapahtuma peli;
    private PelinTallentaja tallentaja;

    public PelinTallentajaTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        peli = new Pelitapahtuma(3, 3, 10000);
        tallentaja = new PelinTallentaja(peli, "test/sovelluslogiikka/Testitallennus.txt");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void tallennusTiedostoOnOlemassa() {
        assertTrue(tallentaja.getFile().exists());
    }

    @Test
    public void tunnistetaanJosTiedostoaEiOle() {
        tallentaja = new PelinTallentaja(peli, "");
        assertFalse(tallentaja.getFile().exists());
    }

    @Test
    public void tiedostoonTallentuuJotain() throws Exception {
        Scanner lukija = new Scanner(tallentaja.getFile());
        tallentaja.tallennaPeli();
        int merkkeja = 0;

        while (lukija.hasNext()) {
            lukija.next();
            merkkeja++;
        }
        assertTrue(merkkeja > 0);
    }

    @Test
    public void tiedostoonTallentuuOikeaMaaraLukuja() throws Exception {
        Scanner lukija = new Scanner(tallentaja.getFile());
        tallentaja.tallennaPeli();
        int[] luvut = new int[12];

        for (int i = 0; i < luvut.length; i++) {
            luvut[i] = lukija.nextInt();
        }
        lukija.close();
        // lukuja pitää olla ruutujen määrä + 3 (leveys, korkeus, vuorojen määrä)
        // vuorot voi olla 0, muut ei saa olla
        for (int i = 0; i < luvut.length; i++) {
            if (i != 2) {
                assertNotSame(0, luvut[i]);
            }
        }
    }

    @Test
    public void tunnisteetTallentuvatOikeassaJarjestyksessa() throws Exception {
        peli = new Pelitapahtuma(3, 3, 0);
        tallentaja = new PelinTallentaja(peli, "test/sovelluslogiikka/Testitallennus.txt");
        Scanner lukija = new Scanner(tallentaja.getFile());
        tallentaja.tallennaPeli();

        int[] taulukko = new int[9];
        int indeksi = 0;
        lukija.nextLine();
        while (lukija.hasNext()) {
            String[] rivi = lukija.next().split(",");
            for (int i = 0; i < rivi.length; i++) {
                taulukko[indeksi] = Integer.parseInt(rivi[i]);
                indeksi++;
            }
        }
        lukija.close();

        for (int i = 0; i < 9; i++) {
            if (i == 8) {
                assertEquals(-1, taulukko[i]);
            } else {
                assertEquals(i+1, taulukko[i]);
            }
        }


    }
}
