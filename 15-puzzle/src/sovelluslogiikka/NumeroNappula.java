
package sovelluslogiikka;


public class NumeroNappula implements Nappula {
    
    private int arvo;
    
    public NumeroNappula(int arvo) {
        this.arvo = arvo;
    }

    @Override
    public int getArvo() {
        return arvo;
    }
    
    
    
}
