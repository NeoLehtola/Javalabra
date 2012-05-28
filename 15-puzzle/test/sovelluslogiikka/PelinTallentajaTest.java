/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikka;

import java.io.File;
import java.util.Scanner;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author pklehtol
 */
public class PelinTallentajaTest {
    
    private File file;
    private Pelitapahtuma peli;
    
    public PelinTallentajaTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        file = new File("src/sovelluslogiikka/Tallennus.txt");
        peli = new Pelitapahtuma(3, 3, 10000);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void pelinTallennusOnnistuu() throws Exception {
        peli.tallennaPeli();
        Scanner lukija = new Scanner(file);
        while (lukija.hasNextLine()) {
            
        }
        
        
    }
    


    
}
