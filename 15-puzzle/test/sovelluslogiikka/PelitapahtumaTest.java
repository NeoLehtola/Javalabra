
package sovelluslogiikka;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author pklehtol
 */
public class PelitapahtumaTest {
    
    private Pelitapahtuma peli;
    
    public PelitapahtumaTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        this.peli = new Pelitapahtuma(4, 4, 0);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void vuorojenMaaraAlussaNolla() {
        assertEquals(0, peli.getVuorojenMaara());
    }
    

    @Test
    public void laskePisteetPalauttaaOikeanPistemaaran() {
       
    }
    

    
//    @Test
//    public void vuoroaEiEnaaPelataJosLautaOnValmis() {
//        
//    }
    
    @Test
    public void eiVoidaTehdaSiirtoaJonkaKorkeusOnPelilaudanUlkopuolella() {
        assertFalse(peli.pelaaYksiVuoroJosSiirtoSallittu(5, 2));
    }
    
    @Test
    public void eiVoidaTehdaSiirtoaJonkaLeveysPelilaudanUlkopuolella() {
        assertFalse(peli.pelaaYksiVuoroJosSiirtoSallittu(3, -2));
    }
    
    
    
}
