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

//    @Test
//    public void eiVoiAntaaLiianPientaLeveytta() {
//    }
//
//    @Test
//    public void vaaranKokoistaPelilautaaEiVoiLuoda() {
//        pelilauta = new Pelilauta(2, 2);
//    }

//    @Test
//    public void alkuarvotOvatJarjestyksessa() {
//        int nro = 1;
//        for (int i = 0; i < pelilauta.getKorkeus(); i++) {
//            for (int j = 0; j < pelilauta.getLeveys(); j++) {
//            }
//        }
//
//
//    }

    @Test
    public void alkuarvoistaViimeinenOnTyhja() {
        assertEquals(-1, pelilauta.getNappula(pelilauta.getKorkeus() - 1, pelilauta.getLeveys() - 1).getArvo());
    }

    @Test
    public void laudallaOnVainYksiTyhjaNappi() {
        int tyhjia = 0;

        for (int i = 0; i < pelilauta.getKorkeus(); i++) {
            for (int j = 0; j < pelilauta.getLeveys(); j++) {
                if (pelilauta.getNappula(i, j).getArvo() == -1) {
                    tyhjia++;
                }
            }
        }
        assertEquals(1, tyhjia);
    }

//    @Test
//    public void lautaSekoittuuAlussa() {
//    }

    @Test
    public void siirraOikealleToimiiKunOikeallaTyhjaa() {
        assertTrue(pelilauta.siirraOikealle(3, 1));
    }

    @Test
    public void siirraOikeallePalauttaaFalseKunOllaanReunassa() {
        assertFalse(pelilauta.siirraOikealle(3, 2));
    }

    @Test
    public void siirraVasemmalleToimiiKunVasemmallaTyhjaa() {
        pelilauta.siirraOikealle(3, 1);
        assertTrue(pelilauta.siirraVasemmalle(3, 2));
    }

    @Test
    public void siirraVasemmallePalauttaaFalseKunOllaanReunassa() {
        assertFalse(pelilauta.siirraVasemmalle(3, 0));
    }

//    @Test
//    public void siirraYlosToimiiKunYlapuolellaTyhjaa() {
//    }
//
//    @Test
//    public void siirraYlosPalauttaaFalseKunOllaanYlareunassa() {
//    }
//
//    @Test
//    public void siirraAlasToimiiKunAlapuolellaTyhjaa() {
//    }
//
//    @Test
//    public void siirraAlasPalauttaaFalseKunOllaanAlareunassa() {
//    }

    @Test
    public void teeSiirtoSiirtaaNappiaJosVieressaOnTyhjaa() {
        assertTrue(pelilauta.teeSiirto(3, 1));
    }

    @Test
    public void nappiaEiVoiSiirtaaJosVieressaEiOleTyhjaa() {
        assertFalse(pelilauta.teeSiirto(1, 1));
    }
}
