/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikka;

import java.util.Scanner;
import static org.junit.Assert.*;
import org.junit.*;

/**
 *
 * @author pklehtol
 */

// luokka korjattu
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
        int lukuja = 0;

        while (lukija.hasNextInt()) {
            lukija.nextInt();
            lukuja++;
        }
        // lukuja oltava nappuloiden määrä + 3: korkeus, leveys ja vuorojen määrä
        assertEquals(12, lukuja);

    }

    @Test
    public void laudanKorkeusTallentuuOikein() throws Exception {
        Scanner lukija = new Scanner(tallentaja.getFile());
        tallentaja.tallennaPeli();

        assertEquals(3, lukija.nextInt());
    }

    @Test
    public void laudanLeveysTallentuuOikein() throws Exception {
        peli = new Pelitapahtuma(3, 4, 1000);
        tallentaja = new PelinTallentaja(peli, "test/sovelluslogiikka/Testitallennus.txt");
        Scanner lukija = new Scanner(tallentaja.getFile());
        tallentaja.tallennaPeli();
        // hypätään korkeuden yli
        lukija.nextInt();
        assertEquals(4, lukija.nextInt());
    }

    @Test
    public void vuorojenMaaraTallentuuOikein() throws Exception {
        Scanner lukija = new Scanner(tallentaja.getFile());

        for (int i = 0; i < 5; i++) {
            peli.kasvataVuorojenMaaraa();
        }

        tallentaja.tallennaPeli();
        lukija.nextInt();
        lukija.nextInt();
        // hypättiin kolmanteen lukuun eli vuoroihin
        assertEquals(5, lukija.nextInt());
    }

    @Test
    public void tunnisteetTallentuvatOikeassaJarjestyksessa() throws Exception {
        peli = new Pelitapahtuma(3, 3, 0);
        tallentaja = new PelinTallentaja(peli, "test/sovelluslogiikka/Testitallennus.txt");
        Scanner lukija = new Scanner(tallentaja.getFile());
        tallentaja.tallennaPeli();
        
        // hypätään eka rivi yli
        lukija.nextLine();
        
        int i = 1; 
        while (i <= 8) {
            assertEquals(i, lukija.nextInt());
            i++;
        }
    




    }
}
