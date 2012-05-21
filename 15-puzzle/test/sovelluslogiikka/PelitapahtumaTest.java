
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
        this.peli = new Pelitapahtuma(4, 4);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void vuorojenMaaraAlussaNolla() {
        assertEquals(0, peli.getVuorojenMaara());
    }
    
    @Test
    public void vuorojenMaaraKasvaaYhdellaJokaKierroksenJalkeen() {
        // muuta testiä niin, että se huomioi vuoroiksi vain onnistuneet siirrot!
//        for (int i = 0; i < 8; i++) {
//            peli.pelaaYksiVuoro();
//        }      
//        assertEquals(8, peli.getVuorojenMaara());
    }
    
}
