package sovelluslogiikka;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * Tämän luokan testit edellyttävät, että pelilautaa ei ole vielä sekoitettu
 * kertaakaan
 *
 */
public class PelilautaTest {

    Pelilauta pelilauta;

    public PelilautaTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        pelilauta = new Pelilauta(4, 3);
    }

    @After
    public void tearDown() {
    }



    

    

    
 

    @Test
    public void kaikissaRuuduissaOnNappula() {
        for (int i = 0; i < pelilauta.getKorkeus(); i++) {
            for (int j = 0; j < pelilauta.getLeveys(); j++) {
                assertNotNull(pelilauta.getNappula(i, j));

            }
        }
    }

    @Test
    public void numerointiAlkaaYkkosesta() {
        assertEquals(1, pelilauta.getNappula(0, 0).getTunniste());
    }

    @Test
    public void alkuarvotOvatJarjestyksessa() {
        int nro = 1;
        for (int i = 0; i < pelilauta.getKorkeus(); i++) {
            for (int j = 0; j < pelilauta.getLeveys(); j++) {
                if (i == pelilauta.getKorkeus() - 1 && j == pelilauta.getLeveys() - 1) {
                    return;
                }
                assertEquals(nro, pelilauta.getNappula(i, j).getTunniste());
                nro++;
            }
        }
    }

    @Test
    public void alkuarvoistaViimeinenOnTyhja() {
        assertEquals(-1, pelilauta.getNappula(pelilauta.getKorkeus() - 1, pelilauta.getLeveys() - 1).getTunniste());
    }

    @Test
    public void laudallaOnVainYksiTyhjaNappi() {
        int tyhjia = 0;

        for (int i = 0; i < pelilauta.getKorkeus(); i++) {
            for (int j = 0; j < pelilauta.getLeveys(); j++) {
                if (pelilauta.getNappula(i, j).getTunniste() == -1) {
                    tyhjia++;
                }
            }
        }
        assertEquals(1, tyhjia);
    }
}
