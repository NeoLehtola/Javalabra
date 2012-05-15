
package sovelluslogiikka;

public class Nappula {
    // tämä voisi toimia yliluokkana erityyppisille nappuloille
    // pitäisikö olla abstract?
    
    private int vaakaSijainti;
    private int pystySijainti;
    private int arvo;
    
    public Nappula(int vaaka, int pysty, int arvo) {
        this.arvo = arvo;
        this.vaakaSijainti = vaaka;
        this.pystySijainti = pysty;
    }

    public int getPystySijainti() {
        return pystySijainti;
    }

    public void setPystySijainti(int pystySijainti) {
        this.pystySijainti = pystySijainti;
    }

    public int getVaakaSijainti() {
        return vaakaSijainti;
    }

    public void setVaakaSijainti(int vaakaSijainti) {
        this.vaakaSijainti = vaakaSijainti;
    }
    
    public int getArvo() {
        return arvo;
    }
    
    
}
