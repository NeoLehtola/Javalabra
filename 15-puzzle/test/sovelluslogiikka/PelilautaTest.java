
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
      
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void eiVoiAntaaLiianPientaLeveytta() {
        pelilauta = new Pelilauta(2, 8);
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
    public void alkuarvoistaViimeinenOnTyhja() {
       
    }

}
