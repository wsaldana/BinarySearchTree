/**
 * @author Walter Saldaña #19897
 * Clase con asociaciones comparables
 */

public class Association<E extends Comparable<E>> implements Comparable<Association<E>>{

    private E ingles;
    private E espanol;

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
    public Association(E ingles, E espanol){
        this.ingles = ingles;
        this.espanol = espanol;
    }

    /**
     * @param ingles the ingles to set
     */
    public void setIngles(E ingles) {
        this.ingles = ingles;
    }

    /**
     * @param espanol the espanol to set
     */
    public void setEspanol(E espanol) {
        this.espanol = espanol;
    }

    /**
     * @return the ingles
     */
    public E getIngles() {
        return ingles;
    }

    /**
     * @return the espanol
     */
    public E getEspanol() {
        return espanol;
    }

    public String toString() {
        return "("+this.ingles.toString()+", "+this.espanol.toString()+")";
    }

    @Override
    public int compareTo(Association<E> other) {
        return this.getIngles().compareTo(other.getIngles());
    }
}