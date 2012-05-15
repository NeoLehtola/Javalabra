
package sovelluslogiikka;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author pklehtol
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
        pelilauta = new Pelilauta(4);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void alkuarvotOvatJarjestyksessa() {
//        for (int i = 0; i < pelilauta.getSivunPituus(); i++) {
//            for (int j = 0; j < pelilauta.getSivunPituus(); j++) {
//                
//            }
//        }
    }
    
    @Test
    public void alkuarvoistaViimeinenOnNolla() {
       
    }

}
