package sovelluslogiikka;

import java.util.Scanner;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author pklehtol
 */
public class PelinLataajaTest {

    private PelinLataaja lataaja;

    public PelinLataajaTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        lataaja = new PelinLataaja("test/sovelluslogiikka/Testitallennus.txt");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void latausTiedostoOnOlemassa() {
        assertTrue(lataaja.getFile().exists());
    }

    @Test
    public void latausTiedostossaOnTallennettunaJotain() throws Exception {
        Scanner lukija = new Scanner(lataaja.getFile());
        int merkkeja = 0;

        while (lukija.hasNext()) {
            lukija.next();
            merkkeja++;
        }
        assertTrue(merkkeja > 0);
    }
    

//
//    @Test
//    public void tiedostonNumerotLatautuvatOikeassaJarjestyksessaNappulaTaulukonTunnisteiksi() {
//    }
    
//    @Test
//    public void lataajaLuoUudenPelinJosTiedostoOK() throws Exception {
//        assertNotNull(lataaja.luoUusiPeliTallennetunPohjalta());
//    }
//    
//    @Test 
//    public void lataajaEiLuoUuttaPeliaJosTiedostoOnTyhja() throws Exception {
//        lataaja = new PelinLataaja("test/sovelluslogiikka/TyhjaTiedosto.txt");
//        assertNull(lataaja.luoUusiPeliTallennetunPohjalta());
//    }
    
//    @Test
//    public void lataajaEiLuoUuttaPeliaJosTiedostoaEiOle() {
//        
//    }
}
