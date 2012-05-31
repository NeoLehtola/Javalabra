
package sovelluslogiikka;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author neom
 */
public class SiirtavaPelilautaTest {

    private SiirtavaPelilauta kayttaja;

    public SiirtavaPelilautaTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        kayttaja = new SiirtavaPelilauta(4, 3, 0);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void lautaSekoittuuAlussa() {
        kayttaja = new SiirtavaPelilauta(4, 3, 10000);
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
        kayttaja.siirraVaakasuunnassa(3, 1, 1);
        assertFalse(kayttaja.lautaValmis());
    }

    @Test
    public void siirraOikealleToimiiKunOikeallaTyhjaa() {
        assertTrue(kayttaja.siirraVaakasuunnassa(3, 1, 1));

    }

    @Test
    public void siirraOikeallePalauttaaFalseKunOllaanReunassa() {
        assertFalse(kayttaja.siirraVaakasuunnassa(3, 2, 1));

    }

    // tää ei toimi
    @Test
    public void siirraVasemmalleToimiiKunVasemmallaTyhjaa() {
        kayttaja.siirraVaakasuunnassa(3, 1, 1);
        assertTrue(kayttaja.siirraVaakasuunnassa(3, 2, -1));

    }

    @Test
    public void siirraVasemmallePalauttaaFalseKunOllaanReunassa() {
        assertFalse(kayttaja.siirraVaakasuunnassa(3, 0, -1));

    }

    @Test
    public void siirraYlosToimiiKunYlapuolellaTyhjaa() {
        kayttaja.siirraPystysuunnassa(2, 2, 1);
        assertTrue(kayttaja.siirraPystysuunnassa(3, 2, -1));
    }

    @Test
    public void siirraYlosPalauttaaFalseKunOllaanYlareunassa() {
        assertFalse(kayttaja.siirraPystysuunnassa(0, 2, -1));
    }

    @Test
    public void siirraAlasToimiiKunAlapuolellaTyhjaa() {
        assertTrue(kayttaja.siirraPystysuunnassa(2, 2, 1));
    }

    @Test
    public void siirraAlasPalauttaaFalseKunOllaanAlareunassa() {
        assertFalse(kayttaja.siirraPystysuunnassa(3, 1, 1));
    }
    
    @Test
    public void siirtoMetodiEiToimiLiianSuurellaSyotteella() {
        assertFalse(kayttaja.teeSiirto(6, 10));
    }
    
    @Test
    public void siirtoMetodiEiToimiNegatiivisellaKorkeudella() {
        assertFalse(kayttaja.teeSiirto(-2, 0));
    }
    
    @Test 
    public void siirtoMetodiEiToimiNegatiivisellaLeveydella() {
        assertFalse(kayttaja.teeSiirto(1, -1));
    }
}
