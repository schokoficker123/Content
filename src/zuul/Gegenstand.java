package zuul;

public class Gegenstand {

    private String name;
    private String beschreibung;
    private double gewicht;
    private boolean essbar;
    
       

    public Gegenstand(String name, String beschreibung, double gewicht) {
        this.beschreibung=beschreibung;
        this.name=name;
        this.gewicht=gewicht;
    }

    /**
     * 
     * @return name / Beschreibung / Gewicht
     */
    
    
    @Override
    public String toString() {
        return name + ", " + this.beschreibung +", " + this.gewicht+"kg";
    }


    public double getGewicht() {
        return this.gewicht;
    }

    public String getName() {
        return this.name;
    }
}
