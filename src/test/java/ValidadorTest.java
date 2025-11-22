import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// 4.1 Test RED inicial
public class ValidadorTest {

    @Test
    void soloLetrasConHolaRetornaTrue() {
        assertTrue(Validador.soloLetras("Hola"));
    }
}