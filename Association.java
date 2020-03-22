/**
 * @author Walter Saldaña #19897
 * Clase con asociaciones comparables
 */

public class Association implements Comparable<Association>{

    private String ingles;
    private String espanol;

    /**
     * Constructor si parametros
     */
    public Association(){}

    /**
     * Constructor con parametros
     * Crea un objeto associaion con valores iniciales
     * @param ingles
     * @param espanol
     */
    public Association(String ingles, String espanol){
        this.ingles = ingles;
        this.espanol = espanol;
    }

    /**
     * @param ingles the ingles to set
     */
    public void setIngles(String ingles) {
        this.ingles = ingles;
    }

    /**
     * @param espanol the espanol to set
     */
    public void setEspanol(String espanol) {
        this.espanol = espanol;
    }

    /**
     * @return the ingles
     */
    public String getIngles() {
        return ingles;
    }

    /**
     * @return the espanol
     */
    public String getEspanol() {
        return espanol;
    }

    public String toString() {
        return "("+this.ingles+", "+this.espanol+")";
    }

    @Override
    public int compareTo(Association other) {
        return this.getIngles().compareTo(other.getIngles());
    }
}