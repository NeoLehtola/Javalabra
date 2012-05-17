/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikka;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author neom
 */
public class PelilaudanKayttajaTest {

    private PelilaudanKayttaja kayttaja;

    public PelilaudanKayttajaTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        kayttaja = new PelilaudanKayttaja(4, 3, 0);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void lautaSekoittuuAlussa() {
        kayttaja = new PelilaudanKayttaja(4, 3, 10000);
        assertFalse(kayttaja.lautaValmis());
    }

    @Test
    public void teeSiirtoSiirtaaNappiaJosVieressaOnTyhjaa() {
        assertTrue(kayttaja.teeSiirto(3, 1));
    }

//    @Test
//    public void teeSiirtoEiJataSiirtamattaJosVieressaTyhjaa() {
//    }

    @Test
    public void nappiaEiVoiSiirtaaJosVieressaEiOleTyhjaa() {
        assertFalse(kayttaja.teeSiirto(2, 1));
    }

//    @Test
//    public void lautaValmisTestaaNumerotOikein() {
//    }

    @Test
    public void lautaValmisEiPaastaLapiMelkeinValmista() {
        kayttaja.siirraOikealle(3, 1);
        assertFalse(kayttaja.lautaValmis());
    }

    @Test
    public void siirraOikealleToimiiKunOikeallaTyhjaa() {
        assertTrue(kayttaja.siirraOikealle(3, 1));

    }

    @Test
    public void siirraOikeallePalauttaaFalseKunOllaanReunassa() {
        assertFalse(kayttaja.siirraOikealle(3, 2));

    }

    @Test
    public void siirraVasemmalleToimiiKunVasemmallaTyhjaa() {
        kayttaja.siirraOikealle(3, 1);
        assertTrue(kayttaja.siirraVasemmalle(3, 2));

    }

    @Test
    public void siirraVasemmallePalauttaaFalseKunOllaanReunassa() {
        assertFalse(kayttaja.siirraVasemmalle(3, 0));

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
}
