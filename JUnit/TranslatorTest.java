import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Clase de tests
 * @author Walter Saldana 19897
 */

public class TranslatorTest {
    
    @Test
    public void testTraducir() {
        String traduccion = "*The* mujer *asked* *me* *to* *do* *my* tarea *about* *my* pueblo";
        String oracion = "The woman asked me to do my homework about my town";
        assertEquals(traduccion, oracion);
    }

    @Test
    public void testTraducir2() {
        String traduccion = "*The* perro *asked* *me* *to* *feed* *it*";
        String oracion = "The dog asked me to feed it";
        assertEquals(traduccion, oracion);
    }

    @Test
    public void testTraducir3() {
        String traduccion = "*There* *is* *a* mujer *with* *a* perro *at* *my* pueblo";
        String oracion = "There is a woman with a dog at my town";
        assertEquals(traduccion, oracion);
    }
}
