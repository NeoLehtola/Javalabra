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
        kayttaja = new PelilaudanKayttaja(4, 3);
    }

    @After
    public void tearDown() {
    }

    

    @Test
    public void lautaSekoittuuAlussa() {
        assertFalse(kayttaja.lautaValmis());
    }

    @Test
    public void teeSiirtoSiirtaaNappiaJosVieressaOnTyhjaa() {
        
    }

    @Test
    public void nappiaEiVoiSiirtaaJosVieressaEiOleTyhjaa() {
        
    }
}
